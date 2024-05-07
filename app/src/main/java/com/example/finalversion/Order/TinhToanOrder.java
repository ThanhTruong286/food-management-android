package com.example.finalversion.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalversion.Ban.Ban;
import com.example.finalversion.Ban.TrangChuBan;
import com.example.finalversion.Database.Database;
import com.example.finalversion.KhachHang.KhachHang;
import com.example.finalversion.KhachHang.TrangChuKhachHang;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.R;

public class TinhToanOrder extends AppCompatActivity {
    EditText edtMaOrder,edtMaKH,edtMaBan,edtGiamGia,edtTongTien,edtTienNhan,edtTienTra;
    Button btnThanhToan,btnQuayLai;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_toan_order);
        setControl();
        setEvent();
    }
    private void setEvent(){
        db = new Database(this);
        edtMaOrder.setEnabled(false);
        edtMaKH.setEnabled(false);
        edtMaBan.setEnabled(false);
        edtGiamGia.setEnabled(false);
        edtTienTra.setEnabled(false);
        edtTongTien.setEnabled(false);
        edtTienNhan.setEnabled(false);

        edtMaOrder.setText(getIntent().getStringExtra("maOrder"));
        edtMaKH.setText(getIntent().getStringExtra("maKH"));
        edtMaBan.setText(getIntent().getStringExtra("maBan"));
        edtGiamGia.setText(getIntent().getStringExtra("giamGia"));
        edtTienNhan.setText(getIntent().getStringExtra("tienDua"));
        edtTongTien.setText(getIntent().getStringExtra("TongTien"));

        String giamGia = edtGiamGia.getText().toString();

        int tien = Integer.parseInt(edtTongTien.getText().toString());
        int tienNhan = Integer.parseInt(edtTienNhan.getText().toString());
        int giam = Integer.parseInt(giamGia);
        int tra = 0;

        int tongTien = tien-giam;
        if(tienNhan > tongTien){
            tra = tienNhan-tongTien;
        }
        edtTienTra.setText(String.valueOf(tra));
        edtTongTien.setText(String.valueOf(tongTien));
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order();
                order.setMaOrder(edtMaOrder.getText().toString());
                TrangChuOrder.db.XoaOrder(order);
                KhachHang kh = new KhachHang();
                kh.setMaKH(edtMaKH.getText().toString());
                TrangChuOrder.db.XoaKhachHang(kh);
                Ban ban = new Ban();
                ban.setMaBan(edtMaBan.getText().toString());
                TrangChuOrder.db.UpdateBan(ban);
                MonAn ma = new MonAn();
                ma.setMaKH(edtMaKH.getText().toString());
                TrangChuOrder.db.XoaMonAn(ma);
                Toast.makeText(TinhToanOrder.this, "Thanh Toan thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TinhToanOrder.this,TrangChuOrder.class);
                startActivity(intent);
            }
        });
    }
    private void setControl(){
        edtMaOrder=findViewById(R.id.edtmaOrder_ThanhToan);
        edtMaKH=findViewById(R.id.edtMaKH_ThanhToan);
        edtMaBan=findViewById(R.id.edtMaBan_ThanhToan);
        edtGiamGia=findViewById(R.id.edtGiamGia_ThanhToan);
        edtTongTien=findViewById(R.id.edtTong_ThanhToan);
        edtTienNhan=findViewById(R.id.edtNhan_ThanhToan);
        edtTienTra=findViewById(R.id.edtTra_ThanhToan);

        btnThanhToan=findViewById(R.id.btnThanhToan);
        btnQuayLai=findViewById(R.id.btnQuayLai);
    }
}