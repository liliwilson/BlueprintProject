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

                    testText.setText("You emitted " + 0.96 * number1 + " pounds of CO2 from transit, " + 1.95 * number3 + " pounds of CO2 from laundry, and " + .45*number4 + " pounds from showering!");
                } catch (NumberFormatException e) {
                    testText.setText("You didn't enter a number - try again and resubmit!");
                }
            }
        });

    }

}

    // Hi it's Ria :)
    //hey this is Zara
    // hey its lili!