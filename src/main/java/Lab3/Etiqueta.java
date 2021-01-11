/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author Sebastián
 */
public class Etiqueta {
    private String etiqueta;// Nombre de la etiqueta
    private String descripcion;//Descripcion de la etiqueta

    /*Crea un etiqueta
    @param etiqueta es el nombre de la etiqueta
    @param descripcion de la etiqueta*/
    public Etiqueta(String etiqueta, String descripcion) {
        this.etiqueta = etiqueta;
        this.descripcion = descripcion;
    }
    /*Permite retornar el nombre de la etiqueta
    @return Nombre de la etiqueta en String
    */
    public String getEtiqueta() {
        return etiqueta;
    }
    /*Permite retornar la descripcion de la etiqueta
    @return descripcion de la etiqueta en String
    */
    public String getDescripcion() {
        return descripcion;
    }
   
    
    
}
