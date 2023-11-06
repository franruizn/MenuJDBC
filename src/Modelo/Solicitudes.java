/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * La clase Solicitudes representa información sobre solicitudes relacionadas con consultas médicas.
 * Contiene detalles como el identificador de la solicitud y el identificador de la consulta asociada.
 *
 * @author franr
 */
public class Solicitudes {
    private int idsolicitudes;    // Identificador de la solicitud.
    private int fk_idconsulta;    // Identificador de la consulta asociada.

    /**
     * Constructor por defecto de la clase Solicitudes.
     */
    public Solicitudes() {
    }

    /**
     * Constructor de la clase Solicitudes con parámetros.
     *
     * @param idsolicitudes Identificador de la solicitud.
     * @param fk_idconsulta Identificador de la consulta asociada.
     */
    public Solicitudes(int idsolicitudes, int fk_idconsulta) {
        this.idsolicitudes = idsolicitudes;
        this.fk_idconsulta = fk_idconsulta;
    }

    /**
     * Obtiene el identificador de la solicitud.
     *
     * @return El identificador de la solicitud.
     */
    public int getIdsolicitudes() {
        return idsolicitudes;
    }

    /**
     * Establece el identificador de la solicitud.
     *
     * @param idsolicitudes El identificador de la solicitud.
     */
    public void setIdsolicitudes(int idsolicitudes) {
        this.idsolicitudes = idsolicitudes;
    }

    /**
     * Obtiene el identificador de la consulta asociada a la solicitud.
     *
     * @return El identificador de la consulta asociada.
     */
    public int getFk_idconsulta() {
        return fk_idconsulta;
    }

    /**
     * Establece el identificador de la consulta asociada a la solicitud.
     *
     * @param fk_idconsulta El identificador de la consulta asociada.
     */
    public void setFk_idconsulta(int fk_idconsulta) {
        this.fk_idconsulta = fk_idconsulta;
    }
}