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
public class Pregunta {
    private static int cantidadPreguntas = 0;
    private int ID;
    private ListaRespuestas listaRespuestas;
    private ListaEtiquetas listaEtiquetas;
    private String titulo;
    private String contenido;
    private String fecha;
    private String autor;
    private boolean estado;
    private ListaRecompensas listaRecompensa;

    public Pregunta(String titulo, String contenido,ListaEtiquetas etiquetas,String autor) {  
        this.ID = cantidadPreguntas;
        cantidadPreguntas++;
        this.listaRespuestas = new ListaRespuestas();
        this.listaEtiquetas = etiquetas;
        this.listaRecompensa = new ListaRecompensas();
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = "fecha";
        this.autor = autor;
        this.estado = false;  
    }

    public int getID() {
        return ID;
    }

    public String getContenido() {
        return contenido;
    }

    public String getAutor() {
        return autor;
    }

    public ListaRespuestas getListaRespuestas() {
        return listaRespuestas;
    }
    
    
    
}
