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
    public void imprimir(){
        for(int i = 0;i < this.listaEtiquetas.size();i++){
            System.out.println("- "+(i+1)+this.listaEtiquetas.get(i).getEtiqueta()+"    descripcion"+this.listaEtiquetas.get(i).getDescripcion());
        }
    }
    public boolean verificarNombre(String nombreEtiqueta){
        for(int i = 0;i < this.listaEtiquetas.size();i++){
            if(this.listaEtiquetas.get(i).getEtiqueta().equals(nombreEtiqueta)){
                return true;
            }
        }
        return false;
    }
    public Etiqueta buscador(String nombreEtiqueta){
        for(int i = 0;i < listaEtiquetas.size();i++){
            if(this.listaEtiquetas.get(i).getEtiqueta().equals(nombreEtiqueta)){
                return this.listaEtiquetas.get(i);
            }
        }
        return null;
    }
}
