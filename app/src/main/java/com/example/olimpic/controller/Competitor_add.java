package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityCompetitorAddBinding;
import com.example.olimpic.model.Competitor;

import java.util.Arrays;
import java.util.List;

public class Competitor_add extends AppCompatActivity implements View.OnClickListener{

    ActivityCompetitorAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitor_add);
        binding=ActivityCompetitorAddBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        List<String> categorias= Arrays.asList("Infantil","Avanzado");

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,categorias);
        binding.spinner.setAdapter(adapter);
        binding.addBtn.setOnClickListener(this);
        binding.cancelBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==binding.addBtn.getId()){
            if(createCompetitor()){
                System.out.println(true);
            }

            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }else if(view.getId()==binding.cancelBtn.getId()){
            finish();
        }
    }

    /**
     * Crea Competidor, queda implementar bbdd
     * @return
     */
    private boolean createCompetitor(){

        if(controlEditText()){
            Competitor newCompetitor=
                    new Competitor(1,binding.editName.getText().toString(),
                                   binding.editLastName.getText().toString(),
                                   binding.editLastName2.getText().toString(),
                                   binding.editAka.getText().toString(),
                                   (String) binding.spinner.getSelectedItem());

            return true;
        }

       return false;
    }

    private Boolean controlEditText(){
        if((binding.editName.getText().toString().isEmpty())||
            binding.editAka.getText().toString().isEmpty()||
            binding.editAka.getText().toString().isEmpty()){
            showErrorDialog();
            return false;

        }else{
            return true;
        }
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title="Error";
        String message="Es necesario que cubras todos los campos";
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}