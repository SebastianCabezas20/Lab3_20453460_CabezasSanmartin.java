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
/*Clase que representa un lista de objetos tipo Respuesta*/

public class ListaRespuestas {
    private ArrayList<Respuesta> listaRespuesta; // ArrayList que almacenara las respuestas
    /*Constructor de lista respuestas*/
    public ListaRespuestas() {
        this.listaRespuesta = new ArrayList<>();
    }
    /*Permite agregar una respuesta a la lista de respuestas
    @param respuesta corresponde a una objeto de la clase Respuesta*/
    public void agregarRespuesta(Respuesta respuesta){
        this.listaRespuesta.add(respuesta); 
    }
    /*Permite obtener la cantidad total de respuestas
    @return retorna el numero de respuestas*/ 
    public int cantidadRespuestas(){
        return this.listaRespuesta.size();
    }
    /*Permite obtener una respuesta en base a su ID
    @param ID corresponde al ID buscado
    @return retorna un objeto de la clase Respuesta*/ 
    public Respuesta getRespuesta(int ID){
        for(int i = 0; i < this.listaRespuesta.size();i++){
            if(this.listaRespuesta.get(i).getID() == ID){ //Si coincide el ID se retorna la respuesta
                return this.listaRespuesta.get(i);
            }
        }
        return null;
    }
    /*Permite verificar si existe ID en la lista de respuestas
    @param ID corresponde al ID buscado
    @return retorna un booleano que indica si existe ID*/ 
    public boolean verificarID(int ID){
        for(int i = 0; i < this.listaRespuesta.size();i++){
            if(this.listaRespuesta.get(i).getID() == ID){ // Si existe ID
                return true;
            }
        }
        return false;
    }
    /*Permite imprimir respuesta de una determinada pregunta siempre que no este aceptada
    @param ID corresponde al ID de la pregunta */ 
    public void imprimirRespuestas(int IDPregunta){
        int respuestas = 0;// cantidad de respuestas en total
        for(int i = 0; i < this.listaRespuesta.size();i++){
            // Si tiene el ID de la pregunta buscada y el estado es no aceptada
            if(this.listaRespuesta.get(i).getPreguntaRespondida() == IDPregunta && !this.listaRespuesta.get(i).getEstado()){
                respuestas++;// Sumar cantidad de respuestas
                this.listaRespuesta.get(i).imprimirRespuesta(); // imprimir
            }
        }
        if(respuestas == 0){ // caso que no se encuentren respuestas que coincidan con los criterios
            System.out.println("NO TIENE RESPUESTAS PENDIENTES");
        }
    }
    /*Permite imprimir las respuestas que no sean de un usuario pero si de un ID pregunta determinado
    @param IDPregunta ID de la pregunta buscada
    @param username corresponde al nombre del usuario evitado*/ 
    public void imprimirRespuestasNoUser(int IDPregunta,String username){
        int respuestas = 0; // Cantidad de respuestas en total
        for(int i = 0; i < this.listaRespuesta.size();i++){
            //Si la respuesta es igual al ID de la pregunta y a sido aceptada y el autor no coincide con el username
            if(this.listaRespuesta.get(i).getPreguntaRespondida() == IDPregunta && this.listaRespuesta.get(i).getEstado() && !this.listaRespuesta.get(i).getAutor().equals(username)){
                respuestas++; //Sumamos cantidad de respuestas
                this.listaRespuesta.get(i).imprimirRespuesta();
            }
        }
        if(respuestas == 0){ // caso que no se encuentren respuestas para votar
            System.out.println("NO TIENE RESPUESTAS PARA VOTAR");
        }
    }
    /*permite imprimir todas las respuestas de una determinada pregunta
    @param ID corresponde al ID de la pregunta*/ 
    public void imprimirTotalRespuestas(int IDPregunta){
        for(int i = 0; i < this.listaRespuesta.size();i++){
            if(this.listaRespuesta.get(i).getPreguntaRespondida() == IDPregunta){ //Se comprueba que sea de la pregunta
                this.listaRespuesta.get(i).imprimirRespuesta();
            }
        }
    }
}

