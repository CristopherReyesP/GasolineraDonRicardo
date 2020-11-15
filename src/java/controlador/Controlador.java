
package controlador;

import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ProductoDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.CategoriaDAO;
import modelo.Categoría;
import modelo.Egreso;
import modelo.EgresoDAO;
import modelo.Ingreso;
import modelo.IngresoDAO;
import modelo.Producto;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class Controlador extends HttpServlet {

    ProductoDAO pdao=new ProductoDAO();
    ProveedorDAO provdao=new ProveedorDAO();
    CategoriaDAO catdao=new CategoriaDAO();
    IngresoDAO indao=new IngresoDAO();
    EgresoDAO edao=new EgresoDAO();
    UsuarioDAO usdao=new UsuarioDAO();
    List<Producto> productos=new ArrayList<>();
    List<Proveedor> proveedor=new ArrayList<>();
    List<Categoría> categoria=new ArrayList<>();
    List<Usuario> usuario=new ArrayList<>();
    List<Ingreso> ingreso=new ArrayList<>();
    List<Ingreso> egreso=new ArrayList<>();
    List<Producto> favoritos=new ArrayList<>();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        String accion=request.getParameter("accion");
        favoritos = pdao.listar_favoritos();
        productos = pdao.listar();
        proveedor = provdao.listar_proveedor();
        categoria = catdao.listar_categoria();
        usuario = usdao.listar_usuario();
        ingreso = indao.listar_ingreso();
        egreso = edao.listar_egreso();
        Usuario eu = new Usuario();
        int r;
        switch (accion){
            case "Ingresar":
            String nom = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            eu.setNombreUsuario(nom);
            eu.setPassword(pass);
            r = usdao.validar(eu);
            if (r == 1) {
                request.getSession().setAttribute("nom", nom);
                request.getSession().setAttribute("pass", pass);
                request.getRequestDispatcher("Controlador?accion=ListarTabla").forward(request, response);
            } else {
                request.getRequestDispatcher("ingreso.jsp").forward(request, response);
            }
                break;
              case "EliminarEgreso":
                int idegreso = Integer.valueOf(request.getParameter("id"));
                edao.EliminarIngreso(idegreso);
                request.getRequestDispatcher("Controlador?accion=ListarEgresos").forward(request, response);
                break;
            case "GuardarEgreso":
                ArrayList<String> egr = new ArrayList<>();
                Egreso eg = new Egreso();
                Calendar ca = new GregorianCalendar();
                String diae = Integer.toString(ca.get(Calendar.DATE));
                String mese = Integer.toString(ca.get(Calendar.MONTH)+1);
                String anioe = Integer.toString(ca.get(Calendar.YEAR));
                String fechae =  diae + "-" + mese + "-" + anioe;
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        egr.add(fileItem.getString("UTF-8"));
                    }
                    int ide=edao.IdProducto(egr.get(0));
                    eg.setNombreProd(egr.get(0));
                    eg.setFecha(fechae);
                    eg.setProducto(ide);
                    eg.setCantidad(Integer.parseInt(egr.get(1)));
                    edao.guardarEgreso(eg);
                } catch (Exception e) {
                    System.err.println("shhhhhhhay un error" + e);
                }
                request.getRequestDispatcher("Controlador?accion=ListarEgresos").forward(request, response);
                break;
             case "NuevoEgreso":
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("formegresos.jsp").forward(request, response);
                break;
             case "ListarEgresos":

                request.setAttribute("listaegresos", egreso);
                request.getRequestDispatcher("egresos.jsp").forward(request, response);
                break;
             case "EliminarIngreso":
                int idingreso = Integer.valueOf(request.getParameter("id"));
                indao.EliminarIngreso(idingreso);
                request.getRequestDispatcher("Controlador?accion=ListarIngresos").forward(request, response);
                break;
            case "GuardarIngreso":
                ArrayList<String> ing = new ArrayList<>();
                Ingreso in = new Ingreso();
                Calendar c = new GregorianCalendar();
                String dia = Integer.toString(c.get(Calendar.DATE));
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String anio = Integer.toString(c.get(Calendar.YEAR));
                String fecha =  dia + "-" + mes + "-" + anio;
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        ing.add(fileItem.getString("UTF-8"));
                    }
                    int id=indao.IdProducto(ing.get(0));
                    in.setNombreProd(ing.get(0));
                    in.setFecha(fecha);
                    in.setProducto(id);
                    in.setCantidad(Integer.parseInt(ing.get(1)));
                    indao.guardarIngreso(in);
                } catch (Exception e) {
                    System.err.println("shhhhhhhay un error" + e);
                }
                request.getRequestDispatcher("Controlador?accion=ListarIngresos").forward(request, response);
                break;
             case "NuevoIngreso":
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("formingresos.jsp").forward(request, response);
                break;
             case "ListarIngresos":

                request.setAttribute("listaingresos", ingreso);
                request.getRequestDispatcher("ingresos.jsp").forward(request, response);
                break;
             case "EliminarUsuario":
                int idusr = Integer.valueOf(request.getParameter("id"));
                usdao.EliminarUsuario(idusr);
                response.sendRedirect("alert_eliminar_usu.jsp");
                //request.getRequestDispatcher("Controlador?accion=ListarUsuarios").forward(request, response);
                break;
            case "ActualizaUsuario":
                ArrayList<String> user = new ArrayList<>();
                Usuario usr = new Usuario();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);

                        user.add(fileItem.getString("UTF-8"));
                    }
                    usr.setIdUsuario(Integer.parseInt(user.get(0)));
                    usr.setNombreUsuario(user.get(1));
                    usr.setPassword(user.get(2));
                    usdao.ActualizarUsuario(usr);
                    response.sendRedirect("alert_guardar_usu.jsp");
                } catch (Exception e) {
                    //System.err.println("shhhhhhhay un error" + e);
                    response.sendRedirect("alert_error_usu.jsp");
                }
