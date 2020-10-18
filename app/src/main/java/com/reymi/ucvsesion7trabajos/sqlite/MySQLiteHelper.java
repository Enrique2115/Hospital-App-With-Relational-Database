package com.reymi.ucvsesion7trabajos.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.reymi.ucvsesion7trabajos.utilidades.Utilidades;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(@Nullable Context context) {
        super(context, Utilidades.NOMBREBASEDATOS, null, Utilidades.VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.SQLMedico);
        db.execSQL(Utilidades.SQLPaciente);
        db.execSQL(Utilidades.SQLCita);

        Log.d("tablas", "Creacion correcta de las tablas");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionActual) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaCita);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaPaci);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaMedico);
        onCreate(db);
    }
}
