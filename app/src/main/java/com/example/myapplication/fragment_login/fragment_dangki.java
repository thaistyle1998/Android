package com.example.myapplication.fragment_login;

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

import com.example.myapplication.R;
import com.example.myapplication.Server.APIServicesXAMPP;
import com.example.myapplication.Server.DataCilentXAMPP;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_dangki extends Fragment {
    View view;
Button btnxacnhan;
EditText ten,sdt,matkhau,matkhau1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_dangki,container,false);
        btnxacnhan=view.findViewById(R.id.btntieptuc);
        ten=view.findViewById(R.id.edittentaikhoan);
        sdt=view.findViewById(R.id.editsdt);
        matkhau=view.findViewById(R.id.editmatkhau);
        matkhau1=view.findViewById(R.id.editmatkhauhai);
        getData();
        return view;
    }

    private void getData() {






                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String Ten=ten.getText().toString().trim();
                        final String Sodienthoai=sdt.getText().toString().trim();
                        final String matkhaus= matkhau.getText().toString().trim();
                        final String matkhau1s=matkhau1.getText().toString().trim();
                        if(!Ten.equals("") && !matkhau1s.equals("") && !Sodienthoai.equals("") && !matkhaus.equals(""))
                        {
                            if(matkhau1s.equals(matkhaus) || matkhaus.equals(matkhau1s))
                            {
                                DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
                                Call<String> call = dataCilentXAMPP.InSertdata(Ten,Sodienthoai,matkhaus,matkhau1s);
                                call.enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {

                                        String x= response.body();
                                        if(x.equals("thanhcong"))
                                        {
                                            Toast.makeText(getContext(),"Đăng Kí Thành Công",Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Log.d("POP",t.getMessage());

                                    }
                                });
                            }
                            else
                            {
                                Toast.makeText(getActivity(),"Mật Khẩu Không Khớp",Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"Không Để trống",Toast.LENGTH_LONG).show();
                        }


                    }
                });
            }




    }

