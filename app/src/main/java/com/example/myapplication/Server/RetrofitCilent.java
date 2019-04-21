package com.example.myapplication.Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCilent {
    private  static Retrofit retrofit=null;
    public  static  Retrofit getRetrofit(String base_url)
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .connectTimeout(15,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_url).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return  retrofit;
    }
}
