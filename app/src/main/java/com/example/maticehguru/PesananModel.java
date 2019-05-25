package com.example.maticehguru;

import android.os.Parcel;
import android.os.Parcelable;

public class PesananModel implements Parcelable {
    private String id, id_guru, id_pemesan, id_mapel, nama_murid, kelas, tgl_pertemuan_pertama, status, created_at, updated_at, guru_name, pemesan_name, pemesan_provinsi, pemesan_kabupaten_kota, pemesan_alamat, nama_mapel;

    public PesananModel() {
    }

    public PesananModel(String id, String id_guru, String id_pemesan, String id_mapel, String nama_murid, String kelas, String tgl_pertemuan_pertama, String status, String created_at, String updated_at, String guru_name, String pemesan_name, String pemesan_provinsi, String pemesan_kabupaten_kota, String pemesan_alamat, String nama_mapel) {
        this.id = id;
        this.id_guru = id_guru;
        this.id_pemesan = id_pemesan;
        this.id_mapel = id_mapel;
        this.nama_murid = nama_murid;
        this.kelas = kelas;
        this.tgl_pertemuan_pertama = tgl_pertemuan_pertama;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.guru_name = guru_name;
        this.pemesan_name = pemesan_name;
        this.pemesan_provinsi = pemesan_provinsi;
        this.pemesan_kabupaten_kota = pemesan_kabupaten_kota;
        this.pemesan_alamat = pemesan_alamat;
        this.nama_mapel = nama_mapel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_guru() {
        return id_guru;
    }

    public void setId_guru(String id_guru) {
        this.id_guru = id_guru;
    }

    public String getId_pemesan() {
        return id_pemesan;
    }

    public void setId_pemesan(String id_pemesan) {
        this.id_pemesan = id_pemesan;
    }

    public String getId_mapel() {
        return id_mapel;
    }

    public void setId_mapel(String id_mapel) {
        this.id_mapel = id_mapel;
    }

    public String getNama_murid() {
        return nama_murid;
    }

    public void setNama_murid(String nama_murid) {
        this.nama_murid = nama_murid;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTgl_pertemuan_pertama() {
        return tgl_pertemuan_pertama;
    }

    public void setTgl_pertemuan_pertama(String tgl_pertemuan_pertama) {
        this.tgl_pertemuan_pertama = tgl_pertemuan_pertama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getGuru_name() {
        return guru_name;
    }

    public void setGuru_name(String guru_name) {
        this.guru_name = guru_name;
    }

    public String getPemesan_name() {
        return pemesan_name;
    }

    public void setPemesan_name(String pemesan_name) {
        this.pemesan_name = pemesan_name;
    }

    public String getPemesan_provinsi() {
        return pemesan_provinsi;
    }

    public void setPemesan_provinsi(String pemesan_provinsi) {
        this.pemesan_provinsi = pemesan_provinsi;
    }

    public String getPemesan_kabupaten_kota() {
        return pemesan_kabupaten_kota;
    }

    public void setPemesan_kabupaten_kota(String pemesan_kabupaten_kota) {
        this.pemesan_kabupaten_kota = pemesan_kabupaten_kota;
    }

    public String getPemesan_alamat() {
        return pemesan_alamat;
    }

    public void setPemesan_alamat(String pemesan_alamat) {
        this.pemesan_alamat = pemesan_alamat;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public static Creator<PesananModel> getCREATOR() {
        return CREATOR;
    }

    protected PesananModel(Parcel in) {
        id = in.readString();
        id_guru = in.readString();
        id_pemesan = in.readString();
        id_mapel = in.readString();
        nama_murid = in.readString();
        kelas = in.readString();
        tgl_pertemuan_pertama = in.readString();
        status = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        guru_name = in.readString();
        pemesan_name = in.readString();
        pemesan_provinsi = in.readString();
        pemesan_kabupaten_kota = in.readString();
        pemesan_alamat = in.readString();
        nama_mapel = in.readString();
    }

    public static final Creator<PesananModel> CREATOR = new Creator<PesananModel>() {
        @Override
        public PesananModel createFromParcel(Parcel in) {
            return new PesananModel(in);
        }

        @Override
        public PesananModel[] newArray(int size) {
            return new PesananModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(id_guru);
        parcel.writeString(id_pemesan);
        parcel.writeString(id_mapel);
        parcel.writeString(nama_murid);
        parcel.writeString(kelas);
        parcel.writeString(tgl_pertemuan_pertama);
        parcel.writeString(status);
        parcel.writeString(created_at);
        parcel.writeString(updated_at);
        parcel.writeString(guru_name);
        parcel.writeString(pemesan_name);
        parcel.writeString(pemesan_provinsi);
        parcel.writeString(pemesan_kabupaten_kota);
        parcel.writeString(pemesan_alamat);
        parcel.writeString(nama_mapel);
    }
}
