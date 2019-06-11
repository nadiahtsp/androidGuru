<?php 

 /*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */
	
	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	
	//Importing database

	require_once('connection.php');

	var_dump($_GET);
	$id = $_GET['id'];
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM users WHERE id = $id AND role = 2";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
            "id"=>$row['id'],
            "name"=>$row['name'],
            "email"=>$row['email'],
            "no_hp"=>$row['no_hp'],
            "jenis_kelamin"=>$row['jenis_kelamin'],
            "role"=>$row['role']
		));

	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>