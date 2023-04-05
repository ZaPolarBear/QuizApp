package com.example.quizzapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapp.MainActivity;
import com.example.quizzapp.QuizActivity;
import com.example.quizzapp.R;
import com.example.quizzapp.TaskListActivity;
import com.example.quizzapp.data.Action;

import java.util.List;

public class ActionItemAdapter extends RecyclerView.Adapter<ActionItemAdapter.ActionHolder> {

    private List<Action> actionList;

    private Context context;

    public ActionItemAdapter(List<Action> actionList, Context context){
        this.actionList = actionList;
        this.context = context;
    }
    @NonNull
    @Override
    public ActionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ActionHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.actionitem,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ActionHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskListActivity activity = (TaskListActivity) view.getContext();
                Intent intent = new Intent(activity, QuizActivity.class);
                intent.putExtra("actionNumber", holder.getAdapterPosition());
                view.getContext().startActivity(intent);
            }
        });

        if (actionList.get(holder.getAdapterPosition()).isComplete()){
            holder.status.setBackground(ContextCompat.getDrawable(context, R.drawable.rectangle));
        }
    }

    @Override
    public int getItemCount() {
        return actionList.size();
    }

    protected static class ActionHolder extends RecyclerView.ViewHolder {

        TextView action, task;
        View status;
        ImageView actionImage;

        public ActionHolder(@NonNull View itemView) {
            super(itemView);
            action = itemView.findViewById(R.id.action);
            task = itemView.findViewById(R.id.task);
            status = itemView.findViewById(R.id.checkbox);
            actionImage = itemView.findViewById(R.id.action_image);
        }
    }
}
