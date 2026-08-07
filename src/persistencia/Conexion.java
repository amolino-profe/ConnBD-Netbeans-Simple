/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class Conexion {
    //Respetaremos el patron singleton para la conexion (solo queremos una)
    private static Conexion instancia;
    // Atributos de la conexion
    private Connection con;
    private String driver;
    private String url;
    private String usuario;
    private String password;
    private String nomBaseDatos;

    // Constructor de la conexion 
    private Conexion() {
        nomBaseDatos = "pruebas";
        driver = "org.mariadb.jdbc.Driver";
        url = "jdbc:mariadb://localhost:3307/" + nomBaseDatos;
        usuario = "root";
        password = "";
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() throws Exception {
        Class.forName(driver); // Establecer y devolver la conexion
        con = DriverManager.getConnection(url, usuario, password);
        return con;
    }
}