//                request.getRequestDispatcher("Controlador?accion=ListarUsuarios").forward(request, response);
                break;
            case "EditarUsuarior":
                int idus = Integer.valueOf(request.getParameter("id"));
                Usuario usu = usdao.listarporid(idus);
                request.setAttribute("usuarios", usu);
                request.getRequestDispatcher("editar_usuario.jsp").forward(request, response);
                break;
            case "GuardarUsuario":
                ArrayList<String> us = new ArrayList<>();
                Usuario u = new Usuario();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        us.add(fileItem.getString("UTF-8"));
                    }
                    u.setNombreUsuario(us.get(0));
                    u.setPassword(us.get(1));
                    usdao.guardarUsuario(u);
                    response.sendRedirect("alert_guardar_usu.jsp");
                } catch (Exception e) {
                    //System.err.println("shhhhhhhay un error" + e);
                    response.sendRedirect("alert_error_usu.jsp");
                    
                }
//                request.getRequestDispatcher("Controlador?accion=ListarUsuarios").forward(request, response);
                break;
            case "NuevoUsuario":
                request.getRequestDispatcher("formusuario.jsp").forward(request, response);
                break;
            case "ListarUsuarios":
                request.setAttribute("listausuario", usuario);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                break;
            case "EliminarCategoria":
                int idcategoria = Integer.valueOf(request.getParameter("id"));
                catdao.EliminarCategoria(idcategoria);
                response.sendRedirect("alert_eliminar_cat.jsp");
                //request.getRequestDispatcher("Controlador?accion=ListarCategoria").forward(request, response);
                break;
            case "ActualizarCategoria":
                ArrayList<String> categ = new ArrayList<>();
                Categoría catg = new Categoría();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);

                        categ.add(fileItem.getString("UTF-8"));
                    }
                    catg.setId_categoria(Integer.parseInt(categ.get(0)));
                    catg.setNombre_categoria(categ.get(1));
                    catg.setDescripcion(categ.get(2));
                    catdao.ActualizarCategoria(catg);
                    response.sendRedirect("alert_guardar_cat.jsp");
                } catch (Exception e) {
                   // System.err.println("shhhhhhhay un error" + e);
                   response.sendRedirect("alert_error_cat.jsp");
                }
                //request.getRequestDispatcher("Controlador?accion=ListarCategoria").forward(request, response);
                break;
            case "EditarCategoria":
                int idcat = Integer.valueOf(request.getParameter("id"));
                Categoría cate = catdao.listarporid(idcat);
                request.setAttribute("categorias", cate);
                request.getRequestDispatcher("editar_categoria.jsp").forward(request, response);
                break;
            case "GuardarCategoria":
                ArrayList<String> cat = new ArrayList<>();
                Categoría catt = new Categoría();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        cat.add(fileItem.getString("UTF-8"));
                    }
                    catt.setNombre_categoria(cat.get(0));
                    catt.setDescripcion(cat.get(1));
                    catdao.guardarCategoria(catt);
                    response.sendRedirect("alert_guardar_cat.jsp");
                } catch (Exception e) {
                    //System.err.println("shhhhhhhay un error" + e);
                    response.sendRedirect("alert_error_cat.jsp");
                }
                //request.getRequestDispatcher("Controlador?accion=ListarCategoria").forward(request, response);
                break;
            case "ListarCategoria":
                request.setAttribute("listacategoria", categoria);
                request.getRequestDispatcher("categorias.jsp").forward(request, response);
                break;
            case "EditarProveedor":
                int idprov = Integer.valueOf(request.getParameter("id"));
                Proveedor proveed = provdao.listarporid(idprov);
                request.setAttribute("proveedores", proveed);
                request.getRequestDispatcher("editar_proveedor.jsp").forward(request, response);
                break;
            case "ActualizarProveedor":
                ArrayList<String> prvd = new ArrayList<>();
                Proveedor ap = new Proveedor();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);

                        prvd.add(fileItem.getString("UTF-8"));
                    }
                    ap.setId_proveedor(Integer.parseInt(prvd.get(0)));
                    ap.setNombre_Proveedor(prvd.get(1));
                    ap.setDireccion(prvd.get(2));
                    ap.setTelefono(Integer.parseInt(prvd.get(3)));
                    provdao.ActualizarProveedor(ap);
                     response.sendRedirect("alert_guardar_prov.jsp");
                } catch (Exception e) {
                    //System.err.println("shhhhhhhay un error" + e);
                    response.sendRedirect("alert_error_prov.jsp");
                }
                request.getRequestDispatcher("Controlador?accion=ListarProveedor").forward(request, response);
                break;
            case "EliminarProveedor":
                int idprv = Integer.valueOf(request.getParameter("id"));
                provdao.EliminarProveedor(idprv);
                //request.getRequestDispatcher("Controlador?accion=ListarProveedor").forward(request, response);
                response.sendRedirect("alert_eliminar_prov.jsp");
                break;
            case "GuardarProveedor":
                ArrayList<String> prov = new ArrayList<>();
                Proveedor pv = new Proveedor();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        prov.add(fileItem.getString("UTF-8"));
                    }
                    pv.setNombre_Proveedor(prov.get(0));
                    pv.setDireccion(prov.get(1));
                    pv.setTelefono(Integer.parseInt(prov.get(2)));
                    provdao.guardarProveedor(pv);
                    response.sendRedirect("alert_guardar_prov.jsp");
                } catch (Exception e) {
                    //System.err.println("shhhhhhhay un error" + e);
                    response.sendRedirect("alert_error_prov.jsp");
                }
