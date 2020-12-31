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
public class ListaEtiquetas {
    ArrayList<Etiqueta> listaEtiquetas;

    public ListaEtiquetas() {
        this.listaEtiquetas = new ArrayList<>();
    }
    public void agregarEtiqueta(Etiqueta etiqueta){
        this.listaEtiquetas.add(etiqueta);
    }
    
}
