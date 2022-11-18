package com.example.hraftiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPswdActivity extends AppCompatActivity {
    EditText EmailCheck;
    Button valide;
    Helper database;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pswd);
        EmailCheck = findViewById(R.id.editEmailAddress);
        valide = findViewById(R.id.valide);

        database = new Helper(this);

        valide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = EmailCheck.getText().toString();
                Boolean checkEmail= database.checkEmail(email);
                if (checkEmail){
                    Intent i = new Intent(getApplicationContext(),ResetPasswordActivity.class);
                    i.putExtra("email",email);
                    startActivity(i);
                }
                else{
                    Toast.makeText(ForgotPswdActivity.this, "email non existant ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}