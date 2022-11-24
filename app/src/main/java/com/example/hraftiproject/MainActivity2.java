package com.example.hraftiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(MainActivity2.this,MainActivity.class));
                finish();
            }
        },3000);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}