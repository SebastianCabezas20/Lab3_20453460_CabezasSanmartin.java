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
    private int IDgeneral;
    private ListaUsuarios listaUsuarios;
    private ListaPreguntas listaPreguntas;
    private ListaEtiquetas listaEtiquetas;
    private ListaRespuestas listaRespuestas;
    private int indexActivo;

    public Stack() {
        this.listaUsuarios = new ListaUsuarios();
        this.listaPreguntas = new ListaPreguntas();
        this.listaEtiquetas = new ListaEtiquetas();
        this.listaRespuestas = new ListaRespuestas();
        this.indexActivo = -1;
        this.IDgeneral = 1;
    }

    public ListaRespuestas getListaRespuestas() {
        return listaRespuestas;
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
        Pregunta pregunta = new Pregunta(this.IDgeneral,titulo,contenido,etiquetas,this.listaUsuarios.getUsuario(this.indexActivo).getUsername());
        this.listaPreguntas.agregarPregunta(pregunta);
        this.IDgeneral = this.IDgeneral +1;
    }
    public void answer(int ID,String contenido){
        if(!this.listaPreguntas.verificarIDPregunta(ID)){
            System.out.println("EL ID INGRESADO NO EXISTE");
        }
        else{         
            Respuesta respuesta = new Respuesta(this.IDgeneral,contenido,this.listaUsuarios.getUsuario(this.indexActivo).getUsername(),ID);
            this.listaPreguntas.getPregunta(ID).getListaRespuestas().agregarRespuesta(respuesta);
            this.cantidadTotalRespuestas = this.cantidadTotalRespuestas +1;
            this.IDgeneral = this.IDgeneral +1;
        }
    }
    public void reward(int ID, int recompensa){
        if(!this.listaPreguntas.verificarIDPregunta(ID) || this.listaPreguntas.getPregunta(ID).getEstado()){
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
    public void accept(int IDPregunta,int IDRespuesta){
        //Verificar que la pregunta exista 
        //Verificar que la pregunta sea del usuario
        if(!this.listaPreguntas.verificarIDPregunta(IDPregunta) ||
            this.listaPreguntas.verificarUsername(IDPregunta,this.listaUsuarios.getUsuario(this.indexActivo).getUsername())){
            System.out.println("ID DE PREGUNTA NO VALIDO");
        }
        ///Verificar que existe ID respuesta en la pregunta
        // Verificar que
        else if(!this.getListaPreguntas().getPregunta(IDPregunta).getListaRespuestas().verificarID(IDRespuesta)|| 
                this.listaPreguntas.getPregunta(IDPregunta).getListaRespuestas().getRespuesta(IDRespuesta).getEstado() 
                || this.listaPreguntas.perteneceRespuesta(IDPregunta, IDRespuesta) ){//verificar que exista la respuesta en la pregunta
            System.out.println("ID RESPUESTA NO VALIDO");
        }
        else{
            if(this.listaPreguntas.getPregunta(IDPregunta).getListaRecompensa().cantidadRecompensas() > 0 && !this.listaPreguntas.getPregunta(IDPregunta).getEstado()){//existe recompensa
                int recompensaTotal = 0;
                for(int i = 0; i < this.listaPreguntas.getPregunta(IDPregunta).getListaRecompensa().cantidadRecompensas();i++){
                    int recompensaCobrada = this.listaPreguntas.getPregunta(IDPregunta).getListaRecompensa().getRecompensa(i).getReputacion();
                    int indexOfrecido = this.listaPreguntas.getPregunta(IDPregunta).getListaRecompensa().getRecompensa(i).getUsuarioRecompensa();
                    recompensaTotal = recompensaTotal + recompensaCobrada;
                    this.listaUsuarios.getUsuario(indexOfrecido).restarReputacionAbsoluta(recompensaCobrada);
                }
                this.listaPreguntas.getPregunta(IDPregunta).setEstado(true);
                this.listaPreguntas.getPregunta(IDPregunta).getListaRespuestas().getRespuesta(IDRespuesta).setEstado(true);
                this.listaUsuarios.getUsuarioUsername(this.listaPreguntas.getPregunta(IDPregunta).getListaRespuestas()
                        .getRespuesta(IDRespuesta).getAutor()).sumarReputacionAbsoluta(recompensaTotal);
                
            }
            else{
               this.listaPreguntas.getPregunta(IDPregunta).getListaRespuestas().getRespuesta(IDRespuesta).setEstado(true); 
            }
        }
    }
    public void vote(int ID,boolean opcion){
        if(this.listaPreguntas.verificarIDPregunta(ID)){
            this.getListaPreguntas().getPregunta(ID).aumentarVoto(opcion);
        }else if(this.listaPreguntas.verificarIDGeneralRespuesta(ID)){
            this.listaPreguntas.getRespuestaID(ID).aumentarVoto(opcion);
        }
        else{System.out.println("No existe ID");}
    }
}
