package com.example.exitpoll.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "poll.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "rerult";
    public static final String COL_ID = "_id";
    public static final String COL_NUMBER = "number";
    public static final String COL_COUNT = "count";
    public static final String COL_IMAGE = "image";

    private static final String SQL_CREATE_TABLE_PHONE
            = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NUMBER + " TEXT,"
            + COL_COUNT + " TEXT,"
            + COL_IMAGE + " TEXT"
            + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_PHONE);

        ContentValues cv = new ContentValues();
        cv.put(COL_NUMBER, "1");
        cv.put(COL_COUNT, "0");
        cv.put(COL_IMAGE, "one.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NUMBER, "2");
        cv.put(COL_COUNT, "0");
        cv.put(COL_IMAGE, "two.png");
        db.insert(TABLE_NAME, null, cv);

        cv.put(COL_NUMBER, "3");
        cv.put(COL_COUNT, "0");
        cv.put(COL_IMAGE, "three.png");
        db.insert(TABLE_NAME, null, cv);

        cv.put(COL_NUMBER, "nulll");
        cv.put(COL_COUNT, "0");
        cv.put(COL_IMAGE, "vote_no.png");
        db.insert(TABLE_NAME, null, cv);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
