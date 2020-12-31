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

    public Pregunta(String titulo, String contenido, String fecha, String autor) {  
        cantidadPreguntas++;
        this.ID = cantidadPreguntas;
        this.listaRespuestas = new ListaRespuestas();
        this.listaEtiquetas = new ListaEtiquetas();
        this.listaRecompensa = new ListaRecompensas();
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.autor = autor;
        this.estado = false;
        
    }
    
    
}
