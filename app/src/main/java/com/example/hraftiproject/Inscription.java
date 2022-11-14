package com.example.hraftiproject;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inscription extends AppCompatActivity {  //implements View.OnClickListener
   EditText nomEdt ,emailEdt,passwordEdt,metierEdt,villeEdt,numtelEdt,descriptionEdt;
   Button submitBtn;
   Helper helper =new Helper(this);  //Inscription.this
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        nomEdt=findViewById(R.id.nom);
        emailEdt=findViewById(R.id.email);
        passwordEdt=findViewById(R.id.password);
        metierEdt=findViewById(R.id.metier);
        villeEdt=findViewById(R.id.ville);
        numtelEdt=findViewById(R.id.numtel);
        descriptionEdt=findViewById(R.id.description);
        submitBtn=findViewById(R.id.submit);
       // submitBtn.setOnClickListener(this);


    }

    //@Override
    public void onClick(View view) {


            String  nom=nomEdt.getText().toString();
            String email = emailEdt.getText().toString();
            String password=  passwordEdt.getText().toString();
            String metier= metierEdt.getText().toString() ;
            String ville=  villeEdt.getText().toString();
            int numtel= Integer.parseInt(numtelEdt.getText().toString());
            String description= descriptionEdt.getText().toString();


            professionnel professionnel=new professionnel(nom ,email,password,metier,ville ,numtel,description );

            helper.addNewProfessionnel(professionnel);

            // after adding the data we are displaying a toast message.
           Toast.makeText(Inscription.this, "Professionel has been added.", Toast.LENGTH_SHORT).show();
            nomEdt.setText("");
            emailEdt.setText("");
            passwordEdt.setText("");
            metierEdt.setText("");
            villeEdt.setText("");
            descriptionEdt.setText("");



    }
}