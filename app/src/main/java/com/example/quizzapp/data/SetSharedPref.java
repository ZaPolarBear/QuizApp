package com.example.quizzapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.List;

public class SetSharedPref {
    private Context context;
    private List<Action> actionList ;

    public SetSharedPref(Context context, List<Action> actionList){
        this.context = context;
        this.actionList = actionList;
    }

    public void execute() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putBoolean("save", true).commit();
        for (int i = 0; i < 4; i++) {
            preferences.edit().putString("actionName" + i, actionList.get(i).getActionName()).commit();
            preferences.edit().putString("task" + i, actionList.get(i).getTask()).commit();
            preferences.edit().putInt("completeCount" + i, actionList.get(i).getCompleted()).commit();
            preferences.edit().putBoolean("completeStatus" + i, actionList.get(i).isComplete()).commit();
        }
    }

}
