package com.example.myapplication.Fragment_trangchu;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.myapplication.Adapter.BannerAdapter;
import com.example.myapplication.Model.Banner;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;


import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_banner extends Fragment {
    View view;

    CircleIndicator circleIndicator;
    BannerAdapter adapter;
    ViewPager viewpagers;
 Runnable runnable;
 Handler handler;
 int currenttime=0;
 ImageView  imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_banner,container,false);
        circleIndicator=view.findViewById(R.id.cidicator);
        viewpagers=view.findViewById(R.id.myviewpager);
        imageView=view.findViewById(R.id.imagethongbao);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.anim_ronate);
        imageView.startAnimation(animation);

        getData();
        return view;
    }

    private void getData() {
        Dataservice dataservice= APIService.getDataservice();
        Call<List<Banner>> callback = dataservice.getDataBanner();
        callback.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                ArrayList<Banner> arrayList = (ArrayList<Banner>) response.body();

                adapter = new BannerAdapter(getActivity(),arrayList);
                viewpagers.setAdapter(adapter);
                circleIndicator.setViewPager(viewpagers);
               handler= new Handler();
               runnable = new Runnable() {
                   @Override
                   public void run() {
                        currenttime =viewpagers.getCurrentItem();
                        currenttime++;
                        if(currenttime>=viewpagers.getAdapter().getCount())
                        {
                            currenttime=0;
                        }
                        viewpagers.setCurrentItem(currenttime,true);
                        handler.postDelayed(runnable,4000);
                   }
               };

              handler.postDelayed(runnable,4000);
            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {
                Log.d("KKK",t.getMessage());

            }
        });

    }
}
