package com.example.triviaapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button button;
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    DBHelper mydb;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init()
    {
        nameEditText = findViewById(R.id.nameEditText);
        button = findViewById(R.id.button);
      //  mydb = new  DBHelper(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = nameEditText.getText().toString();
        //        if(mydb.insertData(text,"dhoni","white")) {
                    Intent intent = new Intent(MainActivity.this,NextActivity.class);
                    intent.putExtra("name",text);
                    startActivity(intent);
          //      }

            }
        });


    }


}
