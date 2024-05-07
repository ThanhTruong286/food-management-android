package com.example.finalversion.Ban;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.finalversion.Adapter.BanAdapter;
import com.example.finalversion.Adapter.CongViecAdapter;
import com.example.finalversion.CongViec.ChiTietCongViec;
import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.CongViec.ThemCongViec;
import com.example.finalversion.CongViec.TrangChuCongViec;
import com.example.finalversion.Database.Database;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuBan extends AppCompatActivity {
    Button btnDoc,btnThem,btnThoat;
    static ListView lvDanhSachBan;
    static List<Ban> data_ban = new ArrayList<>();
    static BanAdapter adapter_ban;
    public static Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_ban);
        setControl();
        setEvent();
    }
    private void setEvent() {
        db = new Database(this);
        adapter_ban = new BanAdapter(this,R.layout.item_ban,data_ban);
        lvDanhSachBan.setAdapter(adapter_ban);

        lvDanhSachBan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent =new Intent(TrangChuBan.this, ChiTietBan.class);
                intent.putExtra("item", data_ban.get(i));
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ban ban = new Ban();
                data_ban.clear();
                data_ban.addAll(db.DocBan());
                adapter_ban.notifyDataSetChanged();
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
                Intent intent =new Intent(TrangChuBan.this, ThemBan.class);
                startActivity(intent);
            }
        });
    }
    private void setControl() {
        btnDoc=findViewById(R.id.btnDocDLBan);
        btnThem=findViewById(R.id.btnThemBan);
        btnThoat=findViewById(R.id.btnThoatBan);
        lvDanhSachBan = findViewById(R.id.lvDanhSachBan);
    }
}