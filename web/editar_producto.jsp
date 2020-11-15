<%-- 
    Document   : editar_producto
    Created on : 22/09/2020, 06:42:29 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Formulario de productos</title>
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
         

            <main role="main " class="col-md-9 ml-sm-auto col-lg-10 px-md-4 ">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom ">
                    <h1 class="h2 "> Formulario de productos</h1>
                </div>
                <form class="needs-validation" action="Controlador?accion=ActualizarProducto"  enctype="multipart/form-data" method="POST" novalidate>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>ID del producto: </label>
                            <input type="text" class="form-control" name="txtid" value="${productos.getId()}"  readonly>
                            
                        </div>
                        <div class="form-group col-md-6">
                            <label>Imagen anterior:&nbsp;&nbsp;</label> 
                            <br>
                            <img src="${productos.getFoto()}"width="100" height="100">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Nombre:</label>
                            <input type="text" class="form-control" value="${productos.nombre}" name="txtNombre" placeholder="" maxLength="45" required>
                            <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                            <div class="invalid-feedback">
                                Por favor introduzca su Nombre.
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="exampleFormControlFile1">Selecciona la Imagen que desees guardar:</label>
                            <input type="file" accept=".png, .jpg"   class="form-control-sm form-control-file" id="imgProducto" name="imgProducto" required>
                            <div class="invalid-feedback">
                                Por favor seleccione la imagen que desees guardar.
                            </div>
                        </div>


                    </div>
                <div class="form-group">
                    <label for="descripcionProducto">Descripción:</label>
                    <textarea class="form-control" id="descripcionProducto"  name="descripcionProducto" rows="3" maxLength="60" required>${productos.descripcion}</textarea>
                       <div class="invalid-feedback">
                        Por favor introduzca una descripcion.
                       </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="categoria">Proveedor:<!--((codigo de proveedor anterior: ${productos.getProveedor_idProveedor()})--></label>
                        <select class="custom-select d-block w-100"  name="item_prov" required>
                           <option hidden selected value="">Selecciona una opción</option>
                            <c:forEach var="prov" items="${proveedor}">
                            <option value="${prov.getNombre_Proveedor()}">${prov.getNombre_Proveedor()}</option>
                            </c:forEach>
                            </select>
                          <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                          <div class="invalid-feedback">
                           Seleccione un Proveedor válido.
                           </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="categoria">Categoría:<!--(codigo de categoría anterior: ${productos.getCategoria()})--></label>
                        <select class="custom-select d-block w-100" name="item_cat"  required>
                            <option hidden selected value="">Selecciona una opción</option>
                           <c:forEach var="cate" items="${categoria}">
                           <option value="${cate.getNombre_categoria()}">${cate.getNombre_categoria()}</option>
                          </c:forEach>
                         </select>
                        <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                        <div class="invalid-feedback">
                       Seleccione una categoría válida.
                      </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Costo en Quetzales:</label>
                        <input type="number" class="form-control" id="costo" value="${productos.precio_compra}" name="costo" min="1" required>
                        <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                          <div class="invalid-feedback">
                          Por favor introduzca un precio valido.
                          </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Precio en Quetzales:</label>
                        <input type="number" class="form-control" id="precio" value="${productos.precio_venta}" name="precio" min="1" required>
                        <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                        <div class="invalid-feedback">
                        Por favor introduzca un precio valido.
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Cantidad Mínima de existencia:</label>
                        <input type="number" class="form-control" id="Minimo" value="${productos.min_stock}" name="Minimo" min="1" required>
                        <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                        <div class="invalid-feedback">
                         Por favor introduzca stock minimo para el producto.
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Cantidad Máxima de existencia:</label>
                        <input type="number" class="form-control" id="Maximo" value="${productos.max_stock}" name="Maximo" min="1" required>
                        <small id="emailHelp" class="form-text text-muted">Campo obligatorio. No debe dejarse vacío</small>
                         <div class="invalid-feedback">
                         Por favor introduzca stock maximo para el producto.
                         </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary btn-lg btn-block">
                    <img src="img/icons/guardar.png">
                    Editar datos
                </button>
                <br>
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
