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
            if(!this.preguntas.get(i).getEstado()){
                System.out.println(this.preguntas.get(i).getID()+this.preguntas.get(i).getContenido());//representacion de la pregunta
            }
        }
    }
    public int cantidadPreguntas(){
        return this.preguntas.size();
    }
    public Pregunta getPregunta(int ID){
        for(int i = 0;i < this.preguntas.size(); i++){
            if(this.preguntas.get(i).getID() == ID){
                return this.preguntas.get(i);
            }
        }
        return null;
    }
    public void filtrarPreguntas(String username){
        for(int i = 0; i < this.preguntas.size();i++){
            if(this.preguntas.get(i).getAutor().equals(username)){//Caso que la pregunta se del usuario
                System.out.println(this.preguntas.get(i).getContenido());
                int respuestas = 0;
                for(int j = 0; j < this.preguntas.get(i).getListaRespuestas().cantidadRespuestas();j++){
                    if(!this.preguntas.get(i).getListaRespuestas().getRespuesta(j).getEstado()){//Caso que la respuesta no haya sido respondida
                        System.out.println(this.preguntas.get(j).getListaRespuestas().getRespuesta(j).getID());
                        respuestas++;
                    }
                }
                if(respuestas == 0){
                    System.out.println("NO TIENE RESPUESTAS PENDIENTES");
                }
            }
        }
    }
    public boolean perteneceRespuesta(int IDPregunta,int IDRespuesta){
        if(this.getPregunta(IDPregunta).getListaRespuestas().getRespuesta(IDPregunta) == null){
            return true;
        }
        else{
            return false;
        }
    }
}
