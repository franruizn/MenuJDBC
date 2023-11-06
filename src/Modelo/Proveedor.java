/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * La clase Proveedor representa información sobre un proveedor de productos o servicios.
 * Contiene detalles como el identificador del proveedor, el número de teléfono y el nombre.
 *
 * @author franr
 */
public class Proveedor {
    private int idproveedor;  // Identificador del proveedor.
    private int telefono;     // Número de teléfono del proveedor.
    private String nombre;    // Nombre del proveedor.

    /**
     * Constructor por defecto de la clase Proveedor.
     */
    public Proveedor() {
    }

    /**
     * Constructor de la clase Proveedor con parámetros.
     *
     * @param idproveedor Identificador del proveedor.
     * @param telefono Número de teléfono del proveedor.
     * @param nombre Nombre del proveedor.
     */
    public Proveedor(int idproveedor, int telefono, String nombre) {
        this.idproveedor = idproveedor;
        this.telefono = telefono;
        this nombre = nombre;
    }

    /**
     * Obtiene el identificador del proveedor.
     *
     * @return El identificador del proveedor.
     */
    public int getIdproveedor() {
        return idproveedor;
    }

    /**
     * Establece el identificador del proveedor.
     *
     * @param idproveedor El identificador del proveedor.
     */
    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    /**
     * Obtiene el número de teléfono del proveedor.
     *
     * @return El número de teléfono del proveedor.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del proveedor.
     *
     * @param telefono El número de teléfono del proveedor.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return El nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre El nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
