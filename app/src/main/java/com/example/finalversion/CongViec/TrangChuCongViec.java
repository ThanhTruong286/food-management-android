package com.example.finalversion.CongViec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.finalversion.Adapter.CongViecAdapter;
import com.example.finalversion.Adapter.NhanVienAdapter;
import com.example.finalversion.Database.Database;
import com.example.finalversion.NhanVien.ChiTietNhanVien;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.NhanVien.ThemNhanVien;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuCongViec extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSachCongViec;
    static List<CongViec> data_cv = new ArrayList<>();
    static CongViecAdapter adapter_cv;
    static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_cong_viec);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_cv = new CongViecAdapter(this,R.layout.item_congviec,data_cv);
        lvDanhSachCongViec.setAdapter(adapter_cv);

        lvDanhSachCongViec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuCongViec.this, ChiTietCongViec.class);
                intent.putExtra("item", data_cv.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = new NhanVien("1","Thanh Truong","","","");
                data_cv.clear();
                data_cv.addAll(db.DocAllCongViec());
                adapter_cv.notifyDataSetChanged();
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
                Intent intent =new Intent(TrangChuCongViec.this, ThemCongViec.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLCongViec);
        btnThem=findViewById(R.id.btnThemCongViec);
        btnThoat=findViewById(R.id.btnThoat);
        lvDanhSachCongViec = findViewById(R.id.lvDanhSachCongViec);
    }
}