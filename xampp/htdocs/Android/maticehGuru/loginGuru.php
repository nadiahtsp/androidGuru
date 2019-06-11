<?php
require_once('connection.php');
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $email = $_POST['email'];
    $password = md5($_POST['password']);

    $sql = "SELECT users.*, guru.institusi, guru.direktori_cv FROM `users` JOIN guru ON users.id = guru.id_guru WHERE users.email = '$email' and users.password = '$password';";

    //Mendapatkan Hasil
    try {
        $r = mysqli_query($con, $sql);
        $row = mysqli_fetch_array($r);
        $result = array();

        array_push($result, array(
            "id" => $row['id'],
            "name" => $row['name'],
            "email" => $row['email'],
            "password" => $row['password'],
            "remember_token" => $row['remember_token'],
            "alamat" => $row['alamat'],
            "provinsi" => $row['provinsi'],
            "kabupatenKota" => $row['kabupaten_kota'],
            "status" => $row['status'],
            "role" => $row['role'],
            "no_hp" => $row['no_hp'],
            "jenis_kelamin" => $row['jenis_kelamin'],
            "created_at" => $row['created_at'],
            "updated_at" => $row['updated_at'],
            "institusi" => $row['institusi'],
            "direktori_cv" => $row['direktori_cv']

        ));

        //Menampilkan dalam format JSON
        echo json_encode(array('result' => $result));
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
