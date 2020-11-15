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
public class ProveedorDAO {
    Connection con;
    Conexion    cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
        public List listar_proveedor(){
        List<Proveedor>proveedor=new ArrayList();
        String sql="select * from proveedor";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Proveedor p=new Proveedor();
                p.setId_proveedor(rs.getInt(1));
                p.setNombre_Proveedor(rs.getString(2));
                p.setDireccion(rs.getString(3));
                p.setTelefono(rs.getInt(4));

                proveedor.add(p);
            }
        } catch (Exception e) {
        }
        return proveedor;
    }
            public int listarid(String nombre_prov){
        int id=0;
        
        String sql="select Id from proveedor where Nombre='"+nombre_prov+"'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) { 
                id=rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return id;
    }

    public int guardarProveedor(Proveedor pv) {
        int r = 0;
       String sql="insert into Proveedor (Nombre,Direccion,Telefono)values(?,?,?)";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,pv.getNombre_Proveedor());
                ps.setString(2,pv.getDireccion());
                ps.setString(3,Integer.toString(pv.getTelefono()));
                r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Proveedor listarporid(int idprov) {
        String sql="select * from proveedor where Id=?";
        Proveedor p=new Proveedor();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idprov);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setId_proveedor(rs.getInt(1));
                p.setNombre_Proveedor(rs.getString(2));
                p.setDireccion(rs.getString(3));
                p.setTelefono(rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return p;    
    }

    public int ActualizarProveedor(Proveedor ap) {
        int resultado=0;
        String sql="update proveedor set  Nombre=?,Direccion=?,Telefono=? where Id=?";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,ap.getNombre_Proveedor());
                ps.setString(2,ap.getDireccion());
                ps.setInt(3,ap.getTelefono());
                ps.setInt(4,ap.getId_proveedor());
                resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al actualizar proveedor"+e);
        }
        return resultado;
    }

    public int EliminarProveedor(int idprv) {
             int resultado=0;
        String sql="delete from proveedor where Id= "+idprv;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            resultado =ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar proveedor"+e);
        }
        return resultado;  
    }

        public List buscar(String texto){
        List<Proveedor>proveedor=new ArrayList();
        String sql="select * from proveedor where Id like'%"+texto+"%' or Nombre like '%"+texto+"%'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Proveedor p=new Proveedor();
                p.setId_proveedor(rs.getInt(1));
                p.setNombre_Proveedor(rs.getString(2));
                p.setDireccion(rs.getString(3));
                p.setTelefono(rs.getInt(4));
                proveedor.add(p);
            }
        } catch (Exception e) {
        }
        return proveedor;
    }
}
