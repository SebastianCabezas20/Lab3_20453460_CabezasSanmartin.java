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
public class ListaPreguntas {
    ArrayList<Pregunta> preguntas;

    public ListaPreguntas() {
        this.preguntas = new ArrayList<>();
    }
    public void agregarPregunta(Pregunta pregunta){
        this.preguntas.add(pregunta);
    }

    
}
