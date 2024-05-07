package com.example.finalversion.NhanVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.finalversion.Adapter.NhanVienAdapter;
import com.example.finalversion.Database.Database;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuNhanVien extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSach;
    static List<NhanVien> data_nv = new ArrayList<>();
    static NhanVienAdapter adapter_nv;
    static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_nhan_vien);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_nv = new NhanVienAdapter(this,R.layout.item_nhan_vien,data_nv);
        lvDanhSach.setAdapter(adapter_nv);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuNhanVien.this, ChiTietNhanVien.class);
                intent.putExtra("item", data_nv.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_nv.clear();
                data_nv.addAll(db.DocNhanVien());
                adapter_nv.notifyDataSetChanged();
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
                Intent intent =new Intent(TrangChuNhanVien.this, ThemNhanVien.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLNhanVien);
        btnThem=findViewById(R.id.btnThemNhanVien);
        btnThoat=findViewById(R.id.btnThoat);
        lvDanhSach = findViewById(R.id.lvDanhSachNhanVien);
    }
}