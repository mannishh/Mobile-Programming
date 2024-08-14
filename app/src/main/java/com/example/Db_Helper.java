package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Db_Helper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "mydb";
    // Table Name
    private static final String TABLE_NAME = "mytable";

    public Db_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table
        String createQuery = "CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY, name TEXT, address TEXT)";
        db.execSQL(createQuery);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    // Code to insert data
    public void insertData(int id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("address", address);
        // Inserting row
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    // Code to select data
    public Cursor selectData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        return db.rawQuery(query, null);
    }

    // Code to update data
    public void updateData(String id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        // Updating row
        db.update(TABLE_NAME, contentValues, "id=?", new String[]{id});
        db.close();
    }

    // Code to delete data
    public void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Deleting row
        db.delete(TABLE_NAME, "id=?", new String[]{id});
        db.close();
    }
}