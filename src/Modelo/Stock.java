/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ivanf
 */
public class Stock {
    private int idstock, fk_idproveedor, cantidad;
    private String nombre;

    public Stock() {
    }

    public Stock(int idstock, int fk_idproveedor, int cantidad, String nombre) {
        this.idstock = idstock;
        this.fk_idproveedor = fk_idproveedor;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getIdstock() {
        return idstock;
    }

    public void setIdstock(int idstock) {
        this.idstock = idstock;
    }

    public int getFk_idproveedor() {
        return fk_idproveedor;
    }

    public void setFk_idproveedor(int fk_idproveedor) {
        this.fk_idproveedor = fk_idproveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
