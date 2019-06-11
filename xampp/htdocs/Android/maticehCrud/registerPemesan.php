<?php

 /*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */

	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Import File Koneksi database
		require_once('connection.php');

        //role = 
        // 0 -> admin
        // 1 -> pemesan
        // 2 -> guru
		
		//Mendapatkan Nilai Variable
		$name = $_POST['name'];
        $email = $_POST['email'];
		$password = md5($_POST['password']);
		$alamat = $_POST['alamat'];
		$provinsi = $_POST['provinsi'];
		$kabupatenKota = $_POST['kabupatenKota'];
        $nomorTelepon = $_POST['no_hp'];
		$jenisKelamin = $_POST['jenis_kelamin'];
        $role = 1;
        $status = 1;
		$created_at = date("Y-m-d H:i:s");
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO users (name, email, password, alamat, provinsi, kabupaten_kota, no_hp, jenis_kelamin, role, created_at, status)
       			VALUES ('$name','$email','$password', '$alamat', '$provinsi', '$kabupatenKota', '$nomorTelepon', '$jenisKelamin', '$role', '$created_at', $status)";
		
		//Eksekusi Query database
		try {
			if(mysqli_query($con,$sql)){
				echo 'Register success!';
			}else{
				echo 'Email has already been used';
			}
		} catch (Exception $e) {
		    echo 'Caught exception: ',  $e->getMessage(), "\n";
		}
		
		mysqli_close($con);
	};
?>