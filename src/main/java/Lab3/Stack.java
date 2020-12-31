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
public class Stack {
    private ListaUsuarios listaUsuarios;
    private ListaPreguntas listaPreguntas;
    private ListaEtiquetas listaEtiquetas;
    private int indexActivo;

    public Stack() {
        this.listaUsuarios = new ListaUsuarios();
        this.listaPreguntas = new ListaPreguntas();
        this.listaEtiquetas = new ListaEtiquetas();
        this.indexActivo = -1;
    }

    public int getIndexActivo() {
        return indexActivo;
    }

    public void setIndexActivo(int indexActivo) {
        this.indexActivo = indexActivo;
    }

    public ListaUsuarios getListaUsuarios() {
        return listaUsuarios;
    }

    public ListaPreguntas getListaPreguntas() {
        return listaPreguntas;
    }

    public ListaEtiquetas getListaEtiquetas() {
        return this.listaEtiquetas;
    }
    public void Registrar(String username,String pass){
        if(this.listaUsuarios.verificarUsuario(username)){
            this.listaUsuarios.agregarUsuario(new Usuario(username,pass));
            System.out.println("USUARIO REGISTRADO CON EXITO");
        }
        else{
            System.out.println("USERNAME YA EXISTE");
        }
    }
    public boolean login(String usermane,String pass){
        int index = this.listaUsuarios.autenticar(usermane, pass);
        if(index != -1){
            this.indexActivo = index;
            return true;
        }
        else{
            System.out.println("USERNAME Y/O CONTRASEÑA INCORRECTA");
            return false;
        }
    }
    public boolean logout(String username,String pass){
        if(this.listaUsuarios.getUsuario(this.indexActivo).getUsername().equals(username) && this.listaUsuarios.getUsuario(this.indexActivo).getPass().equals(pass)){
            this.indexActivo = -1;
            return true;
        }
        else{
            System.out.println("USERNAME Y/O CONTRASEÑA INCORRECTA");
            return false;
        }
    }
    public void ask(String titulo,String contenido,ListaEtiquetas etiquetas){
        Pregunta pregunta = new Pregunta(titulo,contenido,etiquetas,this.listaUsuarios.getUsuario(this.indexActivo).getUsername());
        this.listaPreguntas.agregarPregunta(pregunta);
    }
    public void answer(int ID,String contenido){
        Respuesta respuesta = new Respuesta(contenido,this.listaUsuarios.getUsuario(this.indexActivo).getUsername(),ID);
        this.listaPreguntas.getPregunta(ID).getListaRespuestas().agregarRespuesta(respuesta);//get pregunta
    }
    public void reward(int ID, int recompensa){
        if(ID >= this.listaPreguntas.cantidadPreguntas() && ID >= 0 && this.listaPreguntas.verificarEstado(ID)){//verificar estado
            System.out.println("EL ID INGRESADO NO VALIDO");
        }
        else{
           if(recompensa <= this.listaUsuarios.getUsuario(this.indexActivo).getReputacionRelativa()){
               Recompensa nuevaRecompensa = new Recompensa(recompensa,this.indexActivo);
               this.getListaUsuarios().getUsuario(this.indexActivo).restarReputacionRelativa(recompensa);
               this.listaPreguntas.getPregunta(ID).getListaRecompensa().agregarRecompensa(nuevaRecompensa);
           }
           else{
               System.out.println("NO POSEE LA SUFICIENTE REPUTACION");
           }
        }     
    }
    
}
