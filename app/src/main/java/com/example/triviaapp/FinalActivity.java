package com.example.triviaapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {
    private ListView data_list;
    ArrayList<String> ArrayList = new ArrayList<String>();
    private Button finalButton, historybutton;
    Cursor cursor;
    SQLiteDatabase SQLITEDATABASE;
    SQLiteListAdapter ListAdapter;
    DBHelper mydb;

    ArrayList<String> created_at = new ArrayList<>();
    ArrayList<String> userName = new ArrayList<>();
    ArrayList<String> UserQu1ame = new ArrayList<>();

    ArrayList<String> ans1 = new ArrayList<>();

    ArrayList<String> qu2 = new ArrayList<>();

    ArrayList<String> ans2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        data_list = findViewById(R.id.data_list);
        finalButton = findViewById(R.id.finalButton);
        mydb = new DBHelper(FinalActivity.this);
        historybutton = findViewById(R.id.historybutton);
        finalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        historybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_list.setVisibility(View.VISIBLE);
               ShowSQLiteDBdata();



            }
        });

    }



    private void ShowSQLiteDBdata() {

        SQLITEDATABASE = mydb.getWritableDatabase();

        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM trivia", null);

        created_at.clear();
        userName.clear();
        UserQu1ame.clear();
        ans1.clear();
        qu2.clear();
        ans2.clear();

        if (cursor.moveToFirst()) {
            do {
                created_at.add(cursor.getString(cursor.getColumnIndex(DBHelper.QUIZ_COL_tidate)));

                userName.add(cursor.getString(cursor.getColumnIndex(DBHelper.Quiz_COLUMN_NAME)));

                UserQu1ame.add(cursor.getString(cursor.getColumnIndex(DBHelper.Quiz_COL_QU)));

                ans1.add(cursor.getString(cursor.getColumnIndex(DBHelper.Quiz_COLUMN_PLAYER)));

                qu2.add(cursor.getString(cursor.getColumnIndex(DBHelper.Quiz_COL_QUE)));

                ans2.add(cursor.getString(cursor.getColumnIndex(DBHelper.Quiz_COLUMN_FLAG)));

            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(FinalActivity.this,

                created_at,
                userName,
                UserQu1ame,
                ans1,
                qu2,
                ans2

        );

        data_list.setAdapter(ListAdapter);

        cursor.close();
    }
}
