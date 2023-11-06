/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * La clase ConexionMySQL se utiliza para gestionar la conexión a una base de datos MySQL
 * y ejecutar consultas SQL.
 */
public class ConexionMySQL {
    
    // Variables de configuración para la conexión a la base de datos MySQL.
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/practicajdbc?useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "1234";
    
    // Variables para la gestión de la conexión y metadatos de la base de datos.
    Statement stm = null;
    DatabaseMetaData databaseMetaData;
    Connection cn = null;

    /**
     * Constructor de la clase que inicializa la conexión con la base de datos.
     */
    public ConexionMySQL() {
        try {
            // Carga el controlador JDBC de MySQL.
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }

    /**
     * Establece una conexión con la base de datos MySQL y obtiene información sobre las tablas.
     *
     * @return La conexión establecida.
     */
    public Connection conectar() {
        try {
            cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            
            // Obtiene información sobre las tablas en la base de datos y la almacena en databaseMetaData.
            databaseMetaData = cn.getMetaData();
            ResultSet tables = databaseMetaData.getTables(null, null, "%", null);
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
            }
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        return cn;
    }

    /**
     * Cierra la conexión a la base de datos si está abierta.
     *
     * @throws SQLException Si ocurre un error al cerrar la conexión.
     */
    public void desconectar() throws SQLException {
        if (cn != null && cn.isClosed()) {
            cn.close();
        }
    }

    /**
     * Ejecuta una consulta SQL de tipo SELECT y devuelve un ResultSet con los resultados.
     *
     * @param consulta La consulta SELECT a ejecutar.
     * @return Un ResultSet con los resultados de la consulta.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public ResultSet ejecutarSelect(String consulta) throws SQLException {
        Statement stmt = cn.createStatement();
        ResultSet rset = stmt.executeQuery(consulta);
        return rset;
    }

    /**
     * Ejecuta una consulta SQL de tipo INSERT, UPDATE o DELETE y devuelve el número de filas afectadas.
     *
     * @param consulta La consulta INSERT, UPDATE o DELETE a ejecutar.
     * @return El número de filas afectadas por la consulta.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public int ejecutarIDU(String consulta) throws SQLException {
        Statement stmt = cn.createStatement();
        int fila = stmt.executeUpdate(consulta);
        return fila;
    }

    /**
     * Obtiene los metadatos de la base de datos.
     *
     * @return El objeto DatabaseMetaData con información sobre la base de datos.
     */
    public DatabaseMetaData getDatabaseMetaData() {
        return databaseMetaData;
    }
    
    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public Connection getConnection() {
        return cn;
    }
}
