package com.example.olimpic.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.example.olimpic.adapter.AdapterJudge;
import com.example.olimpic.databinding.FragmentJudgesBinding;
import com.example.olimpic.model.Judge;
import com.example.olimpic.model.JudgeItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JudgesFragment extends Fragment implements AdapterJudge.OnItemClickListener, AdapterJudge.SendData {

    FragmentJudgesBinding fragmentJudgesBinding;
    private JudgesFragmentListener listener;

    AdapterJudge adapterJudge;
    private List<JudgeItem> listJudges;
    private byte numJudges = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args=getArguments();
        listJudges=new ArrayList<>();
        if(args!=null){
            listJudges=args.getParcelableArrayList("listJudges");
        }

        adapterJudge = new AdapterJudge(listJudges, this, this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentJudgesBinding = FragmentJudgesBinding.inflate(inflater, container, false);
        View rootView = fragmentJudgesBinding.getRoot();
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        fragmentJudgesBinding.judgesList.setLayoutManager(layoutManager);
        fragmentJudgesBinding.judgesList.setAdapter(adapterJudge);


        return rootView;
    }


    @Override
    public void sendInfo(byte valor) {
        numJudges = valor;
        fragmentJudgesBinding.numJudgesSelectText.setText(String.valueOf(numJudges));
    }

    @Override
    public void sendList(List<JudgeItem> judges) {
        listJudges = judges;

    }

    @Override
    public void onItemClick(Judge judge) {

        adapterJudge.notifyDataSetChanged();
        adapterJudge.countCheckedItems();



    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("se activa onstart");

    }
    public interface JudgesFragmentListener {
        void onJudgesListReceived(List<JudgeItem> judges);
    }
    @Override
    public void onStop() {
        super.onStop();
        this.listJudges = adapterJudge.judgeList();

    }

}
