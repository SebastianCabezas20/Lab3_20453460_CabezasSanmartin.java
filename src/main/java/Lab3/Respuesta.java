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
public class Respuesta {
    private static int cantidadRespuestas = 1;
    private int ID;
    private String contenido;
    private String autor;
    private String fecha;
    private int preguntaRespondida;

    public Respuesta(String contenido, String autor, int preguntaRespondida) {
        this.ID = cantidadRespuestas;
        cantidadRespuestas++;
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = "FECHA";
        this.preguntaRespondida = preguntaRespondida;
    }
}
