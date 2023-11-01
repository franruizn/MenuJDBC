/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Especialidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franr
 */
public class ControladorEspecialidad {
    private ConexionMySQL con;

    public ControladorEspecialidad(ConexionMySQL con) {
        this.con = con;
    }

    public ArrayList<Especialidad> obtenerEspecialidades() throws SQLException { // Va a devolver un ArrayList de Jugadores
        ArrayList<Especialidad> lista = new ArrayList<>();
        String consultaSQL = "SELECT * FROM especialidad";
        ResultSet rset = con.ejecutarSelect(consultaSQL);
        while (rset.next()) {
            int idespecialidad = rset.getInt("idespecialidad");
            String nombre = rset.getString("nombre");
            
            Especialidad e = new Especialidad(idespecialidad,nombre);
            
            lista.add(e);
        }
        return lista;
    }

    public void insertarEspecialidad(Especialidad especialidad) throws SQLException, ClassNotFoundException {
        String consultaSQL = "INSERT INTO especialidad VALUES(" + especialidad.getIdespecialidad() + ",'" + especialidad.getNombre() + "')";

        try {
            con.ejectutarIDU(consultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarEspecialidad(Especialidad especialidad) throws SQLException, ClassNotFoundException {
        String consultaSQL = "DELETE FROM especialidad WHERE (idespecialidad = " + especialidad.getIdespecialidad() + ");";
        con.ejectutarIDU(consultaSQL);
    }
}
