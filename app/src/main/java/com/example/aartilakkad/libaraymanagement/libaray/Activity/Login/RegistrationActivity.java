package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aartilakkad.libaraymanagement.R;
import com.example.aartilakkad.libaraymanagement.libaray.Activity.ApiClient;

import ProjectServices.ProjectServices;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RegistrationActivity extends AppCompatActivity {


    private EditText EdName,EdMobile,EdAddress,EdCity,EdEmail,EdPassword,EdConfirmPassword;
    private Spinner SpGender;
    private Button Btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EdName = (EditText)findViewById(R.id.EdName);
        EdMobile = (EditText)findViewById(R.id.EdMobile);
        EdAddress = (EditText)findViewById(R.id.EdAddress);
        EdCity = (EditText)findViewById(R.id.EdCity);
        EdEmail = (EditText)findViewById(R.id.EdEmail);
        EdPassword = (EditText)findViewById(R.id.EdPassword);
        EdConfirmPassword = (EditText)findViewById(R.id.EdConfirmPassword);
        SpGender = (Spinner) findViewById(R.id.SpGender);
        Btnsignup = (Button) findViewById(R.id.Btnsignup);
        Btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ProjectServices services = ApiClient.addData().create(ProjectServices.class);
                 services.UserRegister(EdName.getText().toString(), SpGender.getSelectedItem().toString(),
                         EdMobile.getText().toString(), EdEmail.getText().toString(), EdAddress.getText().toString(),
                         EdCity.getText().toString(), EdPassword.getText().toString(), new Callback<Response>() {
                             @Override
                             public void success(Response response, Response response2) {
                                 Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_LONG).show();
                                 startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                 finish();
                             }
                             @Override
                             public void failure(RetrofitError error) {
                                 Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                             }
                         });

            }
        });

    }
}
