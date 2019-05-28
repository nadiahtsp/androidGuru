<?php
require_once('connection.php');
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $jenjang = $_POST['jenjang'];

    //Jika jenjang tidak ada isinya
    if ($jenjang == "") {
        $sql = "SELECT distinct(jenjang) FROM mata_pelajaran";
        try {
            $r = mysqli_query($con, $sql);
            $result = array();

            while ($row = mysqli_fetch_array($r)) {
                array_push($result, array(
                    "jenjang" => $row['jenjang']
                ));
            }

            //Menampilkan dalam format JSON
            echo json_encode(array('result' => $result));
        } catch (Exception $e) {
            echo 'Caught exception: ',  $e->getMessage(), "\n";
        }
        //jika jenjang ada isinya
    } else {
        $sql = "SELECT * FROM mata_pelajaran where jenjang = '$jenjang'";
        //Mendapatkan Hasil
        try {
            $r = mysqli_query($con, $sql);
            $result = array();

            while ($row = mysqli_fetch_array($r)) {
                array_push($result, array(
                    "id" => $row['id'],
                    "nama_mapel" => $row['nama_mapel'],
                    "jenjang" => $row['jenjang']
                ));
            }

            //Menampilkan dalam format JSON
            echo json_encode(array('result' => $result));
        } catch (Exception $e) {
            echo 'Caught exception: ',  $e->getMessage(), "\n";
        }
    }
    mysqli_close($con);
}
