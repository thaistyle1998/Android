package com.example.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.FlashDetail;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsAdapter  extends  RecyclerView.Adapter<DetailsAdapter.ViewHodler>  {

    private  ArrayList<FlashDetail> arrayList;
    private Context context;

    public DetailsAdapter(ArrayList<FlashDetail> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.dong_detail,viewGroup,false);

        return  new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
             FlashDetail detail=arrayList.get(i);
             Picasso.with(context).load(detail.getHinhAnh()).into(viewHodler.imageView);
             viewHodler.txtsale.setText(detail.getSale());
             viewHodler.txtgia.setText(detail.getGia());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{
           ImageView imageView;
           TextView txtgia,txtsale;

           public ViewHodler(@NonNull View itemView) {
               super(itemView);

               imageView=itemView.findViewById(R.id.imageviewdetails);
               txtgia=itemView.findViewById(R.id.txtgiadetail);
               txtsale=itemView.findViewById(R.id.txtgiamgiadetails);

           }
       }


}
