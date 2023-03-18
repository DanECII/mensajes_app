package com.dc.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Conexion {

    public Connection get_connection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "05740574");
            if (conection != null) {
                System.out.println("Conexión exitosa!");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conection;
    }
}
