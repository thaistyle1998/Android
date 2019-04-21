package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Adapter.DetailsAdapter;
import com.example.myapplication.Model.FlashDetail;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_detail extends Fragment {
    View view;
    TextView textView,textView1,textView2;
    CountDownTimer countDownTimer;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    private  boolean Timerunning;
    int gio=2;
    public long Time=7200000;
             DetailsAdapter adapter;

RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_flash,container,false);
        textView=view.findViewById(R.id.timegio);
        recyclerView =view.findViewById(R.id.recycleview);

        GetData();
        return view;

    }

    private void GetData() {

        Dataservice dataservice = APIService.getDataservice();
        Call<List<FlashDetail>> callback = dataservice.getFlashDetail();
        callback.enqueue(new Callback<List<FlashDetail>>() {
            @Override
            public void onResponse(Call<List<FlashDetail>> call, Response<List<FlashDetail>> response) {
                ArrayList<FlashDetail> arrayList = (ArrayList<FlashDetail>) response.body();
                   adapter= new DetailsAdapter(arrayList,getActivity());
                  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
                   recyclerView.setLayoutManager(linearLayoutManager);

                  recyclerView.setAdapter(adapter);
                   Log.d("HHH",arrayList.get(0).getGia());
            }

            @Override
            public void onFailure(Call<List<FlashDetail>> call, Throwable t) {
                Log.d("KKK",t.getMessage());

            }
        });



        StartTimer();
        UpdateTimer();


    }

    private void UpdateTimer() {

        int minutes= (int) ((Time/1000)/60)/2;
        int second= (int) (Time/1000) %60;
        int gio = (int) ((Time/1000)/60)/20;
        String timeformat = String.format(Locale.getDefault()," %2d:%2d :%2d ",gio,minutes,second);
        textView.setText(timeformat);
    }

    private void StartTimer() {
        countDownTimer = new CountDownTimer(Time,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Time=millisUntilFinished;
                UpdateTimer();

            }

            @Override
            public void onFinish() {
                Timerunning=false;

            }
        }.start();
        Timerunning=true;
    }

}
