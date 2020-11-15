<%-- 
    Document   : alerta_succes
    Created on : 02-oct-2020, 18:01:34
    Author     : Shelby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    </head>
    <body>
        
        <script>
            setTimeout(function () { 
swal({
     title: "Registro almacenado",
     text: "La información ha sido registrada exitosamente.",
     type: "success",
     confirmButtonText: "OK"
},
function(isConfirm){
     if (isConfirm) {
        window.location.href = "http://localhost:8080/DonRicardo/Controlador?accion=ListarUsuarios";
     }
}); }, 2000);

    
        </script>

        <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
    </body>
</html>
