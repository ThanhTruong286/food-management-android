package com.example.finalversion.MonAn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalversion.Adapter.MonAnAdapter;
import com.example.finalversion.Adapter.NhanVienAdapter;
import com.example.finalversion.Database.Database;
import com.example.finalversion.KhachHang.KhachHang;
import com.example.finalversion.NhanVien.ChiTietNhanVien;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.NhanVien.ThemNhanVien;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.Order.ThemOrder;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuMonAn extends AppCompatActivity {
    EditText edtMaKH,edtTong;
    Button btnDoc,btnThem,btnThoat,btnTinhTien;
    static ListView lvDanhSach;
    static List<MonAn> data_ma = new ArrayList<>();
    static MonAnAdapter adapter_ma;
    public static Database db;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_mon_an);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtTong.setEnabled(false);
        edtMaKH.setEnabled(false);
        edtMaKH.setText(getIntent().getStringExtra("maKH"));
        db = new Database(this);
        adapter_ma = new MonAnAdapter(this,R.layout.item_mon_an,data_ma);
        lvDanhSach.setAdapter(adapter_ma);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuMonAn.this, ChiTietMonAn.class);
                intent.putExtra("item", data_ma.get(i));
                startActivity(intent);
            }
        });

        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_ma.clear();
                data_ma.addAll(db.DocMonAn());
                adapter_ma.notifyDataSetChanged();
                KhachHang kh = new KhachHang();
                kh.setMaKH(edtMaKH.getText().toString());
                int a = db.TongTien(kh);
                tv.setText("Tong Tien: "+a);
                edtTong.setText(String.valueOf(a));
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TrangChuMonAn.this, ThemMonAn.class);
                intent.putExtra("maKH",edtMaKH.getText().toString());
                startActivity(intent);
            }
        });
        btnTinhTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TrangChuMonAn.this, ThemOrder.class);
                intent.putExtra("TongTien",edtTong.getText().toString());
                intent.putExtra("maKH",edtMaKH.getText().toString());
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        edtMaKH=findViewById(R.id.maKH_tinhTien);
        btnTinhTien=findViewById(R.id.btnTinhTien);
        btnDoc=findViewById(R.id.btnDocDLMonAn);
        btnThem=findViewById(R.id.btnThemMonAn);
        btnThoat=findViewById(R.id.btnThoatMA);
        lvDanhSach = findViewById(R.id.lvDanhSachMonAn);
        edtTong=findViewById(R.id.edtTinhT_them);
        tv=findViewById(R.id.tvTien);
    }
}