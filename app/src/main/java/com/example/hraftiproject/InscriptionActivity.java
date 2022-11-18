package com.example.hraftiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionActivity extends AppCompatActivity {



    // creating variables for our edittext, button and dbhandler
    private EditText nomEdt ,emailEdt,passwordEdt,metierEdt,villeEdt,numtelEdt,descriptionEdt;
    private Button submitBtn ,Inscrption,button;
    Helper helper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2);

        // initializing all our variables.
        nomEdt = findViewById(R.id.nom);
        emailEdt=findViewById(R.id.email);
        passwordEdt=findViewById(R.id.password);
        metierEdt=findViewById(R.id.metier);
        villeEdt=findViewById(R.id.ville);
        numtelEdt=findViewById(R.id.numtel);
        descriptionEdt=findViewById(R.id.description);
        submitBtn=findViewById(R.id.submit);

        // creating a new dbhandler class
        // and passing our context to it.
        helper = new Helper(InscriptionActivity.this);


        // below line is to add on click listener for our add course button.
        submitBtn.setOnClickListener(v -> {

            // below line is to get data from all edit text fields.
            String  nom=nomEdt.getText().toString();
            String email = emailEdt.getText().toString();
            String password=  passwordEdt.getText().toString();
            String metier= metierEdt.getText().toString() ;
            String ville=  villeEdt.getText().toString();
            int numtel= Integer.parseInt(numtelEdt.getText().toString());
            String description= descriptionEdt.getText().toString();

            // validating if the text fields are empty or not.
            if (nom.isEmpty() && email.isEmpty() && password.isEmpty() && metier.isEmpty() && ville.isEmpty() && description.isEmpty() ) {
                Toast.makeText(InscriptionActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }
            // on below line we are calling a method to add new
            // course to sqlite data and pass all our values to it.
            // professionnel professionnel=new professionnel(nom ,email,password,metier,ville ,numtel,description );
            try{
                helper.addNewProfessionnel( nom ,email,password,metier,numtel,ville ,description);
                Toast.makeText(InscriptionActivity.this, "Professionnel has been added.", Toast.LENGTH_SHORT).show();

            }catch (Exception E){
                Toast.makeText(InscriptionActivity.this, "error.", Toast.LENGTH_SHORT).show();

                System.out.println("error "+E);
            }


            // after adding the data we are displaying a toast message.

            nomEdt.setText("");
            emailEdt.setText("");
            passwordEdt.setText("");
            metierEdt.setText("");
            villeEdt.setText("");
            numtelEdt.setText("");
            descriptionEdt.setText("");
        });


    }


}