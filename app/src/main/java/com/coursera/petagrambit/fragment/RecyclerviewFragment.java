package com.coursera.petagrambit.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.petagrambit.Mascota;
import adapter.MascotaAdaptador;
import com.coursera.petagrambit.R;
import com.coursera.petagrambit.presentador.IRecyclerViewPresenterFragment;
import com.coursera.petagrambit.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerviewFragment  extends Fragment implements IRecyclerViewViewFragment{


    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeMascotas;
    private IRecyclerViewPresenterFragment presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclearview, container, false);
        listaDeMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    /*
    private  void cargarDatosIniciales(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro, Boolean.FALSE.toString(), "PEPE", 1 ));
        mascotas.add(new Mascota(R.drawable.caracol, Boolean.TRUE.toString(), "MARLO", 3 ));
        mascotas.add(new Mascota(R.drawable.gato, Boolean.FALSE.toString(), "THEODORO", 9 ));
        mascotas.add(new Mascota(R.drawable.leon, Boolean.TRUE.toString(), "AXE", 7 ));
        mascotas.add(new Mascota(R.drawable.abeja, Boolean.FALSE.toString(), "PIU", 5 ));
    }
*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaDeMascotas.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayoutManager() {

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaDeMascotas.setAdapter(adaptador);
    }


}
