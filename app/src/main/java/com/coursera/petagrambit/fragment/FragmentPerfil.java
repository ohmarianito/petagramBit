package com.coursera.petagrambit.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.petagrambit.Mascota;
import adapter.MascotaAdaptador;
import com.coursera.petagrambit.R;

import java.util.ArrayList;


public class FragmentPerfil extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeMascotas;

    public FragmentPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaDeMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);

        GridLayoutManager llm = new GridLayoutManager(getContext(), 3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeMascotas.setLayoutManager(llm);

        cargarDatosIniciales();
        inicializarAdaptador();
        return v;
    }

    private  void cargarDatosIniciales(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro, Boolean.FALSE.toString(), "NONE", 1 ));
        mascotas.add(new Mascota(R.drawable.perro, Boolean.TRUE.toString(), "NONE", 3 ));
        mascotas.add(new Mascota(R.drawable.perro, Boolean.FALSE.toString(), "NONE", 9 ));
        mascotas.add(new Mascota(R.drawable.perro, Boolean.TRUE.toString(), "NONE", 7 ));
        mascotas.add(new Mascota(R.drawable.perro, Boolean.FALSE.toString(), "NONE", 5 ));
    }

    private void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaDeMascotas.setAdapter(adaptador);
    }
}