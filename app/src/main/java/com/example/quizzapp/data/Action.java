package com.example.quizzapp.data;

public class Action {
    private String ActionName = "Action1";
    private String Task = "do Task";
    private boolean Complete = false;
    private int Completed = 0;

    public Action(String actionName, String task, boolean complete, int completed){
        this.ActionName = actionName;
        this.Task = task;
        this.Complete = complete;
        this.Completed = completed;
    }

    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String actionName) {
        ActionName = actionName;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public boolean isComplete() {
        return Complete;
    }

    public void setComplete(boolean complete) {
        Complete = complete;
    }

    public int getCompleted() {
        return Completed;
    }

    public void setCompleted(int completed) {
        Completed = completed;
    }
}
