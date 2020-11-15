<%-- 
    Document   : menu
    Created on : 24/09/2020, 02:13:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet"  type="text/css" href="css/estilos.css">
<!DOCTYPE html>
            <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="./Controlador?accion=ListarTabla">
                                <img src="img/icons/inventario.png"> Inventario <span class="sr-only"></span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link " href="./Controlador?accion=ListarProveedor">
                                <img src="img/icons/proveedores.png"> Proveedores
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link " href="./Controlador?accion=ListarCategoria">
                                <img src="img/icons/categorias.png"> </span> Categorias
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link " href="./Controlador?accion=ListarUsuarios">
                                <img src="img/icons/usuarios.png">Usuarios
                            </a>
                        </li>
                       <li class="nav-item ">
                            <a class="nav-link " href="./Controlador?accion=ListarIngresos">
                                <img src="img/icons/growth.png"> </span> Ingresos
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link " href="./Controlador?accion=ListarEgresos">
                                <img src="img/icons/delivery-truck.png"> Egresos
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
