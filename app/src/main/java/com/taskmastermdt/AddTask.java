package com.taskmastermdt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class AddTask extends AppCompatActivity {

ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        backBtn();
        snackbarMessage();
    }

    public void backBtn(){
        Button goToMainActivityPageFromAddTaskPage = AddTask.this.findViewById(R.id.AddTaskBtnBack);
        goToMainActivityPageFromAddTaskPage.setOnClickListener(view -> {
            Intent goToMainActivityPageActivity = new Intent(AddTask.this, MainActivity.class);
            startActivity(goToMainActivityPageActivity);
        });
    }

    public void snackbarMessage(){
        constraintLayout = findViewById(R.id.constraintLayout);
       Button displaySuccessMessageAfterAddTaskSubmit = AddTask.this.findViewById(R.id.AddTaskBtnAddTask);
       displaySuccessMessageAfterAddTaskSubmit.setOnClickListener(view -> {
           Snackbar snackbar = Snackbar.make(constraintLayout, "Submitted!", Snackbar.LENGTH_SHORT);
           snackbar.show();
       });
    }
}