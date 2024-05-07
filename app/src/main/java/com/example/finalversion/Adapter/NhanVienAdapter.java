package com.example.finalversion.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.R;

import java.util.List;

public class NhanVienAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<NhanVien> data;

    public NhanVienAdapter(@NonNull Context context, int resource, @NonNull List<NhanVien> data) {
        super(context, resource, data);
        this.context = context;
        this.resuorse = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        convertView = LayoutInflater.from(context).inflate(resuorse, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvMaNV = convertView.findViewById(R.id.tvmaNV);
        TextView tvTenNV = convertView.findViewById(R.id.tvtenNV);
        TextView tvLuong = convertView.findViewById(R.id.tvLuong);
        TextView tvViTri = convertView.findViewById(R.id.tvViTri);

        NhanVien nhanVien = data.get(position);

        tvMaNV.setText("Ma Nhan Vien"+nhanVien.getMaNV());
        tvTenNV.setText("Ten Nhan Vien: "+nhanVien.getTenNV());
        tvLuong.setText("Luong: "+nhanVien.getLuong());
        tvViTri.setText("Vi Tri Lam Viec: "+nhanVien.getViTri());

        if(nhanVien.getGioiTinh().equals("Nam"))
        {
            ivHinh.setImageResource(R.drawable.male);
        }
        if(nhanVien.getGioiTinh().equals("Nu"))
        {
            ivHinh.setImageResource(R.drawable.female);
        }
        return  convertView;
    }
}
