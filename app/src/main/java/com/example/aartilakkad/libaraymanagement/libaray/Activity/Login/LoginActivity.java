package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aartilakkad.libaraymanagement.R;
import com.example.aartilakkad.libaraymanagement.libaray.Activity.ApiClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ProjectServices.ProjectServices;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {
    private android.support.v7.app.ActionBar actionBar;
    private EditText EdEmail,EdPassword;
    private TextView Txtsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EdEmail=(EditText) findViewById(R.id.EdEmail);
        EdPassword=(EditText) findViewById(R.id.EdPassword);
        Txtsignup = (TextView)findViewById(R.id.Txtsignup);
        Txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });
    }

    public void signin(View view) {
         ProjectServices services = ApiClient.addData().create(ProjectServices.class);
         services.UserLogin(EdEmail.getText().toString(), EdPassword.getText().toString(), new Callback<Response>() {
             @Override
             public void success(Response response, Response response2) {
                 BufferedReader reader = null;
                 String output = "";
                 try {
                     reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
                     output = reader.readLine();
                     if (output == null)
                     {
                         Toast.makeText(getApplicationContext(),"Enter valid username and password",Toast.LENGTH_SHORT).show();
                         return;
                     }
                     else
                     {
                         Toast.makeText(getApplicationContext(),"Login Successfull...!",Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                         finish();
                     }

                 }
                 catch (Exception e)
                 {
                     e.printStackTrace();
                 }
             }

             @Override
             public void failure(RetrofitError error) {

             }
         });
    }
}
