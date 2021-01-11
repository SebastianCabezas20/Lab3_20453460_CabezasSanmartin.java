/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author Sebastian Cabezas
 */
/* Clase que correspondera a una representacion del usuario
*/
public class Usuario {
    private String username; //Nombre del usuario
    private String pass; // Contraseña del usuario
    private int reputacion; //reputacion real 
    private int reputacionRelativa; //Reputacion que ayudara a controlar la cantidad de recompensas
    
    /*Permite construir un usuario*/
    public Usuario(String username, String pass) {
        this.username = username;
        this.pass = pass;
        this.reputacion = 1000;
        this.reputacionRelativa = 1000;
    }
    /*Perimite obtener el username del usuario
    @return corresponde a un String con el nombre del usuario*/
    public String getUsername() {
        return username;
    }
    /*Perimite obtener el pass del usuario
    @return corresponde a un String con la contraseña del usuario*/
    public String getPass() {
        return pass;
    }
    /*Perimite obtener reputacion obsoluta del usuario
    @return corresponde a un entero con la reputacion absoluta del usuario*/
    public int getReputacion() {
        return reputacion;
    }
    /*Perimite obtener reputacion relativa del usuario
    @return corresponde a un entero con la reputacion relativa del usuario*/
    public int getReputacionRelativa() {
        return reputacionRelativa;
    }
    /*Perimite restar reputacion relativa al usuario
    @param Reputacion corresponde a la reputacion ofrecida*/
    public void restarReputacionRelativa (int Reputacion){
        this.reputacionRelativa = this.reputacionRelativa - Reputacion;
    }
    /*Perimite restar reputacion obsoluta al usuario
    @param Reputacion corresponde a la reputacion ofrecida*/
    public void restarReputacionAbsoluta (int Reputacion){
        this.reputacion = this.reputacion - Reputacion;
    }
    /*Perimite sumar reputacion obsoluta al usuario
    @param Reputacion corresponde a la reputacion ofrecida*/
    public void sumarReputacionAbsoluta (int Reputacion){
        this.reputacion = this.reputacion + Reputacion;
    }
    /*Perimite sumar reputacion relativa al usuario
    @param Reputacion corresponde a la reputacion ofrecida*/
    public void sumarReputacionRelativa (int Reputacion){
        this.reputacionRelativa = this.reputacionRelativa + Reputacion;
    }
    /*Permite imprimir a un usuario
    @return retornara un String que correspondera a los datos del usuario*/
    public String imprimir(){
        return this.username + " reputacion absoluta: " + this.reputacion + " reputacion relativa: " + this.reputacionRelativa;
    }
}
