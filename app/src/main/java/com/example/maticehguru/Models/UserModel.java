package com.example.maticehguru.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String id, name, email, password, remember_token, alamat, provinsi, kabupatenKota, status, role, no_hp, jenis_kelamin, created_at, updated_at = "";
    private String direktori_cv, institusi = "";

    public UserModel(String id, String name, String email, String password, String remember_token, String alamat, String provinsi, String kabupatenKota, String status, String role, String no_hp, String jenis_kelamin, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.remember_token = remember_token;
        this.alamat = alamat;
        this.provinsi = provinsi;
        this.kabupatenKota = kabupatenKota;
        this.status = status;
        this.role = role;
        this.no_hp = no_hp;
        this.jenis_kelamin = jenis_kelamin;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void fillDataGuru(String direktori_cv, String institusi){
        this.direktori_cv = direktori_cv;
        this.institusi = institusi;
    }

    protected UserModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        email = in.readString();
        password = in.readString();
        remember_token = in.readString();
        alamat = in.readString();
        provinsi = in.readString();
        kabupatenKota = in.readString();
        status = in.readString();
        role = in.readString();
        no_hp = in.readString();
        jenis_kelamin = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        direktori_cv = in.readString();
        institusi = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(remember_token);
        parcel.writeString(alamat);
        parcel.writeString(provinsi);
        parcel.writeString(kabupatenKota);
        parcel.writeString(status);
        parcel.writeString(role);
        parcel.writeString(no_hp);
        parcel.writeString(jenis_kelamin);
        parcel.writeString(created_at);
        parcel.writeString(updated_at);
        parcel.writeString(direktori_cv);
        parcel.writeString(institusi);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupatenKota() {
        return kabupatenKota;
    }

    public void setKabupatenKota(String kabupatenKota) {
        this.kabupatenKota = kabupatenKota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
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

    public String getDirektori_cv() {
        return direktori_cv;
    }

    public void setDirektori_cv(String direktori_cv) {
        this.direktori_cv = direktori_cv;
    }

    public String getInstitusi() {
        return institusi;
    }

    public void setInstitusi(String institusi) {
        this.institusi = institusi;
    }

    public static Creator<UserModel> getCREATOR() {
        return CREATOR;
    }
}
