package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {

@SerializedName("ID")
@Expose
private String iD;
@SerializedName("HinhAnh")
@Expose
private String hinhAnh;

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

}