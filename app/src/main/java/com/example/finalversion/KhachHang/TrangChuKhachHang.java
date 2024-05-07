package com.example.finalversion.KhachHang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.finalversion.Adapter.KhachHangAdapter;
import com.example.finalversion.Adapter.NhanVienAdapter;
import com.example.finalversion.Database.Database;
import com.example.finalversion.NhanVien.ChiTietNhanVien;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.NhanVien.ThemNhanVien;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuKhachHang extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSach;
    static List<KhachHang> data_kh = new ArrayList<>();
    static KhachHangAdapter adapter_kh;
    public static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_khach_hang);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_kh = new KhachHangAdapter(this,R.layout.item_khach_hang,data_kh);
        lvDanhSach.setAdapter(adapter_kh);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuKhachHang.this, ChiTietKhachHang.class);
                intent.putExtra("item", data_kh.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_kh.clear();
                data_kh.addAll(db.DocKhachHang());
                adapter_kh.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TrangChuKhachHang.this, ThemKhachHang.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLKhachHang);
        btnThem=findViewById(R.id.btnThemKhachHang);
        btnThoat=findViewById(R.id.btnThoatKH);
        lvDanhSach = findViewById(R.id.lvDanhSachKhachHang);
    }
}