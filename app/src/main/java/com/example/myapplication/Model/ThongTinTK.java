package com.example.myapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThongTinTK implements Parcelable {
    @SerializedName("ID")
    @Expose
    private  String iD;
    @SerializedName("ten")
    @Expose
    private  String ten;
    @SerializedName("sodienthoai")
    @Expose
    private  String sodienthoai;
    @SerializedName("matkhau")
    @Expose
    private String matkhau;
    @SerializedName("matkhautwo")
    @Expose
    private  String matkhautwo;
    @SerializedName("hinhanhicon")
    @Expose
    private  String hinhanhicon;
    @SerializedName("hinhanh")
    @Expose
    private  String hinhanh;
    @SerializedName("gioitinh")
    @Expose
    private  String gioitinh;
    @SerializedName("ngaysinh")
    @Expose
    private  String ngaysinh;

    protected ThongTinTK(Parcel in) {
        iD = in.readString();
        ten = in.readString();
        sodienthoai = in.readString();
        matkhau = in.readString();
        matkhautwo = in.readString();
        hinhanhicon = in.readString();
        hinhanh = in.readString();
        gioitinh = in.readString();
        ngaysinh = in.readString();
    }

    public static final Creator<ThongTinTK> CREATOR = new Creator<ThongTinTK>() {
        @Override
        public ThongTinTK createFromParcel(Parcel in) {
            return new ThongTinTK(in);
        }

        @Override
        public ThongTinTK[] newArray(int size) {
            return new ThongTinTK[size];
        }
    };

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getMatkhautwo() {
        return matkhautwo;
    }

    public void setMatkhautwo(String matkhautwo) {
        this.matkhautwo = matkhautwo;
    }

    public String getHinhanhicon() {
        return hinhanhicon;
    }

    public void setHinhanhicon(String hinhanhicon) {
        this.hinhanhicon = hinhanhicon;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iD);
        dest.writeString(ten);
        dest.writeString(sodienthoai);
        dest.writeString(matkhau);
        dest.writeString(matkhautwo);
        dest.writeString(hinhanhicon);
        dest.writeString(hinhanh);
        dest.writeString(gioitinh);
        dest.writeString(ngaysinh);
    }
}
