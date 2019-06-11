<?php 
    require_once('connection.php');
    

        $sql = "SELECT * FROM jenjang";

        try {
            $r = mysqli_query($con, $sql);
            $result = array();

            while ($row = mysqli_fetch_array($r)) {
                array_push($result, array(
                    "id_jenjang"=>$row['id_jenjang'],
                    "nama_jenjang" => $row['jenjang']
                ));
            }
            //Menampilkan dalam format JSON
            echo json_encode(array('result' => $result));
        } catch (Exception $e) {
            echo 'Caught exception: ',  $e->getMessage(), "\n";
        }
    
    mysqli_close($con);
?>