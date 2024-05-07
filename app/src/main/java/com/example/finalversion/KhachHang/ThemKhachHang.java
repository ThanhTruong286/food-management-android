package com.example.finalversion.KhachHang;

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

import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.NhanVien.ThemNhanVien;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ThemKhachHang extends AppCompatActivity {

    EditText edtmaNV, edtTenNV;
    ImageView ivThemHinh;
    Spinner spLoaiKhach;
    Button btnThem,btnLamMoi,btnQuayLai;
    List<String> data_nv= new ArrayList<>();
    ArrayAdapter adapter_nv;
    int[] srcIv = {R.drawable.normal , R.drawable.vip};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_khach_hang);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        Khoitao();
        adapter_nv = new ArrayAdapter<>(ThemKhachHang.this, android.R.layout.simple_list_item_1,data_nv);
        spLoaiKhach.setAdapter(adapter_nv);
        TrangChuKhachHang.lvDanhSach.setAdapter(TrangChuKhachHang.adapter_kh);

        spLoaiKhach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                KhachHang khachHang = new KhachHang("","","");
                khachHang.setMaKH(edtmaNV.getText().toString());
                khachHang.setTenKH(edtTenNV.getText().toString());

                khachHang.setLoaiKH(spLoaiKhach.getSelectedItem().toString());
                TrangChuKhachHang.db.ThemKhachHang(khachHang);

                Toast.makeText(ThemKhachHang.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaNV.setText("");
                edtTenNV.setText("");
                spLoaiKhach.setSelection(0);
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
        data_nv.add("Thuong");
        data_nv.add("VIP");
    }

    private void setColntrol() {
        edtmaNV = findViewById(R.id.edtmaKH_them);
        edtTenNV = findViewById(R.id.edtTenKH_them);
        ivThemHinh=findViewById(R.id.ivThemhinhKH);
        spLoaiKhach = findViewById(R.id.spLoaiKhach_them);
        btnThem = findViewById(R.id.btnThem_KH);
        btnLamMoi = findViewById(R.id.btnLamMoiKH);
        btnQuayLai = findViewById(R.id.btnQuayLaiKH);
    }
}