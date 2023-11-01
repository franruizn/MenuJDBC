/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ivanf
 */
public class Consulta {
    private int idconsulta, fk_idpaciente, fk_iddoctor, fk_idtratamiento;
    private String observaciones, fecha;

    public Consulta() {
    }

    public Consulta(int idconsulta, int fk_idpaciente, int fk_iddoctor, int fk_idtratamiento, String observaciones, String fecha) {
        this.idconsulta = idconsulta;
        this.fk_idpaciente = fk_idpaciente;
        this.fk_iddoctor = fk_iddoctor;
        this.fk_idtratamiento = fk_idtratamiento;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    public int getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(int idconsulta) {
        this.idconsulta = idconsulta;
    }

    public int getFk_idpaciente() {
        return fk_idpaciente;
    }

    public void setFk_idpaciente(int fk_idpaciente) {
        this.fk_idpaciente = fk_idpaciente;
    }

    public int getFk_iddoctor() {
        return fk_iddoctor;
    }

    public void setFk_iddoctor(int fk_iddoctor) {
        this.fk_iddoctor = fk_iddoctor;
    }

    public int getFk_idtratamiento() {
        return fk_idtratamiento;
    }

    public void setFk_idtratamiento(int fk_idtratamiento) {
        this.fk_idtratamiento = fk_idtratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
