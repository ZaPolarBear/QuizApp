package com.example.quizzapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapp.adapters.ActionItemAdapter;
import com.example.quizzapp.data.Action;
import com.example.quizzapp.data.CheckCompletion;
import com.example.quizzapp.data.GetSharedPref;
import com.example.quizzapp.data.SetSharedPref;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends Activity {
    private List<Action> actionList = new ArrayList<>();
    private ActionItemAdapter actionItemAdapter;
    private RecyclerView recyclerView;

    SharedPreferences preferences;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasklist);

        init();



    }

    private void init(){
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        recyclerView = findViewById(R.id.actionList);

        boolean saveStatus = preferences.getBoolean("save", false);

        if (saveStatus){
            GetSharedPref getSharedPref = new GetSharedPref(getApplicationContext());
            actionList = getSharedPref.execute();
        }
        else {
            for (int i = 0; i < 4; i++){
                Action action = new Action("Action" + i, "Do task", false, 0);
                actionList.add(action);
            }
            SetSharedPref setSharedPref = new SetSharedPref(getApplicationContext(), actionList);
            setSharedPref.execute();
        }

        actionItemAdapter = new ActionItemAdapter(actionList, getApplicationContext());

        recyclerView.setAdapter(actionItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

}
