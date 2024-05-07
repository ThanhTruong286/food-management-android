package com.example.finalversion.KhachHang;

import java.io.Serializable;

public class KhachHang implements Serializable {
    String maKH,tenKH,loaiKH;

    public KhachHang(String maKH, String tenKH, String loaiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.loaiKH = loaiKH;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }
}
