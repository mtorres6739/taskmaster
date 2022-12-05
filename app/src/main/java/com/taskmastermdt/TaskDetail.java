package com.taskmastermdt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        receiveSetupTaskButtonValues();
        backBtn();
    }

    public void receiveSetupTaskButtonValues(){
        Intent callingIntent = getIntent();
        String taskName = null;
        if (callingIntent != null){
            taskName = callingIntent.getStringExtra(MainActivity.TASKMASTER_TASK_NAME_TAG);
        }
        TextView textViewTaskName = findViewById(R.id.TaskDetailTextViewTaskName);
        if (taskName != null) {
            textViewTaskName.setText(taskName);
        } else {
            textViewTaskName.setText("No Task Listed");
        }
    }


    public void backBtn(){
        Button goToMainActivityPageFromTaskDetailPage = TaskDetail.this.findViewById(R.id.TaskDetailBtnBack);
        goToMainActivityPageFromTaskDetailPage.setOnClickListener(view -> {
            Intent goToMainActivityPageActivity = new Intent(TaskDetail.this, MainActivity.class);
            startActivity(goToMainActivityPageActivity);
        });
    }
}