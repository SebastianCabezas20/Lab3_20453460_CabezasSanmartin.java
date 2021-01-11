/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Cabezas
 */
/*Clase que correspondera a una lista de preguntas, la cual contendra objetos de clase Pregunta*/

public class ListaPreguntas {
    ArrayList<Pregunta> preguntas; //ArrayList que contendra las Preguntas
    /*Perimite crear una lista de preguntas*/
    public ListaPreguntas() {
        this.preguntas = new ArrayList<>();
    }
    /*
    Permite agregar pregunta a lista de preguntas*/
    public void agregarPregunta(Pregunta pregunta){
        this.preguntas.add(pregunta);
    }
    /*Permite obtener la cantidad de preguntas que hay en la lista
    @return cantidad de preguntas
    */
    public int cantidadPreguntas(){
        return this.preguntas.size();
    }
    /*
    Permite imprimir preguntas de la lista
    */
    public void imprimirPreguntas(){
        for(int i = 0; i < this.preguntas.size();i++){
            this.preguntas.get(i).imprimir();
        }
    }
    /*Permite imprimir las preguntas que aun no obtienen recompensa*/
    public void imprimirPreguntasRecompensa(){
        for(int i = 0; i < this.preguntas.size();i++){
            if(!this.preguntas.get(i).getEstado()){//Caso que no tengan respuestas asociadas
                this.preguntas.get(i).imprimir();
            }
        }
    }
    /*Permite verificar que existe ID 
    @param ID, ID a verificar
    @return boolean que indicara si se verifica*/
    public boolean verificarIDPregunta(int ID){
        for(int i = 0;i < this.preguntas.size(); i++){
            if(this.preguntas.get(i).getID() == ID){//Caso que incidan los IDs
                return true;
            }
        }
        return false;
    }
    /*Permite verificar que ID y username coinciden 
    @param ID, ID a verificar
    @param username, nombre de usuario a verificar
    @return boolean que indicara si se verifica*/
   public boolean verificarUsername(int ID, String username){
       if(this.getPregunta(ID).getAutor().equals(username)){ //caso que el autor sea el username
           return true;
       }
       return false;
   }
   /*Permite obtener pregunta de lista preguntas mediante ID 
    @param ID, ID a buscar
    @return Pregunta, clase pregunta que se buscaba*/
    public Pregunta getPregunta(int ID){
        for(int i = 0; i < this.preguntas.size();i++){
            if(this.preguntas.get(i).getID() == ID){ //caso que coincidan los IDs
                return this.preguntas.get(i);
            }
        }
        return null;
    }
    /*Permite obtener pregunta de lista preguntas mediante index 
    @param index a buscar
    @return Pregunta, clase pregunta que se buscaba*/
     public Pregunta getPreguntaIndex(int index){
        return this.preguntas.get(index);
    }
 
    
}
