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
import com.example.finalversion.Order.Order;
import com.example.finalversion.R;

import java.util.List;

public class OrderAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<Order> data;

    public OrderAdapter(@NonNull Context context, int resource, @NonNull List<Order> data) {
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

        TextView tvmaBan = convertView.findViewById(R.id.tvmaBan_order);
        TextView tvmaOrder = convertView.findViewById(R.id.tvmaOrder);
        TextView tvmaKH = convertView.findViewById(R.id.tvmaKH_order);
        TextView tvgiamGia = convertView.findViewById(R.id.tvgiamGia);
        TextView tvTong = convertView.findViewById(R.id.tvTT);
        Order order = data.get(position);
        tvmaBan.setText("Ma Ban: "+order.getMaBan());
        tvmaOrder.setText("Ma Order: "+order.getMaOrder());
        tvmaKH.setText("Ma Khach Hang: "+order.getMaKH());
        tvgiamGia.setText("Giam Gia: "+order.getGiamGia());
        tvTong.setText("Tong: "+order.getTongTien());
        return  convertView;
    }
}
