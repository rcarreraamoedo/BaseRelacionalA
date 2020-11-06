/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosjave;

/**
 *
 * @author xavier
 */
public class Producto {
    private String cod;
    private String desc;
    private int precio;

    public Producto(String cod, String desc, int precio) {
        this.cod = cod;
        this.desc = desc;
        this.precio = precio;
    }

    public Producto() {
        this(null,null,0);
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
