package com.example.hraftiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class Helper extends SQLiteOpenHelper {
    private static final String DB_NAME = "database";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "professionnel";
    private static final String ID_COL = "id";
    private static final String Nom_COL = "nomComplet";
    private static final String EMAIL_COL = "email";
    private static final String PASSWORD_COL = "mdps";
    private static final String Metier_COL = "metier";
    private static final String numTel_COL = "numTel";
    private static final String ville_COL = "ville";
    private static final String description_COL = "description";



    public Helper(@Nullable Context context) {
        super(context,DB_NAME , null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Nom_COL + " TEXT,"
                +EMAIL_COL+ "TEXT,"
                +PASSWORD_COL+"TEXT"
                + Metier_COL + " TEXT,"
                + numTel_COL + " INTEGER,"
                + ville_COL + " TEXT,"
                + description_COL + " TEXT)";
            //IMAGE IN DB

            // String query="CREATE TABLE professionnel(_id INTEGER PRIMARY KEY,nomComplet TEXT ,metier TEXT ,numTel INTEGER ,ville TEXT ,description Text)";

            db.execSQL(query);
           /* String query2="INSERT INTO "+TABLE_NAME+" VALUES ('nom','email@gmail.com' ,'passwd','metier','0214578963','ville','descrrrrrrrrption' )";
        db.execSQL(query2);*/



    }

    public void addNewProfessionnel(professionnel p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Nom_COL, p.getNomComplet());
        values.put(EMAIL_COL, p.getEmail());
        values.put(PASSWORD_COL, p.getPassword());
        values.put(Metier_COL , p.getMetier());
        values.put(numTel_COL , p.getNumTel());
        values.put(ville_COL, p.getVille());
        values.put(description_COL, p.getDescription());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

     /*
    public void addNewProfessionnel(String nom ,String email ,String psd ,String metier ,String  ville  ,int num ,String DESCRIPTION){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Nom_COL, nom);
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, psd);
        values.put(Metier_COL , metier);
        values.put(numTel_COL , num);
        values.put(ville_COL, ville);
        values.put(description_COL, DESCRIPTION);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    public Boolean checkEmail(String email){
       SQLiteDatabase mydatabase =  this.getWritableDatabase();
        Cursor cursor=mydatabase.rawQuery("select * from professionnel where email = ?",new String[]{email});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkEmailPassword(String email,String mdps){
        SQLiteDatabase mydatabase =  this.getWritableDatabase();
        Cursor cursor=mydatabase.rawQuery("select * from professionnel where email = ? and mdps=?",new String[]{email,mdps});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
