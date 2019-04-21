package com.example.myapplication.Server;

import com.example.myapplication.Model.TaiKhoan;
import com.example.myapplication.Model.TaiKhoanTT;
import com.example.myapplication.Model.ThongTinTK;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface DataCilentXAMPP {


    @FormUrlEncoded
    @POST("DangKy.php")
    Call<String> InSertdata(@Field("ten") String ten,
                        @Field("sodienthoai") String sodienthoai,
                        @Field("matkhau") String matkhau,
                        @Field("matkhautwo") String matkhautwo);
    @FormUrlEncoded
    @POST("dangnhap.php")
    Call<List<TaiKhoan>> getDatataikhoan(@Field("ten") String ten,
                                         @Field("matkhau") String matkhau);
    @Multipart
    @POST("upload.php")
    Call<String> getUpLoad (@Part MultipartBody.Part photo);
    @Multipart
    @POST("uploadicon.php")
    Call<String> getUploadIcon (@Part MultipartBody.Part photos);
    @FormUrlEncoded
    @POST("insertdata.php")
    Call<String>  Insertthongtin(
                                 @Field("ten") String ten,
                                 @Field("gioitinh") String gioitinh,
                                 @Field("ngaysinh") String ngaysinh,
                                 @Field("sodienthoai") String sodienthoai);
    @FormUrlEncoded
    @POST("Update.php")
    Call<String> getUpdate(@Field("ten") String ten,
                           @Field("matkhau") String matkhau,
                           @Field("matkhautwo") String matkhautwo);
    @FormUrlEncoded
    @POST("updateanh.php")
    Call<String> UpdateAnh(@Field("ten") String ten,
                           @Field("hinhanh") String hinhanh);
    @FormUrlEncoded
    @POST("loadphoto.php")
    Call<List<TaiKhoanTT>> getLoadphoto(@Field("ten") String ten);
    @FormUrlEncoded
    @POST("updateicon.php")
    Call<String> getUpdateIcon(@Field("ten") String ten,
                               @Field("hinhanhicon") String hinhanhicon);
    @FormUrlEncoded
    @POST("loadphotoicon.php")
    Call<List<TaiKhoanTT>> getHinhAnhIcon(@Field("ten") String ten);
@FormUrlEncoded
    @POST("photoicon.php")
    Call<List<TaiKhoanTT>> getIconUser(@Field("ten") String ten);
@FormUrlEncoded
    @POST("UpdateTT.php")
    Call<String> getThongTin(@Field("ten") String ten,
                             @Field("gioitinh") String gioitinh,
                             @Field("ngaysinh") String ngaysinh);
 @FormUrlEncoded
    @POST("UpdateTTS.php")
    Call<List<TaiKhoanTT>> getThongTinTT(@Field("ten") String ten);
}
