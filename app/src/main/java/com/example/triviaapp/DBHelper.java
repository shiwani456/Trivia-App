package com.example.triviaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String QUIZ_TABLE_NAME = "trivia";
    public static final String Quiz_COLUMN_NAME = "name";
    public static final String Quiz_COLUMN_PLAYER = "player";
    public static final String Quiz_COLUMN_FLAG = "indianflag";
    public static final String Quiz_COL_QU= "queone";
    public static final String Quiz_COL_QUE= "quetwo";
    public  static final String QUIZ_COL_tidate ="created_at";


// creating data base
    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table trivia " +
                        "(id integer primary key AUTOINCREMENT , created_at DEFAULT CURRENT_TIMESTAMP, name text, queone text , player text, quetwo text, indianflag text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS trivia");
        onCreate(db);

    }
    //inserting data to database
    public boolean insertData (String name, String queone,String player, String quetwo,String indianflag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("created_at", getDateTime());
        contentValues.put("name", name);
        contentValues.put("queone",queone);
        contentValues.put("player", player);
        contentValues.put("quetwo",quetwo);
        contentValues.put("indianflag", indianflag);
        db.insert("trivia", null, contentValues);
        return true;
    }



    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }




}
