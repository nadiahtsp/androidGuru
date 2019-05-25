package com.example.maticehguru;

public class Config {

        //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
        //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
        //dimana File PHP tersebut berada
        //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA

//        public static final String BASE_URL = "http://192.168.1.25:8080/Android/maticehGuru/";
        public static final String BASE_URL = "http://192.168.100.15:8080/Android/maticehGuru/";
//        public static final String BASE_URL = "http://192.168.100.9:81/Android/maticehGuru/";

        public static final String URL_GET_PEMESAN_ID = BASE_URL + "selectPemesanId.php/";
        public static final String URL_ACC_PESANAN_BARU = BASE_URL + "acceptPesananBaru.php/";
        public static final String URL_DEC_PESANAN_BARU = BASE_URL + "declinePesananBaru.php/";
        public static final String URL_GET_GURU_ALL = BASE_URL + "selectGuruAll.php/";
        public static final String URL_GET_GURU_ID = BASE_URL + "selectGuruId.php?id=";
        public static final String URL_GET_LOGIN = BASE_URL + "loginGuru.php";
        public static final String URL_GET_ALL_PESANAN = BASE_URL + "selectAllPesanan.php";
        public static final String URL_ADD_ABSEN_BARU = BASE_URL + "addAbsenBaru.php";
//        public static final String URL_UPDATE_USER = BASE_URL + "update.php/";
//        public static final String URL_DELETE_USER = BASE_URL + "delete.php?id=";

        //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
        public static final String KEY_USER_ID = "id";
        public static final String KEY_USER_NAME = "name";
        public static final String KEY_USER_EMAIL = "email";
        public static final String KEY_USER_PASSWORD = "password";
        public static final String KEY_USER_NOMOR_TELEPON = "no_hp";
        public static final String KEY_USER_JENIS_KELAMIN = "jenis_kelamin";
        public static final String KEY_USER_ALAMAT = "alamat";
        public static final String KEY_USER_PROVINSI = "provinsi";
        public static final String KEY_USER_KABUPATEN_KOTA = "kabupatenKota";
        public static final String KEY_USER_REMEMBER_TOKEN = "remember_token";
        public static final String KEY_USER_STATUS = "status";
        public static final String KEY_USER_ROLE = "role";
        public static final String KEY_USER_CREATED_AT = "created_at";
        public static final String KEY_USER_UPDATED_AT = "updated_at";
        public static final String KEY_USER_DIREKTORI_CV = "direktori_cv";
        public static final String KEY_USER_INSTITUSI = "institusi";

        public static final String KEY_BAHAN_AJAR_ID = "id";
        public static final String KEY_BAHAN_AJAR_ID_GURU = "id_guru";
        public static final String KEY_BAHAN_AJAR_ID_MAPEL = "id_mapel";
        public static final String KEY_BAHAN_AJAR_NAMA_MAPEL = "nama_mapel";
        public static final String KEY_BAHAN_AJAR_JENJANG_ = "jenjang";

        public static final String KEY_PESANAN_ID = "id";
        public static final String KEY_PESANAN_ID_GURU = "id_guru";
        public static final String KEY_PESANAN_ID_PEMESAN = "id_pemesan";
        public static final String KEY_PESANAN_ID_MAPEL = "id_mapel";
        public static final String KEY_PESANAN_NAMA_MURID = "nama_murid";
        public static final String KEY_PESANAN_KELAS = "kelas";
        public static final String KEY_PESANAN_TGL_PERTEMUAN_PERTAMA = "tgl_pertemuan_pertama";
        public static final String KEY_PESANAN_STATUS = "status";
        public static final String KEY_PESANAN_CREATED_AT = "created_at";
        public static final String KEY_PESANAN_UPDATED_AT = "updated_at";
        public static final String KEY_PESANAN_GURU_NAME = "guru_name";
        public static final String KEY_PESANAN_PEMESAN_NAME = "pemesan_name";
        public static final String KEY_PESANAN_PEMESAN_PROVINSI = "pemesan_provinsi";
        public static final String KEY_PESANAN_PEMESAN_KABUPATEN_KOTA = "pemesan_kabupaten_kota";
        public static final String KEY_PESANAN_PEMESAN_ALAMAT = "pemesan_alamat";
        public static final String KEY_PESANAN_MAPEL_NAME = "mapel_name";
        //JSON Tags
        public static final String TAG_JSON_ARRAY = "result";
}
