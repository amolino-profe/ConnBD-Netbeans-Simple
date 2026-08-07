/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import logica.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class ProductoDB {

    public ListadoProductos devolverProductos() throws Exception {
        Conexion DB = Conexion.getInstancia();
        Connection conn = DB.getConnection();

        String sql = "SELECT * FROM productos";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ListadoProductos listado = ListadoProductos.getInstancia();

        while (rs.next()) {
            Producto p = new Producto();

            //p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getDouble("precio"));

            listado.agregarProducto(p);

        }
        conn.close();

        return listado;
    }

    public void IngresarDatosProducto(String nombre, double precio) throws Exception {
        Conexion DB = Conexion.getInstancia();
        Connection conn = DB.getConnection();
        String insertar = "INSERT INTO productos(nombre, precio) VALUES('" + nombre + "'," + precio + ")";
        //System.out.println(insertar);
        PreparedStatement st = conn.prepareStatement(insertar);
        st.executeUpdate();
        conn.close();
    }
}
