package com.example.aartilakkad.libaraymanagement.libaray.Activity.Book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aartilakkad.libaraymanagement.R;
import com.example.aartilakkad.libaraymanagement.libaray.Activity.ApiClient;

import ProjectServices.ProjectServices;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class IssueBookActivity extends AppCompatActivity {

    private Intent intent;
    private EditText edUSer,edBookname,edIssueDate,edReturn;
    private Button BtnInsert;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_book);
        intent = getIntent();
        edUSer=findViewById(R.id.edUSer);
        edBookname = (EditText)findViewById(R.id.edBookname);
        edIssueDate = (EditText)findViewById(R.id.edIssueDate);
        edReturn = (EditText)findViewById(R.id.edReturn);
         BtnInsert = (Button) findViewById(R.id.BtnInsert);

         try {
             //edUSer.setText(intent.getStringExtra("Name").toString());
             edBookname.setText(intent.getStringExtra("bookname").toString());
         } catch (Exception e) {
             e.printStackTrace();
         }
         BtnInsert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ProjectServices services = ApiClient.addData().create(ProjectServices.class);
                 services.getIssueBookDetail("User_id", intent.getStringExtra("bookId"), edIssueDate.getText().toString(),
                         edReturn.getText().toString(), new Callback<Response>() {
                             @Override
                             public void success(Response response, Response response2) {
                                 Toast.makeText(getApplicationContext(),"Book Issue Successfull...",Toast.LENGTH_SHORT).show();
                             }

                             @Override
                             public void failure(RetrofitError error) {
                                 Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                             }
                         });
             }
         });


    }
}
