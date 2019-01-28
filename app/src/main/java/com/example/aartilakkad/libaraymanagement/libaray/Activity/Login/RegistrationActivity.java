package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aartilakkad.libaraymanagement.R;

public class RegistrationActivity extends AppCompatActivity {
    private android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00697f")));
    }
}
