package com.example.blueprintproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ArrayList<String> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        historyList = (ArrayList<String>) getIntent().getSerializableExtra("history");
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycle2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        HistoryAdapter historyAdapter = new HistoryAdapter(historyList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(historyAdapter);
    }

}