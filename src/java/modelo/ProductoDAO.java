/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import configuraciones.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class ProductoDAO {
    Connection con;
    Conexion    cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    public List listar(){
        List<Producto>productos=new ArrayList();
        String sql="select * from producto";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setFoto(rs.getString(4));
                p.setPrecio_compra(rs.getDouble(5));
                p.setPrecio_venta(rs.getDouble(6));
                p.setProveedor_idProveedor(rs.getInt(7));
                p.setCategoria(rs.getInt(8));
                p.setMax_stock(rs.getInt(9));
                p.setMin_stock(rs.getInt(10));
                p.setStock(rs.getInt(11));
                p.setEstado_stock(rs.getString(12));
                p.setFavorito(rs.getString(13));
                productos.add(p);
            }
        } catch (Exception e) {
        }
        return productos;
    }
        public Producto listarporid(int id){
        String sql="select * from producto where Id=?";
        Producto p=new Producto();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {                

                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setFoto(rs.getString(4));
                p.setPrecio_compra(rs.getDouble(5));
                p.setPrecio_venta(rs.getDouble(6));
                p.setProveedor_idProveedor(rs.getInt(7));
                p.setCategoria(rs.getInt(8));
                p.setMax_stock(rs.getInt(9));
                p.setMin_stock(rs.getInt(10));
                p.setStock(rs.getInt(11));
                p.setEstado_stock(rs.getString(12));
                p.setFavorito(rs.getString(13));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
        public List buscar(String texto){
        List<Producto>productos=new ArrayList();
        String sql="select * from producto where Id like'%"+texto+"%' or Nombre like '%"+texto+"%'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setFoto(rs.getString(4));
                p.setPrecio_compra(rs.getDouble(5));
                p.setPrecio_venta(rs.getDouble(6));
                p.setProveedor_idProveedor(rs.getInt(7));
                p.setCategoria(rs.getInt(8));
                p.setMax_stock(rs.getInt(9));
                p.setMin_stock(rs.getInt(10));
                p.setStock(rs.getInt(11));
                p.setEstado_stock(rs.getString(12));
                p.setFavorito(rs.getString(13));
                productos.add(p);
            }
        } catch (Exception e) {
        }
        return productos;
    }

    public int guardar(Producto p) {
        int r = 0;
        String sql="insert into producto(Nombre,Descripccion,Foto,Precio_compra,Precio_venta,Proveedor_idProveedor,Categoria_Id,Max_stock,Min_stock,Stock)values(?,?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("la descripcion del producto dice:"+p.getDescripcion());
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,p.getNombre());
                ps.setString(2,p.getDescripcion());
                ps.setString(3,p.getFoto());
                ps.setDouble(4,p.getPrecio_compra());
                ps.setDouble(5,p.getPrecio_venta());
                ps.setInt(6,p.getProveedor_idProveedor());
                ps.setInt(7,p.getCategoria());
                ps.setInt(8,p.getMax_stock());
                ps.setInt(9,p.getMin_stock());
                ps.setInt(10,p.getStock());
                r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }  
        public int ActualizarProducto(Producto p) {
        int resultado=0;
        String sql="update producto set  Nombre=?, Descripccion=?,Foto=?,Precio_compra=?,Precio_venta=?,Proveedor_idProveedor=?,Categoria_Id=?,Max_stock=?,Min_stock=? where Id=?";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,p.getNombre());
                ps.setString(2,p.getDescripcion());
                ps.setString(3,p.getFoto());
                ps.setDouble(4,p.getPrecio_compra());
                ps.setDouble(5,p.getPrecio_venta());
                ps.setInt(6,p.getProveedor_idProveedor());
                ps.setInt(7,p.getCategoria());
                ps.setInt(8,p.getMax_stock());
                ps.setInt(9,p.getMin_stock());
                ps.setInt(10,p.getId());
                resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al actualizar producto"+e);
        }
        return resultado;
    }

    public int EliminarProducto(int id) {
        int resultado=0;
        String sql="delete from producto where Id= "+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            resultado =ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar producto"+e);
        }
        return resultado;
    }

    public List<Producto> listar_favoritos() {
        List<Producto>productos=new ArrayList();
        String sql="select * from producto where favorito='SI'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setFoto(rs.getString(4));
                p.setPrecio_compra(rs.getDouble(5));
                p.setPrecio_venta(rs.getDouble(6));
                p.setProveedor_idProveedor(rs.getInt(7));
                p.setCategoria(rs.getInt(8));
                p.setMax_stock(rs.getInt(9));
                p.setMin_stock(rs.getInt(10));
                p.setStock(rs.getInt(11));
                p.setEstado_stock(rs.getString(12));
                p.setFavorito(rs.getString(13));
                productos.add(p);
            }
        } catch (Exception e) {
        }
        return productos;
    }

    public int agregarfavoritos(String fav) {
        int resultado=0;
        String sql="update producto set  favorito='SI' where Nombre='"+ fav +"'";
        System.out.println("el producto es:"+fav);
    
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al agregar favorito"+e);
        }
        return resultado;
    }

    public int EliminarFavorito(int idfav) {
                int resultado=0;
        String sql="update producto set  favorito='NO' where Id="+idfav;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            resultado =ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al actualizar campo favorito de la tabla producto"+e);
        }
        return resultado;
    }
    }
        
        

