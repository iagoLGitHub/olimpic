package com.example.olimpic.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityJudgeAddBinding;

public class JudgeAdd extends AppCompatActivity implements View.OnClickListener{

    ActivityJudgeAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judge_add);
        binding=ActivityJudgeAddBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.addBtn.setOnClickListener(this);
        binding.cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==binding.addBtn.getId()){
            controlEditText();
            //insert new Judge
        }else if(view.getId()==binding.cancelBtn.getId()){
            onBackPressed();
        }
    }

    private Boolean controlEditText(){
        if((binding.editName.getText().toString().isEmpty())||
                binding.editName.getText().toString().isEmpty()||
                binding.editLastName.getText().toString().isEmpty()||
                binding.editLastName2.getText().toString().isEmpty()||
                binding.editDni.getText().toString().isEmpty()||
                binding.editAka.getText().toString().isEmpty()){
            showErrorDialog();
            return false;

        }else if(!dniControl()){
            showErrorDni();
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

    private void showErrorDni() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title="Error";
        String message="Dni incorrecto";
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
    private boolean dniControl(){
        try {
            int dni = Integer.parseInt(binding.editDni.getText().toString().substring(0, binding.editDni.getText().toString().length() - 1));
            char letter = binding.editDni.getText().toString().toUpperCase().charAt(binding.editDni.getText().toString().length() - 1);
            System.out.println(dni);
            System.out.println(letter);
            return controlLetter(dni,letter);
        }catch (Exception e){
            showErrorDni();
        }
        return false;
    }

   private boolean controlLetter(int dni, char letra) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int index= dni % 23;
        char letraCalculada = letters.charAt(index);
        return letra == letraCalculada;
    }
}