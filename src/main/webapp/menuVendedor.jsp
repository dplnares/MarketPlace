<%-- 
    Document   : menuVendedor
    Created on : 03/10/2021, 02:37:43 PM
    Author     : edicz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br> 
        <br>
        <div class="container">
            <div class="row align-items-center">
                <div class="col-sm text-center card">
                    <img class="d-block w-100" src="img/logoImagen.png" width="120" height="200">
                </div>
            </div><br>
            <div class="row align-items-center">
                <div class="col-sm text-center card" id="busqueda-cerrar">
                    <span class="busqueda-etiqueta"><jsp:getProperty name="tiendaBean" property ="nombreTienda" /></span>
                </div>
            </div><br>
            <div class="row align-items-center">
                <div class="col-sm text-center card"><br>
                    <a class="btn btn-info mr-2 " href="loginVender.jsp">Cerrar Sesion</a>
                    <br>
                    <a class="btn btn-info mr-2" href="" >Mi Perfil</a>
                    <br>
                    <a class="btn btn-info mr-2" href="ServletProducto?tipo=listarProducto&id=<jsp:getProperty name="tiendaBean" property ="idTienda"/>">Productos</a>
                    <br>
                    <a class="btn btn-info mr-2" href="ServletProducto?tipo=listarReporte&id=<jsp:getProperty name="tiendaBean" property ="idTienda"/>"">Reportes</a>
                    <br>
                    <a class="btn btn-info mr-2" href="ServletProducto?tipo=listarPedidoClienteTienda&id=<jsp:getProperty name="tiendaBean" property ="idTienda"/>">Pedidos</a>
                    <br>
                </div>
            </div>
        </div>
        <br> 
        <br>
        <br>
    </body>
   
</html>
