<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
	//Import File Koneksi database
	require_once('connection.php');

	$id_pemesanan = $_POST['id_pemesanan'];
	$id_guru = $_POST['id_guru'];
	// $id_mapel = 1;
	$status = 1;
	$created_at = date("Y-m-d H:i:s");

	$sql = "SELECT count(*) AS verifikasi FROM pemesanan WHERE id = '$id_pemesanan' AND id_guru = '$id_guru'";

	$row = mysqli_query($con, $sql);
	if ($row['verifikasi'] == '1') {
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO absen (id_pemesanan, status, created_at)
		VALUES ('$id_pemesanan', '$status', '$created_at')";
		
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
	}else{
		echo 'QR code is invalid';
	}
	
	mysqli_close($con);
}
?>