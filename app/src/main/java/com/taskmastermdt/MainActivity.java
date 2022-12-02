package com.taskmastermdt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTaskBtn();
        allTasksBtn();
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


}