package com.example.finalversion.Menu;

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

import com.example.finalversion.MonAn.ChiTietMonAn;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietMenu extends AppCompatActivity {
    EditText edtMaMA,edtTenMA,edtdonGia;
    Button btnBack, btnXoa, btnSua;
    Menu monAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_menu);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaMA.setEnabled(false);
        monAn = (Menu) getIntent().getSerializableExtra("item");

        edtMaMA.setText(monAn.getMaMenu());
        edtTenMA.setText(monAn.getTenMenu());
        edtdonGia.setText(monAn.getDonGiaMenu());


        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu monAn=new Menu();
                monAn.setMaMenu(edtMaMA.getText().toString());

                TrangChuMenu.db.XoaMenu(monAn);
                Toast.makeText(ChiTietMenu.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu monAn=new Menu();
                monAn.setMaMenu(edtMaMA.getText().toString());
                monAn.setTenMenu(edtTenMA.getText().toString());
                monAn.setDonGiaMenu(edtdonGia.getText().toString());

                TrangChuMonAn.db.SuaMenu(monAn);
                Toast.makeText(ChiTietMenu.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void setControl() {
        edtMaMA= findViewById(R.id.maMn);
        edtTenMA = findViewById(R.id.tenMn);
        edtdonGia = findViewById(R.id.donGiaMn);
        btnBack = findViewById(R.id.btnCTBackMn);
        btnXoa = findViewById(R.id.btnCTXoaMn);
        btnSua = findViewById(R.id.btnCTSuaMn);
    }
}