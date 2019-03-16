package com.example.aartilakkad.libaraymanagement.libaray.Activity.BookInformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aartilakkad.libaraymanagement.R;

import java.util.ArrayList;

public class BookInformationActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_information);
        recyclerView = (RecyclerView)findViewById(R.id.bookinfo);

        ArrayList<Modelclass> lists=new ArrayList<Modelclass>();
        recyclerView.setLayoutManager(new LinearLayoutManager(BookInformationActivity.this));

        Modelclass modelclass[]={
                new Modelclass("1234", "9:52", "31/12/2018"),
                new Modelclass( "1234", "10:00", "12/11/2018"),
                new Modelclass( "1234", "05:08", "30/09/2018" ),
                new Modelclass( "1234", "11:52", "21/07/2018")
        };
        for(int i=0;i<modelclass.length;i++)
        {
            lists.add(modelclass[i]);
        }
        Adapaterclass adp= new Adapaterclass(this,lists);
        recyclerView.setAdapter(adp);
    }

}
