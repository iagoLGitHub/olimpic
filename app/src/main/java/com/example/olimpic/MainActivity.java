package com.example.olimpic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olimpic.controller.GeneralOptions;
import com.example.olimpic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=activityMainBinding.getRoot();
        setContentView(view);
        Intent i=new Intent(this, GeneralOptions.class);
        startActivity(i);
    }
}