package com.dc.mensajes_app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Tu nombre");
        String nombre = sc.nextLine();
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    public static void listarMensajes(){
        ArrayList<Mensajes> mensajes = MensajesDAO.leerMensajesDB();
        mensajes.forEach((mensaje) -> {
            System.out.println("ID: " + mensaje.id_mensaje);
            System.out.println("Mensaje: " + mensaje.mensaje);
            System.out.println("Autor: " + mensaje.autor_mensaje);
            System.out.println("Fecha: " + mensaje.fecha_mensaje);
        });
        
    }
    public static void borrarMensaje(){}
    public static void editarMensaje(){}
}
