package com.example.olimpic.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.olimpic.R;

public class CompetitorViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    public CompetitorViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.textViewCompetitor);
    }
}
