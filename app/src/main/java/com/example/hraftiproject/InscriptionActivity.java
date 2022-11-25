package com.example.hraftiproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class InscriptionActivity extends AppCompatActivity  {

    private EditText nomEdt ,emailEdt,passwordEdt,villeEdt,numtelEdt,descriptionEdt ,passwordEdtConf;
    private Button submitBtn ;
    private Spinner dropdown;
    boolean passwordVisible ,passwordVisible1;
    String item1;
    //insertion image
    private ImageView profileImage;
    private static final int PICK_IMAGE_REQUEST=99;
    Uri imagePath;
    Bitmap imageToStore;
    int Increment=0;

    private Helper helper;
    String[] items = new String[]{"Select device", "Agriculteur","Boucher", "Boulanger", "Chauffeur","Cuisinier", "Femme de menage",
            "Menuisier","Mécanicien","Jardinier",
            "Peintre", "Photographe",  "Plombier"
            ,"Serveur"};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2);
        //insertion image
        profileImage =findViewById(R.id.profile);

        nomEdt=findViewById(R.id.nom);
        emailEdt=findViewById(R.id.email);
        passwordEdt=findViewById(R.id.password);
        passwordEdtConf=findViewById(R.id.passwordConf);
        villeEdt=findViewById(R.id.ville);
        numtelEdt=findViewById(R.id.numtel);
        descriptionEdt=findViewById(R.id.description);
        submitBtn=findViewById(R.id.submit);
        dropdown = findViewById(R.id.spinner1);
          //kant
         ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);


        //dropDown layout style
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        //attaching data adapter to spinner
        dropdown.setAdapter(adapter);
        /// valeur par defaut de spinner
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if(parent.getItemAtPosition(position).equals("Select device")){

                    //do nothing
                   Increment=1;
                }else{
                    // on selecting a spinner item
                    item1=parent.getItemAtPosition(position).toString();
                    Increment=0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                      //TODO Auto-generated method stub
            }
        });
        dropdown.setSelection(0);


        helper = new Helper(InscriptionActivity.this);
        //insertion image
        //chose image from device
        profileImage.setOnClickListener(view -> choseImage());

        //visibility password

        passwordEdt.setOnTouchListener((view, motionEvent) -> {
            final  int Right=2;
            if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                if(motionEvent.getRawX()>=passwordEdt.getRight()-passwordEdt.getCompoundDrawables()[Right].getBounds().width()){
                   int selection=passwordEdt.getSelectionEnd();
                   if(passwordVisible){
                       //set drawable image here
                       passwordEdt.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility_off,0);
                       //for hide password
                       passwordEdt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                       passwordVisible=false;
                   }else{
                       //set drawable image here
                       passwordEdt.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility,0);
                       //for show password
                       passwordEdt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                       passwordVisible=true;
                   }
                   passwordEdt.setSelection(selection);
                   return true ;
                }
            }

            return false;
        });

        passwordEdtConf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final  int Right=2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=passwordEdtConf.getRight()-passwordEdtConf.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=passwordEdtConf.getSelectionEnd();
                        if(passwordVisible1){
                            //set drawable image here
                            passwordEdtConf.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility_off,0);
                            //for hide password
                            passwordEdtConf.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible1=false;
                        }else{
                            //set drawable image here
                            passwordEdtConf.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility,0);
                            //for show password
                            passwordEdtConf.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible1=true;
                        }
                        passwordEdtConf.setSelection(selection);
                        return true ;
                    }
                }

                return false;
            }
        });
        /////////////
        submitBtn.setOnClickListener(v -> {

            // below line is to get data from all edit text fields.
            String  nom=nomEdt.getText().toString();
            String email = emailEdt.getText().toString();
            String password=  passwordEdt.getText().toString();
            String passwordConf=  passwordEdtConf.getText().toString();
            String ville=  villeEdt.getText().toString();
            int numtel= Integer.parseInt(numtelEdt.getText().toString());
            String num = numtelEdt.getText().toString() ;
            String description= descriptionEdt.getText().toString();
           String spinner_data = dropdown.getSelectedItem().toString();
           //

            // validating if the text fields are empty or not.
            if (nom.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConf.isEmpty()   || ville.isEmpty() || description.isEmpty() ||num.isEmpty() ) {
                Toast.makeText(getApplicationContext(), "Fields can't be blank", Toast.LENGTH_SHORT).show(); //InscriptionActivity.this

            }else if (!password.equals(passwordConf)){
                Toast.makeText(getApplicationContext(), "Password and confirm password should match login ..", Toast.LENGTH_SHORT).show(); //InscriptionActivity.this
                  //verifier format de e-mail
            }else if (Increment ==1){
            Toast.makeText(getApplicationContext(), "Selectioner metier ..", Toast.LENGTH_SHORT).show(); //InscriptionActivity.this

        }
            else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){


                {
                    Toast.makeText(this, "Email not correct !", Toast.LENGTH_SHORT).show();
                }




            }else {

                try{
                    helper.addNewProfessionnel( nom ,email,password,item1,numtel,ville ,description ,imageToStore); //spinner_data
                    Toast.makeText(InscriptionActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(InscriptionActivity.this,LoginActivity.class);
                    startActivity(i);
                }catch (Exception E){
                     Toast.makeText(getApplicationContext(),"registration user failed ! " + E, Toast.LENGTH_LONG).show();

                }

            }


        });






    }
    //insertion image
    private void choseImage() {
        try{
            Intent intent=new Intent();
            intent.setType("image/*");
            intent.setAction(intent.ACTION_GET_CONTENT);
            startActivityForResult(intent,PICK_IMAGE_REQUEST);
        }catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data !=null && data.getData()!=null)
            {
                imagePath=data.getData();
                imageToStore= MediaStore.Images.Media.getBitmap(getContentResolver(),imagePath);
                profileImage.setImageBitmap(imageToStore);
            }
        }catch(Exception e)
        {

        }
    }
    public void Login(View view){
        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);


    }



}