/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ivanf
 */
public class Facturacion {
    private int idfacturacion, fk_idpaciente, pagado, pagar;

    public Facturacion(int idfacturacion, int fk_idpaciente, int pagado, int pagar) {
        this.idfacturacion = idfacturacion;
        this.fk_idpaciente = fk_idpaciente;
        this.pagado = pagado;
        this.pagar = pagar;
    }

    public Facturacion() {
    }
    
    public int getIdfacturacion() {
        return idfacturacion;
    }

    public void setIdfacturacion(int idfacturacion) {
        this.idfacturacion = idfacturacion;
    }

    public int getFk_idpaciente() {
        return fk_idpaciente;
    }

    public void setFk_idpaciente(int fk_idpaciente) {
        this.fk_idpaciente = fk_idpaciente;
    }

    public int getPagado() {
        return pagado;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

    public int getPagar() {
        return pagar;
    }

    public void setPagar(int pagar) {
        this.pagar = pagar;
    }
}
