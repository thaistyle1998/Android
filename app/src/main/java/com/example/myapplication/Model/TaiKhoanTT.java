package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaiKhoanTT {

@SerializedName("ID")
@Expose
private String iD;
@SerializedName("ten")
@Expose
private String ten;
@SerializedName("sodienthoai")
@Expose
private String sodienthoai;
@SerializedName("matkhau")
@Expose
private String matkhau;
@SerializedName("matkhautwo")
@Expose
private String matkhautwo;
@SerializedName("hinhanhicon")
@Expose
private String hinhanhicon;
@SerializedName("hinhanh")
@Expose
private String hinhanh;
@SerializedName("gioitinh")
@Expose
private String gioitinh;
@SerializedName("ngaysinh")
@Expose
private String ngaysinh;

public String getID() {
return iD;
}

public void setID(String iD) {
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

}