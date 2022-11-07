package com.example.stressmanagementapp.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("dateTime",dateTime);
        contentValues.put("meditateTime",meditateTime);
        contentValues.put("stepCount",stepCount);
        patientDb.insert("patient",null,contentValues);
    }

    public ArrayList<PatientRecord> getPatientRecords(){
        ArrayList<PatientRecord>arrayList= new ArrayList<>();
        String email=mAuth.getEmail();
        String stepCount ="";
        String dateTime ="";
        String meditateTime ="";
        Cursor cursor = patientDb.query("patient",null,email,null,null,null,null);
        while(cursor.moveToNext()){

            stepCount = cursor.getString(cursor.getColumnIndexOrThrow("stepCount"));
            dateTime = cursor.getString(cursor.getColumnIndexOrThrow("dateTime"));
            meditateTime = cursor.getString(cursor.getColumnIndexOrThrow("meditateTime"));
            PatientRecord patientRecord = new PatientRecord(meditateTime,stepCount,email,dateTime);
            arrayList.add(patientRecord);
        }
        return arrayList;
    }
    private static class PatientDbHelper extends SQLiteOpenHelper {

        public PatientDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE patient " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT,dateTime Date,meditateTime TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
