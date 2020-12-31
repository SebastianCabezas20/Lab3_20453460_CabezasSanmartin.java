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
    private static int cantidadRespuestas = 0;
    private int ID;
    private String contenido;
    private String autor;
    private String fecha;
    private int preguntaRespondida;

    public Respuesta(int ID, String contenido, String autor, String fecha, int preguntaRespondida) {
        cantidadRespuestas++;
        this.ID = ID;
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = fecha;
        this.preguntaRespondida = preguntaRespondida;
    }
}
