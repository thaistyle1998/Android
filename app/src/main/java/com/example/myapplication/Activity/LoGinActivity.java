package com.example.myapplication.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.Adapter.LoGinAdapter;
import com.example.myapplication.R;
import com.example.myapplication.ViewPagerChange.ScrollViewPager;
import com.example.myapplication.fragment_login.fragment_dangki;
import com.example.myapplication.fragment_login.fragment_login;

public class LoGinActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
}
