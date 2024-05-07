package com.example.finalversion.Ban;

import java.io.Serializable;

public class Ban implements Serializable {
    String maBan,sucChua,trangThai;

    public Ban() {
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getSucChua() {
        return sucChua;
    }

    public void setSucChua(String sucChua) {
        this.sucChua = sucChua;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Ban(String maBan, String sucChua, String trangThai) {
        this.maBan = maBan;
        this.sucChua = sucChua;
        this.trangThai = trangThai;
    }
}
