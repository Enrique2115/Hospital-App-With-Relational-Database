package com.reymi.ucvsesion7trabajos.entidades;

public class Cita {
    private int idCita;
    private String consulta;
    private int precio;
    private String nomMedico;
    private String nomPaciente;

    public Cita() {
    }

    public Cita(int idCita, String consulta, int precio, String nomMedico, String nomPaciente) {
        this.idCita = idCita;
        this.consulta = consulta;
        this.precio = precio;
        this.nomMedico = nomMedico;
        this.nomPaciente = nomPaciente;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNomMedico() {
        return nomMedico;
    }

    public void setNomMedico(String nomMedico) {
        this.nomMedico = nomMedico;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }
}
