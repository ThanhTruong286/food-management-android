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

import com.example.finalversion.Menu.Menu;
import com.example.finalversion.MonAn.MonAn;
import com.example.finalversion.R;

import java.util.List;

public class MenuAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<Menu> data;

    public MenuAdapter(@NonNull Context context, int resource, @NonNull List<Menu> data) {
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

        TextView tvtenMA = convertView.findViewById(R.id.tvtenMenu);
        TextView tvdonGia = convertView.findViewById(R.id.tvDonGiaMenu);
        TextView tvmaMA = convertView.findViewById(R.id.tvmaMenu);

        Menu menu = data.get(position);
        tvmaMA.setText("Ma Mon An: "+menu.getMaMenu());
        tvtenMA.setText("Ten Mon An: "+menu.getTenMenu());
        tvdonGia.setText("Don Gia: "+menu.getDonGiaMenu());
        if(menu.getTenMenu().equals("Com Ga"))
        {
            ivHinh.setImageResource(R.drawable.comga);
        }
        if(menu.getTenMenu().equals("Com Suon"))
        {
            ivHinh.setImageResource(R.drawable.comsuon);
        }
        if(menu.getTenMenu().equals("Lau Thai"))
        {
            ivHinh.setImageResource(R.drawable.lau);
        }
        if(menu.getTenMenu().equals("Com Chien"))
        {
            ivHinh.setImageResource(R.drawable.comchien);
        }
        if(menu.getTenMenu().equals("My Xao"))
        {
            ivHinh.setImageResource(R.drawable.mixao);
        }
        return  convertView;
    }
}
