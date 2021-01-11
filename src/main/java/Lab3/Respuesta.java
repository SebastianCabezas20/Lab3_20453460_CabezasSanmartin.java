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
 * @author Sebastian Cabezas
 */
/*Clase que representara un respuesta dentro del stack*/
public class Respuesta {
    private int ID; //ID unico 
    private String contenido; //Contenido de la respuesta
    private String autor; ///autor de la respuesta
    private Date fecha; // Fecha de publicacion
    private int preguntaRespondida; // ID de pregunta respondida
    private boolean estado;//No aceptado
    private int votosPositivos; //votos
    private int votosNegativos;
    
    /*Permite construir una respuesta
    @param IDGeneral ID de la respuesta
    @param contenido corresponde al contenido de la respuesta
    @param autor autor de la respuesta
    @param preguntaRespondida, ID de la pregunta a responder*/ 
    public Respuesta(int IDGeneral,String contenido, String autor, int preguntaRespondida) {
        this.votosPositivos = 0;
        this.votosNegativos = 0;
        this.ID = IDGeneral;
        this.contenido = contenido;
        this.estado = false; //Primeramente esta sin aceptar
        this.autor = autor;
        this.fecha = new Date();
        this.preguntaRespondida = preguntaRespondida;
    }
    /*Permite imprimir una respuesta*/
    public void imprimirRespuesta(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println("   ID: " + this.ID + "  el usuario: " + this.autor+ "  contesto: \n"
        +"   " + this.contenido+ "   Votos   Dislike: " + this.votosNegativos + "    Like: " + this.votosPositivos + "\n " 
        +"  " + sdf.format(this.fecha)+ "  estado: " + this.getEstado());
    }
    /*Permite obtener el ID de la respuesta
    @return ID de la respuesta que corresponde a un enntero*/ 
    public int getID() {
        return ID;
    }
    /*Permite obtener el estaod de la pregunta
    @return retorna el estado de la respuesta que en este caso es un boolean*/ 
    public boolean getEstado() {
        return estado;
    }
    /*Permite cambiar el estado de la respuesta
    @param estado, corresponde al nuevo estado de la respuesta*/ 
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /*Permite obtener el ID de la pregunta respondida
    @return ID de pregunta respondida de la respuesta*/ 
    public int getPreguntaRespondida() {
        return preguntaRespondida;
    }    
    /*Permite obtener el nombre del autor de la respuesta
    @return retorna el nombre del autor de la respuesta*/ 
    public String getAutor() {
        return autor;
    }
    /*Permite aumentar el voto negativo o positivo
    @param opcion da a conocer si es negativo o positivo
    @return booleano que permite verificar el voto*/
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
