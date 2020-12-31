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
    public void imprimir(){
        for(int i = 0; i < this.preguntas.size();i++){
            System.out.println(this.preguntas.get(i).getID()+this.preguntas.get(i).getID());//representacion de la pregunta
        }
    }
    public int cantidadPreguntas(){
        return this.preguntas.size();
    }
    public Pregunta getPregunta(int index){
        return this.preguntas.get(index);
    }
    
}
