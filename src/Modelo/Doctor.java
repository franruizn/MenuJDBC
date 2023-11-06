/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * La clase Doctor representa a un médico en el sistema. Contiene información
 * sobre el médico, incluyendo su identificador, especialidad, nombre y
 * identificador de usuario asociado.
 *
 * @author franr
 */
public class Doctor {
    private int iddoctor;             // Identificador único del médico.
    private int fk_idespecialidad;    // Identificador de la especialidad a la que pertenece el médico.
    private String nombre;            // Nombre del médico.
    private String fk_idusuario;     // Identificador de usuario asociado al médico.

    /**
     * Constructor por defecto de la clase Doctor.
     */
    public Doctor() {
    }

    /**
     * Constructor de la clase Doctor con parámetros.
     *
     * @param iddoctor Identificador único del médico.
     * @param fk_idespecialidad Identificador de la especialidad a la que pertenece el médico.
     * @param nombre Nombre del médico.
     * @param fk_idusuario Identificador de usuario asociado al médico.
     */
    public Doctor(int iddoctor, int fk_idespecialidad, String nombre, String fk_idusuario) {
        this.iddoctor = iddoctor;
        this.fk_idespecialidad = fk_idespecialidad;
        this.nombre = nombre;
        this.fk_idusuario = fk_idusuario;
    }

    /**
     * Obtiene el identificador único del médico.
     *
     * @return El identificador único del médico.
     */
    public int getIddoctor() {
        return iddoctor;
    }

    /**
     * Establece el identificador único del médico.
     *
     * @param iddoctor El identificador único del médico.
     */
    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    /**
     * Obtiene el identificador de la especialidad a la que pertenece el médico.
     *
     * @return El identificador de la especialidad del médico.
     */
    public int getFk_idespecialidad() {
        return fk_idespecialidad;
    }

    /**
     * Establece el identificador de la especialidad del médico.
     *
     * @param fk_idespecialidad El identificador de la especialidad del médico.
     */
    public void setFk_idespecialidad(int fk_idespecialidad) {
        this.fk_idespecialidad = fk_idespecialidad;
    }

    /**
     * Obtiene el nombre del médico.
     *
     * @return El nombre del médico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del médico.
     *
     * @param nombre El nombre del médico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de usuario asociado al médico.
     *
     * @return El identificador de usuario asociado al médico.
     */
    public String getFk_idusuario() {
        return fk_idusuario;
    }

    /**
     * Establece el identificador de usuario asociado al médico.
     *
     * @param fk_idusuario El identificador de usuario asociado al médico.
     */
    public void setFk_idusuario(String fk_idusuario) {
        this.fk_idusuario = fk_idusuario;
    }
}

Esta documentación describe la clase Doctor, que representa a un médico en el sistema. La clase contiene propiedades como el identificador del médico, la especialidad a la que pertenece, su nombre y el identificador de usuario asociado. Se explican los constructores, propiedades y métodos de acceso de la clase.

