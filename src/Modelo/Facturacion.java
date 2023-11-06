/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * La clase Facturacion representa la información relacionada con la facturación de un paciente.
 * Contiene detalles sobre la factura, incluyendo su identificador, el identificador del paciente,
 * la cantidad pagada y la cantidad pendiente de pago.
 *
 * @author franr
 */
public class Facturacion {
    private int idfacturacion;    // Identificador único de la factura.
    private int fk_idpaciente;    // Identificador del paciente asociado a la factura.
    private int pagado;           // Cantidad pagada.
    private int pagar;            // Cantidad pendiente de pago.

    /**
     * Constructor de la clase Facturacion con parámetros.
     *
     * @param idfacturacion Identificador único de la factura.
     * @param fk_idpaciente Identificador del paciente asociado a la factura.
     * @param pagado Cantidad pagada.
     * @param pagar Cantidad pendiente de pago.
     */
    public Facturacion(int idfacturacion, int fk_idpaciente, int pagado, int pagar) {
        this.idfacturacion = idfacturacion;
        this.fk_idpaciente = fk_idpaciente;
        this.pagado = pagado;
        this.pagar = pagar;
    }

    /**
     * Constructor por defecto de la clase Facturacion.
     */
    public Facturacion() {
    }

    /**
     * Obtiene el identificador único de la factura.
     *
     * @return El identificador único de la factura.
     */
    public int getIdfacturacion() {
        return idfacturacion;
    }

    /**
     * Establece el identificador único de la factura.
     *
     * @param idfacturacion El identificador único de la factura.
     */
    public void setIdfacturacion(int idfacturacion) {
        this.idfacturacion = idfacturacion;
    }

    /**
     * Obtiene el identificador del paciente asociado a la factura.
     *
     * @return El identificador del paciente asociado a la factura.
     */
    public int getFk_idpaciente() {
        return fk_idpaciente;
    }

    /**
     * Establece el identificador del paciente asociado a la factura.
     *
     * @param fk_idpaciente El identificador del paciente asociado a la factura.
     */
    public void setFk_idpaciente(int fk_idpaciente) {
        this.fk_idpaciente = fk_idpaciente;
    }

    /**
     * Obtiene la cantidad pagada.
     *
     * @return La cantidad pagada.
     */
    public int getPagado() {
        return pagado;
    }

    /**
     * Establece la cantidad pagada.
     *
     * @param pagado La cantidad pagada.
     */
    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

    /**
     * Obtiene la cantidad pendiente de pago.
     *
     * @return La cantidad pendiente de pago.
     */
    public int getPagar() {
        return pagar;
    }

    /**
     * Establece la cantidad pendiente de pago.
     *
     * @param pagar La cantidad pendiente de pago.
     */
    public void setPagar(int pagar) {
        this.pagar = pagar;
    }
}