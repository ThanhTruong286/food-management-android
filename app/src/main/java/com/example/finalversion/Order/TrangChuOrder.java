package com.example.finalversion.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.finalversion.Adapter.MonAnAdapter;
import com.example.finalversion.Adapter.OrderAdapter;
import com.example.finalversion.Database.Database;
import com.example.finalversion.FragmentNhanVien;
import com.example.finalversion.MonAn.ChiTietMonAn;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.MonAn.ThemMonAn;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuOrder extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSach;
    static List<Order> data_or = new ArrayList<>();
    static OrderAdapter adapter_or;
    static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_order);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_or = new OrderAdapter(this,R.layout.item_order,data_or);
        lvDanhSach.setAdapter(adapter_or);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuOrder.this, ChiTietOrder.class);
                intent.putExtra("item", data_or.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_or.clear();
                data_or.addAll(db.DocOrder());
                adapter_or.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TrangChuOrder.this, FragmentNhanVien.class);
                startActivity(intent);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TrangChuOrder.this, ThemOrder.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLOrder);
        btnThem=findViewById(R.id.btnThemOrder);
        btnThoat=findViewById(R.id.btnThoatOrder);
        lvDanhSach = findViewById(R.id.lvDanhSachOrder);
    }
}