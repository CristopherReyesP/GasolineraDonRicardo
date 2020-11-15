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
public class Ingreso {
   int Id_ingreso;
   String Fecha;
   int Producto;
   int Cantidad;
   String NombreProd;

    public Ingreso() {
    }

    public Ingreso(int Id_ingreso, String Fecha, int Producto, int Cantidad, String NombreProd) {
        this.Id_ingreso = Id_ingreso;
        this.Fecha = Fecha;
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.NombreProd = NombreProd;
    }

    public int getId_ingreso() {
        return Id_ingreso;
    }

    public void setId_ingreso(int Id_ingreso) {
        this.Id_ingreso = Id_ingreso;
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
