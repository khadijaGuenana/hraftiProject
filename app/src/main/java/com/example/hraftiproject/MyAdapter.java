package com.example.hraftiproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;




public class MyAdapter  extends RecyclerView.Adapter<MainActivity.ViewHolder> {


    private Helper dbHelper;
    private Context context;
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
    public MainActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new MainActivity.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MainActivity.ViewHolder holder, int position) {
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




}







