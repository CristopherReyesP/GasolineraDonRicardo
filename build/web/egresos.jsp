<%-- 
    Document   : egresos
    Created on : 24/09/2020, 08:52:12 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Egresos</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie-edge">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
    <!-- ICONO -->
    <link rel="shortcut icon" href="img/icons/inventario.png" type="image/x-icon">


    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/animaciones.css">
    <link rel="stylesheet" type="text/css" href="css/dashboard.css">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }
        
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

</head>

<body onload="funciones()">
    <nav class="navbar navbar-dark sticky-top bg-celeste flex-md-nowrap p-0 shadow bg-primary">
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
            <main role="main " class="col-md-9 ml-sm-auto col-lg-10 px-md-4 ">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom ">
                    <h1 class="h2 ">Dashboard: Egresos</h1>
                    <div class="btn-toolbar mb-2 mb-md-0 ">
                        <div class="btn-group mr-2 ">
                            <button type="button " class="btn btn-lg btn-outline-success " onclick="location.href='./Controlador?accion=NuevoEgreso'">
                                <img src="img/icons/añadir.png">
                                Añadir nuevo egreso
                            </button>
                        </div>
                    </div>
                </div>

                <!-- <canvas class="my-4 w-100 " id="myChart " width="900 " height="380 ">Tu navegador no soporta canvas. Mensaje para mostrar si el navegador no soporta la etiqueta canvas 
      
      </canvas></canvas> -->

                <div class="table-responsive ">
                    <table id="datos" number-per-page="10" current-page=""  class="table table-striped table-sm ">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Fecha</th>
                                <th>Producto</th>
                                <th>Cantidad</th>
                                 <!-- <th>Eliminar</th> -->
                            </tr>
                        </thead>
                        <tbody>
                             <c:forEach var="p" items="${listaegresos}">
                            <tr>
                                <td>${p.getId_egreso()}</td>
                                <td>${p.getFecha()}</td>
                                <td>${p.getNombreProd()}</td>
                                <td>${p.getCantidad()}</td>
                            </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </main>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js " integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj " crossorigin="anonymous "></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js " integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN " crossorigin="anonymous "></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js " integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV " crossorigin="anonymous "></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
    <script language="javascript">       
    $(document).ready( function () {
        $('#datos').DataTable();
    } );
    </script>
    <script language="javascript">
       function reenvio(){
         if (window.history.replaceState) { // verificamos disponibilidad
         window.history.replaceState(null, null, window.location.href);
         }
       }
     function funciones(){
         reenvio();
     }     
    </script>
</body>

</html>