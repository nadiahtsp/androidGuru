<?php
require_once('connection.php');
    // $id_guru = 36;
    //Import File Koneksi Database

	try {
	
		//Membuat SQL Query
		$sql = "SELECT pemesanan.*, tguru.name AS guru_name, tpemesan.name AS pemesan_name, tpemesan.provinsi AS pemesan_provinsi, tpemesan.kabupaten_kota AS pemesan_kabupaten_kota, tpemesan.alamat AS pemesan_alamat FROM pemesanan, (SELECT * FROM users WHERE role = 1) AS tpemesan, (SELECT * FROM users WHERE role = 2) AS tguru WHERE pemesanan.id_guru = tguru.id AND pemesanan.id_pemesan = tpemesan.id";

		//Mendapatkan Hasil
		$r = mysqli_query($con,$sql);
		
		//Membuat Array Kosong 
		$result = array();
		
		while($row = mysqli_fetch_array($r)){
			
			//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
			array_push($result,array(
				"id"=>$row['id'],
				"id_guru"=>$row['id_guru'],
				"id_pemesan"=>$row['id_pemesan'],
				"status"=>$row['status'],
				"created_at"=>$row['created_at'],
				"updated_at"=>$row['updated_at'],
				"guru_name"=>$row['guru_name'],
				"pemesan_name"=>$row['pemesan_name'],
				"pemesan_provinsi"=>$row['pemesan_provinsi'],
				"pemesan_kabupaten_kota"=>$row['pemesan_kabupaten_kota'],
				"pemesan_alamat"=>$row['pemesan_alamat']
			));
		}
		
		//Menampilkan Array dalam Format JSON
		echo json_encode(array('result'=>$result));
		// var_dump($r);
		mysqli_close($con);
	} catch (Exception $e) {
		echo 'Caught exception: ',  $e->getMessage(), "\n";
	}
?>