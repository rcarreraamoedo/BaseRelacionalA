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
public class OpSQL {
    private String driver;
    private String host;
    private String port;
    private String sid;
    private String usr;
    private String passwd;
    private String url;
    private Connection cn;

    public OpSQL() {
        driver="jdbc:oracle:thin:";
        host="localhost";
        sid="orcl";
        usr="hr";
        passwd="hr";
        port="1521";
        url= driver + usr + "/" + passwd + "@" + host + ":" + port + ":" +sid;
        try{
            cn=DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println("Error al conectar con la base de datos");
        }
    }

    
    public void insertarProducto(String cod, String desc, int precio){
        String query = "insert into productos values(?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, cod);
            pst.setString(2, desc);
            pst.setInt(3, precio);
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            System.out.println("Error al insertar datos en la base de datos");
        }
    }
    
    public void listarProductos(){
        try{
            Statement st = cn.createStatement();
            ResultSet res = st.executeQuery("select * from productos");
            while(res.next()){
                System.out.println("codigo: " + res.getString("codp") + "\nDescripcion: " + res.getString("descp") + "\nPrecio: "+ res.getInt("precio"));
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("No se pudo ejecutar la consulta");
        }
    }
    
    public void mostrarProducto(String cod){
        PreparedStatement st;
        ResultSet res;
        try{
            st = cn.prepareStatement("select descp,precio from productos where codp = ?");
            st.setString(1, cod);
            res = st.executeQuery();
            while(res.next()){
                System.out.println("Descripcion: " + res.getString("descp") + "\nPrecio: " + res.getInt("precio"));
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
        }
    }
    
    public void borrarProducto(String cod){
        PreparedStatement pst;
        String sql="delete from productos where codp = ?";
        try{
            pst=cn.prepareStatement(sql);
            pst.setString(1, cod);
            pst.executeUpdate();
        }catch(SQLException e){
            System.out.println("No se pudo eliminar la fila");
        }
    }
    
    public void actualizarPrecio(String cod, int precio){
        PreparedStatement pst;
        String sql="update productos set precio = ? where codp = ?";
        try{
            pst=cn.prepareStatement(sql);
            pst.setInt(1, precio);
            pst.setString(2, cod);
            pst.executeUpdate();
        }catch(SQLException e){
            System.out.println("No se pudo eliminar la fila");
        }
    }
    
    public void closeConnection(){
        if(cn!=null){
            try{
                cn.close();
            }catch(Exception e){
                
            }
        }
        
    }
}
