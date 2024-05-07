package com.example.finalversion.CongViec;

import java.io.Serializable;

public class CongViec implements Serializable {
    String maCV, tenCV, tenNV,maNV,loaiCV;

    public CongViec(String maCV, String tenCV, String tenNV, String maNV, String loaiMon) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.loaiCV = loaiMon;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public CongViec() {
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getLoaiCV() {
        return loaiCV;
    }

    public void setLoaiCV(String loaiMon) {
        this.loaiCV = loaiMon;
    }
}
