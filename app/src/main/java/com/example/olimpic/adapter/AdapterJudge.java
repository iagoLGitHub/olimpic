package com.example.olimpic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.olimpic.R;
import com.example.olimpic.fragment.JudgesFragment;
import com.example.olimpic.model.Competitor;
import com.example.olimpic.model.Judge;
import com.example.olimpic.model.JudgeItem;

import java.util.List;

public class AdapterJudge extends RecyclerView.Adapter<JudgeViewHolder> {


    private List<JudgeItem> judges;
    private OnItemClickListener listener;

    private SendData sendData;


    public AdapterJudge(List<JudgeItem> judges) {
        this.judges = judges;
    }

    public AdapterJudge(List<JudgeItem> judges, OnItemClickListener onItemClickListener, SendData sendData) {
        this.judges = judges;
        this.listener = onItemClickListener;
        this.sendData = sendData;

    }

    @NonNull
    @Override
    public JudgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_judge, parent, false);

        return new JudgeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JudgeViewHolder holder, int position) {
        final JudgeItem judgeItem = judges.get(position);
        String nameAka = judgeItem.getJudge().getAka();
        Boolean isChecked=judgeItem.isChecked();
        holder.textView.setText(nameAka);

        if(isChecked){
            holder.checkBox.setChecked(true);
        }else{
            holder.checkBox.setChecked(false);
        }

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.checkBox.isChecked()){
                    judges.get(position).setChecked(true);
                    sendData.sendInfo(countCheckedItems());
                    sendData.sendList(judges);

                }else{
                    judges.get(position).setChecked(false);
                    sendData.sendInfo(countCheckedItems());
                    sendData.sendList(judges);

                }

            }

        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(judgeItem.getJudge());
                    boolean isChecked = holder.checkBox.isChecked();
                    holder.checkBox.setChecked(!isChecked);
                    judges.get(position).setChecked(!isChecked);
                    sendData.sendInfo(countCheckedItems());
                    sendData.sendList(judges);

                }

            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(Judge judge);

    }

    public interface SendData {

        void sendInfo(byte valor);
        void sendList(List<JudgeItem>judges);
    }



    public byte countCheckedItems() {
        byte count = 0;
        for (JudgeItem judgeItem : judges) {
            if (judgeItem.isChecked()) {
                count++;
            }

        }

        return count;
    }

    @Override
    public int getItemCount() {
        return judges.size();
    }
}
