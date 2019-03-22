package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aartilakkad.libaraymanagement.Artical;
import com.example.aartilakkad.libaraymanagement.ComputerScience;
import com.example.aartilakkad.libaraymanagement.Gate;
import com.example.aartilakkad.libaraymanagement.HistoryBook;
import com.example.aartilakkad.libaraymanagement.Jee;
import com.example.aartilakkad.libaraymanagement.Neet;
import com.example.aartilakkad.libaraymanagement.R;
import com.example.aartilakkad.libaraymanagement.Technology;
import com.example.aartilakkad.libaraymanagement.Thesis;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment = null;
        Class fragmentClass = null;
        fragmentClass = HomeFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
            if (id == R.id.nav_home) {
        }
        else if (id == R.id.nav_Computer) {
                startActivity(new Intent(getApplicationContext(), ComputerScience.class));
        } else if (id == R.id.nav_History) {
                startActivity(new Intent(getApplicationContext(), HistoryBook.class));

        }else if (id == R.id.nav_Neet) {
                startActivity(new Intent(getApplicationContext(), Neet.class));

        }else if (id == R.id.nav_Get) {
                startActivity(new Intent(getApplicationContext(), Gate.class));

        } else if (id == R.id.nav_Jee) {

                startActivity(new Intent(getApplicationContext(), Jee.class));
        }else if (id == R.id.nav_Technology) {
                startActivity(new Intent(getApplicationContext(), Technology.class));

        }else if (id == R.id.nav_Thesis) {
                startActivity(new Intent(getApplicationContext(), Thesis.class));

        }else if (id == R.id.nav_Artical) {
                startActivity(new Intent(getApplicationContext(), Artical.class));
        }else if (id == R.id.nav_Question_Paper) {


        }else if (id == R.id.nav_Search) {

        } else if (id == R.id.nav_Contact) {

        } else if (id == R.id.nav_Pi) {

        }
        else if (id == R.id.nav_LogOut) {
            }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

