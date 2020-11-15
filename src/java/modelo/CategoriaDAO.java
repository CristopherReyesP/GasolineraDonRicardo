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
public class CategoriaDAO {
      Connection con;
    Conexion    cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

        public List listar_categoria(){
        List<Categoría>cat=new ArrayList();
        String sql="select * from categoria";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Categoría c=new Categoría();
                c.setId_categoria(rs.getInt(1));
                c.setNombre_categoria(rs.getString(2));
                 c.setDescripcion(rs.getString(3));
                cat.add(c);
            }
        } catch (Exception e) {
        }
        return cat;
    }
            public int listarid(String nombre_cat){
        int id=0;
        String sql="select Id from categoria where Categoria='"+ nombre_cat +"'";
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

    public int guardarCategoria(Categoría c) {
        int r = 0;
        String sql="insert into categoria (Categoria,Descripcion)values(?,?)";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,c.getNombre_categoria());
                ps.setString(2,c.getDescripcion());
                r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Categoría listarporid(int idcat) {
       String sql="select * from categoria where Id=?";
        Categoría p=new Categoría();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idcat);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setId_categoria(rs.getInt(1));
                p.setNombre_categoria(rs.getString(2));
                p.setDescripcion(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return p;   
    }

    public int ActualizarCategoria(Categoría catg) {
              int resultado=0;
        String sql="update categoria set  Categoria=?,Descripcion=? where Id=?";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,catg.getNombre_categoria());
                ps.setString(2,catg.getDescripcion());
                ps.setInt(3,catg.getId_categoria());
                resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al actualizar categoria"+e);
        }
        return resultado;  
    }

    public int EliminarCategoria(int idcategoria) {
     int resultad=0;
        String sql="delete from categoria where Id= "+idcategoria;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            resultad =ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar categoria"+e);
        }
        return resultad;         
    }

        public List buscar(String texto){
        List<Categoría>categorias=new ArrayList();
        String sql="select * from categoria where Id like'%"+texto+"%' or Categoria like '%"+texto+"%'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Categoría p=new Categoría();
                p.setId_categoria(rs.getInt(1));
                p.setNombre_categoria(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                categorias.add(p);
            }
        } catch (Exception e) {
        }
        return categorias;
    }
}
