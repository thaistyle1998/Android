package com.example.myapplication.fragment_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Activity.UserActivity;
import com.example.myapplication.Model.TaiKhoan;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIServicesXAMPP;
import com.example.myapplication.Server.DataCilentXAMPP;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_dangnhap extends Fragment {
    View view;
Button btndangnhap;
EditText txten,txtmatkhau;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_dangnhap,container,false);
         btndangnhap=view.findViewById(R.id.btndangnhaptaikhoan);
         txten=view.findViewById(R.id.txtdangnhap);
         txtmatkhau=view.findViewById(R.id.txtmatkhautaikhoan);
         getData();

         return  view;
    }

    private void getData() {

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ten= txten.getText().toString().trim();
                 final  String matkhau=txtmatkhau.getText().toString().trim();
                    DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
                    Call<List<TaiKhoan>> callback = dataCilentXAMPP.getDatataikhoan(ten,matkhau);
                    callback.enqueue(new Callback<List<TaiKhoan>>() {
                        @Override
                        public void onResponse(Call<List<TaiKhoan>> call, Response<List<TaiKhoan>> response) {
                            ArrayList<TaiKhoan> mangtaikhoan  = (ArrayList<TaiKhoan>) response.body();
                            if(mangtaikhoan.size()>0)
                            {
                                Intent intent = new Intent(getContext(),UserActivity.class);
                                 intent.putExtra("mangtaikhoan",mangtaikhoan);
                                 startActivity(intent);


                            }
                        }

                        @Override
                        public void onFailure(Call<List<TaiKhoan>> call, Throwable t) {
                            Toast.makeText(getActivity(),"Không Tồn Tại Tài Khoản",Toast.LENGTH_LONG).show();
                        }
                    });
                 }
            });

    }
}
