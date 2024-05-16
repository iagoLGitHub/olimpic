package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olimpic.R;
import com.example.olimpic.adapter.AdapterCompetitor;
import com.example.olimpic.adapter.AdapterJudge;
import com.example.olimpic.adapter.AdapterSimpleJudge;
import com.example.olimpic.databinding.ActivityCompetitorListBinding;
import com.example.olimpic.databinding.ActivityJudgeListBinding;
import com.example.olimpic.model.Competitor;
import com.example.olimpic.model.Judge;
import com.example.olimpic.model.JudgeItem;

import java.util.ArrayList;
import java.util.List;

public class JudgeList extends AppCompatActivity implements View.OnClickListener,AdapterSimpleJudge.OnItemClickListener,AdapterSimpleJudge.OnItemLongClickListener{

    ActivityJudgeListBinding binding;
    List<Judge> judgeList;
    AdapterSimpleJudge adapterJudge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityJudgeListBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        judgeList=new ArrayList<>();
        Judge judge1 = new Judge(1, "nombrejuez1", "apellidojuez1", "Pérez", "18598021Z", "AKaJuez1");
        Judge judge2 = new Judge(2, "Marta", "apellidoJuez1", "apellido2juez2m", "18598021Z", "akajuez2");
        Judge judge3 = new Judge(3, "Luis", "apellidoJuez3", ",apellidojuez32", "18598021Z", "akajuez3");

        judgeList.add(judge1);
        judgeList.add(judge2);
        judgeList.add(judge3);
        adapterJudge=new AdapterSimpleJudge(judgeList,this,this);
        binding.listJudge.setLayoutManager(new LinearLayoutManager(this));
        binding.listJudge.setAdapter(adapterJudge);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(Judge judge) {
        Intent i=new Intent(this,JudgeAdd.class);
        i.putExtra("judge",judge);
        startActivity(i);

    }

    @Override
    public void onItemLongClick(Judge judge) {

    }
}