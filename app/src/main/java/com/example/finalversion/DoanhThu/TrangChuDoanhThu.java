package com.example.finalversion.DoanhThu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalversion.Adapter.DoanhThuAdapter;
import com.example.finalversion.Adapter.MonAnAdapter;
import com.example.finalversion.Database.Database;
import com.example.finalversion.KhachHang.KhachHang;
import com.example.finalversion.MonAn.ChiTietMonAn;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.MonAn.ThemMonAn;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.Order.ThemOrder;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuDoanhThu extends AppCompatActivity {
    EditText edtNam;
    Button btnDoc,btnThoat,btnXoa;
    static ListView lvDanhSach;
    static List<DoanhThu> data_dt = new ArrayList<>();
    static DoanhThuAdapter adapter_dt;
    public static Database db;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_doanh_thu);
        setControl();
        setEvent();
    }
    private void setEvent() {

        db = new Database(this);
        adapter_dt = new DoanhThuAdapter(this,R.layout.item_doanh_thu,data_dt);
        lvDanhSach.setAdapter(adapter_dt);

        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoanhThu dt = new DoanhThu();
                dt.setNam(edtNam.getText().toString());
                data_dt.clear();
                data_dt.addAll(db.DocDoanhThu(dt));
                adapter_dt.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoanhThu dt = new DoanhThu();
                dt.setNam(edtNam.getText().toString());
                db.XoaDoanhThu(dt);
                Toast.makeText(TrangChuDoanhThu.this,"Xoa Thanh Cong",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setControl() {
        edtNam=findViewById(R.id.Nam);
        btnDoc=findViewById(R.id.docDoanhThu);
        btnThoat=findViewById(R.id.btnThoatDoanhThu);
        lvDanhSach = findViewById(R.id.lvDanhSachDoanhThu);
        tv=findViewById(R.id.tvTien);
        btnXoa=findViewById(R.id.xoaDoanhThu);
    }
}