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
public class ProductoDAOIT {
    
    public ProductoDAOIT() {
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
     * Test of listar method, of class ProductoDAO.
     */
//    @Test
//    public void testListar() {
//        System.out.println("listar");
//        ProductoDAO instance = new ProductoDAO();
//        List expResult = null;
//        List result = instance.listar();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarporid method, of class ProductoDAO.
//     */
//    @Test
//    public void testListarporid() {
//        System.out.println("listarporid");
//        int id = 0;
//        ProductoDAO instance = new ProductoDAO();
//        Producto expResult = null;
//        Producto result = instance.listarporid(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscar method, of class ProductoDAO.
//     */
//    @Test
//    public void testBuscar() {
//        System.out.println("buscar");
//        String texto = "";
//        ProductoDAO instance = new ProductoDAO();
//        List expResult = null;
//        List result = instance.buscar(texto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of guardar method, of class ProductoDAO.
//     */
//    @Test
//    public void testGuardar() {
//        System.out.println("guardar");
//        Producto p = null;
//        ProductoDAO instance = new ProductoDAO();
//        int expResult = 0;
//        int result = instance.guardar(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of ActualizarProducto method, of class ProductoDAO.
     */
    @Test
    public void testActualizarProducto() {
        System.out.println("ActualizarProducto");
        Producto p = new Producto();
        p.setId(61);
        p.setNombre("Grasa 16Oz EBULLI");
        p.setDescripcion("grasa");
        p.setProveedor_idProveedor(26);
        p.setCategoria(23);
        p.setPrecio_compra(18);
        p.setPrecio_venta(25);
        p.setMin_stock(25);
        p.setMax_stock(100);
        p.setFoto("img/grasa.jpg");
        ProductoDAO instance = new ProductoDAO();
        int result = instance.ActualizarProducto(p);
        assertTrue(result!=0);
    }

    /**
     * Test of EliminarProducto method, of class ProductoDAO.
     */
//    @Test
//    public void testEliminarProducto() {
//        System.out.println("EliminarProducto");
//        int id = 0;
//        ProductoDAO instance = new ProductoDAO();
//        int expResult = 0;
//        int result = instance.EliminarProducto(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listar_favoritos method, of class ProductoDAO.
     */
//    @Test
//    public void testListar_favoritos() {
//        System.out.println("listar_favoritos");
//        ProductoDAO instance = new ProductoDAO();
//        List<Producto> expResult = null;
//        List<Producto> result = instance.listar_favoritos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of agregarfavoritos method, of class ProductoDAO.
     */
//    @Test
//    public void testAgregarfavoritos() {
//        System.out.println("agregarfavoritos");
//        String fav = "";
//        ProductoDAO instance = new ProductoDAO();
//        int expResult = 0;
//        int result = instance.agregarfavoritos(fav);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of EliminarFavorito method, of class ProductoDAO.
//     */
//    @Test
//    public void testEliminarFavorito() {
//        System.out.println("EliminarFavorito");
//        int idfav = 0;
//        ProductoDAO instance = new ProductoDAO();
//        int expResult = 0;
//        int result = instance.EliminarFavorito(idfav);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
