<?php

/*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    //role = 
    // 0 -> admin
    // 1 -> pemesan
    // 2 -> guru

    //Mendapatkan Nilai Variable
    $id = $_POST['id'];
    $updated_at = date("Y-m-d H:i:s");

    //Pembuatan Syntax SQL
    $sql = "UPDATE pemesanan SET status = 2, updated_at = '$updated_at'  WHERE id = '$id'";

    //Import File Koneksi database
    require_once('connection.php');

    //Eksekusi Query database

    try {
        if (mysqli_query($con, $sql)) {
            echo 'Pesanan dibatalkan';
        } else {
            echo 'Pesanan gagal dibatalkan, error :(';
        }
    } catch (Exception $e) {
        echo 'Caught exception: ',  $e->getMessage(), "\n";
    }

    mysqli_close($con);
};
