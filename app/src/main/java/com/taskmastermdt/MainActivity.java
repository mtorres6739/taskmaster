package com.taskmastermdt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TASKMASTER_TASK_NAME_TAG = "taskmasterTask";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTaskBtn();
        allTasksBtn();
        settingsScreen();
    }

    @Override
    protected void onResume(){
        super.onResume();
        setupGreeting();
        setupTaskButtons();
    }

    public void setupGreeting(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString(Settings.USERNAME_TAG, "No Username");
        ((TextView)findViewById(R.id.MainActivityTextViewUsernameTasks)).setText(username + "'s Tasks");
    }


    public void setupTaskButtons(){
        Button takeMedicationBtn = findViewById(R.id.MainActivityBtnTaskTakeMedication);
        Button takeOutTrashBtn = findViewById(R.id.MainActivityBtnTaskTakeOutTrash);
        Button updateCalendarBtn = findViewById(R.id.MainActivityBtnTaskUpdateCalendar);

        Intent goToTaskDetailPageIntent = new Intent(MainActivity.this, TaskDetail.class);

        takeMedicationBtn.setOnClickListener(view -> {
            goToTaskDetailPageIntent.putExtra(TASKMASTER_TASK_NAME_TAG, takeMedicationBtn.getText().toString());
            startActivity(goToTaskDetailPageIntent);
        });

        takeOutTrashBtn.setOnClickListener(view -> {
            goToTaskDetailPageIntent.putExtra(TASKMASTER_TASK_NAME_TAG, takeOutTrashBtn.getText().toString());
            startActivity(goToTaskDetailPageIntent);
        });

        updateCalendarBtn.setOnClickListener(view -> {
            goToTaskDetailPageIntent.putExtra(TASKMASTER_TASK_NAME_TAG, updateCalendarBtn.getText().toString());
            startActivity(goToTaskDetailPageIntent);
        });
    }

    public void addTaskBtn(){
//      1. Get UI element by id
        Button goToAddTaskPageBtn = MainActivity.this.findViewById(R.id.MainActivityBtnAddTask);
//      setting up routing logic with intents. Intents are the highway between activities
//      2. Add an event listener
        goToAddTaskPageBtn.setOnClickListener(view -> {
//      3. Set up the intent (Current context.this, class to go to Class.class)
            Intent goToAddTaskPageActivity = new Intent(MainActivity.this, AddTask.class);
//      4. Launch the Intent
            startActivity(goToAddTaskPageActivity);
        });
    }

    public void allTasksBtn(){
        Button goToAllTasksPageBtn = MainActivity.this.findViewById(R.id.MainActivityBtnAllTasks);
        goToAllTasksPageBtn.setOnClickListener(view -> {
            Intent goToAllTasksPageActivity = new Intent(MainActivity.this, AllTasks.class);
            startActivity(goToAllTasksPageActivity);
        });
    }

    public void settingsScreen(){
        ImageView settingsScreenLink = MainActivity.this.findViewById(R.id.MainActivityImgBtnSettings);
        settingsScreenLink.setOnClickListener(view -> {
            Intent goToSettingsScreen = new Intent(MainActivity.this, Settings.class);
            startActivity(goToSettingsScreen);
        });
    }


}