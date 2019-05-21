package com.example.maticehguru;

import android.os.Parcel;
import android.os.Parcelable;

public class PesananModel implements Parcelable {
    private String id, id_guru, id_pemesan, status, created_at, updated_at, guru_name, pemesan_name, pemesan_provinsi, pemesan_kabupaten_kota, pemesan_alamat;

    public PesananModel(String id, String id_guru, String id_pemesan, String status, String created_at, String updated_at, String guru_name, String pemesan_name, String pemesan_provinsi, String pemesan_kabupaten_kota, String pemesan_alamat) {
        this.id = id;
        this.id_guru = id_guru;
        this.id_pemesan = id_pemesan;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.guru_name = guru_name;
        this.pemesan_name = pemesan_name;
        this.pemesan_provinsi = pemesan_provinsi;
        this.pemesan_kabupaten_kota = pemesan_kabupaten_kota;
        this.pemesan_alamat = pemesan_alamat;
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

    public static Creator<PesananModel> getCREATOR() {
        return CREATOR;
    }

    protected PesananModel(Parcel in) {
        id = in.readString();
        id_guru = in.readString();
        id_pemesan = in.readString();
        status = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        guru_name = in.readString();
        pemesan_name = in.readString();
        pemesan_provinsi = in.readString();
        pemesan_kabupaten_kota = in.readString();
        pemesan_alamat = in.readString();
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
        parcel.writeString(status);
        parcel.writeString(created_at);
        parcel.writeString(updated_at);
        parcel.writeString(guru_name);
        parcel.writeString(pemesan_name);
        parcel.writeString(pemesan_provinsi);
        parcel.writeString(pemesan_kabupaten_kota);
        parcel.writeString(pemesan_alamat);
    }
}
