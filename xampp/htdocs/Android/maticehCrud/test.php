<?php
    //Import File Koneksi Database
	require_once('connection.php');
	
	$sql = "SELECT DISTINCT(provinsi) FROM prov_kabot";

        try {
            $r = mysqli_query($con, $sql);
            $result = array();

            while ($row = mysqli_fetch_array($r)) {
                array_push($result, array(
                    "provinsi"=>$row['provinsi']
                ));
            }
            //Menampilkan dalam format JSON
            echo json_encode(array('result' => $result));
        } catch (Exception $e) {
            echo 'Caught exception: ',  $e->getMessage(), "\n";
        }
        
        mysqli_close($con);
?>