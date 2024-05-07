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


import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.R;

import java.util.List;

public class CongViecAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<CongViec> data;

    public CongViecAdapter(@NonNull Context context, int resource, @NonNull List<CongViec> data) {
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
        TextView tvmaCV = convertView.findViewById(R.id.tvmaCV);
        TextView tvtenCV = convertView.findViewById(R.id.tvtenCV);
        TextView tvmaNV = convertView.findViewById(R.id.tvMaNVCV);
        TextView tvtenNV = convertView.findViewById(R.id.tvTenNVCV);

        CongViec cv = data.get(position);
        tvmaCV.setText("Ma Cong Viec: "+cv.getMaCV());
        tvtenNV.setText("Ten Nhan Vien: "+cv.getTenNV());
        tvtenCV.setText("Ten Cong Viec: "+cv.getTenCV());
        tvmaNV.setText("Ma Nhan Vien: "+cv.getMaNV());

        if(cv.getLoaiCV().equals("Viec Vat"))
        {
            ivHinh.setImageResource(R.drawable.lowjob);
        }
        if(cv.getLoaiCV().equals("Viec Uu Tien"))
        {
            ivHinh.setImageResource(R.drawable.highjob);
        }
        if(cv.getLoaiCV().equals("Viec Khan Cap"))
        {
            ivHinh.setImageResource(R.drawable.veryhighjob);
        }
        return  convertView;
    }
}
