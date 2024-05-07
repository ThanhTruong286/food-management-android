package com.example.finalversion.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.finalversion.Adapter.DoanhThuAdapter;
import com.example.finalversion.Ban.Ban;
import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.DoanhThu.DoanhThu;
import com.example.finalversion.KhachHang.KhachHang;
import com.example.finalversion.Menu.Menu;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.Order.Order;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context){
        super(context, "db7",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlMA = "create table tblMonAn(maMA text, tenMA text, donGia text, maKH text,soLuong text,tongTien int)";
        String sqlOrder = "create table tblOrder(maOrder text, maKH text,maBan text, giamGia text,tongTien text)";
        String sql2 = "create table tblBan(maBan text, sucChua text, trangThai text)";
        String sql = "Create table tblNhanVien(maNV text, tenNV text,luongNV text,viTri text,gioiTinh text)";
        String sqlCV = "Create table tblCongViec(maCV text, tenCV text,maNV text,tenNV text,loai text)";
        String sql1 = "Create table tblKhachHang(maKH text,tenKH text,loaiKH text)";
        String menu ="Create table tblMenu(maMA text, tenMA text, donGia text)";
        String doanhThu = "Create table tblDoanhThu(nam text, tongTien int)";
        db.execSQL(doanhThu);
        db.execSQL(menu);
        db.execSQL(sqlOrder);
        db.execSQL(sqlMA);
        db.execSQL(sql1);
        db.execSQL(sqlCV);
        db.execSQL(sql);
        db.execSQL(sql2);
    }
    public int TongTien(KhachHang kh)
    {
        int data= 0;
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select sum(tongTien) from tblMonAn where maKH=?";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,new String[]{kh.getMaKH()});

        if (cursor.moveToFirst())
        {
            data = cursor.getInt(0);
        }

        return data;
    }
    public int TongDoanhThu(DoanhThu dt)
    {
        int data= 0;
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select sum(tongTien) from tblDoanhThu where nam=?";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,new String[]{dt.getNam()});

        if (cursor.moveToFirst())
        {
            data = cursor.getInt(0);
        }

        return data;
    }
    public List<String> DanhSachKhachHang(){
        List<String>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select maKH from tblKhachHang";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                KhachHang kh = new KhachHang();
                kh.setMaKH(cursor.getString(0));
                data.add(kh.getMaKH());
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<String> DanhSachBan(){
        List<String>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select maBan from tblBan where trangThai='Khong Hoat Dong'";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                Ban ban = new Ban();
                ban.setMaBan(cursor.getString(0));
                data.add(ban.getMaBan());
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<String> DanhSachNhanVien(){
        List<String>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select maNV from tblNhanVien";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(cursor.getString(0));
                data.add(nhanVien.getMaNV());
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<String> Menu(){
        List<String>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select tenMA from tblMenu";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                Menu menu = new Menu();
                menu.setTenMenu(cursor.getString(0));
                data.add(menu.getTenMenu());
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void XoaOrder(Order order){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblOrder where maOrder=?";
        sqLiteDatabase.execSQL(sql,new String[]{order.getMaOrder()});
    }
    public void UpdateBanHoatDong(Ban ban){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblBan set trangThai='Hoat Dong' where maBan=?";
        sqLiteDatabase.execSQL(sql,new String[]{ban.getMaBan()});
    }
    public void UpdateBan(Ban ban){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblBan set trangThai='Khong Hoat Dong' where maBan=?";
        sqLiteDatabase.execSQL(sql,new String[]{ban.getMaBan()});
    }
    public void SuaOrder(Order order){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblOrder set maKH=?,maBan=?,giamGia=?,tongTien=? where maOrder=?";
        sqLiteDatabase.execSQL(sql,new String[]{order.getMaKH(),order.getMaBan(),order.getGiamGia(),order.getTongTien(),order.getMaOrder()});
    }
    public void XoaMenu(Menu menu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblMenu where maMA=?";
        sqLiteDatabase.execSQL(sql,new String[]{menu.getMaMenu()});
    }
    public void ThemMenu(Menu menu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblMenu values(?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{menu.getMaMenu(), menu.getTenMenu(), menu.getDonGiaMenu()});
    }
    public void SuaMenu(Menu menu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblMenu set tenMA=?,donGia=? where maMA=?";
        sqLiteDatabase.execSQL(sql,new String[]{menu.getTenMenu(),menu.getDonGiaMenu(),menu.getMaMenu()});
    }
    public List<Menu> DocMenu(){
        List<Menu>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblMenu";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                Menu menu=new Menu();
                menu.setMaMenu(cursor.getString(0));
                menu.setTenMenu(cursor.getString(1));
                menu.setDonGiaMenu(cursor.getString(2));

                data.add(menu);
            }
            while (cursor.moveToNext());
        }
        return data;
    }

    public List<DoanhThu> DocDoanhThu(DoanhThu doanhThu){
        List<DoanhThu>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblDoanhThu where nam=?";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,new String[]{doanhThu.getNam()});
        if (cursor.moveToFirst())
        {
            do {
                DoanhThu menu=new DoanhThu();
                menu.setNam(cursor.getString(0));
                menu.setTongTien(cursor.getInt(1));

                data.add(menu);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void ThemDoanhThu(DoanhThu doanhThu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblDoanhThu values(?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{doanhThu.getNam(), String.valueOf(doanhThu.getTongTien())});
    }
    public void ThemOrder(Order order){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblOrder values(?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{order.getMaOrder(), order.getMaKH(), order.getMaBan(), order.getGiamGia(),order.getTongTien()});
    }
    public List<Order> DocOrder(){
        List<Order>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblOrder";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                Order order=new Order();
                order.setMaOrder(cursor.getString(0));
                order.setMaKH(cursor.getString(1));
                order.setMaBan(cursor.getString(2));
                order.setGiamGia(cursor.getString(3));
                order.setTongTien(cursor.getString(4));

                data.add(order);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<MonAn> DocMonAn(){
        List<MonAn>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblMonAn";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                MonAn monAn=new MonAn();
                monAn.setMaMA(cursor.getString(0));
                monAn.setTenMA(cursor.getString(1));
                monAn.setDonGia(cursor.getString(2));
                monAn.setMaKH(cursor.getString(3));
                monAn.setSoLuong(cursor.getString(4));
                monAn.setTongTien(cursor.getString(5));

                data.add(monAn);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void ThemMonAn(MonAn monAn){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblMonAn values(?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{monAn.getMaMA(), monAn.getTenMA(), monAn.getDonGia(),monAn.getMaKH(),monAn.getSoLuong(),monAn.getTongTien()});
    }
    public void SuaMonAn(MonAn monAn){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblMonAn set tenMA=?,donGia=?,maKH=? where maMA=?";
        sqLiteDatabase.execSQL(sql,new String[]{monAn.getTenMA(),monAn.getDonGia(),monAn.getMaKH(),monAn.getMaMA()});
    }
    public void XoaMonAn(MonAn monAn){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblMonAn where maKH=?";
        sqLiteDatabase.execSQL(sql,new String[]{monAn.getMaKH()});
    }
    public void XoaDoanhThu(DoanhThu doanhThu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblDoanhThu where nam=?";
        sqLiteDatabase.execSQL(sql,new String[]{doanhThu.getNam()});
    }
    public void ThemBan(Ban ban){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblBan values(?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{ban.getMaBan(), ban.getSucChua(),ban.getTrangThai()});
    }
    public void XoaBan(Ban ban){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblBan where maBan=?";
        sqLiteDatabase.execSQL(sql,new String[]{ban.getMaBan()});
    }
    public List<Ban> DocBan(){
        List<Ban>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblBan";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                Ban ban=new Ban();
                ban.setMaBan(cursor.getString(0));
                ban.setSucChua(cursor.getString(1));
                ban.setTrangThai(cursor.getString(2));

                data.add(ban);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void SuaBan(Ban ban){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblBan set sucChua=?,trangThai=? where maBan=?";
        sqLiteDatabase.execSQL(sql,new String[]{ban.getSucChua(),ban.getTrangThai(),ban.getMaBan()});
    }
    public void ThemNhanVien(NhanVien nhanVien){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblNhanVien values(?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{nhanVien.getMaNV(), nhanVien.getTenNV(),nhanVien.getLuong(),nhanVien.getViTri(), nhanVien.getGioiTinh()});
    }
    public void XoaNhanVien(NhanVien nhanVien){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblNhanVien where maNV=?";
        sqLiteDatabase.execSQL(sql,new String[]{nhanVien.getMaNV()});
    }
    public void SuaNhanVien(NhanVien nhanVien){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblNhanVien set tenNV=?,luongNV=?,viTri=?,gioitinh=? where maNV=?";
        sqLiteDatabase.execSQL(sql,new String[]{nhanVien.getTenNV(),nhanVien.getLuong(),nhanVien.getViTri(),nhanVien.getGioiTinh(),nhanVien.getMaNV()});
    }

    public List<NhanVien> DocNhanVien(){
        List<NhanVien>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblNhanVien";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                NhanVien nhanVien=new NhanVien();
                nhanVien.setMaNV(cursor.getString(0));
                nhanVien.setTenNV(cursor.getString(1));
                nhanVien.setLuong(cursor.getString(2));
                nhanVien.setViTri(cursor.getString(3));
                nhanVien.setGioiTinh(cursor.getString(4));

                data.add(nhanVien);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<CongViec> DocAllCongViec(){
        List<CongViec>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblCongViec";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                CongViec congViec=new CongViec();
                congViec.setMaCV(cursor.getString(0));
                congViec.setTenCV(cursor.getString(1));
                congViec.setMaNV(cursor.getString(2));
                congViec.setTenNV(cursor.getString(3));
                congViec.setLoaiCV(cursor.getString(4));

                data.add(congViec);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public List<CongViec> DocCongViec(NhanVien cv){
        List<CongViec>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql= "select * from tblCongViec where maNV =? and tenNV =?";

        Cursor cursor=sqLiteDatabase.rawQuery(sql,new String[]{cv.getMaNV(),cv.getTenNV()});
        if (cursor.moveToFirst())
        {
            do {
                CongViec congViec=new CongViec();
                congViec.setMaCV(cursor.getString(0));
                congViec.setTenCV(cursor.getString(1));
                congViec.setMaNV(cursor.getString(2));
                congViec.setTenNV(cursor.getString(3));
                congViec.setLoaiCV(cursor.getString(4));

                data.add(congViec);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void SuaCongViec(CongViec congViec){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblCongViec set tenCV=?,loai=? where maCV=?";
        sqLiteDatabase.execSQL(sql,new String[]{congViec.getTenCV(),congViec.getLoaiCV(),congViec.getMaCV()});
    }
    public void ThemCongViec(CongViec congViec){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblCongViec values(?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{congViec.getMaCV(), congViec.getTenCV(),congViec.getMaNV(),congViec.getTenNV(), congViec.getLoaiCV()});
    }
    public void XoaCongViec(CongViec congViec){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblCongViec where maCV=?";
        sqLiteDatabase.execSQL(sql,new String[]{congViec.getMaCV()});
    }
    public void ThemKhachHang(KhachHang khachHang){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tblKhachHang values(?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{khachHang.getMaKH(), khachHang.getTenKH(),khachHang.getLoaiKH()});
    }
    public List<KhachHang> DocKhachHang(){
        List<KhachHang>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tblKhachHang";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                KhachHang khachHang=new KhachHang("","","");
                khachHang.setMaKH(cursor.getString(0));
                khachHang.setTenKH(cursor.getString(1));
                khachHang.setLoaiKH(cursor.getString(2));

                data.add(khachHang);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void SuaKhachHang(KhachHang khachHang){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Update tblKhachHang set tenKH=?,loaiKH=? where maKH=?";
        sqLiteDatabase.execSQL(sql,new String[]{khachHang.getTenKH(),khachHang.getLoaiKH(),khachHang.getMaKH()});
    }
    public void XoaKhachHang(KhachHang khachHang){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="Delete from tblKhachHang where maKH=?";
        sqLiteDatabase.execSQL(sql,new String[]{khachHang.getMaKH()});
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
