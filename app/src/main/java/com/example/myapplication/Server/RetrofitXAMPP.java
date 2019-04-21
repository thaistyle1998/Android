package com.example.myapplication.Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitXAMPP {
    private  static Retrofit retrofit=null;
    public  static  Retrofit getRetrofit(String base_url){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(15000, TimeUnit.MILLISECONDS)
                .writeTimeout(15000,TimeUnit.MILLISECONDS)
                .connectTimeout(15000,TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .build();
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_url)
                .client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return  retrofit;
    }

}
