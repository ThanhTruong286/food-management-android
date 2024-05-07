package com.example.finalversion.NhanVien;

import java.io.Serializable;

public class NhanVien implements Serializable {
    String maNV, tenNV, luong, viTri,gioiTinh;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String luong, String viTri, String gioiTinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.luong = luong;
        this.viTri = viTri;
        this.gioiTinh = gioiTinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

}
