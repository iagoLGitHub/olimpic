package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olimpic.R;
import com.example.olimpic.adapter.AdapterCompetitor;
import com.example.olimpic.databinding.ActivityCompetitionListBinding;
import com.example.olimpic.databinding.ActivityCompetitorAddBinding;
import com.example.olimpic.model.Competitor;

import java.util.ArrayList;
import java.util.List;

public class CompetitionList extends AppCompatActivity implements View.OnClickListener,AdapterCompetitor.OnItemClickListener,AdapterCompetitor.OnItemLongClickListener {

    ActivityCompetitionListBinding binding;
    List<Competitor> competitors=new ArrayList<>();
    AdapterCompetitor adapterCompetitor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_list);
        binding=ActivityCompetitionListBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);



        binding.addCompetitor.setOnClickListener(this);
        adapterCompetitor=new AdapterCompetitor(competitors,this,this);
        binding.listCompetitor.setLayoutManager(new LinearLayoutManager(this));
        binding.listCompetitor.setAdapter(adapterCompetitor);
        String totalCompetitor= String.valueOf(competitors.size());
        binding.totalCompetitorText.setText(totalCompetitor);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        if(view.getId()==binding.addCompetitor.getId()){
            i=new Intent(this,Competitor_add.class);
            startActivity(i);
        }
    }

    @Override
    public void onItemClick(Competitor competitor) {

    }

    @Override
    public void onItemLongClick(Competitor competitor) {

    }
}