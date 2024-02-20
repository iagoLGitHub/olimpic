package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityCompetitionCreateBinding;
import com.example.olimpic.fragment.JudgesFragment;
import com.example.olimpic.fragment.PlaceFragment;

public class CompetitionCreate extends AppCompatActivity implements View.OnClickListener{

    ActivityCompetitionCreateBinding binding;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    JudgesFragment judgesFragment;
    PlaceFragment placeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCompetitionCreateBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.judgesBtn.setOnClickListener(this);
        binding.placeBtn.setOnClickListener(this);
        judgesFragment=new JudgesFragment();
        placeFragment=new PlaceFragment();


        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, judgesFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==binding.judgesBtn.getId()){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,judgesFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();

        }else if(view.getId()==binding.placeBtn.getId()){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,placeFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }
}