package com.example.e_pharmacy;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public static final String dbname = "EPPharmacy.db";

    public Database( @Nullable Context context) {
        super(context, dbname , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table userorder(ID INT primary key , name TEXT, MEDNAME TEXT ,  phone INT , Hospital TEXT , OrderCode INT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS  userorder");
        onCreate(db);
    }

    public Boolean insert(String ID ,String name ,  String MEDNAME , String phone  , String Hospital , int OrderCode){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


            contentValues.put("ID", ID);
            contentValues.put("name", name);
            contentValues.put("MEDNAME", MEDNAME);
            contentValues.put("phone", phone);
            contentValues.put("Hospital", Hospital);
            contentValues.put("OrderCode", OrderCode);

            long result = db.insert("userorder", null, contentValues);

            if (result == -1) {
                return false;

            } else {
                return true;
            }




    }
    public Cursor retrieve (){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from userorder ", null);
        return cursor;


    }

}
