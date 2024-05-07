package com.example.finalversion.Order;

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

import com.example.finalversion.Ban.Ban;
import com.example.finalversion.DoanhThu.DoanhThu;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.MonAn.ThemMonAn;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ThemOrder extends AppCompatActivity {
    EditText edtmaOrder,edtGiamGia,edtTong,edtNam;
    Button btnThem,btnLamMoi,btnQuayLai,btnGoiMon;
    Spinner spKH,spBan;
    List<String> data_kh = new ArrayList<>();
    List<String> data_ban = new ArrayList<>();
    ArrayAdapter adapter_kh;
    ArrayAdapter adapter_ban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_order);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtTong.setEnabled(false);
        KhoiTao();
        adapter_kh = new ArrayAdapter(ThemOrder.this, android.R.layout.simple_list_item_1,data_kh);
        spKH.setAdapter(adapter_kh);
        adapter_ban = new ArrayAdapter(ThemOrder.this, android.R.layout.simple_list_item_1,data_ban);
        spBan.setAdapter(adapter_ban);
        edtTong.setText(getIntent().getStringExtra("TongTien"));
        TrangChuOrder.lvDanhSach.setAdapter(TrangChuOrder.adapter_or);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order = new Order();
                order.setMaOrder(edtmaOrder.getText().toString());
                order.setMaKH(spKH.getSelectedItem().toString());
                order.setMaBan(spBan.getSelectedItem().toString());
                order.setGiamGia(edtGiamGia.getText().toString());
                order.setTongTien(edtTong.getText().toString());
                Ban ban = new Ban();
                ban.setMaBan(spBan.getSelectedItem().toString());
                DoanhThu dt = new DoanhThu();
                dt.setNam(edtNam.getText().toString());
                dt.setTongTien(Integer.parseInt(edtTong.getText().toString()));
                TrangChuOrder.db.ThemDoanhThu(dt);
                TrangChuOrder.db.UpdateBanHoatDong(ban);
                TrangChuOrder.db.ThemOrder(order);

                Toast.makeText(ThemOrder.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaOrder.setText("");
                spBan.setSelection(0);
                spKH.setSelection(0);
                edtGiamGia.setText("");
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemOrder.this, TrangChuOrder.class);
                startActivity(intent);
            }
        });
        btnGoiMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemOrder.this, TrangChuMonAn.class);
                intent.putExtra("maKH",spKH.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
    private void KhoiTao(){
        data_kh = TrangChuOrder.db.DanhSachKhachHang();
        data_ban = TrangChuOrder.db.DanhSachBan();
    }
    private void setControl() {
        edtNam =findViewById(R.id.edtThemNam);
        edtmaOrder = findViewById(R.id.edtmaOrder_them);
        spKH = findViewById(R.id.spKhachHang);
        edtGiamGia=findViewById(R.id.edtGiamGia_them);
        spBan=findViewById(R.id.spBan);
        btnThem = findViewById(R.id.btnThem_Or);
        btnLamMoi = findViewById(R.id.btnLamMoi_Or);
        btnQuayLai = findViewById(R.id.btnQuayLai_Or);
        btnGoiMon=findViewById(R.id.btnGoiMon_Or);
        edtTong=findViewById(R.id.edtTongTien_them);
    }
}