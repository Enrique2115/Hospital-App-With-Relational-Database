package com.reymi.ucvsesion7trabajos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.reymi.ucvsesion7trabajos.sqlite.ControladorDAO;
import com.reymi.ucvsesion7trabajos.ui.ListaCitas;
import com.reymi.ucvsesion7trabajos.ui.RegAgenda;
import com.reymi.ucvsesion7trabajos.ui.RegMedico;
import com.reymi.ucvsesion7trabajos.ui.RegPaciente;

public class MainActivity extends AppCompatActivity {

    Button btnRegMedico, btnRegPaciente, btnAgendarCita, btnListarCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegMedico = findViewById(R.id.btnRegMedico);
        btnRegPaciente = findViewById(R.id.btnRegPaciente);
        btnAgendarCita = findViewById(R.id.btnRegCita);
        btnListarCitas = findViewById(R.id.btnListCita);

        btnRegMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegMedico.class));
            }
        });

        btnRegPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegPaciente.class));
            }
        });

        btnAgendarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegAgenda.class));
            }
        });

        btnListarCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListaCitas.class));
            }
        });
    }
}