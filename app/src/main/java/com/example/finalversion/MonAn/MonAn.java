package com.example.finalversion.MonAn;

import java.io.Serializable;

public class MonAn implements Serializable {
    String maMA,tenMA,donGia,maKH,soLuong,tongTien;

    public MonAn(String maMA, String tenMA, String donGia, String maKH, String soLuong, String tongTien) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.donGia = donGia;
        this.maKH = maKH;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public MonAn() {
    }

    public String getMaMA() {
        return maMA;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }
}
