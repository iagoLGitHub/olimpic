package com.example.olimpic.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.olimpic.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JudgesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JudgesFragment extends Fragment {

    public JudgesFragment() {

    }

    public static JudgesFragment newInstance(String param1, String param2) {
        JudgesFragment fragment = new JudgesFragment();
         return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_judges, container, false);
    }
}