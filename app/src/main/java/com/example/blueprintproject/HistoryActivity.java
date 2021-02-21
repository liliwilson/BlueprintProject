package com.example.blueprintproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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
        String[] funFacts = {"It takes ~999 gallons of water to make a pair of jeans.", "1 pound of beef requires anywhere between 2000 and 8,000 gallons of water.", "blah.", "LOOK!!!!!"};
        Random rand = new Random();
        int position = rand.nextInt(funFacts.length);
        funFact.setText(funFacts[position]);
    }

    private void buildRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycle2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        HistoryAdapter historyAdapter = new HistoryAdapter(historyList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(historyAdapter);
    }

}