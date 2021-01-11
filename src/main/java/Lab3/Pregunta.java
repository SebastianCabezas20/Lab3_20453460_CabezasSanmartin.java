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
/*Clase que representa un pregunta dentro del stack*/

public class Pregunta {
    private int ID;// ID unico
    private ListaEtiquetas listaEtiquetas; //Lista con las etiquetas de la pregunta
    private String titulo;
    private String contenido;
    private Date fecha;
    private String autor;
    private boolean estado;//Si existen preguntas aceptadas
    private ListaRecompensas listaRecompensa;
    private int votosPositivos;
    private int votosNegativos;
    
    /*
    Constructor de una pregunta
    @param ID, ID de la pregunta
    @param titulo, String que contiene el titulo de la pregunta
    @param contenido String que contiene el contenido de la pregunta
    @param etiqeutas se refiere a la clase ListaEtiquetas
    @param autor corresponde al autor de la pregunta*/
    public Pregunta(int ID,String titulo, String contenido,ListaEtiquetas etiquetas,String autor) {
        this.votosPositivos = 0;
        this.votosNegativos = 0;
        this.ID = ID;
        this.listaEtiquetas = etiquetas;
        this.listaRecompensa = new ListaRecompensas();
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = new Date();
        this.autor = autor;
        this.estado = false;  
    }

   /*Permite obtener el autor e la pregunta
    @return retorna el nombre del usuario*/ 
    public String getAutor() {
        return autor;
    }
    /*Permite obtener el estado de la pregunta
    @return retorna el estado de la pregunta que corresponde a un boolean*/ 
    public boolean getEstado() {
        return estado;
    }
    /*Permite cambiar el estaod de la pregunta
    @param estado corresponde a un booleano que sera el nuevo estado
    */ 
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /*Permite obtener la lista de recompensas de la pregunta
    @return retorna la clase lista de recompensas*/
    public ListaRecompensas getListaRecompensa() {
        return listaRecompensa;
    }
    
    /*Permite obtener el id de la pregunta
    @return retorna el numero del ID*/ 
    public int getID() {
        return ID;
    }

    /*Permite imprimir la pregunta 
    */ 
    public void imprimir(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        if(!this.estado){
        System.out.println("\n          " + this.titulo + "\n" +" ID:" + this.ID + "   El usuario " + this.autor + "    pregunta : \n " 
        + this.contenido + "         Votos   Dislike: " + this.votosNegativos + "   Like "+ this.votosPositivos + "\n " 
        + sdf.format(this.fecha) + "  estado:  " + this.estado + "  Recompensa asociada: " + this.listaRecompensa.sumarRecompensas());
        }else{
        System.out.println("\n          " + this.titulo + "\n" +" ID:" + this.ID + "   El usuario " + this.autor + "    pregunta : \n " 
        + this.contenido + "         Votos   Dislike: " + this.votosNegativos + "   Like "+ this.votosPositivos + "\n " 
        + sdf.format(this.fecha) + "  estado:  " + this.estado + "   Recompensa desactivada \n"
        + "etiquetas: ");this.listaEtiquetas.imprimirNombre();
        }
    }
   /*Permite obtener aumentar la cantidad de votos, se negativo o positivo
    @return retorna una confirmacion en booleano*/ 
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
