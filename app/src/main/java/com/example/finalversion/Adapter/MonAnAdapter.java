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

import com.example.finalversion.Ban.Ban;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.R;

import java.util.List;

public class MonAnAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<MonAn> data;

    public MonAnAdapter(@NonNull Context context, int resource, @NonNull List<MonAn> data) {
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
        ImageView ivHinh = convertView.findViewById(R.id.ivHinhMA);

        TextView tvtenMA = convertView.findViewById(R.id.tvtenMA);
        TextView tvdonGia = convertView.findViewById(R.id.tvDonGia);
        TextView tvMaKH = convertView.findViewById(R.id.tvMaKH_MA);
        TextView tvSoLuong = convertView.findViewById(R.id.tvSoLuong);

        TextView tvTong = convertView.findViewById(R.id.tvTongTien);
        MonAn monAn = data.get(position);

        tvtenMA.setText("Ten Mon An: "+monAn.getTenMA());
        tvdonGia.setText("Don Gia: "+monAn.getDonGia());
        tvMaKH.setText("Ma Khach Hang: "+monAn.getMaKH());
        tvSoLuong.setText("So Luong: "+monAn.getSoLuong());
        tvTong.setText("Tong: "+monAn.getTongTien());
        if(monAn.getTenMA().equals("Com Ga"))
        {
            ivHinh.setImageResource(R.drawable.comga);
        }
        if(monAn.getTenMA().equals("Com Suon"))
        {
            ivHinh.setImageResource(R.drawable.comsuon);
        }
        if(monAn.getTenMA().equals("Lau Thai"))
        {
            ivHinh.setImageResource(R.drawable.lau);
        }
        if(monAn.getTenMA().equals("Com Chien"))
        {
            ivHinh.setImageResource(R.drawable.comchien);
        }
        if(monAn.getTenMA().equals("My Xao"))
        {
            ivHinh.setImageResource(R.drawable.mixao);
        }
        return  convertView;
    }
}
