package com.example.colorsprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static int timeout=4000;
    ImageView log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log = findViewById(R.id.iLogo);

        /*Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myanim);
        log.startAnimation(animation);*/

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Homepage.class);
                startActivity(intent);
                finish();
            }
        },timeout);
    }
}