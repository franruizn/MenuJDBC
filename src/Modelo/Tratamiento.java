/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * La clase Tratamiento representa la información sobre un tratamiento médico disponible.
 * Contiene detalles como el identificador del tratamiento, el identificador del stock,
 * el nombre del tratamiento y su precio.
 *
 * @author franr
 */
public class Tratamiento {
    private int idtratamiento;  // Identificador del tratamiento.
    private int fk_idstock;     // Identificador del stock relacionado.
    private String nombre;      // Nombre del tratamiento.
    private double precio;      // Precio del tratamiento.

    /**
     * Constructor por defecto de la clase Tratamiento.
     */
    public Tratamiento() {
    }

    /**
     * Constructor de la clase Tratamiento con parámetros.
     *
     * @param idtratamiento Identificador del tratamiento.
     * @param fk_idstock Identificador del stock relacionado.
     * @param nombre Nombre del tratamiento.
     * @param precio Precio del tratamiento.
     */
    public Tratamiento(int idtratamiento, int fk_idstock, String nombre, double precio) {
        this.idtratamiento = idtratamiento;
        this.fk_idstock = fk_idstock;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el identificador del tratamiento.
     *
     * @return El identificador del tratamiento.
     */
    public int getIdtratamiento() {
        return idtratamiento;
    }

    /**
     * Establece el identificador del tratamiento.
     *
     * @param idtratamiento El identificador del tratamiento.
     */
    public void setIdtratamiento(int idtratamiento) {
        this.idtratamiento = idtratamiento;
    }

    /**
     * Obtiene el identificador del stock relacionado.
     *
     * @return El identificador del stock relacionado.
     */
    public int getFk_idstock() {
        return fk_idstock;
    }

    /**
     * Establece el identificador del stock relacionado.
     *
     * @param fk_idstock El identificador del stock relacionado.
     */
    public void setFk_idstock(int fk_idstock) {
        this.fk_idstock = fk_idstock;
    }

    /**
     * Obtiene el nombre del tratamiento.
     *
     * @return El nombre del tratamiento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del tratamiento.
     *
     * @param nombre El nombre del tratamiento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del tratamiento.
     *
     * @return El precio del tratamiento.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del tratamiento.
     *
     * @param precio El precio del tratamiento.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
