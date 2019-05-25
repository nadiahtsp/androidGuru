package com.example.maticehguru;

public class Config {

        //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
        //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
        //dimana File PHP tersebut berada
        //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA

//        public static final String BASE_URL = "http://192.168.1.25:8080/Android/maticehGuru/";
        public static final String BASE_URL = "http://192.168.43.170:81/Android/maticehGuru/";

        public static final String URL_GET_PEMESAN_ID = BASE_URL + "selectPemesanId.php/";
        public static final String URL_ACC_PESANAN_BARU = BASE_URL + "acceptPesananBaru.php/";
        public static final String URL_DEC_PESANAN_BARU = BASE_URL + "declinePesananBaru.php/";
        public static final String URL_GET_GURU_ALL = BASE_URL + "selectGuruAll.php/";
        public static final String URL_GET_GURU_ID = BASE_URL + "selectGuruId.php?id=";
        public static final String URL_GET_LOGIN = BASE_URL + "loginGuru.php";
//        public static final String URL_UPDATE_USER = BASE_URL + "update.php/";
//        public static final String URL_DELETE_USER = BASE_URL + "delete.php?id=";

        //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
        public static final String KEY_USER_ID = "id";
        public static final String KEY_USER_NAME = "name";
        public static final String KEY_USER_EMAIL = "email";
        public static final String KEY_USER_PASSWORD = "password";
        public static final String KEY_USER_NOMOR_TELEPON = "nomorTelepon";
        public static final String KEY_USER_JENIS_KELAMIN = "jenisKelamin";

        //JSON Tags
        public static final String TAG_JSON_ARRAY = "result";
        public static final String TAG_ID = "id";
        public static final String TAG_NAME = "name";
        public static final String TAG_EMAIL = "email";
        public static final String TAG_PASSWORD = "password";
        public static final String TAG_NOMOR_TELEPON = "nomorTelepon";
        public static final String TAG_JENIS_KELAMIN = "jenisKelamin";


        //ID karyawan
        //emp itu singkatan dari Employee
        public static final String USER_ID = "id";
}
