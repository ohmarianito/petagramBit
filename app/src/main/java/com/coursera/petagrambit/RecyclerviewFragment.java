package com.coursera.petagrambit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewFragment  extends Fragment {


    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclearview, container, false);


        listaDeMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);

        listaDeMascotas.setLayoutManager(llm);

        cargarDatosIniciales();
        inicializarAdaptador();
        return v;
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
