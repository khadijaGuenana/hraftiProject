package com.example.hraftiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
    private static final String DB_NAME = "hrayfiDb";
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






    public Helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DB_NAME , null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
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

        sqLiteDatabase.execSQL(query);

    }
    public void addNewProfessionnel(String nomComplet,String email, String password ,String metier ,int numTel ,String ville ,String description){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Nom_COL, nomComplet);
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, password);
        values.put(Metier_COL , metier);
        values.put(numTel_COL , numTel);
        values.put(ville_COL, ville);
        values.put(description_COL, description);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
