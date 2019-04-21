package com.example.myapplication.Server;

public class APIServicesXAMPP {
    public  final  static  String base_url="http://192.168.1.164/BanHangOnLine/";
    public  static  DataCilentXAMPP getDatacilent()
    {
        return  RetrofitXAMPP.getRetrofit(base_url).create(DataCilentXAMPP.class);
    }
}
