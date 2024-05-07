package com.example.finalversion.Order;

import java.io.Serializable;

public class Order implements Serializable {
    String maOrder,maBan,maKH,giamGia,tongTien;

    public Order() {
    }

    public String getMaOrder() {
        return maOrder;
    }

    public void setMaOrder(String maOrder) {
        this.maOrder = maOrder;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public Order(String maOrder, String maBan, String maKH, String giamGia, String tongTien) {
        this.maOrder = maOrder;
        this.maBan = maBan;
        this.maKH = maKH;
        this.giamGia = giamGia;
        this.tongTien = tongTien;
    }
}
