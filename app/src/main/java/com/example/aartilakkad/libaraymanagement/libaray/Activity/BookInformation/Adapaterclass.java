package com.example.aartilakkad.libaraymanagement.libaray.Activity.BookInformation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aartilakkad.libaraymanagement.R;

import java.util.ArrayList;

public class Adapaterclass extends RecyclerView.Adapter<Adapaterclass.ItemViewHolder> {
    Context context;
    ArrayList<Modelclass> modelclass;


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView bookname, sourceid, authorname;
        LinearLayout layout;
        public ItemViewHolder(View itemView) {
            super(itemView);

            bookname = itemView.findViewById(R.id.bookname);
            sourceid = itemView.findViewById(R.id.source);
            authorname = itemView.findViewById(R.id.author);
            layout = itemView.findViewById(R.id.linear);
        }
    }
}
