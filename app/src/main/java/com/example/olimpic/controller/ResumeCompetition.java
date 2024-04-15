package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityCompetitionCreateBinding;
import com.example.olimpic.databinding.ActivityResumeCompetitionBinding;
import com.example.olimpic.fragment.CategoryFragment;
import com.example.olimpic.model.Category;
import com.example.olimpic.model.Judge;
import com.example.olimpic.model.JudgeItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResumeCompetition extends AppCompatActivity implements View.OnClickListener{

    List<JudgeItem> listJudges;
    ActivityResumeCompetitionBinding binding;

    ArrayAdapter<String> adaptador;

    List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResumeCompetitionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCreate.setOnClickListener(this);
        binding.btnCancel.setOnClickListener(this);
        listJudges = new ArrayList<>();
        Judge judge1 = new Judge(1, "nombrejuez1", "apellidojuez1", "Pérez", "32623154a", "AKaJuez1");
        Judge judge2 = new Judge(2, "Marta", "nombreJuez2", "apellidoJuez2,apellido2juez2m", "45253125G", "akajuez2");
        Judge judge3 = new Judge(3, "Luis", "nombreJuez3", "apellidoJuez3,apellido2juez3m", "45s253125Y", "akajuez3");
        Judge judge4 = new Judge(3, "Luis", "nombreJuez3", "apellidoJuez3,apellido2juez3m", "45s253125Y", "akajuez3");
        Judge judge5 = new Judge(3, "Luis", "nombreJuez3", "apellidoJuez3,apellido2juez3m", "45s253125Y", "akajuez3");
        Judge judge6 = new Judge(3, "Luis", "nombreJuez3", "apellidoJuez3,apellido2juez3m", "45s253125Y", "akajuez3");
        Judge judge7 = new Judge(3, "Luis", "nombreJuez3", "apellidoJuez3,apellido2juez3m", "45s253125Y", "akajuez3");

        JudgeItem judgeItem1 = new JudgeItem(judge1, false);
        JudgeItem judgeItem2 = new JudgeItem(judge2, false);
        JudgeItem judgeItem3 = new JudgeItem(judge3, false);
        JudgeItem judgeItem4 = new JudgeItem(judge4, false);
        JudgeItem judgeItem5 = new JudgeItem(judge5, false);
        JudgeItem judgeItem6 = new JudgeItem(judge6, false);
        JudgeItem judgeItem7 = new JudgeItem(judge7, false);

        listJudges.add(judgeItem1);
        listJudges.add(judgeItem2);
        listJudges.add(judgeItem3);
        listJudges.add(judgeItem4);
        listJudges.add(judgeItem5);
        listJudges.add(judgeItem6);
        listJudges.add(judgeItem7);

        categories = new ArrayList<>();
        Category category1 = Category.ONEVSONEMAN;
        Category category2 = Category.ONEVSONEWOMAN;
        Category category3 = Category.TWOVSTWO;
        Category category4 = Category.FIVEVSFIVE;

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        controlTextViewCategory();
        ArrayList<String> datos = obtenerDatos();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);
        binding.listJudgesResume.setAdapter(adaptador);

    }

    private ArrayList<String> obtenerDatos() {
        ArrayList<String> datos = new ArrayList<>();
        Iterator<JudgeItem> iterator = listJudges.listIterator();

        while (iterator.hasNext()) {
            datos.add(iterator.next().getJudge().getAka());
        }
        return datos;
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
            /**
             * back
             */
        }
    }
}