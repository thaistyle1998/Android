package com.example.myapplication.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainloginAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> arrayList = new ArrayList<>();
    ArrayList<String> Title =new ArrayList<>();
    public MainloginAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
    public void AddFragment(Fragment fragment,String title)
    {
        arrayList.add(fragment);
        Title.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  Title.get(position);
    }
}
