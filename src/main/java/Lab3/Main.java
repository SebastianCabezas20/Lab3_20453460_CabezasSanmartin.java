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
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    
                    break;
                case 2:
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
    
    
}
