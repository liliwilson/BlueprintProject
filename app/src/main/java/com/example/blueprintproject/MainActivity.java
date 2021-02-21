package com.example.blueprintproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // use recycler view! Wahoo
        RecyclerView recyclerView = findViewById(R.id.recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ClimateQuestionAdapter climateQuestionAdapter = new ClimateQuestionAdapter(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(climateQuestionAdapter);
    }

    // Hi it's Ria :)
    //hey this is Zara
    // hey its lili!
    //Hey it's Frances!
}