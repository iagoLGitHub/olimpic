package com.example.olimpic.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.olimpic.R;

public class JudgeViewSimpleHolder extends RecyclerView.ViewHolder {
    TextView textView;



    public JudgeViewSimpleHolder(@NonNull View itemView) {
        super(itemView);

        /**Rehuso el textview del item competitor**/
        textView=itemView.findViewById(R.id.textViewCompetitor);

    }
}
