package com.example.finalversion.MonAn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finalversion.NhanVien.ChiTietNhanVien;
import com.example.finalversion.NhanVien.CongViecNhanVien;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietMonAn extends AppCompatActivity {
    EditText edtMaMA,edtTenMA,edtdonGia,edtMaKH,edtSoLuong;
    Spinner spDanhGia;
    Button btnBack, btnXoa, btnSua, btnDoc;
    ImageView ivHinh;
    MonAn monAn;
    List<String> data_ma = new ArrayList<>();
    ArrayAdapter adapter_ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_mon_an);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaMA.setEnabled(false);
        Khoitao();
        monAn = (MonAn) getIntent().getSerializableExtra("item");
        adapter_ma = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_ma);

        spDanhGia.setAdapter(adapter_ma);
        edtMaMA.setText(monAn.getMaMA());
        edtTenMA.setText(monAn.getTenMA());
        edtTenMA.setEnabled(false);
        edtdonGia.setText(monAn.getDonGia());
        edtMaKH.setText(monAn.getMaKH());
        edtSoLuong.setText(monAn.getSoLuong());

        if(monAn.getTenMA().equals("Com Ga"))
            spDanhGia.setSelection(0);
        if(monAn.getTenMA().equals("Com Suon"))
            spDanhGia.setSelection(1);
        if(monAn.getTenMA().equals("Lau Thai"))
            spDanhGia.setSelection(2);
        if(monAn.getTenMA().equals("Com Chien"))
            spDanhGia.setSelection(3);
        if(monAn.getTenMA().equals("My Xao"))
            spDanhGia.setSelection(4);
        spDanhGia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spDanhGia.getSelectedItem().toString().equals("Com Ga"))
                    ivHinh.setImageResource(R.drawable.comga);
                if(spDanhGia.getSelectedItem().toString().equals("Com Suon"))
                    ivHinh.setImageResource(R.drawable.comsuon);
                if(spDanhGia.getSelectedItem().toString().equals("Lau Thai"))
                    ivHinh.setImageResource(R.drawable.lau);
                if(spDanhGia.getSelectedItem().toString().equals("Com Chien"))
                    ivHinh.setImageResource(R.drawable.comchien);
                if(spDanhGia.getSelectedItem().toString().equals("My Xao"))
                    ivHinh.setImageResource(R.drawable.mixao);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonAn monAn=new MonAn();
                monAn.setMaKH(edtMaKH.getText().toString());

                TrangChuMonAn.db.XoaMonAn(monAn);
                Toast.makeText(ChiTietMonAn.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonAn monAn=new MonAn();
                monAn.setMaMA(edtMaMA.getText().toString());
                monAn.setTenMA(edtTenMA.getText().toString());
                monAn.setDonGia(edtdonGia.getText().toString());
                monAn.setTenMA(spDanhGia.getSelectedItem().toString());
                monAn.setMaKH(edtMaKH.getText().toString());
                TrangChuMonAn.db.SuaMonAn(monAn);
                Toast.makeText(ChiTietMonAn.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
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
        data_ma.add("Com Ga");
        data_ma.add("Com Suon");
        data_ma.add("Lau Thai");
        data_ma.add("Com Chien");
        data_ma.add("My Xao");
    }

    private void setControl() {
        edtSoLuong=findViewById(R.id.edtSoLuong_chitiet);
        edtMaMA= findViewById(R.id.edtmaMa_chitiet);
        edtTenMA = findViewById(R.id.edttenMA_chitiet);
        edtdonGia = findViewById(R.id.edtdonGia_chitiet);
        edtMaKH=findViewById(R.id.edtMAKHMA_chitiet);
        spDanhGia=findViewById(R.id.spDanhGia_chitiet);
        btnBack = findViewById(R.id.btnCTBackMA);
        btnXoa = findViewById(R.id.btnCTXoaMA);
        btnSua = findViewById(R.id.btnCTSuaMA);
        ivHinh = findViewById(R.id.ivCTHinhMA);
    }
}