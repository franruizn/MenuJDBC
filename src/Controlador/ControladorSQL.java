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
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

/**
 * ControladorSQL es una clase que gestiona operaciones SQL en una base de datos.
 * Proporciona métodos para insertar, eliminar, cargar, actualizar y realizar
 * consultas en una base de datos MySQL.
 *
 * @author franr
 */
public class ControladorSQL {

    private ConexionMySQL cn = new ConexionMySQL();
    private DatabaseMetaData metaDatos;
    private ArrayList<String> primaryKeyValue;
    private String primaryKey;

    /**
     * Constructor de la clase ControladorSQL. Inicializa una instancia de
     * ConexionMySQL.
     */
    public ControladorSQL() {
    }

    /**
     * Este método permite insertar nuevos registros en una tabla de la base de datos.
     *
     * @param nombreTabla Nombre de la tabla en la que se insertarán los datos.
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
    public void insertarDatos(String nombreTabla) throws SQLException {
        // Se establece una conexión a la base de datos.
        cn.conectar();
        metaDatos = cn.getConnection().getMetaData();

        // Se obtiene el nombre de las columnas de la tabla.
        String nombreColumnas = obtenerColumnas(nombreTabla);

        String[] cadenaNombreColumnas = nombreColumnas.split(",");
        String nuevosValores = "";

        for (int i = 0; i < cadenaNombreColumnas.length; i++) {
            // Se solicita al usuario que ingrese valores para cada columna.
            String nuevoValor = JOptionPane.showInputDialog("Introduce el valor para el campo " + cadenaNombreColumnas[i] + ":");

            if (i < cadenaNombreColumnas.length - 1) {
                nuevosValores += "'" + nuevoValor + "',";
            } else {
                nuevosValores += "'" + nuevoValor + "',";
            }
        }

        nuevosValores = nuevosValores.substring(0, nuevosValores.length() - 1);

        // Se construye la consulta SQL para la inserción de datos.
        String consulta = "INSERT INTO " + nombreTabla + " (" + nombreColumnas + ") VALUES (" + nuevosValores + ")";
        cn.ejecutarIDU(consulta);
        JOptionPane.showMessageDialog(null, "Registro insertado con éxito en " + nombreTabla + "s", "Registro agregado", JOptionPane.INFORMATION_MESSAGE);

        // Se cierra la conexión a la base de datos.
        cn.desconectar();
    }

    /**
     * Obtiene los nombres de las columnas de una tabla de la base de datos.
     *
     * @param nombreTabla Nombre de la tabla de la que se obtendrán las columnas.
     * @return Una cadena de texto con los nombres de las columnas separados por comas.
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
    public String obtenerColumnas(String nombreTabla) throws SQLException {
        String nombreColumnas = "";
        cn.conectar();
        metaDatos = cn.getConnection().getMetaData();
        ResultSet rset = metaDatos.getColumns(null, null, nombreTabla, null);
        while (rset.next()) {
            String nombreColumnaActual = rset.getString("COLUMN_NAME");
            nombreColumnas += nombreColumnaActual + ",";
        }
        nombreColumnas = nombreColumnas.substring(0, nombreColumnas.length() - 1); // Elimina la última coma
        return nombreColumnas;
    }

    /**
     * Elimina un registro de una tabla de la base de datos.
     *
     * @param nombreTabla Nombre de la tabla de la que se eliminará el registro.
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
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
                // Se construye la consulta SQL para la eliminación del registro.
                String consulta = "DELETE FROM " + nombreTabla + " WHERE " + campoPrimario + " = " + valorCampo;
                cn.ejecutarIDU(consulta);

                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito en " + nombreTabla + "s", "Registro eleminado", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Se cierra la conexión a la base de datos.
        cn.desconectar();
    }

    /**
     * Carga datos de una tabla de la base de datos en un modelo de tabla.
     *
     * @param nombreTabla    Nombre de la tabla de la que se cargarán los datos.
     * @param modeloDatos    Modelo de tabla en el que se cargarán los datos.
     * @return El modelo de tabla actualizado con los datos de la tabla.
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
    public DefaultTableModel cargarDatos(String nombreTabla, DefaultTableModel modeloDatos) throws SQLException {
        cn.conectar();
        metaDatos = cn.getConnection().getMetaData();

        // Se ejecuta una consulta SQL para obtener los datos de la tabla.
        ResultSet rset = cn.ejecutarSelect("SELECT * FROM " + nombreTabla);
        modeloDatos.setRowCount(0);
        while (rset.next()) {
            modeloDatos.setRowCount(modeloDatos.getRowCount() + 1);
            for (int i = 0; i < modeloDatos.getColumnCount(); i++) {
                modeloDatos.setValueAt(rset.getObject(i + 1), modeloDatos.getRowCount() - 1, i);
            }
        }

        ResultSet rs = metaDatos.getPrimaryKeys(null, null, nombreTabla);
        primaryKey = "";
        primaryKeyValue = new ArrayList<String>();

        while (rs.next()) {
            primaryKey = rs.getString("COLUMN_NAME");
        }

        for (int i = 0; i < modeloDatos.getRowCount(); i++) {
            for (int j = 0; j < modeloDatos.getColumnCount(); j++) {
                if (modeloDatos.getColumnName(j).equals(primaryKey)) {
                    primaryKeyValue.add(modeloDatos.getValueAt(i, j).toString());
                }
            }
        }

        // Se cierra la conexión a la base de datos.
        cn.desconectar();
        return modeloDatos;
    }

    /**
     * Realiza una consulta SQL con unoperador LIKE en una tabla de la base de datos.
     * Muestra los resultados en una tabla en la interfaz gráfica.
     *
     * @param tabla1 Tabla en la que se mostrarán los resultados de la consulta.
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
    public void like(JTable tabla1) throws SQLException {
        cn.conectar();
        // Se construye la consulta SQL con el operador LIKE.
        String consulta = "select * FROM paciente where dni like '79%'";
        ResultSet rs = cn.ejecutarSelect(consulta);
        int row = 0;
        int column = 0;
        while (rs.next()) {
            tabla1.setValueAt(rs.getInt("idpaciente"), row, column);
            tabla1.setValueAt(rs.getString("nombre"), row, column + 1);
            tabla1.setValueAt(rs.getString("dni"), row, column + 2);
            row++;
        }
        // Se cierra la conexión a la base de datos.
        cn.desconectar();
    }

    /**
     * Actualiza los datos de una tabla en la base de datos a partir de un modelo de tabla.
     *
     * @param modeloDatos Modelo de tabla con los datos actualizados.
     * @param nombreTabla Nombre de la tabla que se actualizará.
     * @return El modelo de tabla actualizado.
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
    public DefaultTableModel actualizarDatos(DefaultTableModel modeloDatos, String nombreTabla) throws SQLException {
        cn.conectar();
        metaDatos = cn.getConnection().getMetaData();
        ResultSet rset = metaDatos.getColumns(null, null, nombreTabla, null);
        String newValues = "";

        for (int i = 0; i < modeloDatos.getRowCount(); i++) {
            newValues = "";
            for (int j = 0; j < modeloDatos.getColumnCount(); j++) {
                newValues += modeloDatos.getColumnName(j) + " ='" + modeloDatos.getValueAt(i, j).toString() + "',";
            }
            newValues = newValues.substring(0, newValues.length() - 1);
            // Se construye la consulta SQL para la actualización de datos.
            String consulta = "UPDATE " + nombreTabla.toLowerCase() + " SET " + newValues + " WHERE (" + primaryKey + "=" + primaryKeyValue.get(i) + ")";
            System.out.println(consulta);
            cn.ejecutarIDU(consulta);
        }

        // Se cierra la conexión a la base de datos.
        cn.desconectar();
        return modeloDatos;
    }

    /**
     * Realiza una consulta SQL con un operador LIKE en una tabla de la base de datos.
     *
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
    public void like() throws SQLException {
        cn.conectar();
        // Se construye la consulta SQL con el operador LIKE.
        String consulta = "select * FROM paciente where dni like '79%'";
        cn.ejecutarIDU(consulta);
        // Se cierra la conexión a la base de datos.
        cn.desconectar();
    }

    /**
     * Realiza una consulta SQL con una operación JOIN en la base de datos y muestra los resultados en una tabla en la interfaz gráfica.
     *
     * @param tabla2 Tabla en la que se mostrarán los resultados de la consulta.
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
    public void join(JTable tabla2) throws SQLException {
        cn.conectar();
        // Se construye la consulta SQL con la operación JOIN.
        String consulta = "SELECT rol from usuario JOIN doctor ON idusuario = fk_idusuario where iddoctor=2";

        ResultSet rs = cn.ejecutarSelect(consulta);
        int row = 0;
        int column = 0;
        while (rs.next()) {
            tabla2.setValueAt(rs.getInt("rol"), row, column);
            row++;
        }

        cn.ejecutarIDU(consulta);
        // Se cierra la conexión a la base de datos.
        cn.desconectar();
    }

    /**
     * Realiza una consulta SQL con una operación GROUP BY en la base de datos y muestra los resultados en una tabla en la interfaz gráfica.
     *
     * @param tabla3 Tabla en la que se mostrarán los resultados de la consulta.
     * @throws SQLException En caso de errores en la ejecución de la consulta SQL.
     */
    public void groupBy(JTable tabla3) throws SQLException {
        cn.conectar();
        // Se construye la consulta SQL con la operación GROUP BY.
        String consulta = "SELECT rol from usuario GROUP BY rol";

        ResultSet rs = cn.ejecutarSelect(consulta);
        int row = 0;
        int column = 0;
        while (rs.next()) {
            tabla3.setValueAt(rs.getInt("rol"), row, column);
            row++;
        }

        cn.ejecutarIDU(consulta);
        // Se cierra la conexión a la base de datos.
        cn.desconectar();
    }
}