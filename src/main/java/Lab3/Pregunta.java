/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.ArrayList;

/**
 *
 * @author Sebastián
 */
public class Pregunta {
    static int cantidadPreguntas = 0;
    int ID;
    ArrayList<Integer> listaRespuestas;//<int>
    //Etiquetas etiquetas;
    String titulo;
    String contenido;
    String fecha;
    String autor;
    boolean estado;
    int recompensa;
    String usuarioRecompensa;

    public Pregunta(String titulo, String contenido, String fecha, String autor) {
        
        cantidadPreguntas++;
        this.ID = cantidadPreguntas;
        this.listaRespuestas = new ArrayList<>();
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.autor = autor;
        this.estado = false;
        this.recompensa = 0;
        this.usuarioRecompensa = null;
        
    }
    
    
}
