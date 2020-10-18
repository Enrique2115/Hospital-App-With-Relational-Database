package com.reymi.ucvsesion7trabajos.utilidades;

public class Utilidades {
    //Constantes de la Base de datos
    public static final String NOMBREBASEDATOS = "BDHospital.db";
    public static final int VERSION = 1;

    //Constantes de la Tabla Medico
    public static final String tablaMedico = "MEDICO";
    public static final String idMedi = "idMedico";
    public static final String nombreMedi = "nombre";
    public static final String apellidoMedi = "apellido";
    public static final String especialidadMedi = "especialidad";
    public static final String correoMedi = "correo";
    public static final String telefMedi = "telefono";

    public static final String SQLMedico = "CREATE TABLE " + tablaMedico + " (" + idMedi + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " " + nombreMedi + " TEXT NOT NULL, " + apellidoMedi + " TEXT NOT NULL, " + especialidadMedi + " TEXT NOT NULL, " +
            " " + correoMedi + " TEXT NOT NULL, " + telefMedi + " INTEGER) ";

    //Constantes de la Tabla Paciente
    public static final String tablaPaci = "PACIENTE";
    public static final String idPaci = "idPaciente";
    public static final String nombrePaci = "nombre";
    public static final String apellidoPaci = "apellido";
    public static final String direccionPaci = "direccion";
    public static final String correoPaci = "correo";
    public static final String telefPaci = "telefono";

    public static final String SQLPaciente = "CREATE TABLE " + tablaPaci + " (" + idPaci + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "" + nombrePaci + " TEXT NOT NULL, " + apellidoPaci + " TEXT NOT NULL, " + correoPaci + " TEXT NOT NULL, " +
            " " + direccionPaci + " TEXT NOT NULL, " + telefPaci + " INTEGER) ";


    //Constantes de la Tabla Cita
    public static final String tablaCita = "CITA";
    public static final String idCita = "idCita";
    public static final String consulta = "consulta";
    public static final String precio = "precio";

    public static final String SQLCita = "CREATE TABLE " + tablaCita + " (" + idCita + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            "" + consulta + " TEXT NOT NULL, " + precio + " INTEGER NOT NULL," +
            "" + idMedi + " INTEGER NOT NULL," +
            "" + idPaci + " INTEGER NOT NULL," +
            "FOREIGN KEY(" + idMedi + ") REFERENCES MEDICO(" + idMedi + ")," +
            "FOREIGN KEY(" + idPaci + ") REFERENCES PACIENTE(" + idPaci + "))";
}
