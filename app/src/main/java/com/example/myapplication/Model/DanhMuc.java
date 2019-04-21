package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DanhMuc {

@SerializedName("ID")
@Expose
private String iD;
@SerializedName("HinhAnh")
@Expose
private String hinhAnh;
@SerializedName("Ten")
@Expose
private String ten;

public String getID() {
return iD;
}

public void setID(String iD) {
this.iD = iD;
}

public String getHinhAnh() {
return hinhAnh;
}

public void setHinhAnh(String hinhAnh) {
this.hinhAnh = hinhAnh;
}

public String getTen() {
return ten;
}

public void setTen(String ten) {
this.ten = ten;
}

}