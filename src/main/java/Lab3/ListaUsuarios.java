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
public class ListaUsuarios {
    static int cantidadUsuarios = 0;
    ArrayList<Usuario> ListaUsuarios;

    public ListaUsuarios() {
        this.ListaUsuarios = new ArrayList();
    }
    public Usuario getUsuario(int index){
        return this.ListaUsuarios.get(index);
    }
    public boolean verificarUsuario(String username){//Verificar que no exista usermane ingresado
        for(int i = 0; i < this.ListaUsuarios.size();i++){
            if(this.ListaUsuarios.get(i).getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
    public void agregarUsuario(Usuario usuario){
        this.ListaUsuarios.add(usuario);
    }

    int autenticar(String username, String pass) {
        for(int i = 0; i < this.ListaUsuarios.size(); i++){
           if((this.ListaUsuarios.get(i).getUsername().equals(username)) && (this.ListaUsuarios.get(i).getPass().equals(pass))){
               return i;
           } 
        }
        return -1;
    }
    public Usuario getUsuarioUsername(String username){
        for(int i= 0;i < this.ListaUsuarios.size();i++){
            if(this.ListaUsuarios.get(i).getUsername().equals(username)){
                return this.ListaUsuarios.get(i);
            }
        }
        return null;
    }
}
