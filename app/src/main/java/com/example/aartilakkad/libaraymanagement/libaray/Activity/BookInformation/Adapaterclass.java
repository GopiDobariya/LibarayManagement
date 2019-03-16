package com.example.aartilakkad.libaraymanagement.libaray.Activity.BookInformation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aartilakkad.libaraymanagement.R;

import java.util.ArrayList;

public class Adapaterclass extends RecyclerView.Adapter<Adapaterclass.ItemViewHolder> {
    Context context;
    ArrayList<Modelclass> modelclass;

    public Adapaterclass(Context context, ArrayList<Modelclass> modelclass) {
        this.context = context;
        this.modelclass = modelclass;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.details,parent,false);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int i) {
        Modelclass list=modelclass.get(i);

        holder.bookname.setText(list.getBookname());
        holder.sourceid.setText(list.getSourceid());
        holder.authorname.setText(list.getAuthorname());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hii", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelclass.size();
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
