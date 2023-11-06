/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * La clase Paciente representa la información de un paciente en el sistema de gestión de consultas médicas.
 * Contiene detalles sobre el paciente, incluyendo su identificador único, nombre y número de DNI.
 *
 * @author franr
 */
public class Paciente {
    private int idpaciente;  // Identificador único del paciente.
    private String nombre;   // Nombre del paciente.
    private String dni;      // Número de Documento Nacional de Identidad (DNI) del paciente.

    /**
     * Constructor de la clase Paciente con parámetros.
     *
     * @param idpaciente Identificador único del paciente.
     * @param nombre Nombre del paciente.
     * @param dni Número de Documento Nacional de Identidad (DNI) del paciente.
     */
    public Paciente(int idpaciente, String nombre, String dni) {
        this.idpaciente = idpaciente;
        this.nombre = nombre;
        this.dni = dni;
    }

    /**
     * Constructor por defecto de la clase Paciente.
     */
    public Paciente() {
    }

    /**
     * Obtiene el identificador único del paciente.
     *
     * @return El identificador único del paciente.
     */
    public int getIdpaciente() {
        return idpaciente;
    }

    /**
     * Establece el identificador único del paciente.
     *
     * @param idpaciente El identificador único del paciente.
     */
    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del paciente.
     *
     * @param nombre El nombre del paciente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de Documento Nacional de Identidad (DNI) del paciente.
     *
     * @return El número de DNI del paciente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el número de Documento Nacional de Identidad (DNI) del paciente.
     *
     * @param dni El número de DNI del paciente.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
}
