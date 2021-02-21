package com.example.blueprintproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText answerText1 = findViewById(R.id.answer1);
        EditText answerText2 = findViewById(R.id.answer2);
        EditText answerText3 = findViewById(R.id.answer3);
        EditText answerText4 = findViewById(R.id.answer4);
        Button button = findViewById(R.id.submitButton);

        TextView testText = findViewById(R.id.textViewTest);

        File directory = this.getFilesDir(); // for later

        List<String> answers = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
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

                    float transit = (float)Math.round((float) (number1 * 0.96)* 100) / 100;
                    float bottles = (float)Math.round((float) (number2 * .182)* 100) / 100;
                    float laundry = (float)Math.round((float) (number3 * 0.45)* 100) / 100;
                    float shower = (float)Math.round((float) (number4 * 1.95)* 100) / 100;
                    float total = (float)Math.round(transit + bottles + laundry + shower);

                    testText.setText("You emitted " + transit + " pounds of CO2 from transit, " + bottles + " pounds of CO2 from plastic bottles " + laundry + " pounds of CO2 from laundry, and " + shower + " pounds from showering!"
                    + "\n" + "That's a total of " + total + " pounds for the week.");

                    // save a json
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("Answer1", number1);
                    jsonObject.put("Answer2", number2);
                    jsonObject.put("Answer3", number3);
                    jsonObject.put("Answer4", number4);

                    // get date
                    Date date = Calendar.getInstance().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd hh_mm_ss");
                    String filename = dateFormat.format(date) + ".json";

                    // save file
                    String userString = jsonObject.toString();
                    File file = new File(directory,filename);
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(userString);
                    bufferedWriter.close();

                } catch (NumberFormatException | JSONException | IOException e) {
                    testText.setText("Double check - it looks like you didn't enter a number somewhere!");
                }
            }
        });

    }

}

    // Hi it's Ria :)
    //hey this is Zara
    // hey its lili!