//                request.getRequestDispatcher("Controlador?accion=ListarProveedor").forward(request, response);
               
                break;
            case "NuevoProveedor":
                request.getRequestDispatcher("formproveedor.jsp").forward(request, response);
                break;
            case "FormFavoritos":
                request.setAttribute("lista", productos);
                request.setAttribute("listafav", favoritos);
                request.getRequestDispatcher("formfavoritos.jsp").forward(request, response);
                break;
            case "AñadirFavoritos":  
                String pfav;
                pfav=request.getParameter("item_prod");
                pdao.agregarfavoritos(pfav);
                request.getRequestDispatcher("Controlador?accion=FormFavoritos").forward(request, response);
                break;
            case "EliminarFavorito":
                int idfav = Integer.valueOf(request.getParameter("id"));
                pdao.EliminarFavorito(idfav);
                response.sendRedirect("alert_eliminar_produc.jsp");
                //request.getRequestDispatcher("Controlador?accion=FormFavoritos").forward(request, response);
                
                break;
            case "ListarProveedor":
                request.setAttribute("listaproveedor", proveedor);
                request.getRequestDispatcher("proveedores.jsp").forward(request, response);
                break;
            case "EditarProducto":
                int id = Integer.valueOf(request.getParameter("id"));
                Producto product = pdao.listarporid(id);
                request.setAttribute("productos", product);
                request.setAttribute("categoria", categoria);
                request.setAttribute("proveedor", proveedor);
                request.getRequestDispatcher("editar_producto.jsp").forward(request, response);
                break;
            case "ActualizarProducto":
                ArrayList<String> pro = new ArrayList<>();
                Producto p = new Producto();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            File file;//aca es donde queremos guardar C:\Users\DELL\Documents\NetBeansProjects\DonRicardo\web\img
                            file = new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\DonRicardo\\web\\img\\" + fileItem.getName());
                            fileItem.write(file);
                            p.setFoto("img//" + fileItem.getName());
                        } else {
                            pro.add(fileItem.getString("UTF-8"));
                        }
                    }
                    p.setId(Integer.parseInt(pro.get(0)));
                    p.setNombre(pro.get(1));
                    p.setDescripcion(pro.get(2));
                    p.setProveedor_idProveedor(provdao.listarid(pro.get(3)));
                    p.setCategoria(catdao.listarid(pro.get(4)));
                    p.setPrecio_compra(Double.parseDouble(pro.get(5)));
                    p.setPrecio_venta(Double.parseDouble(pro.get(6)));
                    p.setMin_stock(Integer.parseInt(pro.get(7)));
                    p.setMax_stock(Integer.parseInt(pro.get(8)));

                    pdao.ActualizarProducto(p);
                    response.sendRedirect("alert_guardar_produc.jsp");
                } catch (Exception e) {
                    //System.err.println("shhhhhhhay un error" + e);
                     response.sendRedirect("alert_errorMod_produc.jsp");
                }
