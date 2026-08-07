/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import persistencia.ProductoDB;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Fachada {

    private static Fachada instancia;

    private Fachada() {
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public ArrayList<Producto> getLista() {
        ListadoProductos listado = ListadoProductos.getInstancia();
        return listado.getLista();
    }

    public boolean ingresarProducto(String nombre, double precio) throws Exception {
        //Creo nueva persona
        Producto p = new Producto(nombre, precio);
        ProductoDB db = new ProductoDB();
        //Instancio listado
        ListadoProductos l = ListadoProductos.getInstancia();
        //Invoco el metodo booleano de PersonasListado para veri si no existe e ingresarlo
        if (l.existe(p)) {
            return false;
        } else {
            //Si no existe lo ingreso y devuelvo true
            l.agregarProducto(p);//En memoria
            db.IngresarDatosProducto(nombre, precio);
            return true;
        }
    }

    public void Carga() throws SQLException, Exception {
        ListadoProductos l = ListadoProductos.getInstancia();
        l.cargarDatosDB();
        // l.mostrarLista();
    }
}
