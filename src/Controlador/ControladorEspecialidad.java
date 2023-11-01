/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consulta;
import Modelo.Especialidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franr
 */
public class ControladorEspecialidad {
    private ConexionMySQL con = new ConexionMySQL();

    public ControladorEspecialidad() {
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

    public void insertarEspecialidad(Especialidad especialidad) {
        
        String consultaSQL = "INSERT INTO especialidad VALUES(" + especialidad.getIdespecialidad() + ",'" + especialidad.getNombre() + "')";

        try {
            con.ejectutarIDU(consultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarUsuario(Consulta consulta) throws SQLException, ClassNotFoundException {
        String consultaSQL = "DELETE FROM doctor WHERE (iddoctor = " + consulta.getIdconsulta() + ");";
        con.ejectutarIDU(consultaSQL);
    }
}
