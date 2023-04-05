package com.example.quizzapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.quizzapp.data.CheckCompletion;

public class QuizActivity extends Activity {
    private int stage = 1;
    private int actionNumber = 0;

    SharedPreferences preferences;

    TextView nextTxt, progress;
    RelativeLayout btn, layout;
    CheckCompletion checkCompletion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_quiz);

        init();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextTxt.getText().equals("Complete")){

                    preferences.edit().putInt("completeCount" + actionNumber, 4).commit();
                    preferences.edit().putBoolean("completeStatus" + actionNumber, true).commit();

                    if (checkCompletion.execute()) {
                        showPopUp();
                    }
                    else {
                        Intent intent = new Intent(QuizActivity.this, TaskListActivity.class);
                        startActivity(intent);
                    }
                }

                if (stage == 3){
                    progress.setText("Process 4/4");
                    nextTxt.setText("Complete");
                }
                else {
                    stage++;
                    progress.setText("Process " + stage +"/4");
                }

            }
        });


    }


    private void init(){
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        btn = findViewById(R.id.next);
        nextTxt = findViewById(R.id.btnName);
        progress = findViewById(R.id.progress);
        Bundle extras = getIntent().getExtras();
        actionNumber = extras.getInt("actionNumber");
        layout = new RelativeLayout(QuizActivity.this);

        progress.setText("Process " + stage +"/4");
        nextTxt.setText("Next");
        checkCompletion = new CheckCompletion(getApplicationContext());
    }

    public void showPopUp() {

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        final PopupWindow popupWindow = new PopupWindow(QuizActivity.this);

        popupWindow.setContentView(popupView);

        popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
        popupView.findViewById(R.id.final_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                Intent intent = new Intent(QuizActivity.this, TaskListActivity.class);
                startActivity(intent);
            }
        });
    }
}
