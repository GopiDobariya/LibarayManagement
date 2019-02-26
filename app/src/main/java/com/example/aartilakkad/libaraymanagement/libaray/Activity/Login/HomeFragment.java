package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aartilakkad.libaraymanagement.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


FragmentManager fragmentManager;
HomeFragment homeFragment;
FragmentTransaction transaction;
    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
