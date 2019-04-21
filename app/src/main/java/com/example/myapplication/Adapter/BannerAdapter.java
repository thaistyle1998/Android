package com.example.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.Model.Banner;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter  extends PagerAdapter {
         private Context context;
            private ArrayList<Banner> arrayList;

    public BannerAdapter(Context context, ArrayList<Banner> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem( ViewGroup container, int position) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_banner,null);
        ImageView imageView= view.findViewById(R.id.imagwview);

        Banner banner= arrayList.get(position);
        Picasso.with(context).load(banner.getHinhAnh()).into(imageView);


        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
