package com.example.finalversion.Menu;

import java.io.Serializable;

public class Menu implements Serializable {
    String maMenu,tenMenu,donGiaMenu;

    public Menu() {
    }

    public String getMaMenu() {
        return maMenu;
    }

    public void setMaMenu(String maMenu) {
        this.maMenu = maMenu;
    }

    public String getTenMenu() {
        return tenMenu;
    }

    public void setTenMenu(String tenMenu) {
        this.tenMenu = tenMenu;
    }

    public String getDonGiaMenu() {
        return donGiaMenu;
    }

    public void setDonGiaMenu(String donGiaMenu) {
        this.donGiaMenu = donGiaMenu;
    }

    public Menu(String maMenu, String tenMenu, String donGiaMenu) {
        this.maMenu = maMenu;
        this.tenMenu = tenMenu;
        this.donGiaMenu = donGiaMenu;
    }
}
