/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Doctor;
import Modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivanf
 */
public class ControladorProveedor {
    private ConexionMySQL con;

    public ControladorProveedor(ConexionMySQL con) {
        this.con = con;
    }

    public ArrayList<Proveedor> obtenerProveedor() throws SQLException { // Va a devolver un ArrayList de Jugadores
        ArrayList<Proveedor> lista = new ArrayList<>();
        String consulta = "SELECT * FROM proveedor";
        ResultSet rset = con.ejecutarSelect(consulta);
        while (rset.next()) {
            int idproveedor = rset.getInt("idproveedor");
            String nombre = rset.getString("nombre");
            int telefono = rset.getInt("telefono");
            Proveedor d = new Proveedor(idproveedor, telefono, nombre);
            lista.add(d);
        }
        return lista;
    }

    public void insertarProveedor(Proveedor proveedor) {
        String consulta = "INSERT INTO proveedor VALUES(" + proveedor.getIdproveedor() + ",'"
                + proveedor.getNombre() + ",'" + proveedor.getTelefono() + "')";

        try {
            con.ejectutarIDU(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarProveedor(Proveedor proveedor) throws SQLException, ClassNotFoundException{
        String consulta = "DELETE FROM proveedor WHERE (idproveedor = "+proveedor.getIdproveedor()+");";
        con.ejectutarIDU(consulta);
    }
}
