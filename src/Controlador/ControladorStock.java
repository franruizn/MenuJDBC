/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Stock;
import Modelo.Tratamiento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivanf
 */
public class ControladorStock {
    private ConexionMySQL con;

    public ControladorStock(ConexionMySQL con) {
        this.con = con;
    }
    
    public ArrayList<Stock> obtenerStock() throws SQLException, ClassNotFoundException { // Va a devolver un ArrayList de Jugadores
        con.conectar();
        ArrayList<Stock> lista = new ArrayList<>();
        String consulta = "SELECT * FROM stock";
        ResultSet rset = con.ejecutarSelect(consulta);
        while (rset.next()) {
            int idstock = rset.getInt("idstock");
            int fk_idproveedor = rset.getInt("fk_idproveedor");
            String nombre = rset.getString("nombre");
            int cantidad = rset.getInt("cantidad");
            Stock u = new Stock(idstock, fk_idproveedor, cantidad, nombre );
            lista.add(u);
        }
        con.desconectar();
        return lista;
    }
    
    public void insertarStock(Stock stock) throws SQLException, ClassNotFoundException {
        con.conectar();
        String consulta = "INSERT INTO stock VALUES('" + stock.getIdstock() + "','" + stock.getFk_idproveedor() + "'," 
                + stock.getNombre()+ "'," + stock.getCantidad()+")";
        
        try {
            con.ejecutarIDU(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.desconectar();
    }
    public void borrarStock(Stock stock) throws SQLException, ClassNotFoundException{
        String consulta = "DELETE FROM stock WHERE (idstock = "+stock.getIdstock()+");";
        con.ejecutarIDU(consulta);
    }
}
