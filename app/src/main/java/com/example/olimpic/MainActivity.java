package com.example.olimpic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olimpic.controller.Competitor_add;
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

    }

    @Override
    public void onClick(View view) {
        Intent i;

        if(view.getId()==activityMainBinding.btnBBoyadd.getId()){
            i=new Intent(this, Competitor_add.class);
            startActivity(i);
        }
    }
}