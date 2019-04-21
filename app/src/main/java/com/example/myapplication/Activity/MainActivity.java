package com.example.myapplication.Activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.Adapter.MainAdapter;
import com.example.myapplication.Fragment.fragment_dao;
import com.example.myapplication.Fragment.fragment_home;
import com.example.myapplication.Fragment.fragment_mail;
import com.example.myapplication.Fragment.fragment_user;
import com.example.myapplication.R;

import com.example.myapplication.ViewPagerChange.NonSwipeableViewPager;
import com.example.myapplication.ViewPagerChange.ScrollViewPager;

public class MainActivity extends AppCompatActivity {
 TabLayout tabLayout;
ScrollViewPager viewpager;
 MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        Init();

    }

    private void Init() {
        adapter = new MainAdapter(getSupportFragmentManager());
        adapter.AddFragment(new fragment_home(),"Home");
        adapter.AddFragment(new fragment_dao(),"Tin Nhắn");
        adapter.AddFragment(new fragment_mail(),"Email");
        adapter.AddFragment(new fragment_user(),"User");
        viewpager.setAdapter(adapter);
        viewpager.setPagingEnabled(false);
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setIcon(R.drawable.house);
        tabLayout.getTabAt(1).setIcon(R.drawable.chat);
        tabLayout.getTabAt(2).setIcon(R.drawable.emails);
        tabLayout.getTabAt(3).setIcon(R.drawable.thongtin);
    }

    private void Anhxa() {
        tabLayout=findViewById(R.id.mytaplayout);
        viewpager=findViewById(R.id.myviewpager);

    }


}
