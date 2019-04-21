package com.example.myapplication.fragment_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Activity.LoGinActivity;
import com.example.myapplication.Activity.SingInActivity;
import com.example.myapplication.R;

public class fragment_login extends Fragment {
    View view;
Button btndangnhap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_login,container,false) ;
        btndangnhap=view.findViewById(R.id.btndangnhap);
        GetData();
             return view;

    }

    private void GetData() {
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SingInActivity.class));

            }
        });
    }
}
