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
public class ListaRecompensas {
    ArrayList<Recompensa> listaRempensa;

    public ListaRecompensas() {
        this.listaRempensa = new ArrayList<>();
    }
    public void agregarRecompensa(Recompensa recompensa){
        this.listaRempensa.add(recompensa);
    }
    public int cantidadRecompensas(){
        return this.listaRempensa.size();
    }
    public Recompensa getRecompensa(int index){
        return this.listaRempensa.get(index);
    }
    
}
