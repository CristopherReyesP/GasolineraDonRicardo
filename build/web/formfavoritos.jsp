<%-- 
    Document   : formfavoritos
    Created on : 1/10/2020, 08:25:52 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Control de Inventario: dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie-edge">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
  

    <!-- ICONO -->
    <link rel="shortcut icon" href="img/icons/inventario.png" type="image/x-icon">


    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"> 
   <!-- <link rel="stylesheet"  type="text/css" href="css/bootstrap.css">-->
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/animaciones.css">
    <link rel="stylesheet" type="text/css" href="css/dashboard.css">




</head>

<body onload="alerta()">
    <nav class="navbar navbar-dark sticky-top bg-celeste flex-md-nowrap p-0 shadow bg-primary  ">
        <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3ng" href="index.jsp">Don Ricardo</a>
        <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
      


        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="index.jsp">Salir</a>
            </li>
        </ul>
    </nav>

    <div class="container-fluid animated fadeIn fast">
        <div class="row">
<%@include file="menu.jsp" %>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">Dashboard: Añadir Favoritos</h1>

                </div>

           <form class="form-outline mt-2 mt-md-0" action="Controlador">
               <div class="input-group mb-3">
                   <select class="custom-select"  name="item_prod" required>
                           <option hidden selected value="">Selecciona una opción</option>
                            <c:forEach var="pro" items="${lista}">
                            <option>${pro.getNombre()}</option>
                            </c:forEach>
                   </select>
                   <div class="input-group-append">
                      <button class="btn btn-outline-warning my-2 my-sm-0" type="submit" value="AñadirFavoritos" name="accion"><img src="img/icons/estrella.png"> Añadir Favoritos</button>
                   </div>
               </div>
          </form>
                <div class="table-responsive">
                    <table id="datos" number-per-page="4" current-page=""  class="table table-striped table-sm ">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th >Descripción</th>
                                <th>Imagen</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${listafav}">
                            <tr id="resConsulta">
                                <td>${p.getId()}</td>
                                <td class="text-break" style="max-width: 150px;">${p.getNombre()}</td>
                                <td class="text-break" style="max-width: 150px;">${p.getDescripcion()}</td>
                                <td><img src="${p.getFoto()}"width="40" height="40"></td>
                                <td>
                                    <div class="btn-group " role="group " aria-label="Basic example ">
                                            <button  id="deleteItem" type="button" class="btn btn-outline-danger" onclick="location.href='./Controlador?accion=EliminarFavorito&id=${p.getId()}'">
                                            <img src="img/icons/eliminar.png">Eliminar
                                        </button>
                                    </div>
                                </td>

                            </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </main>
        </div>
    </div>

    <script src="js/jquery-3.5.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/paginacion.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="dashboard.js"></script> 
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
     <script>  
$(document).ready( function () {
    $('#datos').DataTable();
} );
    </script>  
</body>

</html>
