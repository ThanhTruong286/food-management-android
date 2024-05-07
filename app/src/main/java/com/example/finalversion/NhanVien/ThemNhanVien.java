package com.example.finalversion.NhanVien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ThemNhanVien extends AppCompatActivity {
    EditText edtmaNV, edtTenNV,edtLuong,edtViTri;
    ImageView ivThemHinh;
    Spinner spGioiTinh;
    Button btnThem,btnLamMoi,btnQuayLai;
    List<String> data_nv= new ArrayList<>();
    ArrayAdapter adapter_nv;
    int[] srcIv = {R.drawable.male , R.drawable.female};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        Khoitao();
        adapter_nv = new ArrayAdapter<>(ThemNhanVien.this, android.R.layout.simple_list_item_1,data_nv);
        spGioiTinh.setAdapter(adapter_nv);
        TrangChuNhanVien.lvDanhSach.setAdapter(TrangChuNhanVien.adapter_nv);

        spGioiTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ivThemHinh.setImageResource(srcIv[position]);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nhanVien = new NhanVien("","","","","");
                nhanVien.setMaNV(edtmaNV.getText().toString());
                nhanVien.setTenNV(edtTenNV.getText().toString());
                nhanVien.setLuong(edtLuong.getText().toString());
                nhanVien.setViTri(edtViTri.getText().toString());

                nhanVien.setGioiTinh(spGioiTinh.getSelectedItem().toString());
                TrangChuNhanVien.db.ThemNhanVien(nhanVien);

                Toast.makeText(ThemNhanVien.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaNV.setText("");
                edtTenNV.setText("");
                edtLuong.setText("");
                edtViTri.setText("");
                spGioiTinh.setSelection(0);
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void Khoitao() {
        data_nv.add("Nam");
        data_nv.add("Nu");
    }

    private void setColntrol() {
        edtmaNV = findViewById(R.id.edtmaNV_them);
        edtTenNV = findViewById(R.id.edtTenNV_them);
        edtLuong = findViewById(R.id.edtLuong_them);
        edtViTri = findViewById(R.id.edtViTri_them);
        ivThemHinh=findViewById(R.id.ivThemhinha);
        spGioiTinh = findViewById(R.id.spThemGioiTinh_them);
        btnThem = findViewById(R.id.btnThem_a);
        btnLamMoi = findViewById(R.id.btnLamMoi);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }
}