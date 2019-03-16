package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aartilakkad.libaraymanagement.R;

import java.util.ArrayList;
import java.util.List;

import ModelClass.ModelSubjectDomain;

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


    private RecyclerView recyclerDomain;
    private List<ModelSubjectDomain> list;
    private LinearLayoutManager layoutManager;
    private AdapterSubDomain subDomain;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        list = new ArrayList<>();
        list.add(new ModelSubjectDomain(R.drawable.computer,"Computer Science"));
        list.add(new ModelSubjectDomain(R.drawable.psychology,"Phylosophy"));
        list.add(new ModelSubjectDomain(R.drawable.technology,"Technology"));
        list.add(new ModelSubjectDomain(R.drawable.history,"History"));
        recyclerDomain = (RecyclerView)v.findViewById(R.id.recyclerDomain);
        subDomain = new AdapterSubDomain(list,getActivity());
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerDomain.setLayoutManager(layoutManager);
        recyclerDomain.setAdapter(subDomain);

        return v;
    }

    public class AdapterSubDomain extends RecyclerView.Adapter<AdapterSubDomain.ViewHolder> {
        private List<ModelSubjectDomain> mDataset;
        private Context mContext;

        public  class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtDomain;
            ImageView imgDomain;
            public ViewHolder(View itemView) {
                super(itemView);
                txtDomain = itemView.findViewById(R.id.txtDomain);
                imgDomain = itemView.findViewById(R.id.imgDomain);
            }
        }

        public AdapterSubDomain(List<ModelSubjectDomain> myDataset, Context context) {
            mDataset = myDataset;
            mContext = context;
        }

        @Override
        public AdapterSubDomain.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_subject_domain, parent, false);
            AdapterSubDomain.ViewHolder vh = new AdapterSubDomain.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(AdapterSubDomain.ViewHolder holder, int position) {
            holder.txtDomain.setText(mDataset.get(position).getName());
            holder.imgDomain.setImageResource(mDataset.get(position).getImg());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
