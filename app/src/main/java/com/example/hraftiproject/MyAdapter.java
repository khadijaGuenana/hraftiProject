package com.example.hraftiproject;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private  Context context;
    private ArrayList<JobModel> jobsArrayList;





    public MyAdapter(ArrayList<JobModel> jobsArrayList, Context context) {
        this.jobsArrayList = jobsArrayList;
        this.context = context;

    }

    public MyAdapter(ArrayList<JobModel> jobs) {
        this.jobsArrayList = jobs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JobModel modal = jobsArrayList.get(position);
        holder.job.setText(modal.getJob());
        holder.name.setText(modal.getName());
        holder.number.setText(modal.getNumber());
        holder.city.setText(modal.getCity());


    }

    @Override
    public int getItemCount() {
        return jobsArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView job,name, number, city;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          job =itemView.findViewById(R.id.job);
          name = itemView.findViewById(R.id.textname);
          number = itemView.findViewById(R.id.textnumber);
          city = itemView.findViewById(R.id.textcity);


            itemView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                   view.getContext().startActivity(intent);
                }


            });

        }


    }


}
