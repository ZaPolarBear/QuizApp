package com.example.quizzapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class CheckCompletion {

    private Context context;

    public CheckCompletion(Context context){
        this.context = context;
    }

    public boolean execute(){
        int completedTasks = 0;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        for (int i = 0; i < 4; i++){
            boolean actionStatus = preferences.getBoolean("completeStatus" + i, false);

            if (actionStatus){
                completedTasks++;
            }

        }

        return completedTasks == 4;
    }
}
