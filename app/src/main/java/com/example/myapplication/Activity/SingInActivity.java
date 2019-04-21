package com.example.myapplication.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.Adapter.LoGinAdapter;
import com.example.myapplication.R;
import com.example.myapplication.ViewPagerChange.ScrollViewPager;
import com.example.myapplication.fragment_login.fragment_dangki;
import com.example.myapplication.fragment_login.fragment_dangnhap;
import com.example.myapplication.fragment_login.fragment_login;

import java.util.ArrayList;

public class SingInActivity extends AppCompatActivity {
    ScrollViewPager viewPager;
    TabLayout tabLayout;
    LoGinAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        viewPager=findViewById(R.id.viewapgerlogin);
        tabLayout=findViewById(R.id.taplayoutlogin);
        adapter = new LoGinAdapter(getSupportFragmentManager());
        adapter.AddFragment(new fragment_dangnhap(),"Đăng Nhập");
        adapter.AddFragment(new fragment_dangki(),"Đăng Ký");
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(true);
        tabLayout.setupWithViewPager(viewPager);
    }
}
