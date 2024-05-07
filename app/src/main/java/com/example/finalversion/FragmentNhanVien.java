package com.example.finalversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.finalversion.Ban.TrangChuBan;
import com.example.finalversion.CongViec.TrangChuCongViec;
import com.example.finalversion.KhachHang.TrangChuKhachHang;
import com.example.finalversion.Menu.TrangChuMenu;
import com.example.finalversion.MonAn.TrangChuMonAn;
import com.example.finalversion.NhanVien.TrangChuNhanVien;
import com.example.finalversion.Order.TrangChuOrder;
import com.google.android.material.navigation.NavigationView;

public class FragmentNhanVien extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_nhan_vien);
        setControl();
        setEvent();
    }
    private void setEvent() {
        drawerToggle=new ActionBarDrawerToggle(FragmentNhanVien.this,drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.mnKhach){
                    Intent intent = new Intent(FragmentNhanVien.this, TrangChuKhachHang.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.mnBan) {
                    Intent intent = new Intent(FragmentNhanVien.this, TrangChuBan.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnMonAn){
                    Intent intent = new Intent(FragmentNhanVien.this, TrangChuMenu.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnOrder){
                    Intent intent = new Intent(FragmentNhanVien.this, TrangChuOrder.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.mnThoat){
                    Intent intent = new Intent(FragmentNhanVien.this, MainActivity.class);
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
        navigationView=findViewById(R.id.navViewNhanVien);
    }
}