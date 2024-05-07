package com.example.finalversion.CongViec;

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

import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.NhanVien.ThemNhanVien;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ThemCongViec extends AppCompatActivity {
    EditText edtmaCV, edtTenCV,edtTenNV;
    ImageView ivThemHinh;
    Spinner spLoaiCV,spNV;
    Button btnThem,btnLamMoi,btnQuayLai;
    List<String> data_cv= new ArrayList<>();
    ArrayAdapter adapter_cv;
    List<String> data_nv = new ArrayList<>();
    ArrayAdapter adapter_nv;
    int[] srcIv = {R.drawable.lowjob , R.drawable.highjob};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_cong_viec);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        Khoitao();
        adapter_nv = new ArrayAdapter<>(ThemCongViec.this, android.R.layout.simple_list_item_1,data_nv);
        spNV.setAdapter(adapter_nv);
        adapter_cv = new ArrayAdapter<>(ThemCongViec.this, android.R.layout.simple_list_item_1,data_cv);
        spLoaiCV.setAdapter(adapter_cv);
        TrangChuCongViec.lvDanhSachCongViec.setAdapter(TrangChuCongViec.adapter_cv);

        spLoaiCV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                CongViec congViec = new CongViec("","","","","");
                congViec.setMaNV(spNV.getSelectedItem().toString());
                congViec.setTenNV(edtTenNV.getText().toString());
                congViec.setMaCV(spNV.getSelectedItem().toString());
                congViec.setTenCV(edtTenCV.getText().toString());

                congViec.setLoaiCV(spLoaiCV.getSelectedItem().toString());
                TrangChuCongViec.db.ThemCongViec(congViec);

                Toast.makeText(ThemCongViec.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTenNV.setText("");
                edtTenCV.setText("");
                edtmaCV.setText("");
                spLoaiCV.setSelection(0);
                spNV.setSelection(0);
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
        data_cv.add("Viec Vat");
        data_cv.add("Viec Uu Tien");
        data_cv.add("Viec Khan Cap");
        data_nv = TrangChuCongViec.db.DanhSachNhanVien();
    }

    private void setColntrol() {
        spNV=findViewById(R.id.spNhanVien);
        edtTenNV = findViewById(R.id.edtTenNVCV_them);
        edtmaCV = findViewById(R.id.edtmaCV_them);
        edtTenCV = findViewById(R.id.edtTenCV_them);
        ivThemHinh=findViewById(R.id.ivThemhinha);
        spLoaiCV = findViewById(R.id.spLoaiCV_them);
        btnThem = findViewById(R.id.btnThem_a);
        btnLamMoi = findViewById(R.id.btnLamMoi);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }
}