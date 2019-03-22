package com.example.aartilakkad.libaraymanagement;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aartilakkad.libaraymanagement.libaray.Activity.ApiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ModelClass.ModelBookDetail;
import ProjectServices.ProjectServices;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Jee extends AppCompatActivity {
    private RecyclerView rcHistory;
    private List<ModelBookDetail> list;
    private RecyclerView.LayoutManager mCLayoutManager;
    private Jee.AdapterHistoryBook adapterHistoryBook;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee);

        rcHistory = (RecyclerView)findViewById(R.id.rcHistory);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Gate Book");
        list = new ArrayList<>();
        rcHistory.setHasFixedSize(true);
        mCLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rcHistory.setLayoutManager(mCLayoutManager);
        ProjectServices services = ApiClient.addData().create(ProjectServices.class);
        services.getBookDetail("Jee", new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                BufferedReader reader = null;
                String output = "";
                try {
                    reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
                    output = reader.readLine();
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ModelBookDetail>>() {
                    }.getType();
                    List<ModelBookDetail> ModelEmergency = gson.fromJson(output, type);
                    for (ModelBookDetail item : ModelEmergency)
                    {
                        list.add(new ModelBookDetail(item.getBook_id(),item.getBook_name(),item.getBook_author(),item.getBook_category(),item.getBook_publish()));
                    }
                    adapterHistoryBook = new Jee.AdapterHistoryBook(list,getApplicationContext());
                    rcHistory.setAdapter(adapterHistoryBook);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public class AdapterHistoryBook extends RecyclerView.Adapter<AdapterHistoryBook.ViewHolder> {
        private List<ModelBookDetail> mDataset;
        private Context mContext;

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtBookId, txtBookName, txtAuthorName, txtBookCat, txtPublishDate;

            public ViewHolder(View itemView) {
                super(itemView);
                txtBookId = itemView.findViewById(R.id.txtBookId);
                txtBookName = itemView.findViewById(R.id.txtBookName);
                txtAuthorName = itemView.findViewById(R.id.txtAuthorName);
                txtBookCat = itemView.findViewById(R.id.txtBookCat);
                txtPublishDate = itemView.findViewById(R.id.txtPublishDate);
            }
        }

        public AdapterHistoryBook(List<ModelBookDetail> myDataset, Context context) {
            mDataset = myDataset;
            mContext = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.details, parent, false);
            Jee.AdapterHistoryBook.ViewHolder vh = new Jee.AdapterHistoryBook.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.txtBookId.setText(mDataset.get(position).getBook_id());
            holder.txtBookName.setText(mDataset.get(position).getBook_name());
            holder.txtAuthorName.setText(mDataset.get(position).getBook_author());
            holder.txtBookCat.setText(mDataset.get(position).getBook_category());
            holder.txtPublishDate.setText(mDataset.get(position).getBook_publish());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
