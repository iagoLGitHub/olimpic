package com.example.olimpic.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;

import com.example.olimpic.model.JudgeItem;

import java.util.List;

public class AdapterResumeList extends BaseAdapter {

    List<JudgeItem>listJudges;
    private Context context;

    private int resourceLayout;


    public AdapterResumeList(Context context,List<JudgeItem> listJudges) {

        this.context = context;
        this.listJudges = listJudges;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
