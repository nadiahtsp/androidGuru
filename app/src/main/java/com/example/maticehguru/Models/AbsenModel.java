package com.example.maticehguru.Models;

public class AbsenModel {
    private String id, id_pemesanan, status, created_at, updated_at;
    private String nama_guru, nama_murid, nama_pemesan, mapel, jenjang;

    public AbsenModel(String id, String id_pemesanan, String status, String created_at, String updated_at) {
        this.id = id;
        this.id_pemesanan = id_pemesanan;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public AbsenModel() {
    }

    public String getNama_pemesan() {
        return nama_pemesan;
    }

    public void setNama_pemesan(String nama_pemesan) {
        this.nama_pemesan = nama_pemesan;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getNama_murid() {
        return nama_murid;
    }

    public void setNama_murid(String nama_murid) {
        this.nama_murid = nama_murid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
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
}
