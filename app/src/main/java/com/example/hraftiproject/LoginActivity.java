package com.example.hraftiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
        EditText Email,motdepasse;
        ImageView SeConnecter;
        TextView motdpOublie;
        TextView Inscrire;
        Helper database;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email = findViewById(R.id.email);
        motdepasse = findViewById(R.id.passwordEdite);
        SeConnecter = findViewById(R.id.Seconnect);
        motdpOublie = findViewById(R.id.Oublie);
        Inscrire =findViewById(R.id.button2);
        database = new Helper(this);

        SeConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user =Email.getText().toString();
                String pass = motdepasse.getText().toString();
                if(user.equals("")){
                    Toast.makeText(LoginActivity.this,"entrer votre email",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals("")) {
                        Toast.makeText(LoginActivity.this, "entrer votre mot de passe", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Boolean checkpass = database.checkEmailPassword(user, pass);
                        if (checkpass) {
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Toast.makeText(LoginActivity.this, "connection succès", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(LoginActivity.this, "Informations invalides", Toast.LENGTH_SHORT).show();

                        }
                    }
                }

            }
        });
        motdpOublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ForgotPswdActivity.class);
                startActivity(i);
            }
        });
        Inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),InscriptionActivity.class);
                startActivity(i);
            }
        });
    }
}