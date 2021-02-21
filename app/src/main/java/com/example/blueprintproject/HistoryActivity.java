package com.example.blueprintproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class HistoryActivity extends AppCompatActivity {
    ArrayList<String> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        historyList = (ArrayList<String>) getIntent().getSerializableExtra("history");
        buildRecyclerView();

        TextView funFact = findViewById(R.id.textView9);
        String[] funFacts = {"1 pound of beef requires anywhere between 2000 and 8,000 gallons of water.", "Heating 1 gallon of water produces, on average, 0.18 lbs of CO2.", "Bring your own water bottle where you can to save plastic!", "Try switching out meat for a plant-based meal to decrease your emissions!", "Turn off lights and unplug technology when it isn't in use!", "Challenge yourself to cut down your food waste!", "Plant something new this week!", "Try to walk or bike instead of using a car whenever you can!"};
        Random rand = new Random();
        int position = rand.nextInt(funFacts.length);
        funFact.setText(funFacts[position]);

        Button button = findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startBack();
            }
        });
    }

    public void startBack() {
        Intent homeActivityIntent = new Intent(this, MainActivity.class);
        this.startActivity(homeActivityIntent);
    }

    private void buildRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycle2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        HistoryAdapter historyAdapter = new HistoryAdapter(historyList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(historyAdapter);
    }

}