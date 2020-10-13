package com.coursera.petagrambit.fragment;

import com.coursera.petagrambit.Mascota;

import java.util.ArrayList;

import adapter.MascotaAdaptador;

public interface IRecyclerViewViewFragment {
    public void generarLinearLayoutVertical();

    public void generarGridLayoutManager();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
