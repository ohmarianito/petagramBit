package com.coursera.petagrambit.presentador;

import android.content.Context;

import com.coursera.petagrambit.Mascota;
import com.coursera.petagrambit.db.ConstructorMascota;
import com.coursera.petagrambit.fragment.IRecyclerViewViewFragment;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewPresenterFragment {

    private IRecyclerViewViewFragment iRecyclerViewViewFragment;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> listaMascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewViewFragment iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewViewFragment = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        ConstructorMascota constructorMascota = new ConstructorMascota(context);
        listaMascotas = constructorMascota.obtenerDatos();
        mostraMascotasRV();
    }

    @Override
    public void mostraMascotasRV() {
        iRecyclerViewViewFragment.inicializarAdaptadorRV(iRecyclerViewViewFragment.crearAdaptador(listaMascotas));
        iRecyclerViewViewFragment.generarLinearLayoutVertical();
    }
}
