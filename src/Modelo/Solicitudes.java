/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ivanf
 */
public class Solicitudes {
    private int idsolicitudes, fk_idconsulta;
    
    public Solicitudes(int idsolicitudes, int fk_idconsulta) {
        this.idsolicitudes = idsolicitudes;
        this.fk_idconsulta = fk_idconsulta;
    }

    public Solicitudes() {
    }

    public int getIdsolicitudes() {
        return idsolicitudes;
    }

    public void setIdsolicitudes(int idsolicitudes) {
        this.idsolicitudes = idsolicitudes;
    }

    public int getFk_idconsulta() {
        return fk_idconsulta;
    }

    public void setFk_idconsulta(int fk_idconsulta) {
        this.fk_idconsulta = fk_idconsulta;
    }

    
}
