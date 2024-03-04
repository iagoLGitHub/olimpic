package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityCompetitionCreateBinding;
import com.example.olimpic.fragment.JudgesFragment;
import com.example.olimpic.fragment.PlaceFragment;
import com.example.olimpic.model.Judge;
import com.example.olimpic.model.JudgeItem;

import java.util.ArrayList;
import java.util.List;

public class CompetitionCreate extends AppCompatActivity implements View.OnClickListener,JudgesFragment.JudgesFragmentListener{

    ActivityCompetitionCreateBinding binding;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    JudgesFragment judgesFragment;
    PlaceFragment placeFragment;
    private List<JudgeItem> listJudges;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("create activity");
        super.onCreate(savedInstanceState);
        binding=ActivityCompetitionCreateBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.judgesBtn.setOnClickListener(this);
        binding.placeBtn.setOnClickListener(this);
        judgesFragment=new JudgesFragment();
        placeFragment=new PlaceFragment();

        if (listJudges == null || listJudges.isEmpty()) {
            listJudges = new ArrayList<>();
            Judge judge1 = new Judge(1, "iago", "leirós", "Pérez", "32623154a", "yeaghGo");
            Judge judge2 = new Judge(2, "Marta", "nombreJuez2", "apellidoJuez2,apellido2juez2m", "45253125G", "akajuez2");
            Judge judge3 = new Judge(3, "Luis", "nombreJuez3", "apellidoJuez3,apellido2juez3m", "45s253125Y", "akajuez3");

            JudgeItem judgeItem1 = new JudgeItem(judge1, false);
            JudgeItem judgeItem2 = new JudgeItem(judge2, false);
            JudgeItem judgeItem3 = new JudgeItem(judge3, false);
            listJudges.add(judgeItem1);
            listJudges.add(judgeItem2);
            listJudges.add(judgeItem3);

        }
        Bundle bundle=new Bundle();
        bundle.putParcelableArrayList("listJudges", (ArrayList<? extends Parcelable>) listJudges);
        judgesFragment.setArguments(bundle);
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
            for(JudgeItem a:listJudges){
                System.out.println(a.getJudge().getAka());
                System.out.println(a.isChecked());
            }
        }
    }



    @Override
    public void onJudgesListReceived(List<JudgeItem> judges) {

    }

}