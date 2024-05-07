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

import com.example.finalversion.DoanhThu.DoanhThu;
import com.example.finalversion.DoanhThu.TrangChuDoanhThu;
import com.example.finalversion.NhanVien.NhanVien;
import com.example.finalversion.R;

import java.util.List;

public class DoanhThuAdapter extends ArrayAdapter {
    Context context;
    int resuorse;
    List<DoanhThu> data;

    public DoanhThuAdapter(@NonNull Context context, int resource, @NonNull List<DoanhThu> data) {
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

        TextView tvNam = convertView.findViewById(R.id.tvNam);
        TextView tvDoanhThu = convertView.findViewById(R.id.tvDoanhThu);


        DoanhThu doanhThu = data.get(position);

        tvNam.setText("Doanh Thu Thang: "+doanhThu.getNam());
        tvDoanhThu.setText("Tong Doanh Thu: "+ TrangChuDoanhThu.db.TongDoanhThu(doanhThu));

        return  convertView;
    }
}
