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
import com.example.finalversion.KhachHang.KhachHang;
import com.example.finalversion.MonAn.ChiTietMonAn;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.NhanVien.ChiTietNhanVien;
import com.example.finalversion.NhanVien.CongViecNhanVien;
import com.example.finalversion.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ChiTietOrder extends AppCompatActivity {
    EditText edtMaOrder,edtMaKH,edtMaBan,edtGiamGia,edtSoLuong,edtTienDua,edtTong;
    Button btnBack, btnXoa, btnSua, btnDoc;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_order);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaOrder.setEnabled(false);
        order = (Order) getIntent().getSerializableExtra("item");

        edtMaOrder.setText(order.getMaOrder());
        edtMaKH.setText(order.getMaKH());
        edtMaBan.setText(order.getMaBan());
        edtGiamGia.setText(order.getGiamGia());
        edtTong.setText(order.getTongTien());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order=new Order();
                order.setMaOrder(edtMaOrder.getText().toString());
                KhachHang kh = new KhachHang();
                kh.setMaKH(edtMaKH.getText().toString());
                TrangChuOrder.db.XoaKhachHang(kh);
                Ban ban = new Ban();
                ban.setMaBan(edtMaBan.getText().toString());
                MonAn ma = new MonAn();
                ma.setMaKH(edtMaKH.getText().toString());
                TrangChuOrder.db.XoaMonAn(ma);
                TrangChuOrder.db.UpdateBan(ban);
                TrangChuOrder.db.XoaOrder(order);
                Toast.makeText(ChiTietOrder.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order=new Order();
                order.setMaOrder(edtMaOrder.getText().toString());
                order.setMaKH(edtMaKH.getText().toString());
                order.setMaBan(edtMaBan.getText().toString());
                order.setGiamGia(edtGiamGia.getText().toString());

                TrangChuOrder.db.SuaOrder(order);
                Toast.makeText(ChiTietOrder.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order=new Order();
                order.setMaOrder(edtMaOrder.getText().toString());
                order.setMaKH(edtMaKH.getText().toString());
                order.setMaBan(edtMaBan.getText().toString());
                order.setGiamGia(edtGiamGia.getText().toString());
                order.setTongTien(edtTong.getText().toString());
                String tien = edtTienDua.getText().toString();
                Intent intent = new Intent(ChiTietOrder.this, TinhToanOrder.class);
                intent.putExtra("maOrder",order.getMaOrder());
                intent.putExtra("maKH",order.getMaKH());
                intent.putExtra("maBan",order.getMaBan());
                intent.putExtra("giamGia",order.getGiamGia());
                intent.putExtra("tienDua",tien);
                intent.putExtra("TongTien",order.getTongTien());
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietOrder.this,TrangChuOrder.class);
                startActivity(intent);
            }
        });
    }


    private void setControl() {
        edtTienDua=findViewById(R.id.edtTienKhachDua_chitiet_Or);
        edtMaOrder= findViewById(R.id.edtmaOrder_chitiet);
        edtMaKH = findViewById(R.id.edtMaKH_chitiet_Or);
        edtMaBan = findViewById(R.id.edtMaBan_chitiet_Or);
        edtGiamGia=findViewById(R.id.edtGiamGia_chitiet_Or);
        edtTong= findViewById(R.id.edtTongTien_chitiet_Or);
        btnBack = findViewById(R.id.btnCTBackOrder);
        btnXoa = findViewById(R.id.btnCTXoaOrder);
        btnSua = findViewById(R.id.btnCTSuaOrder);
        btnDoc=findViewById(R.id.btnDocOrder);
    }
}