/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Facturacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franr
 */
public class ControladorFacturacion {
    private ConexionMySQL con;

    public ControladorFacturacion(ConexionMySQL con) {
        this.con = con;
    }

    public ArrayList<Facturacion> obtenerFacturacion() throws SQLException { // Va a devolver un ArrayList de Jugadores
        ArrayList<Facturacion> lista = new ArrayList<>();
        String consultaSQL = "SELECT * FROM facturacion";
        ResultSet rset = con.ejecutarSelect(consultaSQL);
        while (rset.next()) {
            int idfacturacion = rset.getInt("idfacturacion");
            int fk_idpaciente = rset.getInt("idpaciente");
            int pagado = rset.getInt("pagado");
            int pagar = rset.getInt("pagar");
            
            Facturacion f = new Facturacion(idfacturacion,fk_idpaciente,pagado,pagar);
            
            lista.add(f);
        }
        return lista;
    }

    public void insertarFactura(Facturacion factura) throws SQLException, ClassNotFoundException {
        String consultaSQL = "INSERT INTO facturacion VALUES(" + factura.getIdfacturacion() + "," + factura.getFk_idpaciente() + 
                "," + factura.getPagado() + "," + factura.getPagar()+")";

        try {
            con.ejectutarIDU(consultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarFactura(Facturacion factura) throws SQLException, ClassNotFoundException {
        String consultaSQL = "DELETE FROM facturacion WHERE (idfacturacion = " + factura.getIdfacturacion() + ");";
        con.ejectutarIDU(consultaSQL);
    }
    
}
