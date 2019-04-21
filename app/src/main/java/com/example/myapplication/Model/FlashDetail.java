package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlashDetail {

@SerializedName("ID")
@Expose
private String iD;
@SerializedName("HinhAnh")
@Expose
private String hinhAnh;
@SerializedName("Sale")
@Expose
private String sale;
@SerializedName("Gia")
@Expose
private String gia;

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

public String getSale() {
return sale;
}

public void setSale(String sale) {
this.sale = sale;
}

public String getGia() {
return gia;
}

public void setGia(String gia) {
this.gia = gia;
}

}