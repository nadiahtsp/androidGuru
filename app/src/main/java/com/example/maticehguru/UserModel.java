package com.example.maticehguru;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String id, name, email, password, remember_token, alamat, status, role, no_hp, jenis_kelamin, created_at, updated_at;

    public UserModel(String id, String name, String email, String password, String remember_token, String alamat, String status, String role, String no_hp, String jenis_kelamin, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.remember_token = remember_token;
        this.alamat = alamat;
        this.status = status;
        this.role = role;
        this.no_hp = no_hp;
        this.jenis_kelamin = jenis_kelamin;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    protected UserModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        email = in.readString();
        password = in.readString();
        remember_token = in.readString();
        alamat = in.readString();
        status = in.readString();
        role = in.readString();
        no_hp = in.readString();
        jenis_kelamin = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

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
        parcel.writeString(status);
        parcel.writeString(role);
        parcel.writeString(no_hp);
        parcel.writeString(jenis_kelamin);
        parcel.writeString(created_at);
        parcel.writeString(updated_at);
    }
}
