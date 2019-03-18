package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aartilakkad.libaraymanagement.R;
import com.example.aartilakkad.libaraymanagement.libaray.Activity.BookInformation.BookInformationActivity;

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
    public List<ModelSubjectDomain> list;
    public LinearLayoutManager layoutManager;
    private AdapterSubDomain subDomain;
    private AdapterLearningResource learning;
    private AdapterLearningFeatured featured;
    private RecyclerView recyclerLearning;
    private RecyclerView recyclerFeatured;
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        list = new ArrayList<>();
        list.add(new ModelSubjectDomain(R.drawable.computer,"Computer Science"));
        list.add(new ModelSubjectDomain(R.drawable.psychology,"Psychology"));
        list.add(new ModelSubjectDomain(R.drawable.technology,"Technology"));
        list.add(new ModelSubjectDomain(R.drawable.history,"History"));
        recyclerDomain = (RecyclerView)v.findViewById(R.id.recyclerDomain);
        
        subDomain = new AdapterSubDomain(list,getActivity());
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerDomain.setLayoutManager(layoutManager);
        recyclerDomain.setAdapter(subDomain);


        list = new ArrayList<>();
        list.add(new ModelSubjectDomain(R.drawable.book,"Book"));
        list.add(new ModelSubjectDomain(R.drawable.questionpaper,"Question Paper"));
        list.add(new ModelSubjectDomain(R.drawable.article,"Artical"));
        list.add(new ModelSubjectDomain(R.drawable.thesis,"Thesis"));
        recyclerLearning = (RecyclerView)v.findViewById(R.id.recyclerResource);
        learning = new AdapterLearningResource(list,getActivity());
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerLearning.setLayoutManager(layoutManager);
        recyclerLearning.setAdapter(learning);

        list = new ArrayList<>();
        list.add(new ModelSubjectDomain(R.drawable.gate,"Gate"));
        list.add(new ModelSubjectDomain(R.drawable.spoken,"Spoken Tutorial"));
        list.add(new ModelSubjectDomain(R.drawable.jee,"Jee"));
        list.add(new ModelSubjectDomain(R.drawable.neet,"Neet"));
        recyclerFeatured = (RecyclerView)v.findViewById(R.id.recyclerSource);
        featured = new AdapterLearningFeatured(list,getActivity());
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerFeatured.setLayoutManager(layoutManager);
        recyclerFeatured.setAdapter(featured);

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
            holder.imgDomain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "hi", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getContext(), BookInformationActivity.class);
                    startActivity(i);

                }
            });
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

    public class AdapterLearningResource extends RecyclerView.Adapter<AdapterLearningResource.ViewHolder>
    {
        private List<ModelSubjectDomain> mDataset;
        private Context mContext;

        public AdapterLearningResource(List<ModelSubjectDomain> mDataset, Context mContext) {
            this.mDataset = mDataset;
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_learning_resource, parent, false);
            AdapterLearningResource.ViewHolder vh = new AdapterLearningResource.ViewHolder(v);
            return vh;

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.txtDomain.setText(mDataset.get(position).getName());
            holder.imgDomain.setImageResource(mDataset.get(position).getImg());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public  class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtDomain;
            ImageView imgDomain;
            public ViewHolder(View itemView) {
                super(itemView);
                txtDomain = itemView.findViewById(R.id.txtDomain);
                imgDomain = itemView.findViewById(R.id.imgDomain);
            }
        }






    }
    public  class AdapterLearningFeatured extends RecyclerView.Adapter<AdapterLearningFeatured.ViewHolder>
    {
        private List<ModelSubjectDomain> mDataset;
        private Context mContext;

        public AdapterLearningFeatured(List<ModelSubjectDomain> mDataset, Context mContext) {
            this.mDataset = mDataset;
            this.mContext = mContext;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_features_source, parent, false);
            AdapterLearningFeatured.ViewHolder vh = new AdapterLearningFeatured.ViewHolder(v);
            return vh;

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.txtDomain.setText(mDataset.get(position).getName());
            holder.imgDomain.setImageResource(mDataset.get(position).getImg());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtDomain;
            ImageView imgDomain;
            public ViewHolder(View itemView) {
                super(itemView);
                txtDomain = itemView.findViewById(R.id.txtDomain);
                imgDomain = itemView.findViewById(R.id.imgDomain);
            }
        }
    }
}