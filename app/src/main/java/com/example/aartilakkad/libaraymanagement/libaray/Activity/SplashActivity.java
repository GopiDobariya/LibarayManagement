package com.example.aartilakkad.libaraymanagement.libaray.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aartilakkad.libaraymanagement.R;
import com.example.aartilakkad.libaraymanagement.libaray.Activity.Login.HomeActivity;
import com.example.aartilakkad.libaraymanagement.libaray.Activity.Login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    private static int splash=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setTheme(R.style.SplashTheme);
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        },splash);

    }
}
