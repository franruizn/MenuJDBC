/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Doctor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivanf
 */
public class ControladorDoctor {

    private ConexionMySQL con = new ConexionMySQL();

    public ControladorDoctor() {
    }

    public ArrayList<Doctor> obtenerDoctores() throws SQLException { // Va a devolver un ArrayList de Jugadores
        ArrayList<Doctor> lista = new ArrayList<>();
        String consulta = "SELECT * FROM doctor";
        ResultSet rset = con.ejecutarSelect(consulta);
        while (rset.next()) {
            int iddoctor = rset.getInt("iddoctor");
            int fk_especialidad = rset.getInt("fk_especialidad");
            String nombre = rset.getString("nombre");
            String fk_idusuario = rset.getString("fk_idusuario");
            Doctor d = new Doctor(iddoctor, fk_especialidad, nombre, fk_idusuario);
            lista.add(d);
        }
        return lista;
    }

    public void insertarDoctor(Doctor nuevoDoctor) {
        String consulta = "INSERT INTO doctor VALUES(" + nuevoDoctor.getIddoctor() + ",'" + nuevoDoctor.getFk_idusuario() + "',"
                + nuevoDoctor.getFk_idespecialidad() + ",'" + nuevoDoctor.getNombre() + "')";

        try {
            con.ejectutarIDU(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarUsuario(Doctor doctor) throws SQLException, ClassNotFoundException{
        String consulta = "DELETE FROM doctor WHERE (iddoctor = "+doctor.getIddoctor()+");";
        con.ejectutarIDU(consulta);
    }
}
