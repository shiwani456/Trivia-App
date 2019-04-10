package com.example.triviaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Next2Activity extends AppCompatActivity {
    private CheckBox whiteCheckBox, yellowCheckBox, orangeCheckBox, greenCheckBox;
    private Button finishbutton,nextbutton;
    private TextView quetwoTextView,getthesummary;
    String data, player, queone;
    String getdata = "";
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next3);
        nextbutton = findViewById(R.id.nextbutton);
        getthesummary = findViewById(R.id.getthesummary);
        whiteCheckBox = findViewById(R.id.whiteCheckBox);
        yellowCheckBox = findViewById(R.id.yellowCheckBox);
        orangeCheckBox = findViewById(R.id.orangeCheckBox);
        greenCheckBox = findViewById(R.id.greenCheckBox);
        quetwoTextView = findViewById(R.id.quetwoTextView);

        itemClicked();


        Intent i = getIntent();
        data = i.getStringExtra("name");
        player = i.getStringExtra("player");
        queone = i.getStringExtra("queone");
        finishbutton = findViewById(R.id.finishbutton);
        finishbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Adding details to data base
                mydb = new DBHelper(Next2Activity.this);
                mydb.insertData(data, queone, player, quetwoTextView.getText().toString(), getdata);
                //callinhg next page
                Intent intent = new Intent(Next2Activity.this, FinalActivity.class);
                startActivity(intent);
                finish();

            }
        });
        //showing summary of over work
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getthesummary.setText(data+"\n"+queone+"\n"+player+"\n"+quetwoTextView.getText().toString()+"\n"+getdata);
            }
        });


    }

    public void itemClicked() {
        //code to check if this checkbox is checked!

        whiteCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    getdata = getdata + " " + whiteCheckBox.getText();
                }
            }
        });
        yellowCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    getdata = getdata + " " + yellowCheckBox.getText();
                }
            }
        });
        orangeCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    getdata = getdata + "  " + orangeCheckBox.getText();
                }
            }
        });
        greenCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    getdata = getdata + " " + greenCheckBox.getText();
                }
            }
        });


    }
}