package com.example.stressmanagementapp.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.stressmanagementapp.models.PatientRecord;
import com.google.firebase.auth.FirebaseUser;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class PatientDbAdapter {
    FirebaseUser mAuth;
    private static String dbName="PatientDb";
    private static int dbVersion=1;

    private static PatientDbHelper helper;
    private SQLiteDatabase patientDb;

    public PatientDbAdapter(Context context){
        helper = new PatientDbHelper(context,dbName,null,dbVersion);
    }

    public void Open(){
        patientDb = helper.getWritableDatabase();
    }
    public void Close(){
        patientDb.close();
        patientDb = null;
    }

    public void InsertRecord(String email,String stepCount,String meditateTime,String dateTime){
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("dateTime",dateTime);
        contentValues.put("meditateTime",meditateTime);
        contentValues.put("stepCount",stepCount);
        Log.d("Im here","");
        patientDb.insert("patient",null,contentValues);
    }

    public ArrayList<PatientRecord> getPatientRecords(){
        Cursor cursorRecords = patientDb.rawQuery("SELECT * FROM " + "patient"+" WHERE "+"email"+" = "+ mAuth.getEmail(), null);
        ArrayList<PatientRecord>arrayList= new ArrayList<>();
        String email=mAuth.getEmail();

        Cursor cursor = patientDb.query("patient",null,email,null,null,null,null);

        if (cursorRecords.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                arrayList.add(new PatientRecord(cursorRecords.getString(1),
                        cursorRecords.getString(2),
                        cursorRecords.getString(3),
                        cursorRecords.getString(4)));
            } while (cursorRecords.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorRecords.close();
        return arrayList;
    }

    private static class PatientDbHelper extends SQLiteOpenHelper {

        public PatientDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE patient " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,dateTime TEXT,meditateTime TEXT,stepCount TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "patient");
            sqLiteDatabase.execSQL("CREATE TABLE "+"patient" +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,dateTime TEXT,meditateTime TEXT,stepCount TEXT)");
        }
    }
}
