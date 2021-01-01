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
public class ListaRespuestas {
    ArrayList<Respuesta> listaRespuesta;

    public ListaRespuestas() {
        this.listaRespuesta = new ArrayList<>();
    }
    public void agregarRespuesta(Respuesta respuesta){
        this.listaRespuesta.add(respuesta);
    }
    public int cantidadRespuestas(){
        return this.listaRespuesta.size();
    }
    public Respuesta getRespuesta(int ID){
        for(int i = 0; i < this.listaRespuesta.size();i++){
            if(this.listaRespuesta.get(i).getID() == ID){
                return this.listaRespuesta.get(i);
            }
        }
        return null;
    }
}

