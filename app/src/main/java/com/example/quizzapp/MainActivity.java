package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.quizzapp.data.CheckCompletion;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout nextbtn;
    private TextView statusTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextbtn = findViewById(R.id.start);
        statusTxt = findViewById(R.id.statusTxt);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
                startActivity(intent);
            }
        });

        CheckCompletion checkCompletion = new CheckCompletion(getApplicationContext());

        if(checkCompletion.execute()){
            statusTxt.setText("Status: complete");
        }
    }


}