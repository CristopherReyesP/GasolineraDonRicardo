/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import configuraciones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class IngresoDAO {
    Connection con;
    Conexion    cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    public List listar_ingreso() {
        List<Ingreso>ingreso=new ArrayList();
        String sql="select * from ingreso";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Ingreso p=new Ingreso();
                p.setId_ingreso(rs.getInt(1));
                p.setProducto(rs.getInt(2));
                p.setCantidad(rs.getInt(3));
                p.setFecha(rs.getString(4));
                p.setNombreProd(rs.getString(5));

                ingreso.add(p);
            }
        } catch (Exception e) {
        }
        return ingreso;
    }

    public int IdProducto(String NombreProducto) {
     
        int resultado=0;
        String sql="select Id from producto where Nombre='"+NombreProducto+"'";
        System.out.println("el sql dice"+sql); 
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                resultado =rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return resultado;  
    }

    public int guardarIngreso(Ingreso in) {
        int r = 0;
        System.out.println("el producto es:"+in.getProducto());
         String sql="insert into ingreso (Producto_Id,Cantidad,Fecha,NombreProd)values(?,?,?,?)";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1,in.getProducto());
                ps.setInt(2,in.getCantidad());
                ps.setString(3,in.getFecha());
                ps.setString(4,in.getNombreProd());
                r=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al guardar ingreso en la BD"+e);
        }
        return r;        
    }

    public int EliminarIngreso(int idingreso) {
              int resultado=0;
        String sql="delete from ingreso where Id= "+idingreso;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            resultado =ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar ingreso"+e);
        }
        return resultado;   
    }

        public List buscar(String texto){
        List<Ingreso>ingreso=new ArrayList();
        String sql="select * from ingreso where Id like'%"+texto+"%' or Fecha like '%"+texto+"%'or NombreProd like '%"+texto+"%'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Ingreso p=new Ingreso();
                p.setId_ingreso(rs.getInt(1));
                p.setProducto(rs.getInt(2));
                p.setCantidad(rs.getInt(3));
                p.setFecha(rs.getString(4));
                p.setNombreProd(rs.getString(5));
                ingreso.add(p);
            }
        } catch (Exception e) {
        }
        return ingreso;
    }
    
}
