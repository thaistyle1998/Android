package com.example.myapplication.Model;

public class ThongTin {
    private  String ten;
    private  String sodienthoai;
    public ThongTin(String ten, String sodienthoai)
    {
        this.ten=ten;
        this.sodienthoai=sodienthoai;
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
}
