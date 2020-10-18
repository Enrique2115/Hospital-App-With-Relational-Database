package com.reymi.ucvsesion7trabajos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reymi.ucvsesion7trabajos.R;
import com.reymi.ucvsesion7trabajos.entidades.Medico;
import com.reymi.ucvsesion7trabajos.entidades.Paciente;
import com.reymi.ucvsesion7trabajos.sqlite.ControladorDAO;

import java.util.ArrayList;

public class RegPaciente extends AppCompatActivity {

    EditText inputNombrePa, inputApellidoPa, inputCorreoPa, inputTelefonoPa, inputDireccionPa;
    Button btnRegistrarPaciente, btnListar;

    private ControladorDAO controladorDAO;
    ArrayList<Paciente> lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_paciente);

        inputNombrePa = findViewById(R.id.inputNombrePa);
        inputApellidoPa = findViewById(R.id.inputApellidoPa);
        inputCorreoPa = findViewById(R.id.inputCorreoPa);
        inputTelefonoPa = findViewById(R.id.inputTelefonoPa);
        inputDireccionPa = findViewById(R.id.inputDireccionPa);
        btnRegistrarPaciente = findViewById(R.id.btnRegistrarPaciente);
        btnListar = findViewById(R.id.btnlistarPa);

        controladorDAO = new ControladorDAO(this);
        controladorDAO.open();

        btnRegistrarPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = inputNombrePa.getText().toString();
                String apellido = inputApellidoPa.getText().toString();
                String correo = inputCorreoPa.getText().toString();
                String telefono = inputTelefonoPa.getText().toString();
                String direccion = inputDireccionPa.getText().toString();

                long i = 0;
                i = controladorDAO.insertPaciente(nombre, apellido, correo, direccion, telefono);
                if (i == 0) {
                    Toast.makeText(getApplicationContext(), "No se realizo el registro", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Se realizo el registro del paciente", Toast.LENGTH_SHORT).show();
                    inputNombrePa.setText("");
                    inputApellidoPa.setText("");
                    inputCorreoPa.setText("");
                    inputTelefonoPa.setText("");
                    inputDireccionPa.setText("");
                }
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder acum= new StringBuilder();
                try{
                    lista = controladorDAO.listarPacientes();
                    for (Paciente obj:lista){
                        acum.append(obj.getNombre()).append("\n");
                    }
                    Toast.makeText(getApplicationContext(), acum.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    //Log.d("Error", String.valueOf(e.getCause()));
                }
            }
        });
    }
}