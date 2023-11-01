/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ConsultasGUI;
import java.sql.DatabaseMetaData;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
    
    public void like(JTable tabla1) throws SQLException {
        cn.conectar();
        String consulta = "select * FROM paciente where dni like '79%'";
        ResultSet rs = cn.ejecutarSelect(consulta);
        int row = 0;
        int column = 0;
        while (rs.next()) {
            tabla1.setValueAt(rs.getInt("idpaciente"),row,column);
            tabla1.setValueAt(rs.getString("nombre"),row,column+1);
            tabla1.setValueAt(rs.getString("dni"),row,column+2);
            row++;
            
        }
        
        
    }
    
    public void join(JTable tabla2) throws SQLException{
        cn.conectar();
        String consulta = "SELECT rol from usuario JOIN doctor ON idusuario = fk_idusuario where iddoctor=2"; 
        ResultSet rs=cn.ejecutarSelect(consulta);
        int row = 0;
        int column = 0;
        while (rs.next()) {
            tabla2.setValueAt(rs.getInt("rol"),row,column);
            row++;
        }
        
    }
   
    public void groupBy(JTable tabla3) throws SQLException{
        cn.conectar();
        String consulta = "SELECT rol from usuario GROUP BY rol"; 
        ResultSet rs=cn.ejecutarSelect(consulta);
        int row = 0;
        int column = 0;
        while (rs.next()) {
            tabla3.setValueAt(rs.getInt("rol"),row,column);
            row++;
        }
    }

}
