package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ShopMarKet extends AppCompatActivity {

    Button btnmarket;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_mar_ket);

        btnmarket = findViewById(R.id.btnmuasam);
        btnmarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShopMarKet.this,MainActivity.class));
            }
        });
    }
}
