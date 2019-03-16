package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aartilakkad.libaraymanagement.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrowseFragment extends Fragment {
    private TabLayout browseTabLayout;
    private ViewPager browseViewPager;

    public BrowseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_browse,container,false);

        final TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new BrowseTypeFragment(), "type");
        adapter.addFragment(new browse_featured_Fragment(), "featured");
        adapter.addFragment(new browse_subject_Fragment(), "subject");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);


        return v;


    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter  adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new BrowseTypeFragment(), "PHOTOS");
        adapter.addFragment(new browse_featured_Fragment(), "HI-FIVES");
        adapter.addFragment(new browse_subject_Fragment(), "subject");
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}