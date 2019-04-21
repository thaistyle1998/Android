package com.example.myapplication.Fragment_ThuongMai;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapter.DanhMucAdapter;
import com.example.myapplication.Model.DanhMuc;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_danhmuc  extends Fragment {
    View view;
    RecyclerView recyclerView;
DanhMucAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_danhmuc,container,false);
        recyclerView=view.findViewById(R.id.recycleviewdanhmuc);
        getData();
        return view;
    }

    private void getData() {
        Dataservice dataservice = APIService.getDataservice();
        Call<List<DanhMuc>> callback= dataservice.getDataDanhMuc();
        callback.enqueue(new Callback<List<DanhMuc>>() {
            @Override
            public void onResponse(Call<List<DanhMuc>> call, Response<List<DanhMuc>> response) {
                ArrayList<DanhMuc> arrayList = (ArrayList<DanhMuc>) response.body();
                adapter = new DanhMucAdapter(getContext(),arrayList);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(adapter);

                Log.d("HHH",arrayList.get(0).getHinhAnh());


            }

            @Override
            public void onFailure(Call<List<DanhMuc>> call, Throwable t) {
                Log.d("ooo",t.getMessage());

            }
        });
    }
}
