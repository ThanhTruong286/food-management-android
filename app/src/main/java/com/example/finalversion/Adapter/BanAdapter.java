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
import com.example.finalversion.CongViec.CongViec;
import com.example.finalversion.R;

import java.util.List;

public class BanAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<Ban> data;

    public BanAdapter(@NonNull Context context, int resource, @NonNull List<Ban> data) {
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
        TextView tvmaBan = convertView.findViewById(R.id.tvmaBan);
        TextView tvSucChua = convertView.findViewById(R.id.tvSucChua);


        Ban ban = data.get(position);
        tvmaBan.setText("Ma Ban: "+ban.getMaBan());
        tvSucChua.setText("Suc Chua: "+ban.getSucChua());

        if(ban.getTrangThai().equals("Hoat Dong"))
        {
            ivHinh.setImageResource(R.drawable.green);
        }
        if(ban.getTrangThai().equals("Khong Hoat Dong"))
        {
            ivHinh.setImageResource(R.drawable.red);
        }

        return  convertView;
    }
}
