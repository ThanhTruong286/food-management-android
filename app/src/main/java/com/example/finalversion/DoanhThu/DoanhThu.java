package com.example.finalversion.DoanhThu;

import java.io.Serializable;

public class DoanhThu implements Serializable {
    String nam;

    public String getNam() {
        return nam;
    }

    public DoanhThu() {
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public DoanhThu(String nam, int tongTien) {
        this.nam = nam;
        this.tongTien = tongTien;
    }

    int tongTien;
}
