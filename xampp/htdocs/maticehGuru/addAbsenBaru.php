<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
	$id_pemesan = $_POST['id_pemesan'];
	$id_guru = $_POST['id_guru'];
	$id_mapel = 1;
	$status = 1;
	$created_at = date("Y-m-d H:i:s");

	//Pembuatan Syntax SQL
	$sql = "INSERT INTO absen (id_guru, id_pemesan, id_mapel, status, created_at)
	VALUES ('$id_guru', '$id_pemesan', '$id_mapel', '$status', '$created_at')";
	
	//Import File Koneksi database
	require_once('connection.php');
	
	//Eksekusi Query database

	try {
		if(mysqli_query($con,$sql)){
			echo 'Absen telah direkam!';
		}else{
			echo 'Absen gagal direkam, error!';
		}
	} catch (Exception $e) {
		echo 'Caught exception: ',  $e->getMessage(), "\n";
	}
	
	mysqli_close($con);
}
?>