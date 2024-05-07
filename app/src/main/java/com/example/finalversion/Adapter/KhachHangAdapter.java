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

import com.example.finalversion.KhachHang.KhachHang;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.R;

import java.util.List;

public class KhachHangAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<KhachHang> data;

    public KhachHangAdapter(@NonNull Context context, int resource, @NonNull List<KhachHang> data) {
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
        ImageView ivHinh = convertView.findViewById(R.id.ivHinhKH);
        TextView tvMaKH = convertView.findViewById(R.id.tvmaKH);
        TextView tvTenKH = convertView.findViewById(R.id.tvtenKH);

        KhachHang khachHang = data.get(position);

        tvMaKH.setText("Ma Khach Hang: "+khachHang.getMaKH());
        tvTenKH.setText("Ten Khach Hang: "+khachHang.getTenKH());

        if(khachHang.getLoaiKH().equals("Thuong"))
        {
            ivHinh.setImageResource(R.drawable.normal);
        }
        if(khachHang.getLoaiKH().equals("VIP"))
        {
            ivHinh.setImageResource(R.drawable.vip);
        }
        return  convertView;
    }
}
