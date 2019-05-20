package com.example.maticehguru;

import android.os.Parcel;
import android.os.Parcelable;

public class PesananModel implements Parcelable {
    private String id_pesanan, id_guru, id_pemesan, status, created_at, updated_at, nama_pemesan, nama_guru;

    public PesananModel(String id_pesanan, String id_guru, String id_pemesan, String status, String created_at, String updated_at, String nama_pemesan, String nama_guru) {
        this.id_pesanan = id_pesanan;
        this.id_guru = id_guru;
        this.id_pemesan = id_pemesan;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.nama_pemesan = nama_pemesan;
        this.nama_guru = nama_guru;
    }

    public String getId_pesanan() {
        return id_pesanan;
    }

    public void setId_pesanan(String id_pesanan) {
        this.id_pesanan = id_pesanan;
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

    public String getNama_pemesan() {
        return nama_pemesan;
    }

    public void setNama_pemesan(String nama_pemesan) {
        this.nama_pemesan = nama_pemesan;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public static Creator<PesananModel> getCREATOR() {
        return CREATOR;
    }

    protected PesananModel(Parcel in) {
        id_pesanan = in.readString();
        id_guru = in.readString();
        id_pemesan = in.readString();
        status = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        nama_pemesan = in.readString();
        nama_guru = in.readString();
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
        parcel.writeString(id_pesanan);
        parcel.writeString(id_guru);
        parcel.writeString(id_pemesan);
        parcel.writeString(status);
        parcel.writeString(created_at);
        parcel.writeString(updated_at);
        parcel.writeString(nama_pemesan);
        parcel.writeString(nama_guru);
    }
}
