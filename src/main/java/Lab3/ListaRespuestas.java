/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.ArrayList;

/**
 *
 * @author Sebasti�n
 */
public class ListaRespuestas {
    ArrayList<Respuesta> listaRespuesta;

    public ListaRespuestas() {
        this.listaRespuesta = new ArrayList<>();
    }
    public void agregarRespuesta(Respuesta respuesta){
        this.listaRespuesta.add(respuesta);
    }
    
    
}
