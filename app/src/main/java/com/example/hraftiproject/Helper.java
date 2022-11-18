package com.example.hraftiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class Helper extends SQLiteOpenHelper {

    // creating a constant variables for our database.
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




    // below variable is for our course tracks column.
  //  private static final String TRACKS_COL = "tracks";

    // creating a constructor for our database handler.
    public Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query ="CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Nom_COL +  " TEXT,"
                +EMAIL_COL+  " TEXT UNIQUE ,"
                +PASSWORD_COL+ " TEXT ,"
                + Metier_COL + " TEXT ,"
                + numTel_COL + " INTEGER UNIQUE ,"
                + ville_COL + " TEXT,"
                + description_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);


        String ROW1 = "INSERT INTO " + TABLE_NAME + " ("
                + Nom_COL + ", " + EMAIL_COL + ", "
                + PASSWORD_COL + ", " + Metier_COL + ", "
                +numTel_COL+", " + ville_COL + ","
                + description_COL +")  Values ('nom prenom'," +
                " 'email1@gmail.com', 'password', 'metier1', " +
                "'0612457893' ,'marrakech' ,'description du metier')";
        db.execSQL(ROW1);
        String ROW2 = "INSERT INTO " + TABLE_NAME + " ("
                + Nom_COL + ", " + EMAIL_COL + ", "
                + PASSWORD_COL + ", " + Metier_COL + ", "
                +numTel_COL+", " + ville_COL + ","
                + description_COL +")  Values ('nom prenom2'," +
                " 'email2@gmail.com', 'password', 'metier2', " +
                "'0714895263' ,'agadir' ,'description du metier2')";
        db.execSQL(ROW2);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewProfessionnel(String nom ,String email ,String password,String mt,int numtel ,String ville,String  description) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(Nom_COL, nom);
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, password);
        values.put(Metier_COL , mt);
        values.put(numTel_COL , numtel);
        values.put(ville_COL, ville);
        values.put(description_COL, description);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
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

    public Boolean updatePasswd(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PASSWORD_COL, password);
       long result =  db.update(TABLE_NAME, values,"email= ?" ,new String[]{email});
        if(result == -1) return false;
        else return true;
    }
}
