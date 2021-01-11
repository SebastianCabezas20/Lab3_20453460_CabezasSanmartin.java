/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author Sebastian Cabezas
 */
/*Clase que representara al stack en el la solucion*/
public class Stack {
    private int IDgeneral;//ID unico e incremental
    private ListaUsuarios listaUsuarios;//lista de usuarios del stack
    private ListaPreguntas listaPreguntas;//lista de preguntas del stack
    private ListaEtiquetas listaEtiquetas;//lista etiquetas del stack
    private ListaRespuestas listaRespuestas;//lista respuestas del stack
    private int indexActivo;//index del usuario activo
    
    /*Permite crear un stack vacio*/
    public Stack() {
        this.listaUsuarios = new ListaUsuarios();
        this.listaPreguntas = new ListaPreguntas();
        this.listaEtiquetas = new ListaEtiquetas();
        this.listaRespuestas = new ListaRespuestas();
        this.indexActivo = -1;
        this.IDgeneral = 1;
    }
    
    /*Permite obtener la lista de respuestas
    @return una lista de respuesras
    */
    public ListaRespuestas getListaRespuestas() {
        return listaRespuestas;
    }
    /*Permite obtener el index del usuario activo
    @return index del usuario activo un entero
    */
    public int getIndexActivo() {
        return indexActivo;
    }
    /*permite cambiar el index del usuario activo*/
    public void setIndexActivo(int indexActivo) {
        this.indexActivo = indexActivo;
    }
    /*Permite obtener la lista de usuarios
    @return una lista de usuarios
    */
    public ListaUsuarios getListaUsuarios() {
        return listaUsuarios;
    }
    /*Permite obtener la lista de preguntas
    @return una lista de preguntas
    */
    public ListaPreguntas getListaPreguntas() {
        return listaPreguntas;
    }
    /*Permite obtener la lista de etiquetas
    @return una lista de etiquetas
    */
    public ListaEtiquetas getListaEtiquetas() {
        return this.listaEtiquetas;
    }
    
