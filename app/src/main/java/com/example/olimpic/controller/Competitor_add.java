package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityCompetitorAddBinding;
import java.util.Arrays;
import java.util.List;

public class Competitor_add extends AppCompatActivity {

    ActivityCompetitorAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitor_add);
        binding=ActivityCompetitorAddBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        List<String> categorias= Arrays.asList("Infantil","Avanzado");

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,categorias);
        binding.spinner.setAdapter(adapter);

    }
}