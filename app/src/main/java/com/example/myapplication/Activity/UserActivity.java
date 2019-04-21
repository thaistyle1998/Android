package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.Adapter.MainloginAdapter;
import com.example.myapplication.Model.TaiKhoan;
import com.example.myapplication.R;
import com.example.myapplication.ViewPagerChange.ScrollViewPager;
import com.example.myapplication.fragment_login.fragment_login_User;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ScrollViewPager viewPager;
  TabLayout tabLayout;
   MainloginAdapter adapter;
 TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        viewPager=findViewById(R.id.viewpageruser);
        tabLayout=findViewById(R.id.taplayoutuser);
        adapter= new MainloginAdapter(getSupportFragmentManager());
        adapter.AddFragment(new fragment_login_User(),"Tôi");
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(false);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.thongtin);

        Intent intent =  getIntent();
        ArrayList<TaiKhoan> arrayList= intent.getParcelableArrayListExtra("mangtaikhoan");


    }

}
