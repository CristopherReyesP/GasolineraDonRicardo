<%-- 
    Document   : catalogo
    Created on : 8/09/2020, 07:44:15 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <title>productos</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie-edge">
    <link rel="stylesheet"  type="text/css" href="css/bootstrap.css">
    <link rel="shortcut icon" href="img/logo.jpeg" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet"  type="text/css" href="css/estilos.css">
       <style>
div {
  overflow: hidden;
}
    </style>
  </head>
  <body>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
     <a href="https://api.whatsapp.com/send?phone=50255214765&text=Hola%20" class="float" target="_blank">
     <i class="fa fa-whatsapp my-float"></i>
     </a>
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
            <li class="nav-item active">
              <a class="nav-link" href="./Controlador?accion=Listar">Productos<span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <form class="form-inline mt-2 mt-md-0" action="Controlador">
            <input class="form-control mr-sm-2" type="text" placeholder="Buscar" aria-label="Search" name="txtBuscar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Buscar" name="accion">Buscar</button>
          </form>

        </div>
      </nav>
    </header>

<main role="main">

   <section class="jumbotron text-center">
    <div class="container mt-5">
      <h1 class="text-primary">Productos</h1>
      <p class="lead text-muted">Ponemos a tu disposicion nuestros productos, visitanos en nuestra tienda y será un gusto atenderte.</p>
    </div>
  </section> 

  
<div class="container mt-2">
    <div class="row">
     <c:forEach var="p" items="${lista}"> 
         <div class="col-md-4 mt-4 " style="word-wrap: break-word;">
        <div class="card  ">
          <div class="card-header ">
              <h6>${p.getNombre()}</h6>
          </div>
          <div class="card-body">
            <h7>Q${p.getPrecio_venta()}</h7>
            <img src="${p.getFoto()}" width="200" height="180">
          </div>
          <div class="card-footer text-center text-break" > 
            <label >${p.getDescripcion()}</label>
          </div>
         
        </div>
      </div>
     </c:forEach>
    </div>
</div>
    <hr class="featurette-divider mt-5">
  <footer class="container">
    <p class="float-right"><a href="#">Subir</a></p>
    <p>&copy; 2017-2020 Company, Inc. &middot;<a href="ingreso.jsp" accesskey="r">Registrate</a></p>
  </footer>
</main>

      <script src="js/jquery-3.5.1.slim.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
</html>
