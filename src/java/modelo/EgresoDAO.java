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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class EgresoDAO {
   Connection con;
    Conexion    cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int EliminarIngreso(int idegreso) {
         int resultado=0;
        String sql="delete from egreso where Id= "+idegreso;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            resultado =ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar ingreso"+e);
        }
        return resultado;     
    }

    public int IdProducto(String get) {
        int resultado=0;
        String sql="select Id from producto where Nombre='"+get+"'";
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
    public int guardarEgreso(Egreso eg) {
        int r = 0;
        int IDp = 0;
        String sql0="select stock from producto where ID=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql0);
            ps.setInt(1, eg.getProducto());
            rs = ps.executeQuery();
            while (rs.next()) {
                IDp = rs.getInt(1);
            }
        } catch (SQLException sQLException) {
        }
        if (IDp > eg.Cantidad) {
         
            String sql="insert into egreso (Producto_Id,Cantidad,Fecha,NombreProd)values(?,?,?,?)";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1,eg.getProducto());
                ps.setInt(2,eg.getCantidad());
                ps.setString(3,eg.getFecha());
                ps.setString(4,eg.getNombreProd());
                r=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al guardar egreso en la BD"+e);
        }
       return r; 
        }else{
            return r;
        }
           
    }

    public List listar_egreso() {
         List<Egreso>egreso=new ArrayList();
        String sql="select * from egreso";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Egreso p=new Egreso();
                p.setId_egreso(rs.getInt(1));
                p.setProducto(rs.getInt(2));
                p.setCantidad(rs.getInt(3));
                p.setFecha(rs.getString(4));
                p.setNombreProd(rs.getString(5));

                egreso.add(p);
            }
        } catch (Exception e) {
        }
        return egreso;  
    }

        public List buscar(String texto){
        List<Egreso>egreos=new ArrayList();
        String sql="select * from egreso where Id like'%"+texto+"%' or Fecha like '%"+texto+"%'or NombreProd like '%"+texto+"%'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Egreso p=new Egreso();
               p.setId_egreso(rs.getInt(1));
                p.setProducto(rs.getInt(2));
                p.setCantidad(rs.getInt(3));
                p.setFecha(rs.getString(4));
                p.setNombreProd(rs.getString(5));
                egreos.add(p);
            }
        } catch (Exception e) {
        }
        return egreos;
    }

}
