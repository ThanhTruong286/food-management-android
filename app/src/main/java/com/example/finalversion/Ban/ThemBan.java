package com.example.finalversion.Ban;

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

import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.CongViec.ThemCongViec;
import com.example.finalversion.CongViec.TrangChuCongViec;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ThemBan extends AppCompatActivity {
    EditText edtmaBan, edtSucChua;
    ImageView ivThemHinh;
    Spinner spTrangThai;
    Button btnThem,btnLamMoi,btnQuayLai;
    List<String> data_ban= new ArrayList<>();
    ArrayAdapter adapter_ban;
    int[] srcIv = {R.drawable.green , R.drawable.red};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_ban);
        setColntrol();
        setEvent();
    }
    private void setEvent() {
        Khoitao();
        adapter_ban = new ArrayAdapter<>(ThemBan.this, android.R.layout.simple_list_item_1,data_ban);
        spTrangThai.setAdapter(adapter_ban);
        TrangChuBan.lvDanhSachBan.setAdapter(TrangChuBan.adapter_ban);

        spTrangThai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                Ban ban = new Ban();
                ban.setMaBan(edtmaBan.getText().toString());
                ban.setSucChua(edtSucChua.getText().toString());

                ban.setTrangThai(spTrangThai.getSelectedItem().toString());
                TrangChuBan.db.ThemBan(ban);

                Toast.makeText(ThemBan.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtmaBan.setText("");
                edtSucChua.setText("");
                spTrangThai.setSelection(0);
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
        data_ban.add("Hoat Dong");
        data_ban.add("Khong Hoat Dong");
    }

    private void setColntrol() {
        edtmaBan = findViewById(R.id.edtmaBan_them);
        edtSucChua = findViewById(R.id.edtSucChua_them);

        ivThemHinh=findViewById(R.id.ivThemhinhBan);
        spTrangThai = findViewById(R.id.spTrangThai_them);
        btnThem = findViewById(R.id.btnThemBan_them);
        btnLamMoi = findViewById(R.id.btnLamMoiBan_them);
        btnQuayLai = findViewById(R.id.btnQuayLaiBan_them);
    }
}