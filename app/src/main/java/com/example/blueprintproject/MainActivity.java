package com.example.blueprintproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            loadData();

            EditText answerText1 = findViewById(R.id.answer1);
            EditText answerText2 = findViewById(R.id.answer2);
            EditText answerText3 = findViewById(R.id.answer3);
            EditText answerText4 = findViewById(R.id.answer4);
            Button button = findViewById(R.id.submitButton);
            Button reset = findViewById(R.id.reset);

            TextView testText = findViewById(R.id.textViewTest);

            File directory = this.getFilesDir(); // for later

            List<String> answers = new ArrayList<>();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    answers.add(answerText1.getText().toString());
                    answers.add(answerText2.getText().toString());
                    answers.add(answerText3.getText().toString());
                    answers.add(answerText4.getText().toString());
                    testText.setText(answers.get(0) + answers.get(1) + answers.get(2) + answers.get(3));

                    try {
                        int number1 = Integer.parseInt(answers.get(0));
                        int number2 = Integer.parseInt(answers.get(1));
                        int number3 = Integer.parseInt(answers.get(2));
                        int number4 = Integer.parseInt(answers.get(3));

                        float transit = (float) Math.round((float) (number1 * 0.96) * 100) / 100;
                        float bottles = (float) Math.round((float) (number2 * .182) * 100) / 100;
                        float laundry = (float) Math.round((float) (number3 * 0.45) * 100) / 100;
                        float shower = (float) Math.round((float) (number4 * 1.95) * 100) / 100;
                        float total = (float) Math.round(transit + bottles + laundry + shower);

                        testText.setText("You emitted approximately " + transit + " pounds of CO2 from transit, " + bottles + " pounds of CO2 from plastic bottles, " + laundry + " pounds of CO2 from laundry, and " + shower + " pounds of CO2 from showering!"
                                + "\n" + "That's a total of about " + total + " pounds for the week.");

                        historyList.add(total + " pounds for the week.");
                        saveData();

                    } catch (NumberFormatException e) {
                        testText.setText("Double check - it looks like you didn't enter a number somewhere!");
                    }
                }
            });

            Button historyButton = findViewById(R.id.historyButton);
            historyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startHistory(historyList);
                }
            });

            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    answerText1.setText("");
                    answerText2.setText("");
                    answerText3.setText("");
                    answerText4.setText("");
                    testText.setText("");
                }
            });
        }

    public void startHistory(ArrayList<String> historyList) {
        Intent historyActivityIntent = new Intent(this, HistoryActivity.class);
        historyActivityIntent.putExtra("history", historyList);
        this.startActivity(historyActivityIntent);
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(historyList);
        editor.putString("task list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        historyList = gson.fromJson(json, type);
        if (historyList == null) {
            historyList = new ArrayList<>();
        }
    }


}

    // Hi it's Ria :)
    //hey this is Zara
    // hey its lili!