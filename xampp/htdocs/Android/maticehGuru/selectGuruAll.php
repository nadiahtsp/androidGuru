<?php 

 /*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */
    //role = 
        // 0 -> admin
        // 1 -> pemesan
        // 2 -> guru

	//Import File Koneksi Database
	require_once('connection.php');
	
	//Membuat SQL Query
	$sql = "SELECT users.*, guru.direktori_cv, guru.institusi FROM users LEFT OUTER JOIN guru on users.id = guru.id_guru where users.role = 2;";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id"=>$row['id'],
			"name"=>$row['name'],
            "email"=>$row['email'],
            "remember_token"=>$row['remember_token'],
			"alamat"=>$row['alamat'],
			"provinsi"=>$row['provinsi'],
			"kabupatenKota"=>$row['kabupaten_kota'],
			"status"=>$row['status'],
            "role"=>$row['role'],
            "no_hp"=>$row['no_hp'],
            "jenis_kelamin"=>$row['jenis_kelamin'],
            "created_at"=>$row['created_at'],
            "updated_at"=>$row['updated_at'],
			"direktori_cv"=>$row['direktori_cv'],
			"institusi" => $row['institusi']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	// echo json_encode(array('result'=>$result));
	var_dump ($r);
	
	mysqli_close($con);
?>