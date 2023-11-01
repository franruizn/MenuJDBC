/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franr
 */
public class ControladorPaciente {
    private ConexionMySQL con;

    public ControladorPaciente(ConexionMySQL con) {
        this.con = con;
    }

    public ArrayList<Paciente> obtenerPacientes() throws SQLException { // Va a devolver un ArrayList de Jugadores
        ArrayList<Paciente> lista = new ArrayList<>();
        String consultaSQL = "SELECT * FROM paciente";
        ResultSet rset = con.ejecutarSelect(consultaSQL);
        while (rset.next()) {
            int idpaciente = rset.getInt("idpaciente");
            String nombre = rset.getString("nombre");
            String dni = rset.getString("dni");
            
            Paciente p = new Paciente(idpaciente,nombre,dni);
            
            lista.add(p);
        }
        return lista;
    }

    public void insertarPaciente(Paciente paciente) throws SQLException, ClassNotFoundException {
        String consultaSQL = "INSERT INTO paciente VALUES(" + paciente.getIdpaciente()+ ",'" + paciente.getNombre() + "','" + paciente.getDni()+"')";

        try {
            con.ejectutarIDU(consultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarEspecialidad(Paciente paciente) throws SQLException, ClassNotFoundException {
        String consultaSQL = "DELETE FROM paciente WHERE (idpaciente = " + paciente.getIdpaciente() + ");";
        con.ejectutarIDU(consultaSQL);
    }
}
