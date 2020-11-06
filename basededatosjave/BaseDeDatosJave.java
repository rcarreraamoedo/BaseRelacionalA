/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosjave;

import java.sql.*;

/**
 *
 * @author xavier
 */
public class BaseDeDatosJave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Producto[] p = new Producto[3];
        String[] cods = {"p1","p2","p3"};
        String[] desc = {"parafusos","cravos","tachas"};
        int[] precios = {3,4,5};
        OpSQL osql;
        for(int i=0;i<3;i++){
            p[i]=new Producto(cods[i],desc[i],precios[i]);
        }
        osql = new OpSQL();
        /*for(int i=0;i<3;i++){
            osql.insertarProducto(p[i].getCod(), p[i].getDesc(), p[i].getPrecio());
        }*/
        //System.out.println("Mostrar productos");
        osql.mostrarProducto("p2");
        //System.out.println("Listar productos");
        osql.listarProductos();
        //System.out.println("Borrar Productos");
        osql.borrarProducto("p1");
        osql.listarProductos();
        osql.closeConnection();
    }
    
}
