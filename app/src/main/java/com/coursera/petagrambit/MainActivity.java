package com.coursera.petagrambit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listaDeMascotas.setLayoutManager(llm);

        cargarDatosIniciales();
        inicializarAdaptador();

        ImageButton myButton = (ImageButton) findViewById(R.id.btnFav);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);
            }
        });

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

    public void irAFavs (View v){
        Intent intent = new Intent(this, Favoritos.class);
        startActivity(intent);
    }


}