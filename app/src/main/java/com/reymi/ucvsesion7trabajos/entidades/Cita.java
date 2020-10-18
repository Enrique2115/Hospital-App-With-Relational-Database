package com.reymi.ucvsesion7trabajos.entidades;

public class Cita {
    private int idCita;
    private String consulta;
    private int precio;
    private int idMedico;
    private int idPaciente;

    public Cita() {
    }

    public Cita(int idCita, String consulta, int precio, int idMedico, int idPaciente) {
        this.idCita = idCita;
        this.consulta = consulta;
        this.precio = precio;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
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

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
