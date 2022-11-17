package com.example.hraftiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
        TextView Email,motdepasse;
        ImageView SeConnecter;
        Button motdpOublie;
        Helper database;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email = findViewById(R.id.textEmail);
        motdepasse = findViewById(R.id.textpaswd);
        SeConnecter = findViewById(R.id.Seconnect);
        motdpOublie = findViewById(R.id.Oublie);
        database = new Helper(this);

        SeConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user =Email.getText().toString();
                String pass = motdepasse.getText().toString();
                if(user.equals("")){
                    Toast.makeText(LoginActivity.this,"enter votre email",Toast.LENGTH_SHORT).show();
                }
                if (pass.equals("")){
                    Toast.makeText(LoginActivity.this,"enter votre mot de passe",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkpass=database.checkEmailPassword(user,pass);
                    if (checkpass == true){
                        Toast.makeText(LoginActivity.this,"connection succès",Toast.LENGTH_SHORT).show();
//                        Intent i=new Intent(getApplicationContext(),HomeActivity.class);
//                        startActivity(i);
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Informations invalides",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        motdpOublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}