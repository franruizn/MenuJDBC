/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author franr
 */
public class Usuario {
    private String idusuario, pass;
    private int rol;

    public Usuario() {
    }

    public Usuario(String idusuario, String pass, int rol) {
        this.idusuario = idusuario;
        this.pass = pass;
        this.rol = rol;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", pass=" + pass + ", rol=" + rol + '}';
    }
    
}
