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
        $password = $_POST['password'];
        $nomorTelepon = $_POST['nomorTelepon'];
        $jenisKelamin = $_POST['jenisKelamin'];
        $role = 1;
        $status = 0;
        $created_at = date("Y-m-d H:i:s");
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO users (name, email, password, no_hp, jenis_kelamin, role, created_at, status)
       			VALUES ('$name','$email','$password', '$nomorTelepon', '$jenisKelamin', '$role', '$created_at', $status)";
		
		//Eksekusi Query database
		try {
			if(mysqli_query($con,$sql)){
				echo 'Register success!';
			}else{
				echo 'Register unsuccessful, please check your code';
			}
		} catch (Exception $e) {
		    echo 'Caught exception: ',  $e->getMessage(), "\n";
		}
		
		mysqli_close($con);
	};
?>