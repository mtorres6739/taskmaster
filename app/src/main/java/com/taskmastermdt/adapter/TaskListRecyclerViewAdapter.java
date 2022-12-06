package com.taskmastermdt.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taskmastermdt.R;
import com.taskmastermdt.activities.MainActivity;
import com.taskmastermdt.activities.TaskDetail;
import com.taskmastermdt.models.TaskList;

import java.util.List;

public class TaskListRecyclerViewAdapter extends RecyclerView.Adapter<TaskListRecyclerViewAdapter.TaskListViewHolder> {
    List<TaskList> taskListList;
    Context callingActivity;

    public TaskListRecyclerViewAdapter(List<TaskList> taskListList, Context callingActivity) {
        this.taskListList = taskListList;
        this.callingActivity = callingActivity;
    }

    @NonNull
    @Override
    public TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskListFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task_list, parent, false);
        return new TaskListViewHolder(taskListFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListViewHolder holder, int position) {
        TextView taskListFragmentTextViewName = holder.itemView.findViewById(R.id.TaskListTextViewTaskName);
        String taskListName = taskListList.get(position).getName();
        taskListFragmentTextViewName.setText((position + 1) + ". " + taskListName);

        TextView taskListFragmentTextViewBody = holder.itemView.findViewById(R.id.TaskListTextViewTaskBody);
        String taskListBody = taskListList.get(position).getBody();
        taskListFragmentTextViewBody.setText(taskListBody);

        TextView taskListFragmentTextViewState = holder.itemView.findViewById(R.id.TaskListTextViewTaskState);
        String taskListState = taskListList.get(position).getState();
        taskListFragmentTextViewState.setText(taskListState);

        View taskListItemView = holder.itemView;
        taskListItemView.setOnClickListener(view -> {
            Intent goToTaskDetailIntent = new Intent(callingActivity, TaskDetail.class);
            goToTaskDetailIntent.putExtra(MainActivity.TASKMASTER_TASK_NAME_TAG, taskListName);
            goToTaskDetailIntent.putExtra(MainActivity.TASKMASTER_TASK_BODY_TAG, taskListBody);
            callingActivity.startActivity(goToTaskDetailIntent);

        });

    }

    @Override
    public int getItemCount() {
        return taskListList.size();
    }

    public static class  TaskListViewHolder extends RecyclerView.ViewHolder{
        public TaskListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
