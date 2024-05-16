package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olimpic.databinding.ActivityGeneralOptionsBinding;

public class GeneralOptions extends AppCompatActivity implements View.OnClickListener {

    ActivityGeneralOptionsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGeneralOptionsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initBtn();
    }

    private void initBtn(){
        binding.addJudgesBtn.setOnClickListener(this);
        binding.listJudgesBtn.setOnClickListener(this);
        binding.competitorList.setOnClickListener(this);
        binding.addCompetitorBtn.setOnClickListener(this);
        binding.addCompetitionBtn.setOnClickListener(this);
        binding.listCompetitionBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        if(view.getId()== binding.addJudgesBtn.getId()){
            i=new Intent(this, JudgeAdd.class);
            startActivity(i);

        } else if (view.getId()==binding.listJudgesBtn.getId()) {
            i=new Intent(this, JudgeList.class);
            startActivity(i);

        }else if(view.getId()==binding.addCompetitorBtn.getId()){
            i=new Intent(this, Competitor_add.class);
            startActivity(i);

        }else if(view.getId()==binding.competitorList.getId()){
            i=new Intent(this, CompetitorList.class);
            startActivity(i);

        }else if(view.getId()==binding.addCompetitionBtn.getId()){
            i=new Intent(this, CompetitionCreate.class);
            startActivity(i);

        }else if(view.getId()==binding.listCompetitionBtn.getId()){
            //intent hacia list competition
        }

    }
}