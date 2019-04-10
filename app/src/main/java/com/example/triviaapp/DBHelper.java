package com.example.triviaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from trivia where id="+id+"", null );
        return res;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, QUIZ_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String name, String player, String indianflag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("created_at", getDateTime());
        contentValues.put("name", name);
        contentValues.put("player", player);
        contentValues.put("indianflag", indianflag);
            db.update("trivia", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("trivia",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllData() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from trivia", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(Quiz_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
