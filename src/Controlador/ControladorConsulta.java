/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consulta;
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
public class ControladorConsulta {

    private ConexionMySQL con = new ConexionMySQL();

    public ControladorConsulta() {
    }

    public ArrayList<Consulta> obtenerConsultas() throws SQLException { // Va a devolver un ArrayList de Jugadores
        ArrayList<Consulta> lista = new ArrayList<>();
        String consultaSQL = "SELECT * FROM consulta";
        ResultSet rset = con.ejecutarSelect(consultaSQL);
        while (rset.next()) {
            int idconsulta = rset.getInt("idconsulta");
            int fk_idpaciente = rset.getInt("fk_idpaciente");
            int fk_iddoctor = rset.getInt("fk_iddoctor");
            int fk_idtratamiento = rset.getInt("fk_idtratamiento");
            String observaciones = rset.getString("observaciones");
            Date fecha = rset.getDate("fecha");
            
            Consulta c = new Consulta(idconsulta,fk_idpaciente,fk_iddoctor,fk_idtratamiento,observaciones,fecha);
            
            lista.add(c);
        }
        return lista;
    }

    public void insertarConsulta(Consulta consulta) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(consulta.getFecha());
        String consultaSQL = "INSERT INTO consulta VALUES(" + consulta.getIdconsulta() + "," + consulta.getFk_idpaciente() + ","
                + consulta.getFk_iddoctor() + "," + consulta.getFk_idtratamiento() + ",'" + consulta.getObservaciones() + "','" + formattedDate+"');";

        try {
            con.ejecutarIDU(consultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarConsulta(Consulta consulta) throws SQLException, ClassNotFoundException {
        String consultaSQL = "DELETE FROM consulta WHERE (idconsulta = " + consulta.getIdconsulta() + ");";
        con.ejecutarIDU(consultaSQL);
    }
}
