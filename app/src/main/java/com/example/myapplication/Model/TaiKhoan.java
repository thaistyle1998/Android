package com.example.myapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaiKhoan implements Parcelable {

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

    protected TaiKhoan(Parcel in) {
        iD = in.readString();
        ten = in.readString();
        sodienthoai = in.readString();
        matkhau = in.readString();
        matkhautwo = in.readString();
    }

    public static final Creator<TaiKhoan> CREATOR = new Creator<TaiKhoan>() {
        @Override
        public TaiKhoan createFromParcel(Parcel in) {
            return new TaiKhoan(in);
        }

        @Override
        public TaiKhoan[] newArray(int size) {
            return new TaiKhoan[size];
        }
    };

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
    }
}