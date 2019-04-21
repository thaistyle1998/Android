package com.example.myapplication.Activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.Model.HinhAnhIcon;
import com.example.myapplication.Model.HinhAnhIcons;
import com.example.myapplication.Model.TaiKhoan;
import com.example.myapplication.Model.TaiKhoanTT;
import com.example.myapplication.Model.ThongTin;
import com.example.myapplication.Model.ThongTinTK;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.APIServicesXAMPP;
import com.example.myapplication.Server.DataCilentXAMPP;
import com.example.myapplication.Server.Dataservice;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Hosothongtin extends AppCompatActivity {

    Button btnxacnhan, btnbackstack;

    TextView txtgioitinh, txtgioitinhset, txtten, txtsodienthoai, txtthaydoimatkhau;
    TextView txtngaysinh, txtxacnhanngaysinh;
    TextView txttendangnhap, txtmatkhaumoi, txtxacnhanmatkhau;
    ImageView imageicon, imagebackground;
    int RE_QUEST_ICON = 123;
    int RE_QUEST_Background = 456;
    String repath = "";
    String repaths = "";
    TextView txtchinhsua, txtentai;
    Dialog dialog;
    Button btnxacnhanmatkhau;
    TextView txtchamdesua;
    String k;
    String s;
    CircleImageView circleImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosothongtin);
        Anhxa();

        Init();
        Function();


    }

    public void onEventMainThread(final ThongTin event) {
        txttendangnhap.setText("" + event.getTen());
        txtsodienthoai.setText("" + event.getSodienthoai());
        UploadBackground();
        UploadIcon();
       txtthaydoimatkhau.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               CapNhatMK();
           }
       });
       CapNhatThongTin();

    }

    private void UploadBackground() {
        final DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
        final Call<List<TaiKhoanTT>> listCall = dataCilentXAMPP.getLoadphoto(txttendangnhap.getText().toString().trim());
        listCall.enqueue(new Callback<List<TaiKhoanTT>>() {
            @Override
            public void onResponse(Call<List<TaiKhoanTT>> call, Response<List<TaiKhoanTT>> response) {
                ArrayList<TaiKhoanTT> arrayList = (ArrayList<TaiKhoanTT>) response.body();
                k = arrayList.get(0).getHinhanh();
                Picasso.with(Hosothongtin.this).load(k).into(imagebackground);
                Log.d("OK", arrayList.get(0).getHinhanh());
            }

            @Override
            public void onFailure(Call<List<TaiKhoanTT>> call, Throwable t) {

            }
        });


        final String ten = txttendangnhap.getText().toString().trim();
        DataCilentXAMPP dataCilentXAMPPs = APIServicesXAMPP.getDatacilent();
        File file = new File(repath);
        String file_bath = file.getAbsolutePath();
        String[] mangfile;
        mangfile = file_bath.split("\\.");
        try {
            file_bath = mangfile[0] + System.currentTimeMillis() + "." + mangfile[1];

            final RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part partdy = MultipartBody.Part.createFormData("upload", file_bath, requestBody);
            DataCilentXAMPP dataCilentXAMPP1 = APIServicesXAMPP.getDatacilent();

            Call<String> call = dataCilentXAMPP.getUpLoad(partdy);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response != null) {
                        String mess = response.body();
                        if (mess.length() > 0) {
                            DataCilentXAMPP dataCilentXAMPP2 = APIServicesXAMPP.getDatacilent();
                            Call<String> callback = dataCilentXAMPP2.UpdateAnh(ten,
                                    APIServicesXAMPP.base_url + "hinhanh/" + mess);
                            callback.enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, Response<String> response) {
                                    String mess = response.body();
                                    if (mess.length() > 0) {
                                        DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
                                        Call<List<TaiKhoanTT>> listCall = dataCilentXAMPP.getLoadphoto(txttendangnhap.getText().toString().trim());
                                        listCall.enqueue(new Callback<List<TaiKhoanTT>>() {
                                            @Override
                                            public void onResponse(Call<List<TaiKhoanTT>> call, Response<List<TaiKhoanTT>> response) {
                                                ArrayList<TaiKhoanTT> arrayList = (ArrayList<TaiKhoanTT>) response.body();
                                                k = arrayList.get(0).getHinhanh();
                                                Picasso.with(Hosothongtin.this).load(k).into(imagebackground);
                                                HinhAnhIcon hinhAnhIcon = new HinhAnhIcon(k);
                                                EventBus.getDefault().postSticky(hinhAnhIcon);

                                            }

                                            @Override
                                            public void onFailure(Call<List<TaiKhoanTT>> call, Throwable t) {

                                            }
                                        });
                                    }


                                }

                                @Override
                                public void onFailure(Call<String> call, Throwable t) {
                                    Log.d("OK", t.getMessage());
                                }
                            });

                        }

                    }


                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void UploadIcon() {

        DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
        final Call<List<TaiKhoanTT>> listCall = dataCilentXAMPP.getHinhAnhIcon(txttendangnhap.getText().toString().trim());
        listCall.enqueue(new Callback<List<TaiKhoanTT>>() {
            @Override
            public void onResponse(Call<List<TaiKhoanTT>> call, Response<List<TaiKhoanTT>> response) {
                ArrayList<TaiKhoanTT> arrayList = (ArrayList<TaiKhoanTT>) response.body();
                if(!arrayList.get(0).getHinhanhicon().equals(""))
                {
                    Picasso.with(Hosothongtin.this).load(arrayList.get(0).getHinhanhicon()).into(circleImageView);

                }

            }

            @Override
            public void onFailure(Call<List<TaiKhoanTT>> call, Throwable t) {

            }
        });


        try {
            File files = new File(repaths);
            String file_baths = files.getAbsolutePath();
            Log.d("OKKT", file_baths);
            String[] mangfile_icon = file_baths.split("\\.");
            file_baths = mangfile_icon[0] + System.currentTimeMillis() + "." + mangfile_icon[1];
            final RequestBody requestBodys = RequestBody.create(MediaType.parse("multipart/form-data"), files);
            MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file", file_baths, requestBodys);
            DataCilentXAMPP dataicon = APIServicesXAMPP.getDatacilent();
            Call<String> callback = dataicon.getUploadIcon(body);
            callback.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    if (response != null) {
                        final String mess = response.body();
                        if (mess.length() > 0) {
                            DataCilentXAMPP dataCilentXAMPP1 = APIServicesXAMPP.getDatacilent();
                            Call<String> datacilent = dataCilentXAMPP1.getUpdateIcon(txttendangnhap.getText().toString().trim(),
                                    APIServicesXAMPP.base_url +"image/"+ mess);
                            Log.d("Thaistyle",APIServicesXAMPP.base_url+"image/"+mess);
                            datacilent.enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, Response<String> response) {
                                    String messs = response.body();
                                    if (messs.length() > 0) {
                                        DataCilentXAMPP dataCilentXAMPP2 = APIServicesXAMPP.getDatacilent();
                                        Call<List<TaiKhoanTT>> call1 = dataCilentXAMPP2.getHinhAnhIcon(txttendangnhap.getText().toString().trim());
                                        call1.enqueue(new Callback<List<TaiKhoanTT>>() {
                                            @Override
                                            public void onResponse(Call<List<TaiKhoanTT>> call, Response<List<TaiKhoanTT>> response) {
                                                ArrayList<TaiKhoanTT> arrayList = (ArrayList<TaiKhoanTT>) response.body();
                                                Log.d("OKKK", arrayList.get(0).getHinhanhicon());
                                                if(!arrayList.get(0).getHinhanhicon().equals(""))
                                                {
                                                    Picasso.with(Hosothongtin.this).load(arrayList.get(0).getHinhanhicon()).into(circleImageView);
                                                    HinhAnhIcons hinhAnhIcons = new HinhAnhIcons(arrayList.get(0).getHinhanhicon());
                                                    EventBus.getDefault().postSticky(hinhAnhIcons);

                                                }
                                                else
                                                {
                                                    Toast.makeText(Hosothongtin.this,"Lỗi Update",Toast.LENGTH_LONG).show();

                                                }


                                            }

                                            @Override
                                            public void onFailure(Call<List<TaiKhoanTT>> call, Throwable t) {

                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onFailure(Call<String> call, Throwable t) {

                                }
                            });


                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void Init() {


        btnbackstack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public String getRealPathFromURI(Uri contentUri) {
        String path = null;
        String[] data = {MediaStore.MediaColumns.DATA};
        Cursor cursor = getContentResolver().query(contentUri, data, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }


    private void Anhxa() {


        txtgioitinh = findViewById(R.id.txt);
        txtgioitinhset = findViewById(R.id.txtgioitinh);
        txtgioitinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogGioitinh();
            }
        });
        txtngaysinh = findViewById(R.id.txtngaysinh);
        txtxacnhanngaysinh = findViewById(R.id.txtngaysinhclick);
        txtxacnhanngaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateBirth();
            }
        });
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_doi_mat_khau);
        imagebackground = findViewById(R.id.imageviewbackground);
        circleImageView = findViewById(R.id.imageviewicon);
        btnbackstack = findViewById(R.id.btnbackstack);
        txttendangnhap = findViewById(R.id.txttendangnhap);
        txtthaydoimatkhau = findViewById(R.id.txtthaydoimatkhau);
        txtsodienthoai = findViewById(R.id.txtsodienthoai);
        txtmatkhaumoi = dialog.findViewById(R.id.txtmatkhaumoi);
        txtxacnhanmatkhau = dialog.findViewById(R.id.matkhautwo);
        btnxacnhanmatkhau = dialog.findViewById(R.id.btnxacnhandoimatkhau);


    }
    private  void CapNhatThongTin()
    {


        final Dialog dialog = new Dialog(Hosothongtin.this);
        dialog.setContentView(R.layout.dialog_thongtin);
        dialog.setTitle("Chọn ");
        final Button btnhuy = dialog.findViewById(R.id.btnkhong);
        final Button btnxacnhan=dialog.findViewById(R.id.btnxacnhanthaydoi);
        final String gioitinh= txtgioitinh.getText().toString().trim();
        final String ngaysinh=txtngaysinh.getText().toString().trim();

        DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
        Call<List<TaiKhoanTT>> callback = dataCilentXAMPP.getThongTinTT(txttendangnhap.getText().toString().trim());
        callback.enqueue(new Callback<List<TaiKhoanTT>>() {
            @Override
            public void onResponse(Call<List<TaiKhoanTT>> call, Response<List<TaiKhoanTT>> response) {
                        ArrayList<TaiKhoanTT> arrayList = (ArrayList<TaiKhoanTT>) response.body();
                        txtgioitinhset.setText(arrayList.get(0).getGioitinh());
                        txtngaysinh.setText(arrayList.get(0).getNgaysinh());
                        if(!gioitinh.equals(arrayList.get(0).getGioitinh()) || !ngaysinh.equals(arrayList.get(0).getNgaysinh()))
                        {
                            btnbackstack.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.show();
                                    btnhuy.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog.cancel();
                                        }
                                    });
                                    btnxacnhan.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            DataCilentXAMPP dataCilentXAMPP1 = APIServicesXAMPP.getDatacilent();
                                            Call<String> callback = dataCilentXAMPP1.getThongTin(txttendangnhap.getText().toString().trim(),
                                                             txtgioitinhset.getText().toString().trim(),txtngaysinh.getText().toString().trim());
                                            callback.enqueue(new Callback<String>() {
                                                @Override
                                                public void onResponse(Call<String> call, Response<String> response) {
                                                    String h =response.body();
                                                    if(h.equals("Thanhcong"))
                                                    {
                                                        Toast.makeText(Hosothongtin.this,"Đã Thay Đổi",Toast.LENGTH_LONG).show();
                                                        finish();
                                                    }

                                                }

                                                @Override
                                                public void onFailure(Call<String> call, Throwable t) {

                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }

            }

            @Override
            public void onFailure(Call<List<TaiKhoanTT>> call, Throwable t) {

            }
        });

        btnbackstack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void Function() {
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, RE_QUEST_ICON);
                ;

            }
        });
        imagebackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, RE_QUEST_Background);
            }
        });


        btnxacnhanmatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == RE_QUEST_ICON && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            repaths = getRealPathFromURI(uri);
            try {

                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                circleImageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (requestCode == RE_QUEST_Background && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            repath = getRealPathFromURI(uri);
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imagebackground.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void DialogGioitinh() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_gioitinh);
        dialog.setTitle("Giới Tính");
        dialog.show();
        TextView txtnam = dialog.findViewById(R.id.nam);
        TextView txtnu = dialog.findViewById(R.id.nu);
        txtnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtgioitinhset.setText("Nam");
                dialog.cancel();
            }
        });
        txtnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtgioitinhset.setText("Nữ");
                dialog.dismiss();
            }
        });
    }

    private void DateBirth() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                txtngaysinh.setText(simpleDateFormat.format(calendar.getTime()));

            }
        }, nam, thang, ngay);
        datePickerDialog.show();

    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void CapNhatMK() {

        final Dialog dialog = new Dialog(Hosothongtin.this);
        dialog.setContentView(R.layout.dialog_doi_mat_khau);
        dialog.setTitle("Đổi Mật Khẩu");
        dialog.show();
        Button btnxacnhanmatkhau = dialog.findViewById(R.id.btnxacnhandoimatkhau);
        final EditText editText = dialog.findViewById(R.id.txtmatkhaumoi);
        final EditText editText1 = dialog.findViewById(R.id.matkhautwo);
        Button btnhuy = dialog.findViewById(R.id.btnhuymatkhau);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();

            }
        });
        btnxacnhanmatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              String matkhauone= editText.getText().toString().trim();
              String matkhau2=editText1.getText().toString().trim();
              String ten= txttendangnhap.getText().toString().trim();

              if(!ten.equals("")&&!matkhauone.equals("")&&!matkhau2.equals(""))
              {
                  if(matkhauone.equals(matkhau2) || matkhau2.equals(matkhauone))
                  {
                      DataCilentXAMPP dataCilentXAMPP = APIServicesXAMPP.getDatacilent();
                      Call<String> callback= dataCilentXAMPP.getUpdate(ten,matkhauone,matkhau2);
                      callback.enqueue(new Callback<String>() {
                          @Override
                          public void onResponse(Call<String> call, Response<String> response) {
                              String h = response.body();
                              if(h.equals("Thanhcong"))
                              {
                                  Toast.makeText(Hosothongtin.this,"Đổi Thành Công",Toast.LENGTH_LONG).show();
                                  dialog.cancel();
                              }
                              else
                              {
                                  Toast.makeText(Hosothongtin.this,"Mật Khẩu Không Khớp ",Toast.LENGTH_LONG).show();
                              }
                          }

                          @Override
                          public void onFailure(Call<String> call, Throwable t) {
                                   Toast.makeText(Hosothongtin.this," Lỗi"+t.getMessage(),Toast.LENGTH_LONG).show();
                          }
                      });
                  }
                  else
                  {
                      Toast.makeText(Hosothongtin.this,"Mật Khẩu Không hợp lệ",Toast.LENGTH_LONG).show();
                  }

              }
              else
              {
                  Toast.makeText(Hosothongtin.this,"Điền Đầy Đủ Thông Tin",Toast.LENGTH_LONG).show();
              }


            }
        });


    }
}

