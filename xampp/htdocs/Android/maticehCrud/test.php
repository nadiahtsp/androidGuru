<?php
    //Import File Koneksi Database
	require_once('connection.php');
	
	$id_guru = 2;

        $sql = "SELECT * FROM mata_pelajaran where id_guru = '$id_guru'";

        //Mendapatkan Hasil
        try {
            $r = mysqli_query($con,$sql);
            $result = array();

            while($row = mysqli_fetch_array($r)){
                array_push($result,array(
                    "id"=>$row['id'],
                    "id_guru"=>$row['id_guru'],
                    "nama_mapel"=>$row['nama_mapel'],
                    "created_at"=>$row['created_at'],
                    "updated_at"=>$row['updated_at']
                ));
            }
            
            //Menampilkan dalam format JSON
	        echo json_encode(array('result'=>$result));
        } catch (Exception $e) {
            echo 'Caught exception: ',  $e->getMessage(), "\n";
        }
        

        // try {
		// 	if(mysqli_query($con,$sql)){
		// 		echo 'Login success!';
		// 	}else{
		// 		echo 'Login unsuccessful, please check your code';
		// 	}
		// } catch (Exception $e) {
		//     echo 'Caught exception: ',  $e->getMessage(), "\n";
        // }
        
        mysqli_close($con);
?>