package com.example.blueprintproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClimateQuestionAdapter extends RecyclerView.Adapter<ClimateQuestionAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // list all the things you use in your layout
        public ConstraintLayout layout;
        public TextView question;
        public EditText answer;

        // set all of them equal to the find view by id
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.climate_question_layout);
            question = itemView.findViewById(R.id.textView2);
            answer = itemView.findViewById(R.id.climateInput);
        }
    }

    List<String> climateQuestions = new ArrayList<>();

    // maybe put a constructor here
    public ClimateQuestionAdapter(Context context) {
        // to be fancy make it read from a file
        climateQuestions.add("Hello World.");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.climate_question_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // get data to display onto screen
        holder.question.setText(climateQuestions.get(position));
    }

    // number of items to display in the recycler view
    @Override
    public int getItemCount() {
        return climateQuestions.size();
    }


}
