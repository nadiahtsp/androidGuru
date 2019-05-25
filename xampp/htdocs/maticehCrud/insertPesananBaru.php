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
        $id_pemesan = $_POST['id_pemesan'];
		$id_guru = $_POST['id_guru'];
		$id_mapel = $_POST['id_mapel'];
		$nama_murid = $_POST['nama_murid'];
		$kelas = $_POST['kelas'];
		$tgl_pertemuan_pertama = $_POST['tgl_pertemuan_pertama'];
        $status = 0;
        $tgl_pesanan = date("Y-m-d H:i:s");
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO pemesanan (id_guru, id_pemesan, id_mapel, nama_murid, kelas, tgl_pertemuan_pertama, status, created_at)
        VALUES ('$id_guru', '$id_pemesan', '$id_mapel', '$nama_murid', '$kelas', '$tgl_pertemuan_pertama','$status', '$tgl_pesanan')";
		
		//Import File Koneksi database
		require_once('connection.php');
		
		//Eksekusi Query database

		try {
			if(mysqli_query($con,$sql)){
				echo 'Teacher has been reserved!';
			}else{
				echo 'Reserving failed, error!';
			}
		} catch (Exception $e) {
		    echo 'Caught exception: ',  $e->getMessage(), "\n";
		}
		
		mysqli_close($con);
	};
?>