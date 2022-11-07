package com.example.stressmanagementapp.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PatientDbAdapter {
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

    public void InsertRecord(String name){
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        patientDb.insert("patient",null,contentValues);
    }

    public String getRecordForPerson(){
        String name="";
        Cursor cursor = patientDb.query("patient",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            name = name +";"+ cursor.getString(cursor.getColumnIndexOrThrow("name"));
        }
        return name;
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
