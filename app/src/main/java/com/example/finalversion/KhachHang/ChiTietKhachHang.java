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

import com.example.finalversion.CongViec.ChiTietCongViec;
import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.CongViec.TrangChuCongViec;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietKhachHang extends AppCompatActivity {
    EditText edtMaKH,edtTenKH;
    Spinner spLoaiKH;
    Button btnBack, btnXoa, btnSua;
    ImageView ivHinh;
    KhachHang khachHang;
    List<String> data_lkh = new ArrayList<>();
    ArrayAdapter adapter_lkh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_khach_hang);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaKH.setEnabled(false);
        Khoitao();
        khachHang = (KhachHang) getIntent().getSerializableExtra("item");
        adapter_lkh = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lkh);

        spLoaiKH.setAdapter(adapter_lkh);
        edtMaKH.setText(khachHang.getMaKH());
        edtTenKH.setText(khachHang.getTenKH());

        if(khachHang.getLoaiKH().equals("Thuong"))
            spLoaiKH.setSelection(0);
        if(khachHang.getLoaiKH().equals("VIP"))
            spLoaiKH.setSelection(1);
        spLoaiKH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spLoaiKH.getSelectedItem().toString().equals("Thuong"))
                    ivHinh.setImageResource(R.drawable.normal);
                if(spLoaiKH.getSelectedItem().toString().equals("VIP"))
                    ivHinh.setImageResource(R.drawable.vip);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhachHang khachHang=new KhachHang();
                khachHang.setMaKH(edtMaKH.getText().toString());

                TrangChuKhachHang.db.XoaKhachHang(khachHang);
                Toast.makeText(ChiTietKhachHang.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhachHang khachHang=new KhachHang("","","");
                khachHang.setMaKH(edtMaKH.getText().toString());
                khachHang.setTenKH(edtTenKH.getText().toString());
                khachHang.setLoaiKH(spLoaiKH.getSelectedItem().toString());

                TrangChuKhachHang.db.SuaKhachHang(khachHang);
                Toast.makeText(ChiTietKhachHang.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
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
        data_lkh.add("Thuong");
        data_lkh.add("VIP");
    }

    private void setControl() {
        edtMaKH= findViewById(R.id.edtmaKH_chitiet);
        edtTenKH = findViewById(R.id.edtTenKH_chitiet);

        spLoaiKH=findViewById(R.id.spLoaiKhach_chitiet);
        btnBack = findViewById(R.id.btnCTBackKH);
        btnXoa = findViewById(R.id.btnCTXoaKH);
        btnSua = findViewById(R.id.btnCTSuaKH);
        ivHinh = findViewById(R.id.ivCTHinhKH);
    }
}