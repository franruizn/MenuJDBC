/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * La clase Usuario representa la información de un usuario en el sistema de gestión de consultas médicas.
 * Contiene detalles sobre el usuario, incluyendo su identificador, contraseña y rol.
 *
 * @author franr
 */
public class Usuario {
    private String idusuario;  // Identificador del usuario.
    private String pass;      // Contraseña del usuario.
    private int rol;           // Rol del usuario.

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con parámetros.
     *
     * @param idusuario Identificador del usuario.
     * @param pass Contraseña del usuario.
     * @param rol Rol del usuario.
     */
    public Usuario(String idusuario, String pass, int rol) {
        this.idusuario = idusuario;
        this.pass = pass;
        this.rol = rol;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return El identificador del usuario.
     */
    public String getIdusuario() {
        return idusuario;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param idusuario El identificador del usuario.
     */
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param pass La contraseña del usuario.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Obtiene el rol del usuario.
     *
     * @return El rol del usuario.
     */
    public int getRol() {
        return rol;
    }

    /**
     * Establece el rol del usuario.
     *
     * @param rol El rol del usuario.
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

    /**
     * Devuelve una representación en cadena de la clase Usuario.
     *
     * @return Una cadena que representa la instancia de Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", pass=" + pass +
                ", rol=" + rol +
                '}';
    }
}
