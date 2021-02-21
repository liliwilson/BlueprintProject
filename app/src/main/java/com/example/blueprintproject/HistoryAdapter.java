package com.example.blueprintproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // list all the things you use in your layout
        public ConstraintLayout layout;
        public TextView answers;
        public TextView total;

        // set all of them equal to the find view by id
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.historylayout);
            answers = itemView.findViewById(R.id.answers);
        }
    }

    private ArrayList<String> historyList;

    public HistoryAdapter(ArrayList<String> history) {
        historyList = history;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // get data to display onto screen
        holder.answers.setText(historyList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }


        /*public HistoryAdapter(Context context) {
            try {
                // try to retreive the jsons
                filenames = context.fileList();

                for (String filename : filenames) {
                    File file = new File(context.getFilesDir(), filename);
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        stringBuilder.append(line).append("\n");
                        line = bufferedReader.readLine();
                    }
                    bufferedReader.close();

                    // json format string
                    String response = stringBuilder.toString();
                    JSONObject jsonObject  = new JSONObject(response);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }*/

}
