package com.example.olimpic.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.olimpic.R;
import com.example.olimpic.databinding.ActivityCompetitorAddBinding;
import com.example.olimpic.model.Category;
import com.example.olimpic.model.Competitor;
import com.example.olimpic.model.Judge;

import java.util.Arrays;
import java.util.List;

public class Competitor_add extends AppCompatActivity implements View.OnClickListener {

    ActivityCompetitorAddBinding binding;
    Intent i;
    Competitor competitor;
    List<String> categorias;
    ArrayAdapter<String> adapter;
    boolean isEdit=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitor_add);
        binding = ActivityCompetitorAddBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        categorias = Arrays.asList("Infantil", "Avanzado");

        adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, categorias);
        binding.spinner.setAdapter(adapter);
        i = getIntent();
        competitor = i.getParcelableExtra("competitor");

        if (getIntentFromActivity(competitor)) {
            editOn();
            System.out.println("Competidor es nulo");
        }else{
            System.out.println("competidor no es nulo");
            editOff();
        }

        binding.addBtn.setOnClickListener(this);
        binding.cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.addBtn.getId()) {
            if (createCompetitor()) {
                editOff();
                Toast.makeText(this, "Competidor guardado", Toast.LENGTH_SHORT).show();
                }

        } else if (view.getId() == binding.cancelBtn.getId()) {
            finish();
        }

    }

    private boolean getIntentFromActivity(Competitor competitor) {
        boolean valor = true;
        int categoryNum = 0;
        if (competitor != null) {
            binding.editName.setText(competitor.getName());
            binding.editDni.setText(competitor.getDni());
            binding.editLastName.setText(competitor.getLastName1());
            binding.editLastName2.setText(competitor.getLastName2());
            binding.editAka.setText(competitor.getAka());
            String category = competitor.getCategory();
            if (category.equals("Avanzado")) {
                categoryNum = 1;
            }else{
                categoryNum=0;
            }
            binding.spinner.setSelection(categoryNum);
            binding.addBtn.setVisibility(View.INVISIBLE);

            valor = false;
            return valor;

        } else {
            return valor;
        }


    }

    private void editOn() {
        binding.editName.setEnabled(true);
        binding.editDni.setEnabled(true);
        binding.editLastName.setEnabled(true);
        binding.editLastName2.setEnabled(true);
        binding.editAka.setEnabled(true);
        binding.spinner.setEnabled(true);
        binding.addBtn.setVisibility(View.VISIBLE);

    }

    private void editOff() {
        binding.editName.setEnabled(false);
        binding.editDni.setEnabled(false);
        binding.editLastName.setEnabled(false);
        binding.editLastName2.setEnabled(false);
        binding.editAka.setEnabled(false);
        binding.spinner.setEnabled(false);

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
        if (competitor == null) {
            itemEdit.setVisible(false);
            itemDelete.setVisible(false);
        } else {
            if (isEdit) {
                itemEdit.setVisible(false);
                itemDelete.setVisible(false);
            } else {
                itemEdit.setVisible(true);
                itemDelete.setVisible(true);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }
    /**
     * Si Competitor no tiene id, crea el competidor, si tiene Id lo edita queda implementar bbdd
     *
     * @return boolean
     */
    private boolean createCompetitor() {

        if (controlEditText()&&competitor!=null) {
            Competitor newCompetitor =
                    new Competitor(binding.editName.getText().toString(),
                            binding.editDni.getText().toString(),
                            binding.editLastName.getText().toString(),
                            binding.editLastName2.getText().toString(),
                            binding.editAka.getText().toString(),
                            (String) binding.spinner.getSelectedItem());
            if (controlIdNull()) {
                System.out.println("nuevo competidor creado");
                //Aqui guardado de newCompetitor
                onBackPressed();
            } else {
                if (competitor.equals(newCompetitor)) {
                    binding.addBtn.setVisibility(View.INVISIBLE);
                    //aqui no hace nada
                    isEdit=false;
                    invalidateOptionsMenu();
                    editOff();
                    return false;
                } else {
                    binding.addBtn.setVisibility(View.INVISIBLE);
                    isEdit=false;
                    invalidateOptionsMenu();
                    // aqui guardado de competidor editado
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
    private void showAlertDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title = "Atención";
        String message = "¿Estas seguro que quieres borrar el competidor?";
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        /**
                         * Borrado de competidor con id
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
    private boolean controlIdNull(){
        Integer comp =null;
        boolean isNull=true;
        try{
            comp=competitor.getIdCompetitor();
            isNull=false;
            return isNull;
        }catch(Exception e){

        }
        return true;
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