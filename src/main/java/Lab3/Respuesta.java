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
    private int IDGeneral;
    private static int cantidadRespuestas = 1;
    private int ID;
    private String contenido;
    private String autor;
    private String fecha;
    private int preguntaRespondida;
    private boolean estado = false;//No aceptado
    private int votosPositivos;
    private int votosNegativos;

    public Respuesta(int IDGeneral,String contenido, String autor, int preguntaRespondida) {
        this.votosPositivos = 0;
        this.votosNegativos = 0;
        this.IDGeneral = IDGeneral;
        this.ID = cantidadRespuestas;
        cantidadRespuestas++;
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = "FECHA";
        this.preguntaRespondida = preguntaRespondida;
    }

    public int getID() {
        return ID;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPreguntaRespondida() {
        return preguntaRespondida;
    }    

    public String getAutor() {
        return autor;
    }

    public int getIDGeneral() {
        return IDGeneral;
    }

    public int getVotosPositivos() {
        return votosPositivos;
    }

    public int getVotosNegativos() {
        return votosNegativos;
    }
    public void aumentarVoto(boolean opcion){
        if(opcion){
            this.votosPositivos++;
        }
        else{
            this.votosNegativos++;
        }
    }
    
}
