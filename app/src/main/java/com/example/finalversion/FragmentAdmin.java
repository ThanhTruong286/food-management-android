package com.example.finalversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.finalversion.CongViec.TrangChuCongViec;
import com.example.finalversion.DoanhThu.TrangChuDoanhThu;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.google.android.material.navigation.NavigationView;

public class FragmentAdmin extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_admin);
        setControl();
        setEvent();
    }
    private void setEvent() {
        drawerToggle=new ActionBarDrawerToggle(FragmentAdmin.this,drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.mnNhanVien){
                    Intent intent = new Intent(FragmentAdmin.this, TrangChuNhanVien.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnThoat){
                    Intent intent = new Intent(FragmentAdmin.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnCongViec){
                    Intent intent = new Intent(FragmentAdmin.this, TrangChuCongViec.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnThongKe){
                    Intent intent = new Intent(FragmentAdmin.this, TrangChuDoanhThu.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
    private void setControl() {
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navView);
    }
}