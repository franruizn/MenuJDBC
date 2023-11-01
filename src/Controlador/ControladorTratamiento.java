/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Tratamiento;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivanf
 */
public class ControladorTratamiento {
    private ConexionMySQL con;

    public ControladorTratamiento(ConexionMySQL con) {
        this.con = con;
    }
    
    public ArrayList<Tratamiento> obtenerTratamiento() throws SQLException, ClassNotFoundException { // Va a devolver un ArrayList de Jugadores
        con.conectar();
        ArrayList<Tratamiento> lista = new ArrayList<>();
        String consulta = "SELECT * FROM tratamiento";
        ResultSet rset = con.ejecutarSelect(consulta);
        while (rset.next()) {
            int idtratamiento = rset.getInt("idtratamiento");
            int fk_idstock = rset.getInt("fk_idstock");
            String nombre = rset.getString("nombre");
            double precio = rset.getDouble("nombre");
            Tratamiento u = new Tratamiento(idtratamiento, fk_idstock, nombre, precio);
            lista.add(u);
        }
        con.desconectar();
        return lista;
    }
    
    public void insertarTratamiento(Tratamiento trat) throws SQLException, ClassNotFoundException {
        con.conectar();
        String consulta = "INSERT INTO tratamiento VALUES('" + trat.getIdtratamiento() + "','" + trat.getFk_idstock() + "'," 
                + trat.getNombre()+ "'," + trat.getPrecio()+")";
        
        try {
            con.ejecutarIDU(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTratamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.desconectar();
    }
    public void borrarTratamiento(Tratamiento trat) throws SQLException, ClassNotFoundException{
        String consulta = "DELETE FROM tratamiento WHERE (idtratamiento = "+trat.getIdtratamiento()+");";
        con.ejecutarIDU(consulta);
    }
}
