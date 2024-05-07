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

import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.MonAn.ThemMonAn;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ThemMenu extends AppCompatActivity {
    EditText edtMaMon,edtTenMon,edtDonGia;
    Button btnThem,btnLamMoi,btnQuayLai;
    //int[] srcIv = {R.drawable.comga , R.drawable.comsuon,R.drawable.lau,R.drawable.comchien,R.drawable.mixao};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_menu);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu monAn = new Menu();

                monAn.setMaMenu(edtMaMon.getText().toString());
                monAn.setTenMenu(edtTenMon.getText().toString());
                monAn.setDonGiaMenu(edtDonGia.getText().toString());

                TrangChuMenu.db.ThemMenu(monAn);

                Toast.makeText(ThemMenu.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtMaMon.setText("");
                edtTenMon.setText("");
                edtDonGia.setText("");
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void setColntrol() {
        edtMaMon=findViewById(R.id.maMenu);
        edtTenMon=findViewById(R.id.tenMenu);
        edtDonGia = findViewById(R.id.donGiaMenu);
        btnThem = findViewById(R.id.btnThem_Menu);
        btnLamMoi = findViewById(R.id.btnLamMoi_Menu);
        btnQuayLai = findViewById(R.id.btnQuayLai_Menu);
    }
}