package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityCompetitionCreateBinding;
import com.example.olimpic.databinding.ActivityGeneralOptionsBinding;

public class generalOptions extends AppCompatActivity {

    ActivityGeneralOptionsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGeneralOptionsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}