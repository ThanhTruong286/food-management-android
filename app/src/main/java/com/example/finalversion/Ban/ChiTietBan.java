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

import com.example.finalversion.CongViec.ChiTietCongViec;
import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.CongViec.TrangChuCongViec;
import com.example.finalversion.R;

import java.util.ArrayList;
import java.util.List;

public class ChiTietBan extends AppCompatActivity {
    EditText edtMaBan,edtSucChua;
    Spinner spTrangThai;
    Button btnBack, btnXoa, btnSua;
    ImageView ivHinh;
    Ban ban;
    List<String> data_ban = new ArrayList<>();
    ArrayAdapter adapter_ban;
    int[] srcIv = {R.drawable.lowjob , R.drawable.highjob};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_ban);
        setControl();
        setEvent();
    }
    private void setEvent() {
        edtMaBan.setEnabled(false);
        Khoitao();
        ban = (Ban) getIntent().getSerializableExtra("item");
        adapter_ban = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_ban);

        spTrangThai.setAdapter(adapter_ban);
        edtMaBan.setText(ban.getMaBan());
        edtSucChua.setText(ban.getSucChua());

        if(ban.getTrangThai().equals("Hoat Dong"))
            spTrangThai.setSelection(0);
        if(ban.getTrangThai().equals("Khong Hoat Dong"))
            spTrangThai.setSelection(1);
        spTrangThai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spTrangThai.getSelectedItem().toString().equals("Hoat Dong"))
                    ivHinh.setImageResource(R.drawable.green);
                if(spTrangThai.getSelectedItem().toString().equals("Khong Hoat Dong"))
                    ivHinh.setImageResource(R.drawable.red);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ban ban=new Ban();
                ban.setMaBan(edtMaBan.getText().toString());

                TrangChuBan.db.XoaBan(ban);
                Toast.makeText(ChiTietBan.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ban ban=new Ban();
                ban.setMaBan(edtMaBan.getText().toString());
                ban.setSucChua(edtSucChua.getText().toString());

                ban.setTrangThai(spTrangThai.getSelectedItem().toString());

                TrangChuBan.db.SuaBan(ban);
                Toast.makeText(ChiTietBan.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
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

    private void setControl() {
        edtMaBan= findViewById(R.id.edtmaBan_chitiet);
        edtSucChua = findViewById(R.id.edtSucChua_chitiet);

        spTrangThai=findViewById(R.id.spTrangThai_chitiet);
        btnBack = findViewById(R.id.btnCTBackBan);
        btnXoa = findViewById(R.id.btnCTXoaBan);
        btnSua = findViewById(R.id.btnCTSuaBan);
        ivHinh = findViewById(R.id.ivCTHinh);
    }
}