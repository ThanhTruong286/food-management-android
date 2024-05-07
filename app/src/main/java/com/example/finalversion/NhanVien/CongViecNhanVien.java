package com.example.finalversion.NhanVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.finalversion.Adapter.CongViecAdapter;
import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.CongViec.ThemCongViec;
import com.example.finalversion.CongViec.TrangChuCongViec;
import com.example.finalversion.Database.Database;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class CongViecNhanVien extends AppCompatActivity {
    EditText edtMaNV,edtTenNV;
    Button btnThem,btnDoc,btnQuayLai;
    ListView lvDanhSach;
    CongViecAdapter adapter;
    List<CongViec> data = new ArrayList<>();
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_viec_nhan_vien);
        setControl();
        setEvent();
    }
    private void setEvent(){
        db = new Database(this);
        adapter = new CongViecAdapter(this,R.layout.item_congviec,data);
        lvDanhSach.setAdapter(adapter);
        edtMaNV.setText(getIntent().getStringExtra("maNV"));
        edtTenNV.setText(getIntent().getStringExtra("tenNV"));
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(edtMaNV.getText().toString());
                nv.setTenNV(edtTenNV.getText().toString());
                data.clear();
                data.addAll(db.DocCongViec(nv));
                adapter.notifyDataSetChanged();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CongViecNhanVien.this, TrangChuCongViec.class);
                startActivity(intent);
            }
        });
    }
    private void setControl(){
        btnQuayLai=findViewById(R.id.btnQuayLai1);
        btnThem=findViewById(R.id.btnThem1);
        btnDoc=findViewById(R.id.btnShowCV);
        edtMaNV=findViewById(R.id.edtmaCVCuaNV_them);
        edtTenNV=findViewById(R.id.edtTenCVCuaNV_them);
        lvDanhSach=findViewById(R.id.lvDanhSachCongViecCuaNhanVien);
    }
}