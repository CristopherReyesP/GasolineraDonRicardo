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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class CategoriaDAOTest {
    
    public CategoriaDAOTest() {
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
     * Test of listar_categoria method, of class CategoriaDAO.
     */
    @Test
    public void testListar_categoria() {
        System.out.println("listar_categoria");
        CategoriaDAO instance = new CategoriaDAO();
        List expResult = null;
        List result = instance.listar_categoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarid method, of class CategoriaDAO.
     */
    @Test
    public void testListarid() {
        System.out.println("listarid");
        String nombre_cat = "";
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 0;
        int result = instance.listarid(nombre_cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarCategoria method, of class CategoriaDAO.
     */
    @Test
    public void testGuardarCategoria() {
        System.out.println("guardarCategoria");
        Categoría c = null;
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 0;
        int result = instance.guardarCategoria(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarporid method, of class CategoriaDAO.
     */
    @Test
    public void testListarporid() {
        System.out.println("listarporid");
        int idcat = 0;
        CategoriaDAO instance = new CategoriaDAO();
        Categoría expResult = null;
        Categoría result = instance.listarporid(idcat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarCategoria method, of class CategoriaDAO.
     */
    @Test
    public void testActualizarCategoria() {
        System.out.println("ActualizarCategoria");
        Categoría catg = null;
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 0;
        int result = instance.ActualizarCategoria(catg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarCategoria method, of class CategoriaDAO.
     */
    @Test
    public void testEliminarCategoria() {
        System.out.println("EliminarCategoria");
        int idcategoria = 0;
        CategoriaDAO instance = new CategoriaDAO();
        int expResult = 0;
        int result = instance.EliminarCategoria(idcategoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class CategoriaDAO.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        String texto = "";
        CategoriaDAO instance = new CategoriaDAO();
        List expResult = null;
        List result = instance.buscar(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
