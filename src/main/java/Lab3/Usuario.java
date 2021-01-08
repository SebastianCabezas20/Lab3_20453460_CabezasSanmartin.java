/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author Sebastián
 */
public class Usuario {
    private String username;
    private String pass;
    private int reputacion;
    private int reputacionRelativa;

    public Usuario(String username, String pass) {
        this.username = username;
        this.pass = pass;
        this.reputacion = 1000;
        this.reputacionRelativa = 1000;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getReputacion() {
        return reputacion;
    }

    public int getReputacionRelativa() {
        return reputacionRelativa;
    }
    
    public void restarReputacionRelativa (int Reputacion){
        this.reputacionRelativa = this.reputacionRelativa - Reputacion;
    }
    public void restarReputacionAbsoluta (int Reputacion){
        this.reputacion = this.reputacion - Reputacion;
    }
    public void sumarReputacionAbsoluta (int Reputacion){
        this.reputacion = this.reputacion + Reputacion;
    }
    public String imprimir(){
        return this.username + " reputacion: " + this.reputacion;
    }
}
