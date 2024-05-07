package com.example.finalversion.MonAn;

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

import com.example.finalversion.Adapter.MonAnAdapter;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.NhanVien.ThemNhanVien;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ThemMonAn extends AppCompatActivity {
    EditText edtMaKH,edtSoLuong;
    ImageView ivThemHinh;
    Spinner spDanhGia;
    Button btnThem,btnLamMoi,btnQuayLai;
    List<String> data_ma= new ArrayList<>();
    ArrayAdapter adapter_ma;
    int[] srcIv = {R.drawable.comga , R.drawable.comsuon,R.drawable.lau,R.drawable.comchien,R.drawable.mixao};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_mon_an);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        edtMaKH.setEnabled(false);
        edtMaKH.setText(getIntent().getStringExtra("maKH"));
        Khoitao();
        adapter_ma = new ArrayAdapter<>(ThemMonAn.this, android.R.layout.simple_list_item_1,data_ma);
        spDanhGia.setAdapter(adapter_ma);
        TrangChuMonAn.lvDanhSach.setAdapter(TrangChuMonAn.adapter_ma);

        spDanhGia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ivThemHinh.setImageResource(srcIv[position]);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonAn monAn = new MonAn();

                monAn.setSoLuong(edtSoLuong.getText().toString());
                monAn.setMaKH(edtMaKH.getText().toString());
                monAn.setTenMA(spDanhGia.getSelectedItem().toString());
                if(monAn.getTenMA().equals("Com Ga")){
                    monAn.setDonGia("30000");
                }
                if(monAn.getTenMA().equals("Com Suon")){
                    monAn.setDonGia("40000");
                }
                if(monAn.getTenMA().equals("Lau Thai")){
                    monAn.setDonGia("50000");
                }
                if(monAn.getTenMA().equals("Com Chien")){
                    monAn.setDonGia("35000");
                }
                if(monAn.getTenMA().equals("My Xao")){
                    monAn.setDonGia("15000");
                }
                int a = Integer.parseInt(monAn.getDonGia().toString())*Integer.parseInt(edtSoLuong.getText().toString());
                monAn.setTongTien(String.valueOf(a));
                TrangChuMonAn.db.ThemMonAn(monAn);

                Toast.makeText(ThemMonAn.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtSoLuong.setText("");
                spDanhGia.setSelection(0);
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void Khoitao() {
        data_ma = TrangChuMonAn.db.Menu();
    }

    private void setColntrol() {
        edtSoLuong=findViewById(R.id.edtSoLuong_them);
        edtMaKH=findViewById(R.id.edtMaKHMA_them);
        ivThemHinh=findViewById(R.id.ivThemhinhMA);
        spDanhGia = findViewById(R.id.spDanhGia_them);
        btnThem = findViewById(R.id.btnThem_MA);
        btnLamMoi = findViewById(R.id.btnLamMoiMA);
        btnQuayLai = findViewById(R.id.btnQuayLai_MA);
    }
}