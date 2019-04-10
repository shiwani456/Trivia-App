package com.example.triviaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    private RadioGroup radiogroup;
    private RadioButton radioButton;
    private Button nextbutton;
    private TextView queoneTextView;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);
        radiogroup = findViewById(R.id.radiogroup);
        nextbutton = findViewById(R.id.nextbutton);
        queoneTextView = findViewById(R.id.queoneTextView);
        Intent i = getIntent();
        data = i.getStringExtra("name");
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = radiogroup.getCheckedRadioButtonId();
                radioButton = findViewById(selected);
                Intent intent = new Intent(NextActivity.this,Next2Activity.class);
                intent.putExtra("player",radioButton.getText());
                intent.putExtra("name",data);
                intent.putExtra("queone",queoneTextView.getText());
                startActivity(intent);
                finish();


            }
        });
    }
}
