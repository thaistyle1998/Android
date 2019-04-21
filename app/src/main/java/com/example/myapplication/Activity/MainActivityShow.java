package com.example.myapplication.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;

public class MainActivityShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_show);
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.benaybennay);
        mediaPlayer.start();

        CountDownTimer countDownTimer = new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {


            }

            @Override
            public void onFinish() {
                startActivity(new Intent(MainActivityShow.this,MainActivity.class));
                overridePendingTransition(R.anim.anim_alpha,R.anim.anim_alpha);

            }
        }.start();
    }
}
