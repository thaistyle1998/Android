package com.example.myapplication.fragment_login;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Activity.Hosothongtin;
import com.example.myapplication.Activity.SettingActivity;
import com.example.myapplication.Activity.ShopMarKet;
import com.example.myapplication.Activity.UserActivity;
import com.example.myapplication.Model.HinhAnhIcon;
import com.example.myapplication.Model.HinhAnhIcons;
import com.example.myapplication.Model.TaiKhoan;
import com.example.myapplication.Model.TaiKhoanTT;
import com.example.myapplication.Model.ThongTin;
import com.example.myapplication.Model.ThongTinTK;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIServicesXAMPP;
import com.example.myapplication.Server.DataCilentXAMPP;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_login_User extends Fragment {
    View view;
      TextView textView;
      ImageView shopmarket,imageView,imageuser,imageviewseeting;
CircleImageView circleImageView;
Hosothongtin hosothongtin;
  UserActivity userActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_user_login,container,false);
        textView=view.findViewById(R.id.txttentaikhoanlogin);
       circleImageView=view.findViewById(R.id.imageuserthongtin);
       shopmarket= view.findViewById(R.id.shopmarket);
       imageviewseeting=view.findViewById(R.id.setting);


         Intent intent= getActivity().getIntent();

          final ArrayList<TaiKhoan> arrayList = intent.getParcelableArrayListExtra("mangtaikhoan");
            String h= arrayList.get(0).getTen();
            String k = arrayList.get(0).getSodienthoai();

          textView.setText(arrayList.get(0).getTen());


          imageView=view.findViewById(R.id.imagechinhsuatt);
          imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ThongTin thongTin = new ThongTin(arrayList.get(0).getTen(),arrayList.get(0).getSodienthoai());
                  EventBus.getDefault().postSticky(thongTin);
                  Intent intent = new Intent(getActivity(),Hosothongtin.class);
                  startActivity(intent);
              }

          });
        Update2();
          Update();
          Shopmarket();
          Setting();
        return  view;
    }
    private  void Update()
    {
        DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
        Call<List<TaiKhoanTT>> listCall= dataCilentXAMPP.getLoadphoto(textView.getText().toString().trim());
        listCall.enqueue(new Callback<List<TaiKhoanTT>>() {
            @Override
            public void onResponse(Call<List<TaiKhoanTT>> call, Response<List<TaiKhoanTT>> response) {
                ArrayList<TaiKhoanTT> arrayList = (ArrayList<TaiKhoanTT>) response.body();
                          Picasso.with(getContext()).load(arrayList.get(0).getHinhanh()).into(imageView);
            }
            @Override
            public void onFailure(Call<List<TaiKhoanTT>> call, Throwable t) {
            }
        });
    }
    private  void Update2()
    {
        DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
        final Call<List<TaiKhoanTT>> listCall = dataCilentXAMPP.getIconUser(textView.getText().toString().trim());
        listCall.enqueue(new Callback<List<TaiKhoanTT>>() {
            @Override
            public void onResponse(Call<List<TaiKhoanTT>> call, Response<List<TaiKhoanTT>> response) {
                ArrayList<TaiKhoanTT> arrayList = (ArrayList<TaiKhoanTT>) response.body();
              if(!arrayList.get(0).getHinhanhicon().equals(""))
              {
                  Picasso.with(getContext()).load(arrayList.get(0).getHinhanhicon()).into(circleImageView );
              }
              else
              {
                  Toast.makeText(getContext(),"Loi Cap Nhat",Toast.LENGTH_LONG).show();
              }
            }

            @Override
            public void onFailure(Call<List<TaiKhoanTT>> call, Throwable t) {

            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();

        EventBus.getDefault().registerSticky(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(HinhAnhIcon event)
        {
               Picasso.with(getContext()).load(event.getHinhanh()).into(imageView);
        }
    public  void onEventMainThread(HinhAnhIcons event)
    {
        Picasso.with(getContext()).load(event.getHinhanh()).into(circleImageView);
    }
    private void Shopmarket()
    {
               shopmarket.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       startActivity(new Intent(getActivity(), ShopMarKet.class));
                   }
               });
    }
    private  void Setting()
    {
        imageviewseeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });
    }

}
