/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ivanf
 */
public class Tratamiento {
    private int idtratamiento, fk_idstock;
    private String nombre, precio;

    public Tratamiento() {
    }

    public Tratamiento(int idtratamiento, int fk_idstock, String nombre, String precio) {
        this.idtratamiento = idtratamiento;
        this.fk_idstock = fk_idstock;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdtratamiento() {
        return idtratamiento;
    }

    public void setIdtratamiento(int idtratamiento) {
        this.idtratamiento = idtratamiento;
    }

    public int getFk_idstock() {
        return fk_idstock;
    }

    public void setFk_idstock(int fk_idstock) {
        this.fk_idstock = fk_idstock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
   
}
