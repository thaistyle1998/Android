package com.example.myapplication.Adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MainAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> arrayList = new ArrayList<>();
    ArrayList<String> Title = new ArrayList<>();

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return arrayList.get(i);
    }


    public  void AddFragment(Fragment fragment , String title)
   {
       arrayList.add(fragment);
       Title.add(title);
   }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  Title.get(position);
    }
}
