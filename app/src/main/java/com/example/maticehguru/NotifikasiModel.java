package com.example.maticehguru;

import android.os.Parcel;
import android.os.Parcelable;

public class NotifikasiModel implements Parcelable {
    private String id, pesan, status, tgl_notifikasi, id_user;

    public NotifikasiModel() {
    }

    public NotifikasiModel(String id, String pesan, String status, String tgl_notifikasi, String id_user){
        this.id = id;
        this.pesan = pesan;
        this.status = status;
        this.tgl_notifikasi = tgl_notifikasi;
        this.id_user = id_user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTgl_notifikasi() {
        return tgl_notifikasi;
    }

    public void setTgl_notifikasi(String tgl_notifikasi) {
        this.tgl_notifikasi = tgl_notifikasi;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public static Creator<NotifikasiModel> getCREATOR() {
        return CREATOR;
    }

    protected NotifikasiModel(Parcel in) {
        id = in.readString();
        pesan = in.readString();
        status = in.readString();
        tgl_notifikasi = in.readString();
        id_user = in.readString();


    }

    public static final Creator<NotifikasiModel> CREATOR = new Creator<NotifikasiModel>() {
        @Override
        public NotifikasiModel createFromParcel(Parcel in) {
            return new NotifikasiModel(in);
        }

        @Override
        public NotifikasiModel[] newArray(int size) {
            return new NotifikasiModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(pesan);
        parcel.writeString(status);
        parcel.writeString(tgl_notifikasi);
        parcel.writeString(id_user);

    }

}
