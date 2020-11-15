<%-- 
    Document   : home
    Created on : 30/09/2020, 08:00:56 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <title>Gasolinera Don Ricardo</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie-edge">
    <link rel="stylesheet"  type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet"  type="text/css" href="css/carousel.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="img/logo.jpeg" type="image/x-icon">

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
  <body >
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
            <li class="nav-item active">
              <a class="nav-link" href="index.jsp">Inicio<span class="sr-only">(current) </a>
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

<main role="main">

  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="img/a.jpeg" class="d-block w-100" alt="...">

      </div>
      <div class="carousel-item">
        <img src="img/b.jpeg" class="d-block w-100" alt="...">

      </div>
      <div class="carousel-item">
        <img src="img/gasolinera.jpg" class="d-block w-100" alt="...">

      </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>


  <!-- Marketing messaging and featurettes
  ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->

  <div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
      <div class="col-lg-4">
        <img src="img/persona2.png" class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
        <h2>Rebeca Lopéz</h2>
        <p>Excelente servicio.</p>
        
        
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
        <img src="img/persona1.png" class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
        <h2>Mario Hernandéz</h2>
        <p>Siempre tienen los mejores precios.</p>
       
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
        <img src="img/persona3.png" class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
        <h2>Eli Mendéz</h2>
        <p>Siempre encuentro lo que necesito!.</p>
       
      </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">
<c:forEach var="p" items="${lista}">
    <div class="row featurette">
      <div class="col-md-7">
        <h2 class="featurette-heading">${p.getNombre()}<span class="text-muted">Precio Q${p.getPrecio_venta()}</span></h2>
        <p class="lead">${p.getDescripcion()}</p>
      </div>
      <div class="col-md-5">
        <img src="${p.getFoto()}" class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="350" height="350"  preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 500x500">
      </div>
    </div>

    <hr class="featurette-divider">
</c:forEach>
    

    <!-- /END THE FEATURETTES -->

  </div><!-- /.container -->


  <!-- FOOTER -->
  <footer class="container">
    <p class="float-right"><a href="#">Subir</a></p>
    <p>&copy; 2017-2020 Company, Inc. &middot;<a href="ingreso.jsp" accesskey="r">Registrate</a></p>
  </footer>
</main>

<script src="js/jquery-3.5.1.slim.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
</html>
