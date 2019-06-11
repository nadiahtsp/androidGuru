<?php
require_once('connection.php');
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $id_jenjang = $_POST['id_jenjang'];
    $nama_jenjang = $_POST['nama_jenjang'];

    //Jika jenjang tidak ada isinya
    $sql = "SELECT mata_pelajaran.*, jenjang.jenjang as nama_jenjang FROM mata_pelajaran, jenjang where mata_pelajaran.jenjang = '$id_jenjang' && jenjang.id_jenjang = mata_pelajaran.jenjang";
    //Mendapatkan Hasil
    try {
        $r = mysqli_query($con, $sql);
        $result = array();

        while ($row = mysqli_fetch_array($r)) {
            array_push($result, array(
                "id" => $row['id'],
                "nama_mapel" => $row['nama_mapel'],
                "id_jenjang" => $row['jenjang'],
                "nama_jenjang"=>$row['nama_jenjang']
            ));
        }

        //Menampilkan dalam format JSON
        echo json_encode(array('result' => $result));
    } catch (Exception $e) {
        echo 'Caught exception: ',  $e->getMessage(), "\n";
    }
    mysqli_close($con);
}
