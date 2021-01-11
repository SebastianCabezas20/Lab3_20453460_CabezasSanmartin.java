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
/* Clase que correspondera a una recompensa dentro del stack
*/
public class Recompensa {
    private int reputacion;// Cantidad de recompensa en reputacion
    private int usuarioRecompensa;// Index del usuario que ofrecio recompemsa
    /*permite construir una recompensa*/
    public Recompensa(int reputacion, int usuarioRecompensa) {
        this.reputacion = reputacion;
        this.usuarioRecompensa = usuarioRecompensa;
    }
    /*Perimite obtener la cantidad de la recompensa
    @return cantidad de la recompensa*/
    public int getReputacion() {
        return reputacion;
    }
    /*Perimite obtener el index del usuario que la ofrecio la recompensa
    @return index del usuario*/
    public int getUsuarioRecompensa() {
        return usuarioRecompensa;
    }
    
}
