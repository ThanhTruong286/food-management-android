package com.example.finalversion.CongViec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finalversion.Adapter.CongViecAdapter;
import com.example.finalversion.Database.Database;
import com.example.finalversion.NhanVien.ChiTietNhanVien;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietCongViec extends AppCompatActivity {
    EditText edtMaNV,edtTenNV,edtMaCV,edtTenCV;
    Spinner spLoaiCV;
    Button btnBack, btnXoa, btnSua;
    ImageView ivHinh;
    CongViec congViec;
    List<String> data_lcv = new ArrayList<>();
    ArrayAdapter adapter_lcv;

    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_cong_viec);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaCV.setEnabled(false);
        Khoitao();
        congViec = (CongViec) getIntent().getSerializableExtra("item");
        adapter_lcv = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lcv);

        spLoaiCV.setAdapter(adapter_lcv);
        edtMaNV.setText(congViec.getMaNV());
        edtTenNV.setText(congViec.getTenNV());
        edtMaCV.setText(congViec.getMaCV());
        edtTenCV.setText(congViec.getTenCV());

        if(congViec.getLoaiCV().equals("Viec Vat"))
            spLoaiCV.setSelection(0);
        if(congViec.getLoaiCV().equals("Viec Uu Tien"))
            spLoaiCV.setSelection(1);
        spLoaiCV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spLoaiCV.getSelectedItem().toString().equals("Viec Vat"))
                    ivHinh.setImageResource(R.drawable.lowjob);
                if(spLoaiCV.getSelectedItem().toString().equals("Viec Uu Tien"))
                    ivHinh.setImageResource(R.drawable.highjob);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CongViec congViec=new CongViec();
                congViec.setMaCV(edtMaCV.getText().toString());

                TrangChuCongViec.db.XoaCongViec(congViec);
                Toast.makeText(ChiTietCongViec.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CongViec congViec=new CongViec();
                congViec.setMaNV(edtMaNV.getText().toString());
                congViec.setTenNV(edtTenNV.getText().toString());
                congViec.setMaCV(edtMaCV.getText().toString());
                congViec.setTenCV(edtTenCV.getText().toString());
                congViec.setLoaiCV(spLoaiCV.getSelectedItem().toString());

                TrangChuCongViec.db.SuaCongViec(congViec);
                Toast.makeText(ChiTietCongViec.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void Khoitao() {
        data_lcv.add("Viec Vat");
        data_lcv.add("Viec Uu Tien");
    }

    private void setControl() {
        edtMaNV= findViewById(R.id.edtMaNVCV_chitiet);
        edtTenNV = findViewById(R.id.edtTenNVCV_chitiet);
        edtMaCV = findViewById(R.id.edtmaCV_chitiet);
        edtTenCV = findViewById(R.id.edtTenCV_chitiet);
        spLoaiCV=findViewById(R.id.spLoai_chitiet);
        btnBack = findViewById(R.id.btnCTBackCV);
        btnXoa = findViewById(R.id.btnCTXoaCV);
        btnSua = findViewById(R.id.btnCTSuaCV);
        ivHinh = findViewById(R.id.ivCTHinh);
    }
}