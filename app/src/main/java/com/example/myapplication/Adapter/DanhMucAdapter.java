package com.example.myapplication.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.DanhMuc;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhMucAdapter  extends  RecyclerView.Adapter<DanhMucAdapter.ViewHodler> {
    private Context context;
    private ArrayList<DanhMuc> arrayList;

    public DanhMucAdapter(Context context, ArrayList<DanhMuc> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.dong_danh_muc,viewGroup,false);

        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        DanhMuc danhMuc = arrayList.get(i);
        Picasso.with(context).load(danhMuc.getHinhAnh()).into(viewHodler.imageView);
        viewHodler.txtten.setText(danhMuc.getTen());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{
                ImageView imageView;
                TextView txtten;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageviewdanhmuc);
            txtten=itemView.findViewById(R.id.txttendanhmuc);

        }
    }
}
