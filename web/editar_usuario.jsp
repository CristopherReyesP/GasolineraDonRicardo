<%-- 
    Document   : editar_usuario
    Created on : 24/09/2020, 12:56:15 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Formulario de usuarios</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie-edge">

    <!-- ICONO -->
    <link rel="shortcut icon" href="img/icons/inventario.png" type="image/x-icon">


    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/animaciones.css">
    <link rel="stylesheet" type="text/css" href="css/dashboard.css">
    <link rel="stylesheet"  type="text/css" href="css/form-validation.css">
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

<body>
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
                    <h1 class="h2 "> Formulario de usuarios</h1>
                </div>
                <form class="needs-validation" action="./Controlador?accion=ActualizaUsuario"  enctype="multipart/form-data" method="POST" novalidate>
                                        <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">ID del Usuario:</label>
                            <input type="text" class="form-control" id="IdUsuario" name="IdUsuario" maxLength="45" required value="${usuarios.getIdUsuario()}" readonly>
                            <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                    <div class="invalid-feedback">
                        Por favor introduzca un nombre.
                    </div>                        
                        </div>
               
                </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Nombre</label>
                            <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" maxLength="45"  value="${usuarios.getNombreUsuario()}" required>
                            <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                    <div class="invalid-feedback">
                        Por favor introduzca un nombre.
                    </div>                        
                        </div>
               
                </div>
                <div class="form-row">

                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Contraseña</label>
                        <input type="password" class="form-control" id="pass" name="contraseña" maxLength="20" value="${usuarios.getPassword()}" required>
                        <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                     <div class="invalid-feedback">
                        Por favor introduzca un nombre.
                    </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary btn-lg btn-block">
                    <img src="img/icons/guardar.png">
                    Editar datos
                </button>
                    
               </form>
            </main>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js " integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj " crossorigin="anonymous "></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js " integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN " crossorigin="anonymous "></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js " integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV " crossorigin="anonymous "></script>
   <script src="js/form-validation.js"></script>
    <!-- <script src="../js/jquery-3.5.1.slim.min.js "></script>
    <script src="../js/popper.min.js "></script>
    <script src="../js/bootstrap.min.js "></script>
    <script src="dashboard.js "></script> -->
</body>

</html>

