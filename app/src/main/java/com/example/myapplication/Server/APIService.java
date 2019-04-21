package com.example.myapplication.Server;

import android.widget.Button;

public class APIService {
    public  final  static  String Base_url="https://thai-tran.000webhostapp.com/HeThongBanHang/Server/";

    public  static  Dataservice getDataservice()
    {
        return  RetrofitCilent.getRetrofit(Base_url).create(Dataservice.class);
    }
}
