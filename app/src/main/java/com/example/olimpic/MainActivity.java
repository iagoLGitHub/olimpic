package com.example.olimpic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olimpic.controller.CompetitionCreate;
import com.example.olimpic.controller.CompetitionList;
import com.example.olimpic.controller.Competitor_add;
import com.example.olimpic.controller.ResumeCompetition;
import com.example.olimpic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=activityMainBinding.getRoot();
        setContentView(view);

        activityMainBinding.btnBBoyadd.setOnClickListener(this);
        activityMainBinding.btnBBoylist.setOnClickListener(this);
        activityMainBinding.btnCreateCompetition.setOnClickListener(this);
        activityMainBinding.btnResumeCompetition.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        if(view.getId()==activityMainBinding.btnBBoyadd.getId()){
            i=new Intent(this, Competitor_add.class);
            startActivity(i);
        }else if(view.getId()==activityMainBinding.btnBBoylist.getId()){
            i=new Intent(this, CompetitionList.class);
            startActivity(i);
        }else if(view.getId()==activityMainBinding.btnCreateCompetition.getId()){
            i=new Intent(this, CompetitionCreate.class);
            startActivity(i);
        }else if(view.getId()==activityMainBinding.btnResumeCompetition.getId()){
            i=new Intent(this, ResumeCompetition.class);
            startActivity(i);
        }
    }
}