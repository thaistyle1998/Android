package com.example.myapplication.Fragment_ThuongMai;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapter.GoiYAdapter;
import com.example.myapplication.Model.GoiY;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_goiy extends Fragment {
    View view; 
    RecyclerView recyclerView;
    GoiYAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_goiy,container,false);
         recyclerView=view.findViewById(R.id.recycleviewgoiy);
         getData();
         return view;
    }

    private void getData() {
        Dataservice dataservice= APIService.getDataservice();
        Call<List<GoiY>> call = dataservice.getDataGoiy();
        call.enqueue(new Callback<List<GoiY>>() {
            @Override
            public void onResponse(Call<List<GoiY>> call, Response<List<GoiY>> response) {
                ArrayList<GoiY> arrayList = (ArrayList<GoiY>) response.body();
                adapter = new GoiYAdapter(getContext(),arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<GoiY>> call, Throwable t) {

            }
        });
    }
}
