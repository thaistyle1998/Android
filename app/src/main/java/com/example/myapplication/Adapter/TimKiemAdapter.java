package com.example.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.TimKiem;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.ViewHodler> {

    private ArrayList<TimKiem> arrayList;
    Context context;

    public TimKiemAdapter(ArrayList<TimKiem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.dong_tim_kiem_pho_bien,viewGroup,false);
        return  new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {

        TimKiem timKiem=arrayList.get(i);
        Picasso.with(context).load(timKiem.getHinhAnh()).into(viewHodler.imageView);
        viewHodler.txtten.setText(timKiem.getTen());
        viewHodler.txtsoluong.setText(timKiem.getSoLuong());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{
               ImageView imageView;
               TextView txtten,txtsoluong;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageviewtimkiem);
            txtten=itemView.findViewById(R.id.txtten);
            txtsoluong=itemView.findViewById(R.id.txtsoluong);
        }
    }

}
