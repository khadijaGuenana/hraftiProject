package com.example.hraftiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.SearchView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<JobModel> jobModalArrayList;
    private static Helper dbHandler;
    private MyAdapter myAdapter;
    private RecyclerView recyclerView;
    RecyclerView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);


        jobModalArrayList = new ArrayList<>();
        dbHandler = new Helper(MainActivity.this);
        jobModalArrayList = dbHandler.readJobs();
        myAdapter= new MyAdapter(jobModalArrayList, MainActivity.this);
        recyclerView = findViewById(R.id.idRC);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
        dbHandler = new Helper(this);
        listView = findViewById(R.id.idRC);
        Actualiser("");


    }



     void Actualiser(String str){
        ArrayList<JobModel> jobs = dbHandler.returnJob(str);
        MyAdapter job = new MyAdapter(jobs);
        listView.setAdapter((RecyclerView.Adapter) job);
     }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu, menu);

        MenuItem myItem = menu.findItem(R.id.search);
        SearchView sv = (SearchView) MenuItemCompat.getActionView(myItem);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Actualiser(s);
                return false;
            }
        });

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.inscription) {
            Intent intent = new Intent(this, InscriptionActivity.class);
            startActivity(intent);
        }
        if (id == R.id.login) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        if (id == R.id.profil) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        switch (item.getItemId()) {
            case R.id.search:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView job;
        public TextView name;
        public TextView number;
        public TextView city;
        String email;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            job = itemView.findViewById(R.id.job);
            name = itemView.findViewById(R.id.textname);
            number = itemView.findViewById(R.id.textnumber);
            city = itemView.findViewById(R.id.textcity);


            itemView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    email = dbHandler.getEmailByName(name.getText().toString());
                    Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                    intent.putExtra("useremail", email);
                    System.out.println(email);
                    view.getContext().startActivity(intent);
                }


            });

        }


    }

}