//                request.getRequestDispatcher("Controlador?accion=ListarTabla").forward(request, response);
                break;
            case "ListarTabla":
                request.setAttribute("lista", productos);
                request.getRequestDispatcher("control_de_inventario.jsp").forward(request, response);
                break;
            case "EliminarProducto":
                int idpro = Integer.valueOf(request.getParameter("id"));
                pdao.EliminarProducto(idpro);
                //request.getRequestDispatcher("Controlador?accion=ListarTabla").forward(request, response);
                response.sendRedirect("alert_eliminar_produc.jsp");   
                break;
            case "Nuevo":
                request.setAttribute("categoria", categoria);
                request.setAttribute("proveedor", proveedor);
                request.getRequestDispatcher("formproducto.jsp").forward(request, response);
                break;
            case "Listar":
                request.setAttribute("lista", productos);
                request.getRequestDispatcher("catalogo.jsp").forward(request, response);
                break;
            case "ListarFavoritos":
                request.setAttribute("lista", favoritos);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            case "Buscar":
                String dato = request.getParameter("txtBuscar");
                List<Producto> lista = pdao.buscar(dato);
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("catalogo.jsp").forward(request, response);
                break;
            case "BuscarP":
                String datobuscar = request.getParameter("txtBuscar");
                List<Producto> listas = pdao.buscar(datobuscar);
                request.setAttribute("lista", listas);
                request.getRequestDispatcher("control_de_inventario.jsp").forward(request, response);
                break;
            case "BuscarProveedores":
                String buscarp = request.getParameter("txtBuscar");
                List<Proveedor> listasp = provdao.buscar(buscarp);
                request.setAttribute("listaproveedor", listasp);
                request.getRequestDispatcher("proveedores.jsp").forward(request, response);
                break;
             case "BuscarCategoria":
                String buscarc = request.getParameter("txtBuscar");
                List<Categoría> listasc = catdao.buscar(buscarc);
                request.setAttribute("listacategoria", listasc);
                request.getRequestDispatcher("categorias.jsp").forward(request, response);
                break;
             case "BuscarUsuario":
                String buscarUs = request.getParameter("txtBuscar");
                List<Usuario> listasUs = usdao.buscar(buscarUs);
                request.setAttribute("listausuario", listasUs);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                break;
              case "BuscarFecha":
                String buscarFecha = request.getParameter("txtBuscar");
                List<Ingreso> listasFecha = indao.buscar(buscarFecha);
                request.setAttribute("listaingresos", listasFecha);
                request.getRequestDispatcher("ingresos.jsp").forward(request, response);
                break;
                case "BuscarFechaE":
                String buscarFechaE = request.getParameter("txtBuscar");
                List<Egreso> listasFechaE = edao.buscar(buscarFechaE);
                request.setAttribute("listaegresos", listasFechaE);
                request.getRequestDispatcher("egresos.jsp").forward(request, response);
                break;
            case "GuardarProducto":
                ArrayList<String> prod = new ArrayList<>();
                Producto pt = new Producto();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    fileUpload.setHeaderEncoding("UTF-8");
                    List items = fileUpload.parseRequest(request);//captura todos los datos
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            File file;//aca es donde queremos guardar C:\Users\DELL\Documents\NetBeansProjects\DonRicardo\web\img
                            file = new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\DonRicardo\\web\\img\\" + fileItem.getName());
                            fileItem.write(file);
                            pt.setFoto("img/" + fileItem.getName());
                        } else {
                            prod.add(fileItem.getString("UTF-8"));
                        }
                    }
//                p.setId(Integer.parseInt(pro.get(0)));
                    pt.setNombre(prod.get(0));
                    pt.setDescripcion(prod.get(1));
                    pt.setProveedor_idProveedor(provdao.listarid(prod.get(2)));
                    pt.setCategoria(catdao.listarid(prod.get(3)));
                    pt.setPrecio_compra(Double.parseDouble(prod.get(4)));
                    pt.setPrecio_venta(Double.parseDouble(prod.get(5)));
                    pt.setMin_stock(Integer.parseInt(prod.get(6)));
                    pt.setMax_stock(Integer.parseInt(prod.get(7)));
                    pt.setStock(Integer.parseInt(prod.get(8)));

                    pdao.guardar(pt);
                     response.sendRedirect("alert_guardar_produc.jsp"); 

                } catch (Exception e) {
                    //System.err.println("shhhhhhhay un error" + e);
                    response.sendRedirect("alert_error_produc.jsp");
                }
//                request.getRequestDispatcher("Controlador?accion=ListarTabla").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            }
    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
