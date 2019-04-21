package com.example.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.GoiY;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GoiYAdapter extends RecyclerView.Adapter<GoiYAdapter.ViewHodler>  {
    private Context context;
    private ArrayList<GoiY> arrayList;

    public GoiYAdapter(Context context, ArrayList<GoiY> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.dong_goiy,viewGroup,false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        GoiY goiY= arrayList.get(i);
        Picasso.with(context).load(goiY.getHinhAnh()).into(viewHodler.imageView);
        viewHodler.txtgia.setText(goiY.getGia());
        viewHodler.txtyeuthich.setText(goiY.getYeuThich());
        viewHodler.txtten.setText(goiY.getTen());
        viewHodler.txtsale.setText(goiY.getSale());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txtyeuthich,txtten,txtgia,txtsale;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageviewgoiy);
            txtgia=itemView.findViewById(R.id.txtgia);
            txtsale=itemView.findViewById(R.id.txtgiamgia);
            txtten=itemView.findViewById(R.id.txttengoiy);
            txtyeuthich=itemView.findViewById(R.id.txtyeuthich);
        }
    }
}
