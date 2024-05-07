package com.example.finalversion.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.finalversion.Adapter.MenuAdapter;
import com.example.finalversion.Adapter.MonAnAdapter;
import com.example.finalversion.Database.Database;
import com.example.finalversion.MonAn.ChiTietMonAn;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.MonAn.ThemMonAn;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.Order.ThemOrder;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuMenu extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSach;
    static List<Menu> data_ma = new ArrayList<>();
    static MenuAdapter adapter_ma;
    public static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_menu);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_ma = new MenuAdapter(this,R.layout.item_menu,data_ma);
        lvDanhSach.setAdapter(adapter_ma);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuMenu.this, ChiTietMenu.class);
                intent.putExtra("item", data_ma.get(i));
                startActivity(intent);
            }
        });

        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_ma.clear();
                data_ma.addAll(db.DocMenu());
                adapter_ma.notifyDataSetChanged();
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
                Intent intent =new Intent(TrangChuMenu.this, ThemMenu.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLMenu);
        btnThem=findViewById(R.id.btnThemMenu);
        btnThoat=findViewById(R.id.btnThoatMenu);
        lvDanhSach = findViewById(R.id.lvDanhSachMenu);

    }
}