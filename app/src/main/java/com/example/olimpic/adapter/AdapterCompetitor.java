package com.example.olimpic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.olimpic.R;
import com.example.olimpic.model.Competitor;

import java.util.List;

public class AdapterCompetitor extends RecyclerView.Adapter<CompetitorViewHolder> {
    private List<Competitor> competitors;
    private OnItemClickListener listener;
    private OnItemLongClickListener longClickListener;

    public AdapterCompetitor(List<Competitor> competitors, OnItemClickListener listener, OnItemLongClickListener longClickListener) {
        this.competitors = competitors;
        this.listener = listener;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public CompetitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.competitor_item,parent,false);
        return new CompetitorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitorViewHolder holder, int position) {
        final Competitor competitor=competitors.get(position);
        String nameAka=competitor.getAka();
        holder.textView.setText(nameAka);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    listener.onItemClick(competitor);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (longClickListener != null) {
                    longClickListener.onItemLongClick(competitor);
                    return true;
                }
                return false;
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(Competitor competitor);
    }
    public interface OnItemLongClickListener {
        void onItemLongClick(Competitor competitor);
    }
    @Override
    public int getItemCount() {
        return competitors.size();
    }
}
