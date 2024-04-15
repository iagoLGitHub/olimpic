package com.example.olimpic.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.olimpic.databinding.FragmentCategoryBinding;
import com.example.olimpic.model.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {

    private List<Category> categoryList;
    FragmentCategoryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();
        return rootView;
    }

    public List<Category> getCategoryList(){
        categoryList=new ArrayList<>();
        if(binding.checkBoxMasculino1vs1.isChecked()){
            categoryList.add(Category.ONEVSONEMAN);
        }
        if(binding.checkBoxFemenino1vs1.isChecked()){
            categoryList.add(Category.ONEVSONEWOMAN);
        }
        if(binding.checkBox2vs2.isChecked()){
            categoryList.add(Category.TWOVSTWO);
        }
        if(binding.checkBox5vs5.isChecked()){
            categoryList.add(Category.FIVEVSFIVE);
        }
        return categoryList;
    }
}