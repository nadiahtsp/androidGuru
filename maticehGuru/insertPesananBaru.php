<?php

 /*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */

	if($_SERVER['REQUEST_METHOD']=='POST'){

        //role = 
        // 0 -> admin
        // 1 -> pemesan
        // 2 -> guru
		
        //Mendapatkan Nilai Variable
        $id_pemesan = $_POST['pemesan'];
        $id_guru = $_POST['guru'];
        $status = 0;
        $tgl_pesanan = date("Y-m-d H:i:s");
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO pemesanan (id_guru, id_pemesan, status, tgl_pesanan)
        VALUES ('$id_guru', '$id_pemesan', '$status', '$tgl_pesanan')";
		
		//Import File Koneksi database
		require_once('connection.php');
		
		//Eksekusi Query database

		try {
			if(mysqli_query($con,$sql)){
				echo 'Insertion success!';
			}else{
				echo 'Insertion unsuccessful, please check your code';
			}
		} catch (Exception $e) {
		    echo 'Caught exception: ',  $e->getMessage(), "\n";
		}
		
		mysqli_close($con);
	};
?>