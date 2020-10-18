package com.reymi.ucvsesion7trabajos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reymi.ucvsesion7trabajos.R;
import com.reymi.ucvsesion7trabajos.entidades.Medico;
import com.reymi.ucvsesion7trabajos.sqlite.ControladorDAO;

import java.util.ArrayList;

public class RegMedico extends AppCompatActivity {

    EditText inputNombre, inputApellido, inputCorreo, inputTelefono, inputEspecialidad;
    Button btnRegistrar, btnListar;

    private ControladorDAO controladorDAO;
    ArrayList<Medico> lista = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_medico);

        inputNombre = findViewById(R.id.inputNombre);
        inputApellido = findViewById(R.id.inputApellido);
        inputCorreo = findViewById(R.id.inputCorreo);
        inputTelefono = findViewById(R.id.inputTelefono);
        inputEspecialidad = findViewById(R.id.inputEspecialidad);
        btnRegistrar = findViewById(R.id.btnRegistrarMedico);
        btnListar = findViewById(R.id.btnlistar);

        controladorDAO = new ControladorDAO(this);
        controladorDAO.open();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = inputNombre.getText().toString();
                String apellido = inputApellido.getText().toString();
                String correo = inputCorreo.getText().toString();
                String telefono = inputTelefono.getText().toString();
                String especialidad = inputEspecialidad.getText().toString();

                long i = 0;
                i = controladorDAO.insertMedicos(nombre, apellido, especialidad, correo, telefono);
                if (i == 0) {
                    Toast.makeText(getApplicationContext(), "No se realizo el registro", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Se realizo el registro del Medico", Toast.LENGTH_SHORT).show();
                    inputNombre.setText("");
                    inputApellido.setText("");
                    inputCorreo.setText("");
                    inputTelefono.setText("");
                    inputEspecialidad.setText("");
                }
            }
        });


        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder acum= new StringBuilder();
                try{
                    lista = controladorDAO.listarMedicos();
                    for (Medico obj:lista){
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