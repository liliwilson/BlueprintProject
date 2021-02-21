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
        String[] funFacts = {"It takes ~999 gallons of water to make a pair of jeans.", "1 pound of beef requires anywhere between 2000 and 8,000 gallons of water.", "Heating 1 gallon of water produces, on average, 0.18 lbs of CO2"};
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