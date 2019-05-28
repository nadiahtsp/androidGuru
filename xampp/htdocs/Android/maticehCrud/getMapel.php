<?php
    require_once('connection.php');
    if($_SERVER['REQUEST_METHOD']=='POST'){
        
        $id_guru = $_POST['id_guru'];

        $sql = "SELECT bahan_ajar.*, mata_pelajaran.nama_mapel, mata_pelajaran.jenjang FROM bahan_ajar, mata_pelajaran where id_guru = '$id_guru' && mata_pelajaran.id = bahan_ajar.id_mapel";

        //Mendapatkan Hasil
        try {
            $r = mysqli_query($con,$sql);
            $result = array();

            while($row = mysqli_fetch_array($r)){
                array_push($result,array(
                    "id"=>$row['id'],
                    "id_guru"=>$row['id_guru'],
                    "id_mapel"=>$row['id_mapel'],
                    "nama_mapel"=>$row['nama_mapel'],
                    "jenjang"=>$row['jenjang'],
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
    }
?>