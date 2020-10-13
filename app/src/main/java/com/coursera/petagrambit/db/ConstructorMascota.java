package com.coursera.petagrambit.db;

import android.content.ContentValues;
import android.content.Context;

import com.coursera.petagrambit.Mascota;
import com.coursera.petagrambit.R;

import java.util.ArrayList;

public class ConstructorMascota {

    private Context context;
    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro, Boolean.FALSE.toString(), "PEPE", 1 ));
        mascotas.add(new Mascota(R.drawable.caracol, Boolean.TRUE.toString(), "MARLO", 3 ));
        mascotas.add(new Mascota(R.drawable.gato, Boolean.FALSE.toString(), "THEODORO", 9 ));
        mascotas.add(new Mascota(R.drawable.leon, Boolean.TRUE.toString(), "AXE", 7 ));
        mascotas.add(new Mascota(R.drawable.abeja, Boolean.FALSE.toString(), "PIU", 5 ));
        return mascotas;
         */

        BaseDatos db = new BaseDatos(context);
        insertarContacto(db);
        return db.obtenerMascotas();
    }

    public void insertarContacto(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put( ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.perro);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_ISFAV , 1);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "PEPE");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKES , 5);
        db.insertarMascota(contentValues);

        ContentValues contentValuesDos = new ContentValues();
        contentValuesDos.put( ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.caracol);
        contentValuesDos.put(ConstantesBD.TABLE_MASCOTAS_ISFAV , 1);
        contentValuesDos.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "MARLO");
        contentValuesDos.put(ConstantesBD.TABLE_MASCOTAS_LIKES ,2);
        db.insertarMascota(contentValuesDos);


        ContentValues contentValuesTres = new ContentValues();
        contentValuesTres.put( ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.gato);
        contentValuesTres.put(ConstantesBD.TABLE_MASCOTAS_ISFAV , 0);
        contentValuesTres.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "THEDORO");
        contentValuesTres.put(ConstantesBD.TABLE_MASCOTAS_LIKES , 8);
        db.insertarMascota(contentValuesTres);

        ContentValues contentValuesCuatro = new ContentValues();
        contentValuesCuatro.put( ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.leon);
        contentValuesCuatro.put(ConstantesBD.TABLE_MASCOTAS_ISFAV , 1);
        contentValuesCuatro.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "ACE");
        contentValuesCuatro.put(ConstantesBD.TABLE_MASCOTAS_LIKES , 6);
        db.insertarMascota(contentValuesCuatro);

        ContentValues contentValuesCinco = new ContentValues();
        contentValuesCinco.put( ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.abeja);
        contentValuesCinco.put(ConstantesBD.TABLE_MASCOTAS_ISFAV , 0);
        contentValuesCinco.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "PIU");
        contentValuesCinco.put(ConstantesBD.TABLE_MASCOTAS_LIKES , 1);
        db.insertarMascota(contentValuesCinco);
    }

}
