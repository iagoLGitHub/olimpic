package com.example.olimpic.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityJudgeAddBinding;
import com.example.olimpic.model.Competitor;
import com.example.olimpic.model.Judge;

import java.util.ArrayList;

public class JudgeAdd extends AppCompatActivity implements View.OnClickListener {

    ActivityJudgeAddBinding binding;
    private Intent i;
    private Judge judge;

    boolean isEdit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJudgeAddBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        i = getIntent();
        judge=i.getParcelableExtra("judge");


        if (getIntentFromActivity(judge)) {
            System.out.println("judge no es nulo");
            editOn();
            isEdit=false;
        } else {
            editOff();
            System.out.println("judge es nulo");
        }
        binding.addBtn.setOnClickListener(this);
        binding.cancelBtn.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId() == R.id.menuEditar) {
            editOn();
            isEdit=true;
            item.setVisible(false);
            invalidateOptionsMenu();

        }
        if(item.getItemId()==R.id.menuDelete){
            showAlertDeleteDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        System.out.println("pasa por aqui");
       getMenuInflater().inflate(R.menu.menu_edit, menu);
        MenuItem itemEdit = menu.findItem(R.id.menuEditar);
        MenuItem itemDelete=menu.findItem(R.id.menuDelete);
        if (judge == null) {
            itemEdit.setVisible(false);
            itemDelete.setVisible(false);
        } else {
            if (isEdit) {
                itemEdit.setVisible(false); // Si está en modo edición, oculta el ítem de editar
                itemDelete.setVisible(false); // También oculta el ítem de eliminar
            } else {
                itemEdit.setVisible(true); // Si no está en modo edición, muestra el ítem de editar
                itemDelete.setVisible(true); // También muestra el ítem de eliminar
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }
    private boolean getIntentFromActivity(Judge judge) {
        boolean valor = true;
        if (judge != null) {
            binding.editName.setText(judge.getName());
            binding.editDni.setText(judge.getDni());
            binding.editLastName.setText(judge.getLastName1());
            binding.editLastName2.setText(judge.getLastName2());
            binding.editAka.setText(judge.getAka());
            binding.addBtn.setVisibility(View.INVISIBLE);
            valor = false;
            return valor;

        } else {
            return valor;
        }

    }

    private void editOn(){
        binding.editName.setEnabled(true);
        binding.editDni.setEnabled(true);
        binding.editLastName.setEnabled(true);
        binding.editLastName2.setEnabled(true);
        binding.editAka.setEnabled(true);
        binding.addBtn.setVisibility(View.VISIBLE);

    }

    private void editOff(){
        binding.editName.setEnabled(false);
        binding.editDni.setEnabled(false);
        binding.editLastName.setEnabled(false);
        binding.editLastName2.setEnabled(false);
        binding.editAka.setEnabled(false);

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == binding.addBtn.getId()) {

            if(createJudge()) {
                editOff();
                Toast.makeText(this, "Juez Guardado", Toast.LENGTH_SHORT).show();

            }


        } else if (view.getId() == binding.cancelBtn.getId()) {
            onBackPressed();
        }
    }

    private Boolean controlEditText() {

        if ((binding.editName.getText().toString().isEmpty()) ||
                binding.editName.getText().toString().isEmpty() ||
                binding.editLastName.getText().toString().isEmpty() ||
                binding.editLastName2.getText().toString().isEmpty() ||
                binding.editDni.getText().toString().isEmpty() ||
                binding.editAka.getText().toString().isEmpty()) {
            showErrorDialog();
            return false;

        } else if (!dniControl()) {
            showErrorDni();
            return false;
        } else {
            return true;
        }
    }
    private boolean controlIdNull(){
        Integer comp =null;
        boolean isNull=true;
        try{
            comp=judge.getIdJudge();
            isNull=false;
            return isNull;
        }catch(Exception e){

        }
        return true;
    }

    private void showAlertDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title = "Atención";
        String message = "¿Estas seguro que quieres borrar el Juez?";
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        /**
                         * Borrado de Juez con id
                         */
                        dialog.dismiss();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title = "Error";
        String message = "Es necesario que cubras todos los campos";
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
    private boolean createJudge() {

        if (controlEditText()) {
            Judge newJudge =
                    new Judge(binding.editName.getText().toString(),
                            binding.editLastName.getText().toString(),
                            binding.editLastName2.getText().toString(),
                            binding.editDni.getText().toString(),
                            binding.editAka.getText().toString());

            if (controlIdNull()) {
                System.out.println("nuevo juez creado");
                //Aqui guardado de new Judge

                onBackPressed();
            } else {
                if (judge.equals(newJudge)) {
                    binding.addBtn.setVisibility(View.INVISIBLE);
                    isEdit=false;

                    invalidateOptionsMenu();
                    editOff();
                    //aqui no hace nada
                    return false;
                } else {
                    binding.addBtn.setVisibility(View.INVISIBLE);
                    isEdit=false;
                    invalidateOptionsMenu();
                    // aqui guardado de juez editado
                    System.out.println("no es igual,y lo guarda");
                    editOff();
                    return true;
                }
            }

        } else {
            return false;
        }
        return false;
    }

    private void showErrorDni() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title = "Error";
        String message = "Dni incorrecto";
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

    private boolean dniControl() {
        try {
            int dni = Integer.parseInt(binding.editDni.getText().toString().substring(0, binding.editDni.getText().toString().length() - 1));
            char letter = binding.editDni.getText().toString().toUpperCase().charAt(binding.editDni.getText().toString().length() - 1);
            System.out.println(dni);
            System.out.println(letter);
            return controlLetter(dni, letter);
        } catch (Exception e) {
            showErrorDni();
        }
        return false;
    }

    private boolean controlLetter(int dni, char letra) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int index = dni % 23;
        char letraCalculada = letters.charAt(index);
        return letra == letraCalculada;
    }
}