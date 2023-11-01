/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ivanf
 */
public class ControladorUsuario {
    private ConexionMySQL con;

    public ControladorUsuario(ConexionMySQL con) {
        this.con = con;
    }
    
    public ArrayList<Usuario> obtenerUsuarios() throws SQLException, ClassNotFoundException { // Va a devolver un ArrayList de Jugadores

        ArrayList<Usuario> lista = new ArrayList<>();
        String consulta = "SELECT * FROM usuario";
        ResultSet rset = con.ejecutarSelect(consulta);
        while (rset.next()) {
            String idusuario = rset.getString("idusuario");
            String pass = rset.getString("pass");
            int rol = rset.getInt("rol");
            Usuario u = new Usuario(idusuario, pass, rol);
            lista.add(u);
        }

        return lista;
    }
    
    public void insertarUsuario(Usuario user) throws SQLException, ClassNotFoundException {

        String consulta = "INSERT INTO usuario VALUES('" + user.getIdusuario() + "','" + user.getPass() + "'," 
                + user.getRol()+")";
        
        try {
            con.ejectutarIDU(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    public void borrarUsuario(Usuario user) throws SQLException, ClassNotFoundException{
        String consulta = "DELETE FROM usuario WHERE (idusuario = '"+user.getIdusuario()+"');";
        con.ejectutarIDU(consulta);
    }
    public void borrarUsuario(Usuario user) throws SQLException, ClassNotFoundException{
        String consulta = "DELETE FROM doctor WHERE (idusuario = "+user.getIdusuario()+");";
        con.ejectutarIDU(consulta);
    }
}
