package com.example.olimpic.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityCompetitionCreateBinding;
import com.example.olimpic.fragment.CategoryFragment;
import com.example.olimpic.fragment.JudgesFragment;
import com.example.olimpic.fragment.PlaceFragment;
import com.example.olimpic.model.Category;
import com.example.olimpic.model.Judge;
import com.example.olimpic.model.JudgeItem;
import com.example.olimpic.model.PlaceEvent;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class CompetitionCreate extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    ActivityCompetitionCreateBinding binding;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    JudgesFragment judgesFragment;
    PlaceFragment placeFragment;
    CategoryFragment categoryFragment;
    private List<JudgeItem> listJudges;
    private PlaceEvent placeEvent;

    private List<Category> categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompetitionCreateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.bottomNavigationView.setOnItemSelectedListener(this);
        judgesFragment = new JudgesFragment();
        placeFragment = new PlaceFragment();
        categoryFragment = new CategoryFragment();

        if (listJudges == null || listJudges.isEmpty()) {
            listJudges = new ArrayList<>();
            Judge judge1 = new Judge(1, "nombrejuez1", "apellidojuez1", "Pérez", "32623154a", "AKaJuez1");
            Judge judge2 = new Judge(2, "Marta", "nombreJuez2", "apellidoJuez2,apellido2juez2m", "45253125G", "akajuez2");
            Judge judge3 = new Judge(3, "Luis", "nombreJuez3", "apellidoJuez3,apellido2juez3m", "45s253125Y", "akajuez3");

            JudgeItem judgeItem1 = new JudgeItem(judge1, false);
            JudgeItem judgeItem2 = new JudgeItem(judge2, false);
            JudgeItem judgeItem3 = new JudgeItem(judge3, false);
            listJudges.add(judgeItem1);
            listJudges.add(judgeItem2);
            listJudges.add(judgeItem3);

        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listJudges", (ArrayList<? extends Parcelable>) listJudges);
        judgesFragment.setArguments(bundle);
        initFragments();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuCrear) {
            if (controlEmpty()) {
                Intent i = new Intent(this, ResumeCompetition.class);
                i.putParcelableArrayListExtra("listJudges", (ArrayList<? extends Parcelable>) listJudges);
                i.putExtra("placeEvent", placeEvent);
                i.putExtra("listCategories",new ArrayList<>(categories));
                startActivity(i);
                return true;

            } else {
                messageError();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    private boolean controlEmpty() {
        boolean correct = false;
        listJudges = judgesFragment.getList();
        placeEvent = placeFragment.getPlaceEvent();
        categories = categoryFragment.getCategoryList();
        if (!listJudges.isEmpty() &&
                (placeEvent != null)&&
                (placeEvent.getPlace()!=null) &&
                !categories.isEmpty()) {

            correct = true;
            return correct;
        }
        return correct;
    }

    private void messageError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Mensaje de error detallado aquí");
        builder.setCancelable(false);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void initFragments(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, placeFragment);
        fragmentTransaction.add(R.id.fragment_container, categoryFragment);
        fragmentTransaction.add(R.id.fragment_container, judgesFragment);
        fragmentTransaction.commit();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,judgesFragment);
        fragmentTransaction.commit();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.navJudges) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, judgesFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
            return true;

        } else if (item.getItemId() == R.id.navPlaces) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, placeFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
            return true;

        } else if (item.getItemId() == R.id.navCategories) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
            return true;
        } else {

            return false;
        }

    }
}