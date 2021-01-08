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
    public int cantidadPreguntas(){
        return this.preguntas.size();
    }
    
    public void imprimirPreguntas(){
        for(int i = 0; i < this.preguntas.size();i++){
            this.preguntas.get(i).imprimir();
        }
    }
    
    public void imprimirPreguntasRecompensa(){
        for(int i = 0; i < this.preguntas.size();i++){
            if(!this.preguntas.get(i).getEstado()){
                this.preguntas.get(i).imprimir();
            }
        }
    }
    
    public boolean verificarIDPregunta(int ID){
        for(int i = 0;i < this.preguntas.size(); i++){
            if(this.preguntas.get(i).getID() == ID){
                return true;
            }
        }
        return false;
    }
   public boolean verificarUsername(int ID, String username){
       if(this.getPregunta(ID).getAutor().equals(username)){
           return true;
       }
       return false;
   }
   
    public Pregunta getPregunta(int ID){
        for(int i = 0; i < this.preguntas.size();i++){
            if(this.preguntas.get(i).getID() == ID){
                return this.preguntas.get(i);
            }
        }
        return null;
    }
     public Pregunta getPreguntaIndex(int index){
        return this.preguntas.get(index);
    }
 
    
}