   /*Permite registrar a un usuario en el stack
    @param username es el nombre de usuario 
    @param pass contrasena del usuario*/
    public void Register(String username,String pass){
        if(this.listaUsuarios.verificarUsuario(username)){// Se verifica que el username no exista en la lista de usuarios
            this.listaUsuarios.agregarUsuario(new Usuario(username,pass));//Se crea y se agrega
            System.out.println("USUARIO REGISTRADO CON EXITO");
        }
        else{//caso que exista
            System.out.println("USERNAME YA EXISTE");
        }
    }
    /*Perimte autenticar cuenta de usuario
    @param username es el nombre de usuario 
    @param pass contrasena del usuario
    @return booleano que indicara si se pudo loguear 
    */
    public boolean login(String usermane,String pass){
        int index = this.listaUsuarios.autenticar(usermane, pass);//Se verifica que concida el username y pass
        if(index != -1){
            this.indexActivo = index;//Se cambia el index al de usuario activo
            return true;
        }
        else{//Caso que no coincidan los datos
            System.out.println("USERNAME Y/O CONTRASEÑA INCORRECTA");
            return false;
        }
    }
    /*Perimte cerrar sesion de la cuenta de usuario
    @param username es el nombre de usuario 
    @param pass contrasena del usuario
    @return booleano que indicara si se cerrar sesion 
    */
    public boolean logout(String username,String pass){
        //Se verifica que los datos sean del usuario activo
        if(this.listaUsuarios.getUsuario(this.indexActivo).getUsername().equals(username) && this.listaUsuarios.getUsuario(this.indexActivo).getPass().equals(pass)){
            this.indexActivo = -1;// se cambia index a desactivado
            return true;
        }
        else{
            System.out.println("USERNAME Y/O CONTRASEÑA INCORRECTA");
            return false;
        }
    }
    /*Perimte crear una pregunta y agregarla al stack
    @param titulo, titulo de la pregunta
    @param contenido, el contenido de la pregunta
    @param etiquetas, pertenece a la clase ListaEtiquetas 
    */
    public void ask(String titulo,String contenido,ListaEtiquetas etiquetas){
        // Se crea la pregunta
        Pregunta pregunta = new Pregunta(this.IDgeneral,titulo,contenido,etiquetas,this.listaUsuarios.getUsuario(this.indexActivo).getUsername());
        this.listaPreguntas.agregarPregunta(pregunta);
        this.IDgeneral = this.IDgeneral +1; // suma ID general
        System.out.println("PREGUNTA REALIZADA CON EXITO");
    }
    /*Perimte agregar una respuesta a una determinada pregunta
    @param ID, ID de la pregunta a responder
    @param contenido, contenido de la respuesta 
    */
    public void answer(int ID,String contenido){
        if(!this.listaPreguntas.verificarIDPregunta(ID)){ //Verificar que exista la pregunta
            System.out.println("EL ID INGRESADO NO EXISTE");
        }
        else{         
            Respuesta respuesta = new Respuesta(this.IDgeneral,contenido,this.listaUsuarios.getUsuario(this.indexActivo).getUsername(),ID);
            this.listaRespuestas.agregarRespuesta(respuesta);
            this.IDgeneral = this.IDgeneral +1; //Aumenta ID general
            System.out.println("RESPUESTA REALIZADA CON EXITO");
        }
    }
    /*Perimte agregar recompensa a una determinada pregunta
    @param ID, ID de la pregunta a ofrecer recompensa
    @param recompensa, recompensa a ofrecer 
    */
    public void reward(int ID, int recompensa){
        //Verificar que exista ID pregunta
        if(this.listaPreguntas.verificarIDPregunta(ID)){ 
            if(!this.listaPreguntas.getPregunta(ID).getEstado()){//Verificar que no haya sido respondida
                if(recompensa <= this.listaUsuarios.getUsuario(this.indexActivo).getReputacionRelativa()){//Caso que tenga suficiente reputacion
                    Recompensa nuevaRecompensa = new Recompensa(recompensa,this.indexActivo);
                    this.getListaUsuarios().getUsuario(this.indexActivo).restarReputacionRelativa(recompensa); //Se resta a la relativa
                    this.listaPreguntas.getPregunta(ID).getListaRecompensa().agregarRecompensa(nuevaRecompensa);
                    System.out.println("RECOMPENSA REALIZADA CON EXITO");
                }
                else{
                    System.out.println("NO POSEE LA SUFICIENTE REPUTACION");
                }
            }
            else{ 
                System.out.println("EL ID INGRESADO NO VALIDO");
            }        
        }
        else{
            System.out.println("EL ID INGRESADO NO VALIDO");
        }
    }
    /*Perimte aceptar una respuesta de una determinada pregunta
    @param IDPregunta, ID de la pregunta
    @param IDRespuesta, ID de la respuesta a aceptar 
    */
    public void accept(int IDPregunta,int IDRespuesta){
        //Verificar que la pregunta exista 
        //Verificar que la pregunta sea del usuario
        if(this.listaPreguntas.verificarIDPregunta(IDPregunta)){
            if(this.listaPreguntas.verificarUsername(IDPregunta,this.listaUsuarios.getUsuario(this.indexActivo).getUsername())){
                ///Verificar que existe ID respuesta en la pregunta
                // Verificar que estado
                //verificar que pertenezca a la pregunta
                if(this.listaRespuestas.verificarID(IDRespuesta)){
                    if(!this.listaRespuestas.getRespuesta(IDRespuesta).getEstado() && this.listaRespuestas.getRespuesta(IDRespuesta).getPreguntaRespondida() == IDPregunta){
                        //existe recompensa
                        if(this.listaPreguntas.getPregunta(IDPregunta).getListaRecompensa().cantidadRecompensas() > 0 && !this.listaPreguntas.getPregunta(IDPregunta).getEstado()){
                            int recompensaTotal = 0; //Suma de total
                            //Cobrar recompensas en el arrayList de recompensas
                            for(int i = 0; i < this.listaPreguntas.getPregunta(IDPregunta).getListaRecompensa().cantidadRecompensas();i++){
                                int recompensaCobrada = this.listaPreguntas.getPregunta(IDPregunta).getListaRecompensa().getRecompensa(i).getReputacion();
                                //Se busca a usuario que ofrecio recompensa
                                int indexOfrecido = this.listaPreguntas.getPregunta(IDPregunta).getListaRecompensa().getRecompensa(i).getUsuarioRecompensa();
                                recompensaTotal = recompensaTotal + recompensaCobrada; //Se suma recompensa 
                                this.listaUsuarios.getUsuario(indexOfrecido).restarReputacionAbsoluta(recompensaCobrada);//Restar a usuario
                            }//Se cambian los estados
                            this.listaPreguntas.getPregunta(IDPregunta).setEstado(true);
                            this.listaRespuestas.getRespuesta(IDRespuesta).setEstado(true);
                            //Suma reputacion a usuario que respondio
                            this.listaUsuarios.getUsuarioUsername(this.listaRespuestas.getRespuesta(IDRespuesta).getAutor()).sumarReputacionAbsoluta(recompensaTotal);
                            this.listaUsuarios.getUsuarioUsername(this.listaRespuestas.getRespuesta(IDRespuesta).getAutor()).sumarReputacionRelativa(recompensaTotal);
                            System.out.println("RESPUESTA ACEPTADA CON EXITO");
                        }
                        else{//Caso que no haya recompensa
                            this.listaPreguntas.getPregunta(IDPregunta).setEstado(true);
                            this.listaRespuestas.getRespuesta(IDRespuesta).setEstado(true);
                            System.out.println("RESPUESTA ACEPTADA CON EXITO");
                        }
                    }
                    else{
                        System.out.println("ID DE RESPUESTA NO VALIDO");
                    }
                }
                else{
                    System.out.println("ID DE RESPUESTA NO VALIDO");
                }
            }
            else{
             System.out.println("ID DE PREGUNTA NO VALIDO");   
            }
        }
        else{
            System.out.println("ID DE PREGUNTA NO VALIDO");   
        }     
    }
    /*Perimte votar negativa o positivamente una pregunta o respuesta
    @param ID, ID de pregunta o respuesta
    @param opcion, booleano que indicara voto 
    */
    public void vote(int ID,boolean opcion){
        //Se verifica que existe ID pregunta
        if(this.listaPreguntas.verificarIDPregunta(ID)){
            //Siempre que no sea del usuario
            if(!this.listaPreguntas.getPregunta(ID).getAutor().equals(this.listaUsuarios.getUsuario(this.indexActivo).getUsername())){
                if(this.getListaPreguntas().getPregunta(ID).aumentarVoto(opcion)){
                    //Se suma reputacion segun enunciado
                    this.listaUsuarios.getUsuarioUsername(this.listaPreguntas.getPregunta(ID).getAutor()).sumarReputacionAbsoluta(10);
                    System.out.println("VOTO POSITIVO REALIZADO CON EXITO");
                }
                else{
                    //Se resta reputacion segun enunciado
                    this.listaUsuarios.getUsuarioUsername(this.listaPreguntas.getPregunta(ID).getAutor()).sumarReputacionAbsoluta(2);
                    System.out.println("VOTO NEGATIVO REALIZADO CON EXITO");
                }
            }
            else{
                System.out.println("ID INGRESADO NO VALIDO");
            }
        }
        //O se verifica que existe ID respuesta
        else if(this.listaRespuestas.verificarID(ID)){//votar una respuesta
            //Siempre que no sea del usuario y el estado este aceptado
            if(!this.listaRespuestas.getRespuesta(ID).getAutor().equals(this.listaUsuarios.getUsuario(this.indexActivo).getUsername()) &&
                    this.listaRespuestas.getRespuesta(ID).getEstado()){
                if(this.listaRespuestas.getRespuesta(ID).aumentarVoto(opcion)){//votar positivamente
                    //Se suma reputacion segun enunciado
                    this.listaUsuarios.getUsuarioUsername(this.listaRespuestas.getRespuesta(ID).getAutor()).sumarReputacionAbsoluta(10);
                    System.out.println("VOTO POSITIVO REALIZADO CON EXITO");
                }
                else{//votar negativamente
                    //Se suma reputacion segun enunciado
                    this.listaUsuarios.getUsuarioUsername(this.listaRespuestas.getRespuesta(ID).getAutor()).restarReputacionAbsoluta(2);
                    this.listaUsuarios.getUsuario(this.indexActivo).restarReputacionAbsoluta(2);
                    System.out.println("VOTO NEGATIVO REALIZADO CON EXITO");
                }
            }
            else{
                System.out.println("ID INGRESADO NO VALIDO");
            }
        }
        //Caso que no exista
        else{
            System.out.println("No existe ID");
        }
    }
    /*Perimte imprimir todas las preguntas asociadas a un usuario con sus respectivas respuestas
    @return numero de preguntas disponibles
    */
    public int imprimirPreguntaRespuesta(){
        int preguntas = 0;
        for(int i = 0; i < this.listaPreguntas.cantidadPreguntas(); i++){
            if(this.listaPreguntas.getPreguntaIndex(i).getAutor().equals(this.listaUsuarios.getUsuario(this.indexActivo).getUsername())){
                this.listaPreguntas.getPreguntaIndex(i).imprimir();
                preguntas++;
                System.out.println("   RESPUESTAS ASOCIADAS A LA RESPUESTA");
                this.listaRespuestas.imprimirRespuestas(this.listaPreguntas.getPreguntaIndex(i).getID());
            }
        }
        return preguntas;
    }
    /*Perimte imprimir tanto respuestas y preguntas que no son del usuario
    */
    public void imprimirPreguntaRespuestaVote(){
        for(int i = 0; i < this.listaPreguntas.cantidadPreguntas(); i++){
            if(!this.listaPreguntas.getPreguntaIndex(i).getAutor().equals(this.listaUsuarios.getUsuario(this.indexActivo).getUsername())){
                this.listaPreguntas.getPreguntaIndex(i).imprimir();
                System.out.println("   RESPUESTAS ASOCIADAS A LA RESPUESTA:");
                this.listaRespuestas.imprimirRespuestasNoUser(this.listaPreguntas.getPreguntaIndex(i).getID(), this.listaUsuarios.getUsuario(this.indexActivo).getUsername());
            }
        }

    }
    /*Perimte imprimir todo el stack
    */
    public void imprimirTodo(){
        for(int i = 0; i < this.listaPreguntas.cantidadPreguntas();i++){
            this.listaPreguntas.getPreguntaIndex(i).imprimir();
            System.out.println("   RESPUESTAS ASOCIADAS A LA RESPUESTA");
            this.listaRespuestas.imprimirTotalRespuestas(this.listaPreguntas.getPreguntaIndex(i).getID());
        }
    }
}
