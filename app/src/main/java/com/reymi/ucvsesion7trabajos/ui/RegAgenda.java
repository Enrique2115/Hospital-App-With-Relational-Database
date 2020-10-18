package com.reymi.ucvsesion7trabajos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.reymi.ucvsesion7trabajos.R;
import com.reymi.ucvsesion7trabajos.entidades.Medico;
import com.reymi.ucvsesion7trabajos.entidades.Paciente;
import com.reymi.ucvsesion7trabajos.sqlite.ControladorDAO;

import java.util.ArrayList;

public class RegAgenda extends AppCompatActivity {

    Spinner spPacientes, spMedicos;
    Button btnRegAgendaCita;
    EditText inputConsulta, inputPrecio;

    private ControladorDAO controladorDAO;
    ArrayList<String> listaPacientes;
    ArrayList<String> listaMedicos;

    ArrayList<Medico> medicosList = null;
    ArrayList<Paciente> pacientesList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_agenda);

        spPacientes = findViewById(R.id.spPaciente);
        spMedicos = findViewById(R.id.spMedico);
        inputConsulta = findViewById(R.id.inputConsulta);
        inputPrecio = findViewById(R.id.inputPrecio);
        btnRegAgendaCita = findViewById(R.id.btnAgendarCita);

        controladorDAO = new ControladorDAO(this);
        controladorDAO.open();

        medicosList = controladorDAO.listarMedicos();
        pacientesList = controladorDAO.listarPacientes();

        listaPacientes = controladorDAO.llenarComboPacientes();
        listaMedicos = controladorDAO.llenarComboMedicos();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPacientes);
        ArrayAdapter<CharSequence> adaptador2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMedicos);

        spPacientes.setAdapter(adaptador);
        spMedicos.setAdapter(adaptador2);

        btnRegAgendaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consulta = inputConsulta.getText().toString();
                int precio = Integer.parseInt(inputPrecio.getText().toString());
                int idPacientes = (int) (spPacientes.getSelectedItemId() + 1);
                int idMedicos = (int) (spMedicos.getSelectedItemId() + 1);

                long i = 0;
                i = controladorDAO.insertCita(consulta, precio, idMedicos, idPacientes);
                if (i == 0) {
                    Toast.makeText(getApplicationContext(), "No se realizo el registro", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Se realizo el registro de la agenda", Toast.LENGTH_SHORT).show();
                    inputConsulta.setText("");
                    inputPrecio.setText("");
                }
                //Toast.makeText(getApplicationContext(), "" + idPacientes, Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "" + idMedicos, Toast.LENGTH_SHORT).show();
            }
        });

    }
}