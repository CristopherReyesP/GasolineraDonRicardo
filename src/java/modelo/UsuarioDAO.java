
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
public class UsuarioDAO {
    Connection con;
    Conexion    cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    public List<Usuario> listar_usuario() {
        List<Usuario>usuario=new ArrayList();
        String sql="select * from usuario";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Usuario p=new Usuario();
                p.setIdUsuario(rs.getInt(1));
                p.setNombreUsuario(rs.getString(2));
                p.setPassword(rs.getString(3));
                usuario.add(p);
            }
        } catch (Exception e) {
        }
        return usuario;
    }

    public int guardarUsuario(Usuario u) {
        int r = 0;
        String sql="insert into usuario (Nombre,Password)values(?,?)";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,u.getNombreUsuario());
                ps.setString(2,u.getPassword());
                r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;       
    }

    public Usuario listarporid(int idus) {
        int r = 0;
        String sql="select * from usuario  where Id=?";
        Usuario u=new Usuario();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idus);
            rs=ps.executeQuery();
            while (rs.next()) {                
                u.setIdUsuario(rs.getInt(1));
                u.setNombreUsuario(rs.getString(2));
                u.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return u; 
    }

    public int ActualizarUsuario(Usuario usr) {
   
        int resultado=0;
        String sql="update usuario set  Nombre=?, Password=? where Id=?";
        try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,usr.getNombreUsuario());
                ps.setString(2,usr.getPassword());
                ps.setInt(3,usr.getIdUsuario());
                resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al actualizar usuario"+e);
        }
        return resultado;        
    }

    public int EliminarUsuario(int idusr) {
        int resultado=0;
        String sql="delete from usuario where Id= "+idusr;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            resultado =ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar uduario"+e);
        }
        return resultado;         
    }

    public int validar(Usuario eu) {
        int r=0;
         String sql = "Select * from usuario where Nombre=? and Password=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, eu.getNombreUsuario());
            ps.setString(2, eu.getPassword());
            rs=ps.executeQuery();
            while (rs.next()) {
                r=r+1;
                eu.setNombreUsuario(rs.getString("Nombre"));
                eu.setPassword(rs.getString("Password"));
                System.out.println("Si entra en la conexion de la bd");
            }
            if(r==1){
            return 1;
            }else{
            return 0;
            }
        } catch (Exception e) {
        return 0;
        }  
    }

        public List buscar(String texto){
        List<Usuario>usuarios=new ArrayList();
        String sql="select * from usuario where Id like'%"+texto+"%' or Nombre like '%"+texto+"%'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Usuario u=new Usuario();
                u.setIdUsuario(rs.getInt(1));
                u.setNombreUsuario(rs.getString(2));
                u.setPassword(rs.getString(3));
                usuarios.add(u);
            }
        } catch (Exception e) {
        }
        return usuarios;
    }
    
}
