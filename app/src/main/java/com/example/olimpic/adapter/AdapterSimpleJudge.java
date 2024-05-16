package com.example.olimpic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.olimpic.R;
import com.example.olimpic.model.Judge;

import java.util.List;

public class AdapterSimpleJudge extends RecyclerView.Adapter<JudgeViewSimpleHolder> {
    private List<Judge> judgeList;
    private AdapterSimpleJudge.OnItemClickListener listener;
    private AdapterSimpleJudge.OnItemLongClickListener longClickListener;

    public AdapterSimpleJudge(List<Judge> judgeList,
                              AdapterSimpleJudge.OnItemClickListener listener,
                              AdapterSimpleJudge.OnItemLongClickListener longClickListener) {
        this.judgeList = judgeList;
        this.listener = listener;
        this.longClickListener = longClickListener;
    }


    @NonNull
    @Override
    public JudgeViewSimpleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.competitor_item,parent,false);
        return new JudgeViewSimpleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JudgeViewSimpleHolder holder, int position) {
        final Judge judge=judgeList.get(position);
        String nameAka=judge.getAka();
        holder.textView.setText(nameAka);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    listener.onItemClick(judge);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (longClickListener != null) {
                    longClickListener.onItemLongClick(judge);
                    return true;
                }
                return false;
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(Judge judge);
    }
    public interface OnItemLongClickListener {
        void onItemLongClick(Judge judge);
    }
    @Override
    public int getItemCount() {
        return judgeList.size();
    }
}
