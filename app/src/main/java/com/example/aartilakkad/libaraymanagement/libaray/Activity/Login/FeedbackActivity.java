package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aartilakkad.libaraymanagement.R;
import com.example.aartilakkad.libaraymanagement.libaray.Activity.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FeedbackActivity extends AppCompatActivity {

    EditText email,comment;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        email = (EditText) findViewById(R.id.Email);
        comment = findViewById(R.id.Comment);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckFeedback();
            }
        });


    }

    public void CheckFeedback() {
        APIinterface apIinterface = (APIinterface) ApiClient.getclient().create(APIinterface.class);
        Call<FeedbackResponse> responseCall = apIinterface.CheckFeedback("email" ,email.getText().toString(),
                comment.getText().toString());
        responseCall.enqueue(new Callback<FeedbackResponse>() {

            @Override
            public void onResponse(Call<FeedbackResponse> call, Response<FeedbackResponse> response) {
                if (response.body().getSuccess()==200){
                    Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FeedbackResponse> call, Throwable t) {

            }
        });
    }
}