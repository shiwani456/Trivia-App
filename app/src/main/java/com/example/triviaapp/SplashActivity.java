package com.example.triviaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private final String TAG = SplashActivity.class.getName();
    private int k = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spalsh);
        splashCreation();
    }

    private void splashCreation() {
        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(k * 1000);//sleep System for k seconds
                    Intent loginActivityIntent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(loginActivityIntent);//Going to next page
                    finish();
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage(), e);
                }
            }
        };
        background.start();
    }
}
