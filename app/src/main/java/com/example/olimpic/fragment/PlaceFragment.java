package com.example.olimpic.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.olimpic.databinding.FragmentPlaceBinding;
import com.example.olimpic.model.Place;
import com.example.olimpic.model.PlaceEvent;

import java.util.ArrayList;
import java.util.List;

public class PlaceFragment extends Fragment implements AdapterView.OnItemSelectedListener{


    private FragmentPlaceBinding binding;
    private List<Place>placesList;
    private ArrayAdapter adapter;
    private Place place;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = requireActivity();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        placesList=new ArrayList<>();

        placesList.add(new Place(1,"lugar1"));
        placesList.add(new Place(2,"lugar2"));
        placesList.add(new Place(3,"lugar3"));
        placesList.add(new Place(4,"lugar4"));
        placesList.add(new Place(5,"lugar5"));

        adapter=new ArrayAdapter<>(requireContext(),android.R.layout.simple_spinner_item,placesList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentPlaceBinding.inflate(inflater,container,false);
        View rootView=binding.getRoot();
        binding.placeSpinner.setAdapter(adapter);
        binding.placeSpinner.setOnItemSelectedListener(this);

        return rootView;
    }

    public PlaceEvent getPlaceEvent() {
        String address="";
        PlaceEvent placeEvent = null;
        address= String.valueOf(binding.editTextAddress.getText());
        if(!address.isEmpty()){
            placeEvent=new PlaceEvent(place,address);
            return placeEvent;
        }

        return placeEvent;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        place= (Place) adapterView.getSelectedItem();
        System.out.println(place.getIdPlace());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}