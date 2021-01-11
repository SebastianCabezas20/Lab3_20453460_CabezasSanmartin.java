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
/*Clase que representara la una lista de usuarios que contendra ojetos de la clase Usuario*/
public class ListaUsuarios {
    ArrayList<Usuario> ListaUsuarios; // ArrayList que contendra los usuarios
    /*Crea una lista de usuarios*/
    public ListaUsuarios() {
        this.ListaUsuarios = new ArrayList();
    }
    /*
    Permite obtener un usuario de la lista mediante su index
    @param index, numero del index del usuario
    @return Usuario del index*/
    public Usuario getUsuario(int index){
        return this.ListaUsuarios.get(index);
    }
    /*
    Permite verificar que no exista username ingresado
    @param username, nombre de usuario a verificar
    @return boolean que indica si se verifica o no*/
    public boolean verificarUsuario(String username){
        for(int i = 0; i < this.ListaUsuarios.size();i++){
            if(this.ListaUsuarios.get(i).getUsername().equals(username)){ // Si se encuentra el nombre
                return false;
            }
        }
        return true;
    }
    /*
    Permite agregar un usuario a la lista
    @param usuario, clase de usuario que se quiere agregar*/
    public void agregarUsuario(Usuario usuario){
        this.ListaUsuarios.add(usuario);
    }
    /*
    Permite obtener verificar si conciden los datos a un usuario
    @param username, nombre de usuario a verificar
    @param pass, contraseña de usuario a verificar
    @return Retorna el index de usuario verificado*/
    public int autenticar(String username, String pass) {
        for(int i = 0; i < this.ListaUsuarios.size(); i++){
            //Caso que exista el username asociado a la contraseña
           if((this.ListaUsuarios.get(i).getUsername().equals(username)) && (this.ListaUsuarios.get(i).getPass().equals(pass))){
               return i;
           } 
        }
        return -1;
    }
    /*
    Permite obtener un usuario de la lista mediante su nombre
    @param username, useriname que sera buscado
    @return Usuario del username*/
    public Usuario getUsuarioUsername(String username){
        for(int i= 0;i < this.ListaUsuarios.size();i++){
            if(this.ListaUsuarios.get(i).getUsername().equals(username)){ //Retornar el usuario ya que existe
                return this.ListaUsuarios.get(i);
            }
        }
        return null;
    }
}
