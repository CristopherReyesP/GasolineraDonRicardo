/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DELL
 */
public class Egreso {
       int Id_egreso;
   String Fecha;
   int Producto;
   int Cantidad;
   String NombreProd;

    public Egreso() {
    }

    public Egreso(int Id_egreso, String Fecha, int Producto, int Cantidad, String NombreProd) {
        this.Id_egreso = Id_egreso;
        this.Fecha = Fecha;
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.NombreProd = NombreProd;
    }

    public int getId_egreso() {
        return Id_egreso;
    }

    public void setId_egreso(int Id_egreso) {
        this.Id_egreso = Id_egreso;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getProducto() {
        return Producto;
    }

    public void setProducto(int Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getNombreProd() {
        return NombreProd;
    }

    public void setNombreProd(String NombreProd) {
        this.NombreProd = NombreProd;
    }
    
}
