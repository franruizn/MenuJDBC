/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ivanf
 */
public class Doctor {
    private int iddoctor, fk_idespecialidad;
    private String nombre, fk_idusuario;

    public Doctor(){}
    
    public Doctor(int iddoctor, int fk_idespecialidad, String nombre, String fk_idusuario) {
        this.iddoctor = iddoctor;
        this.fk_idespecialidad = fk_idespecialidad;
        this.nombre = nombre;
        this.fk_idusuario = fk_idusuario;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public int getFk_idespecialidad() {
        return fk_idespecialidad;
    }

    public void setFk_idespecialidad(int fk_idespecialidad) {
        this.fk_idespecialidad = fk_idespecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFk_idusuario() {
        return fk_idusuario;
    }

    public void setFk_idusuario(String fk_idusuario) {
        this.fk_idusuario = fk_idusuario;
    }
    
}
