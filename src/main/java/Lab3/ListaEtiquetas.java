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
/*Clase que corresponde a una lista de objetos de la clase Etiqueta*/
public class ListaEtiquetas {
    ArrayList<Etiqueta> listaEtiquetas; //ArrayList que contendra las Etiquetas
    /*crea la lista de etiquetas*/
    public ListaEtiquetas() {
        this.listaEtiquetas = new ArrayList<>();
    }
    /*
    agrega una etiqueta al stack
    @param etiqueta, corresponde a una clase etiqueta*/
    public void agregarEtiqueta(Etiqueta etiqueta){
        this.listaEtiquetas.add(etiqueta);
    }
    /*
    permite imprimir una etiqueta
    */
    public void imprimir(){
        for(int i = 0;i < this.listaEtiquetas.size();i++){
            System.out.println("- "+(i+1)+this.listaEtiquetas.get(i).getEtiqueta()+"    descripcion"+this.listaEtiquetas.get(i).getDescripcion());
        }
    }
    public void imprimirNombre(){
         for(int i = 0;i < this.listaEtiquetas.size();i++){
            System.out.println(this.listaEtiquetas.get(i).getEtiqueta());
        }
    }
    /*
    Permite verificar si existe nombre en la lista de etiquetas
    @param nombreEtiqueta, corresponde a nombre de etiqueta a buscar
    @return boolean que indica si se verifica o no*/
    public boolean verificarNombre(String nombreEtiqueta){
        for(int i = 0;i < this.listaEtiquetas.size();i++){
            if(this.listaEtiquetas.get(i).getEtiqueta().equals(nombreEtiqueta)){ //Si existe el nombre en la lista de etiquetas
                return true;
            }
        }
        return false;
    }
    /*
    Permite buscar una etiqueta mediante su nombre
    @param nombreEtiqueta, corresponde al nombre de la etiqueta
    @return Etiqueta, corresponde a la etiqueta buscada*/
    public Etiqueta buscador(String nombreEtiqueta){
        for(int i = 0;i < listaEtiquetas.size();i++){
            if(this.listaEtiquetas.get(i).getEtiqueta().equals(nombreEtiqueta)){ //Si coincide el nombre de la etiqueta, se retorna
                return this.listaEtiquetas.get(i);
            }
        }
        return null;
    }
}
