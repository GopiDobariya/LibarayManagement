package com.example.aartilakkad.libaraymanagement.libaray.Activity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aartilakkad.libaraymanagement.R;
import com.example.aartilakkad.libaraymanagement.libaray.Activity.Login.LoginActivity;

public class HomeActivity extends AppCompatActivity {
Button login;
private android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00697f")));

        login=(Button)findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
            }
        });

    }
}
