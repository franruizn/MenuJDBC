/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.DatabaseMetaData;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author franr
 */
public class ControladorSQL {

    private ConexionMySQL cn = new ConexionMySQL();
    private DatabaseMetaData metaDatos;

    public ControladorSQL() {
    }

    public void insertarDatos(String nombreTabla) throws SQLException {
        cn.conectar();
        metaDatos = cn.getConnection().getMetaData();
        
        
        String nombreColumnas = obtenerColumnas(nombreTabla);

        String[] cadenaNombreColumnas = nombreColumnas.split(",");
        String nuevosValores = "";

        for (int i = 0; i < cadenaNombreColumnas.length; i++) {
            String nuevoValor = JOptionPane.showInputDialog("Introduce el valor para el campo " + cadenaNombreColumnas[i] + ":");

            if (i < cadenaNombreColumnas.length - 1) {
                nuevosValores += "'" + nuevoValor + "',";
            } else {
                nuevosValores += "'" + nuevoValor + "'";
            }
        }

        String consulta = "INSERT INTO " + nombreTabla + " (" + nombreColumnas + ") VALUES (" + nuevosValores + ")";
        cn.ejecutarIDU(consulta);
        JOptionPane.showMessageDialog(null, "Registro insertado con éxito en " + nombreTabla + "s", "Registro agregado", JOptionPane.INFORMATION_MESSAGE);

        cn.desconectar();
    }

    public String obtenerColumnas(String nombreTabla) throws SQLException {
        String nombreColumnas = "";
        ResultSet rset = metaDatos.getColumns(null, null, nombreTabla, null);
        while (rset.next()) {
            String nombreColumnaActual = rset.getString("COLUMN_NAME");
            nombreColumnas += nombreColumnaActual + ",";
        }
        nombreColumnas = nombreColumnas.substring(0, nombreColumnas.length() - 1); // Elimina la última coma
        return nombreColumnas;
    }

    public void eliminarDatos(String nombreTabla) throws SQLException {
        cn.conectar();
        metaDatos = cn.getConnection().getMetaData();

        ResultSet rset = metaDatos.getPrimaryKeys(null, null, nombreTabla);
        String campoPrimario = "";
        boolean valido = false;

        while (rset.next()) {
            campoPrimario = rset.getString("COLUMN_NAME");
        }

        while (!valido) {
            String valorCampo = JOptionPane.showInputDialog("Ingrese el id de " + nombreTabla + " que deseas eliminar:");
            if (valorCampo.isEmpty() || valorCampo.equals(null)) {
                JOptionPane.showMessageDialog(null, "El dato introducido no es correcto, por favor, introduce un dato válido");
            } else {
                valido = true;
                String consulta = "DELETE FROM " + nombreTabla + " WHERE " + campoPrimario + " = " + valorCampo;
                cn.ejecutarIDU(consulta);

                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito en " + nombreTabla + "s", "Registro eleminado", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        cn.desconectar();
    }

    public void actualizarDatos(String nombreTabla) throws SQLException {
        cn.conectar();
        metaDatos = cn.getConnection().getMetaData();
        
        String nombreColumnas = obtenerColumnas(nombreTabla);

        String[] cadenaNombreColumnas = nombreColumnas.split(",");
        
        
    }
    
    public void like() throws SQLException{
        cn.conectar();
        String consulta = "select * FROM paciente where dni like '79%'";
        cn.ejecutarIDU(consulta);
    }
    
    public void join() throws SQLException{
        cn.conectar();
        String consulta = "SELECT rol from usuario JOIN doctor ON idusuario = fk_idusuario where iddoctor=2"; 
        cn.ejecutarIDU(consulta);
    }
   
    public void groupBy() throws SQLException{
        cn.conectar();
        String consulta = "SELECT rol from usuario GROUP BY rol"; 
        cn.ejecutarIDU(consulta);
    }

}
