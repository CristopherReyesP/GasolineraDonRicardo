/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class UsuarioDAOIT {
    
    public UsuarioDAOIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of listar_usuario method, of class UsuarioDAO.
     */
//    @Test
//    public void testListar_usuario() {
//        System.out.println("listar_usuario");
//        UsuarioDAO instance = new UsuarioDAO();
//        List<Usuario> expResult = null;
//        List<Usuario> result = instance.listar_usuario();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of guardarUsuario method, of class UsuarioDAO.
//     */
//    @Test
//    public void testGuardarUsuario() {
//        System.out.println("guardarUsuario");
//        Usuario u = null;
//        UsuarioDAO instance = new UsuarioDAO();
//        int expResult = 0;
//        int result = instance.guardarUsuario(u);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarporid method, of class UsuarioDAO.
//     */
//    @Test
//    public void testListarporid() {
//        System.out.println("listarporid");
//        int idus = 0;
//        UsuarioDAO instance = new UsuarioDAO();
//        Usuario expResult = null;
//        Usuario result = instance.listarporid(idus);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of ActualizarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testActualizarUsuario() {
        
        System.out.println("ActualizarUsuario");
        Usuario usr = new Usuario();
        usr.setIdUsuario(11);
        usr.setNombreUsuario("NombreTestt");
        usr.setPassword("PasswordTest");
        UsuarioDAO instance = new UsuarioDAO();
        int result = instance.ActualizarUsuario(usr);
        assertTrue(result!=0);

    }
//
//    /**
//     * Test of EliminarUsuario method, of class UsuarioDAO.
//     */
//    @Test
//    public void testEliminarUsuario() {
//        System.out.println("EliminarUsuario");
//        int idusr = 0;
//        UsuarioDAO instance = new UsuarioDAO();
//        int expResult = 0;
//        int result = instance.EliminarUsuario(idusr);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validar method, of class UsuarioDAO.
//     */
//    @Test
//    public void testValidar() {
//        System.out.println("validar");
//        Usuario eu = null;
//        UsuarioDAO instance = new UsuarioDAO();
//        int expResult = 0;
//        int result = instance.validar(eu);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscar method, of class UsuarioDAO.
//     */
//    @Test
//    public void testBuscar() {
//        System.out.println("buscar");
//        String texto = "";
//        UsuarioDAO instance = new UsuarioDAO();
//        List expResult = null;
//        List result = instance.buscar(texto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
