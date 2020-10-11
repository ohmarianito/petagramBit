package com.coursera.petagrambit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitifavoritos);
        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        listaDeMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llm);
        cargarDatosIniciales();
        inicializarAdaptador();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private  void cargarDatosIniciales(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro, Boolean.FALSE.toString(), "PEPE", 1 ));
        mascotas.add(new Mascota(R.drawable.caracol, Boolean.TRUE.toString(), "MARLO", 3 ));
        mascotas.add(new Mascota(R.drawable.gato, Boolean.FALSE.toString(), "THEODORO", 9 ));
        mascotas.add(new Mascota(R.drawable.leon, Boolean.TRUE.toString(), "AXE", 7 ));
        mascotas.add(new Mascota(R.drawable.abeja, Boolean.FALSE.toString(), "PIU", 5 ));
    }

    private void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaDeMascotas.setAdapter(adaptador);
    }
}