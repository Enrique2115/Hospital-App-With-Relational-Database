package com.reymi.ucvsesion7trabajos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.reymi.ucvsesion7trabajos.R;
import com.reymi.ucvsesion7trabajos.sqlite.ControladorDAO;

import java.util.ArrayList;

public class RegAgenda extends AppCompatActivity {

    Spinner spPacientes, spMedicos;
    private ControladorDAO controladorDAO;
    ArrayList<String> listaPacientes;
    ArrayList<String> listaMedicos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_agenda);

        spPacientes = findViewById(R.id.spPaciente);
        spMedicos = findViewById(R.id.spMedico);

        controladorDAO = new ControladorDAO(this);
        controladorDAO.open();

        listaPacientes = controladorDAO.llenarComboPacientes();
        listaMedicos = controladorDAO.llenarComboMedicos();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPacientes);
        ArrayAdapter<CharSequence> adaptador2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMedicos);

        spPacientes.setAdapter(adaptador);
        spMedicos.setAdapter(adaptador2);

    }
}