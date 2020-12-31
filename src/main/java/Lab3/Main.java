/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.Scanner;

/**
 *
 * @author Sebastián
 */
public class Main {
    
    
    public static void main(String[] args) {
        int salir = 0,opcion;
        String username,pass; 
        Scanner option = new Scanner(System.in);
        Scanner informacion = new Scanner(System.in);
        Stack stack = new Stack();
        ////////////////////////////////////////////////////////
        while(salir == 0){
            System.out.println("******SISTEMA DE PREGUNTAS Y RESPUESTAS******");
            System.out.println("1-Registrar");
            System.out.println("2-Iniciar sesion");
            System.out.println("3-Salir");
            System.out.println("Ingrese opcion: ");
            opcion = option.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese nuevo username: ");
                    username = informacion.nextLine();
                    System.out.println("Ingrese contraseña");
                    pass = informacion.nextLine();
                    stack.Registrar(username, pass);
                    break;
                case 2:
                    System.out.println("Ingrese username: ");
                    username = informacion.nextLine();
                    System.out.println("Ingrese contraseña");
                    pass = informacion.nextLine();
                    if(stack.login(username,pass)){
                        salir = menuPrincipal(stack);//seguimos con 0 ,salimos con 1
                    }
                    break;
                case 3:
                    salir = 1;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    
    }

    private static int menuPrincipal(Stack stack) {
        int salida = 0,opcion;
        String username,pass;
        Scanner entrada = new Scanner(System.in);
        Scanner informacion = new Scanner(System.in);
        while(salida == 0){
            System.out.println("******SISTEMA DE PREGUNTAS Y RESPUESTAS******");
            System.out.println("USUARIO REGISTRADO COMO: "+stack.getListaUsuarios().getUsuario(stack.getIndexActivo()).getUsername());
            System.out.println("1-Agregar pregunta");
            System.out.println("2-Agregar respuesta");
            System.out.println("3-Ofrecer recompensa");
            System.out.println("4-Aceptar respuesta");
            System.out.println("5-Cerrar sesion");
            System.out.println("6-Cerrar programa");
            System.out.println("Ingrese opcion: ");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    agregarPregunta(stack);
                    break;
                case 2:
                    agregarRespuesta(stack);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Ingrese username: ");
                    username = informacion.nextLine();
                    System.out.println("Ingrese contraseña");
                    pass = informacion.nextLine();
                    if(stack.logout(username,pass)){
                        System.out.println("SESION CERRADA CON EXITO");
                        return 0;
                    }
                    break;
                case 6:
                    return 1;
                default:
                    System.out.println("NO EXISTE OPCION ESCOGIDA.");
            }
        }
        return 0;
    }

    private static void agregarPregunta(Stack stack) {
        String contenido,titulo,nombreEtiqueta;
        int opcion;
        ListaEtiquetas etiquetas = new ListaEtiquetas();
        Scanner entrada = new Scanner(System.in);
        Scanner option = new Scanner(System.in);
        System.out.println("Ingrese titulo de la pregunta: ");
        titulo = entrada.nextLine();
        System.out.println("Ingrese contenido de la pregunta");
        contenido = entrada.nextLine();
        int salida = 0;
        int salidaEtiqueta = 0;
        while(salida == 0){
            System.out.println("Desea agregar etiquetas a la pregunta?");
            System.out.println("1-SI");
            System.out.println("2-NO");
            System.out.println("Ingrese opcion: ");
            opcion = option.nextInt();
            if(opcion == 1){
                while(salida == 0){
                    stack.getListaEtiquetas().imprimir();
                    System.out.println("Ingrese nombre de la etiqueta: ");
                    nombreEtiqueta = entrada.nextLine();
                    if(stack.getListaEtiquetas().verificarNombre(nombreEtiqueta)){
                        if(!etiquetas.verificarNombre(nombreEtiqueta)){//caso que no exista el nombre en las nuevas etiquetas,se agrega
                            etiquetas.agregarEtiqueta(stack.getListaEtiquetas().buscador(nombreEtiqueta));
                        }
                        else{
                            System.out.println("LA ETIQUETA YA FUE INGRESADA");
                        }
                    }
                    else{
                        System.out.println("EL NOMBRE INGRESADO NO CORRESPONDE A UNA ETIQUETA");
                    }
                    while(salidaEtiqueta == 0)
                    System.out.println("Desea agregar otra etiqueta?");
                    System.out.println("1-SI");
                    System.out.println("2-NO");
                    System.out.println("Ingrese opcion: ");
                    opcion = option.nextInt();
                    if(opcion == 1){
                        salidaEtiqueta = 1;
                    }
                    else if(opcion == 2){
                        salidaEtiqueta = 1;
                        salida = 1;
                    }
                    else{
                        System.out.println("OPCION NO VALIDA");
                    }
                }
                stack.ask(titulo,contenido,etiquetas);    
            }
            else if(opcion == 2){
                stack.ask(titulo,contenido,etiquetas);
                salida = 1;
            }
            else{
                System.out.println("OPCION INGRESADA NO VALIDA.");
            }
        }
    }

    private static void agregarRespuesta(Stack stack) {
        if(stack.getListaPreguntas().cantidadPreguntas() > 0){
            int salida = 0,ID;
            String contenido;
            Scanner IDPregunta = new Scanner(System.in);
            Scanner informacion = new Scanner(System.in);
            stack.getListaPreguntas().imprimir();
            while(salida == 0){
                System.out.println("Ingrese ID de pregunta a responder:");
                ID = IDPregunta.nextInt();
                if(ID >= stack.getListaPreguntas().cantidadPreguntas() && ID >= 0){
                    System.out.println("EL ID INGRESADO NO EXISTE");
                }
                else{
                    System.out.println("Ingrese el contenido de la pregunta: ");
                    contenido = informacion.nextLine();
                    stack.answer(ID,contenido);
                }
            }
        }
        else{
            System.out.println("NO EXISTEN PREGUNTAS");
        }
    }
    
    
}
