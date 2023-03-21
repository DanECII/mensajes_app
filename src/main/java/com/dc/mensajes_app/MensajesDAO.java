package com.dc.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps;
            
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado!");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<Mensajes> leerMensajesDB(){
        Conexion db_connect = new Conexion();
        
        PreparedStatement ps;
        ResultSet rs;
        
        ArrayList<Mensajes> mensajes = new ArrayList<>();
        
        try (Connection conexion = db_connect.get_connection()){
            
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Mensajes msjAuxiliar = new Mensajes();
                
                msjAuxiliar.setId_mensaje(rs.getInt("id_mensaje"));
                msjAuxiliar.setMensaje(rs.getString("mensaje"));
                msjAuxiliar.setAutor_mensaje(rs.getString("autor_mensaje"));
                msjAuxiliar.setFecha_mensaje(rs.getString("fecha_mensaje"));
                
                mensajes.add(msjAuxiliar);
            }
            
        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
        
        return mensajes;
    }
    
    public static void borrarMensajesDB(int id_mensaje){
        
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps;
            
            try {
                String query = "DELETE FROM mensajes where id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            } catch (SQLException e) {
                System.out.println(e);
            }
            
        } catch (SQLException e) {
            
            System.out.println(e);
        }
    }
    
    public static void actualizarMensajesDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps;
            
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje se actualizo correctamente");
            } catch (SQLException e) {
                System.out.println("No se pudo actualizar el mensaje");
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
