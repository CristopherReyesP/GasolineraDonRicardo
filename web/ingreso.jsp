<%-- 
    Document   : ingreso
    Created on : 8/09/2020, 07:44:28 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <title>login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie-edge">
    <link rel="stylesheet"  type="text/css" href="css/bootstrap.css">
    <link href="css/signin.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/logo.jpeg" type="image/x-icon">
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
    <!-- Custom styles for this template -->

  </head>
  <body class="text-center" >
    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-celeste">
        <a class="navbar-brand" href="#"><label>Don Ricardo</label></a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
              <a class="nav-link" href="index.jsp">Inicio </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="./Controlador?accion=Listar">Productos</span></a>
            </li>
          </ul>
          <form class="form-inline mt-2 mt-md-0" action="Controlador">
            <input class="form-control mr-sm-2" type="text" placeholder="Buscar" aria-label="Search" name="txtBuscar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Buscar" name="accion">Buscar</button>
          </form>

        </div>
      </nav>
    </header>
    <form class="form-signin"  action="Controlador">
  <img class="mb-4 mt-5" src="img/logo.jpeg" alt="" width="150" height="150">
  <h1 class="h3 mb-3 font-weight-normal">Por favor, registrese</h1>
  <label for="inputEmail" class="sr-only">Usuario</label>
  <input type="text"  name="txtuser" class="form-control" placeholder="Usuario" required autofocus>
                      <div class="invalid-feedback">
                        Por favor introduzca un usuario válido.
                    </div>
  <label for="inputPassword" class="sr-only">Contraseña</label>
  <input type="password" name="txtpass" class="form-control" placeholder="Contraseña" required>
                    <div class="invalid-feedback">
                        Por favor introduzca una contraseña válida.
                    </div>
  
  <!-- <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button> -->
  <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn btn-block">

  <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
</form>
</body>

<script src="js/jquery-3.5.1.slim.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/form-validation.js"></script>
</html>
