package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.olimpic.R;
import com.example.olimpic.adapter.AdapterJudge;
import com.example.olimpic.databinding.ActivityCompetitionCreateBinding;
import com.example.olimpic.databinding.ActivityResumeCompetitionBinding;
import com.example.olimpic.fragment.CategoryFragment;
import com.example.olimpic.model.Category;
import com.example.olimpic.model.Judge;
import com.example.olimpic.model.JudgeItem;
import com.example.olimpic.model.PlaceEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResumeCompetition extends AppCompatActivity implements View.OnClickListener{

    List<JudgeItem> listJudges;
    ActivityResumeCompetitionBinding binding;

    ArrayAdapter<JudgeItem> adapter;


    PlaceEvent placeEvent;
    List<Category> categories=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResumeCompetitionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCreate.setOnClickListener(this);
        binding.btnCancel.setOnClickListener(this);
        listJudges = new ArrayList<>();
        categories = new ArrayList<>();
        placeEvent=new PlaceEvent();
        Intent i=getIntent();
        listJudges =i.getParcelableArrayListExtra("listJudges");
        if(listJudges !=null){
            System.out.println("no es nulo");
            for(Parcelable a:listJudges){
                System.out.println(a);
            }
        }
        placeEvent = i.getParcelableExtra("placeEvent");
        categories= (List<Category>) i.getSerializableExtra("listCategories");

        controlTextViewCategory();

        String place= String.valueOf(placeEvent.getPlace().getPlace());
        String address=String.valueOf(placeEvent.getAddress());
        binding.resumePlace.setText(place);
        binding.resumeAddress.setText(address);

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listJudges);
        binding.listJudgesResume.setAdapter(adapter);
    }


    private void controlTextViewCategory() {
        String text="";

        if (categories.contains(Category.ONEVSONEMAN)) {
            text+="1Vs1Masculino\n";
            binding.textViewCategories.setText(text);
        }

        if(categories.contains(Category.ONEVSONEWOMAN)){
            text+="1Vs1Femenino\n";
            binding.textViewCategories.setText(text);
        }

        if(categories.contains(Category.TWOVSTWO)){
            text+="2vs2\n";
            binding.textViewCategories.setText(text);
        }

        if(categories.contains(Category.FIVEVSFIVE)) {
            text+="5Vs5";
            binding.textViewCategories.setText(text);

        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==binding.btnCreate.getId()){
            /**
             * Save in bbdd
             */
        }else if(view.getId()==binding.btnCancel.getId()){
            onBackPressed();
        }
    }
}