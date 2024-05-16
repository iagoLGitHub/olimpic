package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olimpic.R;
import com.example.olimpic.adapter.AdapterCompetitor;
import com.example.olimpic.databinding.ActivityCompetitorListBinding;
import com.example.olimpic.model.Competitor;

import java.util.ArrayList;
import java.util.List;

public class CompetitorList extends AppCompatActivity implements View.OnClickListener,AdapterCompetitor.OnItemClickListener,AdapterCompetitor.OnItemLongClickListener {

    ActivityCompetitorListBinding binding;
    List<Competitor> competitors=new ArrayList<>();
    AdapterCompetitor adapterCompetitor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCompetitorListBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);



        Competitor competitor1=new Competitor(1,"nombreCompetidor1","apellido1Competidor1",
                "apellido2Competidor1","92793575Y","akanombre1","Avanzado");
        Competitor competitor2=new Competitor(2,"nombreCompetidor2","apellido1Competidor2","03805771F",
                "apellido2Competidor2","akanombre2","avanzado");
        Competitor competitor3=new Competitor(3,"nombreCompetidor3","apellido1Competidor3",
                "apellido2Competidor3","09258046V","akanombre3","Avanzado");
        Competitor competitor4=new Competitor(4,"nombreCompetidor4","apellido1Competidor4",
                "apellido2Competidor4","18598021Z","akanombre4","Avanzado");
        Competitor competitor5=new Competitor(5,"nombreCompetidor5","apellido1Competidor5",
                "apellido2Competidor5","07601466N","akanombre5","Infantil");
        competitors.add(competitor1);
        competitors.add(competitor2);
        competitors.add(competitor3);
        competitors.add(competitor4);
        competitors.add(competitor5);


        adapterCompetitor=new AdapterCompetitor(competitors,this,this);
        binding.listCompetitor.setLayoutManager(new LinearLayoutManager(this));
        binding.listCompetitor.setAdapter(adapterCompetitor);

    }

    @Override
    public void onClick(View view) {



    }

    @Override
    public void onItemClick(Competitor competitor) {
        Intent i=new Intent(this,Competitor_add.class);
        i.putExtra("competitor",competitor);
        startActivity(i);
    }

    @Override
    public void onItemLongClick(Competitor competitor) {

    }
}