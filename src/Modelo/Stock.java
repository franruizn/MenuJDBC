/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * La clase Stock representa información sobre productos en el inventario de un proveedor.
 * Contiene detalles como el identificador del producto en stock, el identificador del proveedor,
 * la cantidad disponible y el nombre del producto.
 *
 * @author franr
 */
public class Stock {
    private int idstock;         // Identificador del producto en stock.
    private int fk_idproveedor;  // Identificador del proveedor asociado.
    private int cantidad;        // Cantidad disponible del producto en stock.
    private String nombre;       // Nombre del producto.

    /**
     * Constructor por defecto de la clase Stock.
     */
    public Stock() {
    }

    /**
     * Constructor de la clase Stock con parámetros.
     *
     * @param idstock Identificador del producto en stock.
     * @param fk_idproveedor Identificador del proveedor asociado.
     * @param cantidad Cantidad disponible del producto en stock.
     * @param nombre Nombre del producto.
     */
    public Stock(int idstock, int fk_idproveedor, int cantidad, String nombre) {
        this.idstock = idstock;
        this.fk_idproveedor = fk_idproveedor;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del producto en stock.
     *
     * @return El identificador del producto en stock.
     */
    public int getIdstock() {
        return idstock;
    }

    /**
     * Establece el identificador del producto en stock.
     *
     * @param idstock El identificador del producto en stock.
     */
    public void setIdstock(int idstock) {
        this.idstock = idstock;
    }

    /**
     * Obtiene el identificador del proveedor asociado al producto en stock.
     *
     * @return El identificador del proveedor asociado.
     */
    public int getFk_idproveedor() {
        return fk_idproveedor;
    }

    /**
     * Establece el identificador del proveedor asociado al producto en stock.
     *
     * @param fk_idproveedor El identificador del proveedor asociado.
     */
    public void setFk_idproveedor(int fk_idproveedor) {
        this.fk_idproveedor = fk_idproveedor;
    }

    /**
     * Obtiene la cantidad disponible del producto en stock.
     *
     * @return La cantidad disponible del producto en stock.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del producto en stock.
     *
     * @param cantidad La cantidad disponible del producto en stock.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el nombre del producto en stock.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto en stock.
     *
     * @param nombre El nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
