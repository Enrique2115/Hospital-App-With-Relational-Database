package com.reymi.ucvsesion7trabajos.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.reymi.ucvsesion7trabajos.entidades.*;
import com.reymi.ucvsesion7trabajos.utilidades.Utilidades;

import java.util.ArrayList;

public class ControladorDAO {

    MySQLiteHelper mySQLiteHelper;
    SQLiteDatabase database;

    ContentValues valores = new ContentValues();
    Cursor c;
    long estado = 0;

    ArrayList<Medico> listMedicos;
    ArrayList<Cita> listCitas;
    ArrayList<Paciente> listPacientes;

    public ControladorDAO(Context context) {
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = mySQLiteHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    /**
     * Metodo que permitira el ingreso de Medicos a la base de datos
     *
     * @param nombre   nombre del medico
     * @param apellido apellido del medico
     * @param correo   correo del medico
     * @param telef    telefono del medico
     * @return retorna el estado, si el estado es 0, hubo error en el registro,
     * pero si retorna diferente de 0, el registro es exitoso
     */
    public long insertMedicos(String nombre, String apellido, String especialidad, String correo, String telef) {
        try {
            this.open();

            valores.put(Utilidades.nombreMedi, nombre);
            valores.put(Utilidades.apellidoMedi, apellido);
            valores.put(Utilidades.especialidadMedi, especialidad);
            valores.put(Utilidades.correoMedi, correo);
            valores.put(Utilidades.telefMedi, telef);

            estado = database.insert(Utilidades.tablaMedico, null, valores);
            this.close();

        } catch (Exception e) {
            Log.d("e_insertMEdico", String.valueOf(e.getCause()));
            estado = 0;
        }

        return estado;
    }

    /**
     * Metodo que lista los medicos que hay en la base de datos
     *
     * @return retorna la lista de medicos
     */
    public ArrayList<Medico> listarMedicos() {
        listMedicos = new ArrayList<>();
        try {
            this.open();
            c = database.rawQuery("SELECT * FROM MEDICO", null);
            while (c.moveToNext()) {
                Medico obj = new Medico();
                obj.setIdMedico(c.getInt(0));
                obj.setNombre(c.getString(1));
                obj.setApellido(c.getString(2));
                obj.setEspecialidad(c.getString(3));
                obj.setCorreo(c.getString(4));
                obj.setTelefono(c.getString(5));
                listMedicos.add(obj);
            }
            c.close();
            this.close();
        } catch (Exception e) {
            Log.d("e_listadoMedico", String.valueOf(e.getCause()));
        }

        return listMedicos;
    }


    /**
     * Metodo para registrar un paciente
     *
     * @param nombre    nombre del paciente
     * @param apellido  apellido del paciente
     * @param correo    correo del paciente
     * @param direccion direccion del paciente
     * @param telef     telefono del paciente
     * @return retorna el estado, si el estado es 0, hubo error en el registro,
     * * pero si retorna diferente de 0, el registro es exitoso
     */
    public long insertPaciente(String nombre, String apellido, String correo, String direccion, String telef) {
        try {
            this.open();

            valores.put(Utilidades.nombrePaci, nombre);
            valores.put(Utilidades.apellidoPaci, apellido);
            valores.put(Utilidades.correoPaci, correo);
            valores.put(Utilidades.direccionPaci, direccion);
            valores.put(Utilidades.telefPaci, telef);

            estado = database.insert(Utilidades.tablaPaci, null, valores);
            this.close();

        } catch (Exception e) {
            Log.d("e_insertPaciente", String.valueOf(e.getCause()));
            estado = 0;
        }
        return estado;
    }

    /**
     * Metodo que lista los pacientes que hay en la base de datos
     *
     * @return retorna la lista de pacientes
     */
    public ArrayList<Paciente> listarPacientes() {
        listPacientes = new ArrayList<>();
        try {
            this.open();
            c = database.rawQuery("SELECT * FROM PACIENTE", null);
            while (c.moveToNext()) {
                Paciente obj = new Paciente();
                obj.setIdPaciente(c.getInt(0));
                obj.setNombre(c.getString(1));
                obj.setApellido(c.getString(2));
                obj.setCorreo(c.getString(3));
                obj.setDireccion(c.getString(4));
                obj.setTelefono(c.getString(5));
                listPacientes.add(obj);
            }
            c.close();
            this.close();
        } catch (Exception e) {
            Log.d("e_listadoPaciente", String.valueOf(e.getCause()));
        }

        return listPacientes;
    }
}
