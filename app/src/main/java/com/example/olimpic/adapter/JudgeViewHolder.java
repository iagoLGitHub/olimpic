package com.example.olimpic.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.olimpic.R;

public class JudgeViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    CheckBox checkBox;


    public JudgeViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.itemJudgeAkaText);
        checkBox=itemView.findViewById(R.id.checkJudgeList);

    }
}
