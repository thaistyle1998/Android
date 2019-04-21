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
import android.widget.TextView;

import com.example.myapplication.Adapter.TimKiemAdapter;
import com.example.myapplication.Model.TimKiem;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_timkiem  extends Fragment {
    View view;
    RecyclerView recyclerView;
    TextView txtphotien,txtxemthem;
    TimKiemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_timkiem_phobien,container,false);
        recyclerView=view.findViewById(R.id.recyclerviewtimkiem);
        txtphotien=view.findViewById(R.id.txttiemkiemphobien);
        txtxemthem=view.findViewById(R.id.txtxemthem);
        getData();
        return view;
    }

    private void getData() {
        Dataservice dataservice = APIService.getDataservice();
        Call<List<TimKiem>> callback= dataservice.getDataTimKiem();
        callback.enqueue(new Callback<List<TimKiem>>() {
            @Override
            public void onResponse(Call<List<TimKiem>> call, Response<List<TimKiem>> response) {
                ArrayList<TimKiem> arrayList = (ArrayList<TimKiem>) response.body();
                adapter = new TimKiemAdapter(arrayList,getContext());
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<TimKiem>> call, Throwable t) {

            }
        });
    }
}
