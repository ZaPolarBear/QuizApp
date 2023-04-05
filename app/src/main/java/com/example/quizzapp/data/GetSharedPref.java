package com.example.quizzapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class GetSharedPref {
    private Context context;
    private List<Action> actionList = new ArrayList<>();

    public GetSharedPref(Context context){
        this.context = context;
    }

    public List<Action> execute() {

        String actionName, task;
        int completeCount;
        boolean completeStatus;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        for (int i = 0; i < 4; i++) {

            actionName = preferences.getString("actionName" + i, "fake");
            task = preferences.getString("task" + i, "null");
            completeCount = preferences.getInt("completeCount" + i, 1);
            completeStatus = preferences.getBoolean("completeStatus" + i, false);

            Action action = new Action(actionName, task, completeStatus, completeCount);
            actionList.add(action);
        }

        return actionList;
    }
}
