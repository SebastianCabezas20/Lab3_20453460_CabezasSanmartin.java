/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sebastián
 */
public class Pregunta {
    private int ID;
    private ListaEtiquetas listaEtiquetas;
    private String titulo;
    private String contenido;
    private Date fecha;
    private String autor;
    private boolean estado;//Si existen preguntas aceptadas
    private ListaRecompensas listaRecompensa;
    private int votosPositivos;
    private int votosNegativos;

    public Pregunta(int ID,String titulo, String contenido,ListaEtiquetas etiquetas,String autor) {
        this.votosPositivos = 0;
        this.votosNegativos = 0;
        this.ID = ID;
        this.listaEtiquetas = etiquetas;
        this.listaRecompensa = new ListaRecompensas();
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = new Date();
        this.autor = autor;
        this.estado = false;  
    }



    public String getContenido() {
        return contenido;
    }

    public String getAutor() {
        return autor;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ListaRecompensas getListaRecompensa() {
        return listaRecompensa;
    }

    public int getID() {
        return ID;
    }

    public int getVotosPositivos() {
        return votosPositivos;
    }

    public int getVotosNegativos() {
        return votosNegativos;
    }
    
    public void imprimir(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println("\n          " + this.titulo + "\n" +" ID:" + this.ID + "   El usuario " + this.autor + "    pregunta : \n " 
        + this.getContenido() + "         Votos   Dislike: " + this.votosNegativos + "   Like "+ this.votosPositivos + "\n " 
        + sdf.format(this.fecha) + "  estado  " + this.estado) ;
    }
   
    public boolean aumentarVoto(boolean opcion){
        if(opcion){
            this.votosPositivos++;
            return true;
        }
        else{
            this.votosNegativos++;
            return false;
        }
    }
    
}
