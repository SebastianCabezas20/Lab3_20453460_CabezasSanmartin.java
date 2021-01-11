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
/* Clase que correspondera a una lista de objetos de la clase Recompensa
*/
public class ListaRecompensas {
    private ArrayList<Recompensa> listaRecompensa; //ArrayList que almacenara las recompensas
    /*Construye una nueva lista de recompensas*/
    public ListaRecompensas() {
        this.listaRecompensa = new ArrayList<>();
    }
    /*Permite agregar una recompensa a la lista de recompensas
    @param recompensa corresponde a un onjeto de clase Recompensa*/
    public void agregarRecompensa(Recompensa recompensa){
        this.listaRecompensa.add(recompensa);
    }
    /*Calcular la cantidad de recompensas en la lista
    @return cantidad de recompensas */
    public int cantidadRecompensas(){
        return this.listaRecompensa.size();
    }
    /*Permite obtener una recompensa de la lista mediante su index
    @param index, correponde  al index de la pregunta a buscar
    @return objeto de clase Recompensa que corresponde a la recompensa en el index*/
    public Recompensa getRecompensa(int index){
        return this.listaRecompensa.get(index);
    }
    /*Perimite sumar todas las recompensas
    @return cantidad total de recompensas en reputacion*/
    public int sumarRecompensas(){
        int total = 0; //Contador total
        for(int i = 0; i < this.listaRecompensa.size(); i++)
        {
            total = total + this.listaRecompensa.get(i).getReputacion(); //Sumar cada una de las recompensas
        }
        return total;
    }
    
}
