package com.example.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;


public class SettingActivity extends AppCompatActivity {
          Button btnhoso;
          Button btndiachi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btnhoso=findViewById(R.id.hosocuatoi);
        btndiachi=findViewById(R.id.diachi);
        btnhoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this,Hosothongtin.class));
            }
        });
    }
}
