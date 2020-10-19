package com.reymi.ucvsesion7trabajos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.reymi.ucvsesion7trabajos.R;
import com.reymi.ucvsesion7trabajos.adapters.myAdapter;
import com.reymi.ucvsesion7trabajos.entidades.Cita;
import com.reymi.ucvsesion7trabajos.sqlite.ControladorDAO;

import java.util.ArrayList;

public class ListaCitas extends AppCompatActivity {

    private ControladorDAO controladorDAO;
    RecyclerView citaRecycler;
    ArrayList<Cita> lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_citas);

        citaRecycler = findViewById(R.id.citasRecycler);
        controladorDAO = new ControladorDAO(this);
        controladorDAO.open();

        try {
            lista = controladorDAO.listarCitas();
            citaRecycler.setAdapter(new myAdapter(getApplicationContext(), R.layout.item_citas, lista, new myAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_SHORT).show();
                }
            }));

            citaRecycler.setLayoutManager(new LinearLayoutManager(this));
        } catch (Exception e) {
            //Log.d("Error", String.valueOf(e.getCause()));
        }
    }
}