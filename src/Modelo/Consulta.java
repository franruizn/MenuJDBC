/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 * La clase Consulta representa una consulta médica en el sistema. Contiene
 * información sobre la consulta, incluyendo su identificador, el identificador
 * del paciente, el identificador del médico, el identificador del tratamiento,
 * observaciones y fecha de la consulta.
 *
 * @author franr
 */
public class Consulta {
    private int idconsulta;          // Identificador único de la consulta médica.
    private int fk_idpaciente;       // Identificador del paciente que realizó la consulta.
    private int fk_iddoctor;         // Identificador del médico que atendió la consulta.
    private int fk_idtratamiento;    // Identificador del tratamiento asociado a la consulta.
    private String observaciones;    // Observaciones y notas de la consulta.
    private Date fecha;              // Fecha de la consulta.

    /**
     * Constructor por defecto de la clase Consulta.
     */
    public Consulta() {
    }

    /**
     * Constructor de la clase Consulta con parámetros.
     *
     * @param idconsulta Identificador único de la consulta médica.
     * @param fk_idpaciente Identificador del paciente que realizó la consulta.
     * @param fk_iddoctor Identificador del médico que atendió la consulta.
     * @param fk_idtratamiento Identificador del tratamiento asociado a la consulta.
     * @param observaciones Observaciones y notas de la consulta.
     * @param fecha Fecha de la consulta.
     */
    public Consulta(int idconsulta, int fk_idpaciente, int fk_iddoctor, int fk_idtratamiento, String observaciones, Date fecha) {
        this.idconsulta = idconsulta;
        this.fk_idpaciente = fk_idpaciente;
        this.fk_iddoctor = fk_iddoctor;
        this.fk_idtratamiento = fk_idtratamiento;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    /**
     * Obtiene el identificador único de la consulta médica.
     *
     * @return El identificador único de la consulta médica.
     */
    public int getIdconsulta() {
        return idconsulta;
    }

    /**
     * Establece el identificador único de la consulta médica.
     *
     * @param idconsulta El identificador único de la consulta médica.
     */
    public void setIdconsulta(int idconsulta) {
        this.idconsulta = idconsulta;
    }

    /**
     * Obtiene el identificador del paciente que realizó la consulta.
     *
     * @return El identificador del paciente que realizó la consulta.
     */
    public int getFk_idpaciente() {
        return fk_idpaciente;
    }

    /**
     * Establece el identificador del paciente que realizó la consulta.
     *
     * @param fk_idpaciente El identificador del paciente que realizó la consulta.
     */
    public void setFk_idpaciente(int fk_idpaciente) {
        this.fk_idpaciente = fk_idpaciente;
    }

    /**
     * Obtiene el identificador del médico que atendió la consulta.
     *
     * @return El identificador del médico que atendió la consulta.
     */
    public int getFk_iddoctor() {
        return fk_iddoctor;
    }

    /**
     * Establece el identificador del médico que atendió la consulta.
     *
     * @param fk_iddoctor El identificador del médico que atendió la consulta.
     */
    public void setFk_iddoctor(int fk_iddoctor) {
        this.fk_iddoctor = fk_iddoctor;
    }

    /**
     * Obtiene el identificador del tratamiento asociado a la consulta.
     *
     * @return El identificador del tratamiento asociado a la consulta.
     */
    public int getFk_idtratamiento() {
        return fk_idtratamiento;
    }

    /**
     * Establece el identificador del tratamiento asociado a la consulta.
     *
     * @param fk_idtratamiento El identificador del tratamiento asociado a la consulta.
     */
    public void setFk_idtratamiento(int fk_idtratamiento) {
        this.fk_idtratamiento = fk_idtratamiento;
    }

    /**
     * Obtiene las observaciones y notas de la consulta.
     *
     * @return Las observaciones y notas de la consulta.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones y notas de la consulta.
     *
     * @param observaciones Las observaciones y notas de la consulta.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene la fecha de la consulta.
     *
     * @return La fecha de la consulta.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la consulta.
     *
     * @param fecha La fecha de la consulta.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
