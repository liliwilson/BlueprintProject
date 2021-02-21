package com.example.blueprintproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
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
                } catch (NumberFormatException e) {
                    testText.setText("Double check - it looks like you didn't enter a number somewhere!");
                }
            }
        });

    }

}

    // Hi it's Ria :)
    //hey this is Zara
    // hey its lili!