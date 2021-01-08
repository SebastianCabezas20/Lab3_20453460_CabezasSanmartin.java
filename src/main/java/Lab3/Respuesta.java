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
 * @author Sebastián
 */
public class Respuesta {
    private int ID;
    private String contenido;
    private String autor;
    private Date fecha;
    private int preguntaRespondida;
    private boolean estado;//No aceptado
    private int votosPositivos;
    private int votosNegativos;

    public Respuesta(int IDGeneral,String contenido, String autor, int preguntaRespondida) {
        this.votosPositivos = 0;
        this.votosNegativos = 0;
        this.ID = IDGeneral;
        this.contenido = contenido;
        this.estado = false;
        this.autor = autor;
        this.fecha = new Date();
        this.preguntaRespondida = preguntaRespondida;
    }
    
    public void imprimirRespuesta(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println("   ID: " + this.ID + "  el usuario: " + this.autor+ "  contesto: \n"
        +"   " + this.contenido+ "   Votos   Dislike: " + this.votosNegativos + "    Like: " + this.votosPositivos + "\n " 
        +"  " + sdf.format(this.fecha)+ "  estado: " + this.getEstado());
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

    public int getVotosPositivos() {
        return votosPositivos;
    }

    public int getVotosNegativos() {
        return votosNegativos;
    }
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
