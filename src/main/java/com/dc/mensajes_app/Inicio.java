package com.dc.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Inicio {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        
        do{
            System.out.println("------------------------------------------");
            System.out.println(" Aplicación de mensajes");
            System.out.println(" 1. Crear mensaje");
            System.out.println(" 2. Listar mensajes");
            System.out.println(" 3. Editar mensajes");
            System.out.println(" 4. Eliminar mensajes");
            System.out.println(" 5. Salir");
            
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                default:
                    break;
            }
            
        }while(opcion != 0);
    }
}
