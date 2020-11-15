<%-- 
    Document   : control_de_inventario
    Created on : 8/09/2020, 07:44:50 AM
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


    <!-- ICONO -->
    <link rel="shortcut icon" href="img/icons/inventario.png" type="image/x-icon">
   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"> 
   <!-- <link rel="stylesheet"  type="text/css" href="css/bootstrap.css">-->
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/animaciones.css">
    <link rel="stylesheet" type="text/css" href="css/dashboard.css">

  <!--codigo de paginacion-->


</head>

<body onload="funciones()">
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
                    <h1 class="h2">Dashboard: Control de inventario</h1>
                    <div class="btn-toolbar mb-2 mb-md-0">
                        <div class="btn-group mr-2">
                            <button type="button" class="btn  btn-outline-success" onclick="location.href='./Controlador?accion=Nuevo'">
                                
                                <img src="img/icons/añadir.png">                                
                                Añadir nuevo producto
                            </button>
                             <button class="btn btn-lg btn-outline-warning my-2 my-sm-0" type="button" onclick="location.href='./Controlador?accion=FormFavoritos'">
                             <img src="img/icons/estrella.png"> Actualizar Favoritos
                             </button>
                  
                        </div>
                    </div>
                </div>

                <h2>Productos</h2>

                <div class="table-responsive">
                    <table id="datos"  class="table table-striped table-sm ">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th >Descripción</th>
                                <th>Costo</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th>Stock Mín.</th>
                                <th>Stock Máx.</th>
                                <th>Id Prov.</th>
                                <th>Id Ca.</th>
                                <th>Imagen</th>
                                <th>Actualizar / Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${lista}">
                            <tr id="resConsulta">
                                <td ><img class="${p.getFavorito()}" src=""></td>
                                <td>${p.getId()}</td>
                                <td class="text-break" style="max-width: 150px;">${p.getNombre()}</td>
                                <td class="text-break" style="max-width: 150px;">${p.getDescripcion()}</td>
                                <td>Q${p.getPrecio_compra()}</td>
                                <td>Q${p.getPrecio_venta()}</td>
                                <td id="${p.getEstado_stock()}">${p.getStock()}</td>
                                <td id="minStock">${p.getMin_stock()}</td>
                                <td>${p.getMax_stock()}</td>
                                <td>${p.getProveedor_idProveedor()}</td>
                                <td>${p.getCategoria()}</td>
                                <td><img src="${p.getFoto()}"width="60" height="60"></td>
                                <td>
                                    <div class="btn-group " role="group " aria-label="Basic example ">
                                            <button type="button" class="btn btn-outline-warning" onclick="location.href='./Controlador?accion=EditarProducto&id=${p.getId()}'">
                                                <img src="img/icons/actualizar.png"> Actualizar
                                            </button>
                                             
                                            <button  id="deleteItem" type="button" class="btn btn-outline-danger" onclick="location.href='./Controlador?accion=EliminarProducto&id=${p.getId()}'">
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
    <script src="js/bootstrap.min.js"></script>
    <script src="dashboard.js"></script> 
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
    
    <script language="javascript">
        
     	function alerta() {
                let Stock = document.querySelectorAll('#NO');

    for(i=0; i<Stock.length ; i++)
    {
	Stock[i].style.color="#FF0000";
    }
           
	} 
        
       function imgfav(){
        let favoritos = document.querySelectorAll('.SI');
            for(i=0; i<favoritos.length ; i++)
    {
	favoritos[i].src="img/icons/estrella.png";
    }
       }
       function reenvio(){
         if (window.history.replaceState) { // verificamos disponibilidad
         window.history.replaceState(null, null, window.location.href);
         }
       }
     function funciones(){
         alerta();
         imgfav();
         reenvio();
     }
     $(document).ready( function () {
    $('#datos').DataTable();
    } );

    </script>
    
</body>

</html>
