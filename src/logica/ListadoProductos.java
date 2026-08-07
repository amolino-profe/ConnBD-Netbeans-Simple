/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import persistencia.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class ListadoProductos {

    private static ListadoProductos instancia;
    private ArrayList<Producto> lista;
    
    private ListadoProductos(){
        lista = new ArrayList<Producto>();
    }
    /**
     * Devuelve la instancia de la lista
     * @return listado de personas
     */
    public static ListadoProductos getInstancia(){
         if (instancia == null) {
            instancia = new ListadoProductos();
        }

        return instancia;
    }

    public ArrayList<Producto> getLista() {
        return lista;
    }
    
    /**
     * Metodo que carga una persona a la lista
     * @param p 
     */
    public void agregarProducto(Producto p){
        lista.add(p);
    }
    
    public void cargarDatosDB() throws SQLException, Exception{
        ProductoDB ProdDB = new ProductoDB();
        ListadoProductos lista = ProdDB.devolverProductos();

    }

    
    /**
     * Metodo que verifica si existe ese registro a partir del documento
     * @param p
     * @return true cuando existe
     *
     */
    public boolean existe(Producto p){
        for(int i=0; i<lista.size(); i++){
            if (p.getNombre()== lista.get(i).getNombre()){
                return true;
            }
        }
        return false;
    }
    
    
}
