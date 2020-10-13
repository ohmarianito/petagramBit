package com.coursera.petagrambit.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.coursera.petagrambit.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATA_BASE_NAME, null, ConstantesBD.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTAS + "(" +
                ConstantesBD.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_MASCOTAS_FOTO + " INTEGER, " +
                ConstantesBD.TABLE_MASCOTAS_ISFAV + " INTEGER, " +
                ConstantesBD.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBD.TABLE_MASCOTAS_LIKES + " INTEGER" + ")";
        sqLiteDatabase.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST" + ConstantesBD.TABLE_MASCOTAS);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBD.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaAcutal = new Mascota();
            mascotaAcutal.setId(registros.getInt(0));
            mascotaAcutal.setUrlImage(registros.getInt(1));
            mascotaAcutal.setFav(String.valueOf(registros.getInt(2)));
            mascotaAcutal.setNombre(registros.getString(3));
            mascotaAcutal.setLikes(registros.getInt(4));

            mascotas.add(mascotaAcutal);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

}
