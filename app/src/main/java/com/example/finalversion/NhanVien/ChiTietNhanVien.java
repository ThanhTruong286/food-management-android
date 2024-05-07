package com.example.finalversion.NhanVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import com.example.finalversion.Adapter.NhanVienAdapter;
import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.CongViec.TrangChuCongViec;
import com.example.finalversion.Database.Database;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietNhanVien extends AppCompatActivity {
    EditText edtMaNV,edtTenNV,edtLuong,edtViTri;
    Spinner spGioiTinh;
    Button btnBack, btnXoa, btnSua, btnDoc;
    ImageView ivHinh;
    NhanVien nhanVien;
    List<String> data_lnv = new ArrayList<>();
    ArrayAdapter adapter_lnv;

    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nhan_vien);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaNV.setEnabled(false);
        Khoitao();
        nhanVien = (NhanVien) getIntent().getSerializableExtra("item");
        adapter_lnv = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lnv);

        spGioiTinh.setAdapter(adapter_lnv);
        edtMaNV.setText(nhanVien.getMaNV());
        edtTenNV.setText(nhanVien.getTenNV());
        edtLuong.setText(nhanVien.getLuong());
        edtViTri.setText(nhanVien.getViTri());


        if(nhanVien.getGioiTinh().equals("Nam"))
            spGioiTinh.setSelection(0);
        if(nhanVien.getGioiTinh().equals("Nu"))
            spGioiTinh.setSelection(1);
        spGioiTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spGioiTinh.getSelectedItem().toString().equals("Nam"))
                    ivHinh.setImageResource(R.drawable.male);
                if(spGioiTinh.getSelectedItem().toString().equals("Nu"))
                    ivHinh.setImageResource(R.drawable.female);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nhanVien=new NhanVien();
                nhanVien.setMaNV(edtMaNV.getText().toString());

                TrangChuNhanVien.db.XoaNhanVien(nhanVien);
                Toast.makeText(ChiTietNhanVien.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien sinhVien=new NhanVien();
                sinhVien.setMaNV(edtMaNV.getText().toString());
                sinhVien.setTenNV(edtTenNV.getText().toString());
                sinhVien.setLuong(edtLuong.getText().toString());
                sinhVien.setViTri(edtViTri.getText().toString());
                sinhVien.setGioiTinh(spGioiTinh.getSelectedItem().toString());

                TrangChuNhanVien.db.SuaNhanVien(sinhVien);
                Toast.makeText(ChiTietNhanVien.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(edtMaNV.getText().toString());
                nv.setTenNV(edtTenNV.getText().toString());
                Intent intent = new Intent(ChiTietNhanVien.this,CongViecNhanVien.class);
                intent.putExtra("maNV",nv.getMaNV());
                intent.putExtra("tenNV",nv.getTenNV());
                startActivity(intent);
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
        data_lnv.add("Nam");
        data_lnv.add("Nu");
    }

    private void setControl() {
        edtMaNV= findViewById(R.id.edtmaNV_chitiet);
        edtTenNV = findViewById(R.id.edtTenNV_chitiet);
        edtLuong = findViewById(R.id.edtLuong_chitiet);
        edtViTri = findViewById(R.id.edtViTri_chitiet);

        spGioiTinh=findViewById(R.id.spGioiTinh_chitiet);
        btnDoc=findViewById(R.id.btnDocCongViec);
        btnBack = findViewById(R.id.btnCTBackct);
        btnXoa = findViewById(R.id.btnCTXoact);
        btnSua = findViewById(R.id.btnCTSuact);
        ivHinh = findViewById(R.id.ivCTHinh);
    }
}