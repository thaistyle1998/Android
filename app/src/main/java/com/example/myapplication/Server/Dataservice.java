package com.example.myapplication.Server;

import com.example.myapplication.Model.Banner;
import com.example.myapplication.Model.DanhMuc;
import com.example.myapplication.Model.FlashDetail;
import com.example.myapplication.Model.GoiY;
import com.example.myapplication.Model.TimKiem;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Dataservice {

    @GET("banners.php")
    Call<List<Banner>> getDataBanner();
    @GET("FlashDetails.php")
    Call<List<FlashDetail>>  getFlashDetail();
    @GET("timkiem.php")
    Call<List<TimKiem>> getDataTimKiem();
    @GET("danhmuc.php")
    Call<List<DanhMuc>> getDataDanhMuc();
    @GET("goiy.php")
    Call<List<GoiY>> getDataGoiy();




}
