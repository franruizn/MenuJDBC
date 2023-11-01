/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Doctor;
import Modelo.Solicitudes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivanf
 */
public class ControladorSolicitudes {
    private ConexionMySQL con;

    public ControladorSolicitudes(ConexionMySQL con) {
        this.con = con;
    }

    public ArrayList<Solicitudes> obtenersolicitudes() throws SQLException { // Va a devolver un ArrayList de Jugadores
        ArrayList<Solicitudes> lista = new ArrayList<>();
        String consulta = "SELECT * FROM solicitudes";
        ResultSet rset = con.ejecutarSelect(consulta);
        while (rset.next()) {
            int idsolicitudes = rset.getInt("idsolicitudes");
            int fk_idconsulta = rset.getInt("fk_idconsulta");
            Solicitudes d = new Solicitudes(idsolicitudes, fk_idconsulta);
            lista.add(d);
        }
        return lista;
    }

    public void insertarSolicitud(Solicitudes solicitudes) {
        String consulta = "INSERT INTO solicitudes VALUES(" + solicitudes.getIdsolicitudes() + ",'" + solicitudes.getFk_idconsulta() +  "')";

        try {
            con.ejectutarIDU(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarSolicitudes(Solicitudes solicitudes) throws SQLException, ClassNotFoundException{
        String consulta = "DELETE FROM doctor WHERE (iddoctor = "+solicitudes.getIdsolicitudes()+");";
        con.ejectutarIDU(consulta);
    }
}
