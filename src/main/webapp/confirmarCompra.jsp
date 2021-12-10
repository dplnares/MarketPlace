<%-- 
    Document   : confirmarCompra
    Created on : 06/10/2021, 06:38:19 PM
    Author     : edicz
--%>
<%@page import="Entidad.Producto"%>
<%@page import="Entidad.Articulo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entidad.Carrito"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <%@include file="/header.jsp"%>
        <br> 
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-3 card">
                    <hr>
                    <h3>Bienvenido: </h3>
                    <h5><jsp:getProperty name="usuarioBean" property ="nombresUsuario" /> <jsp:getProperty name="usuarioBean" property ="apellidosUsuario" /></h5>
                    <hr>
                    <img src="img/publicidad.png">
                    <hr>
                </div>
                <div class="col-9 text-center">
                    <form action="ControladoProducto">
                        <input type="hidden" name="accion" value="GenerarCompra">	
                        <div class="row">
                        <hr>
                        <div class="col-sm card">
                            <div class="card-header">
                                <h1>Registrar Compra</h1>                            
                            </div>
                            <div class="card-body" >
                                <div class="form-group">
                                    <label>Direccion de envio: </label>
                                    <input type="text" name="direccionPedido" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div class="form-group">
                                    <label>Fecha de Registro: </label>
                                    <input type="text" name="fechaPedido" required class="form-control" id="fecha" readonly="">
                                    <script>
                                        var f = new Date();
                                        document.getElementById("fecha").value =(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
                                    </script>
                                </div>
                                <div class="form-group">
                                    <label>Hora de Entrega </label>
                                    <input type="time" name="horaEntrega" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Fecha de Entrega </label>
                                    <input type="date" name="fechaEntrega" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <select name="idTienda" class="custom-select mr-sm-2 form-control" style="visibility:hidden">
                                        <c:forEach var="car" items="${carrito}">
                                            <option value="${car.getIdTienda()}"></option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group ">
                                    <label>Metodo de Pago</label>
                                    <select name="idPago" class="custom-select mr-sm-2 form-control">
                                        <option value="1">Efectivo</option>
                                        <option value="2" selected>Tarjeta</option>
                                    </select>
                                </div>
                                <input type="hidden" value="<jsp:getProperty name="usuarioBean" property ="idUsuario" />" name="idUsuario" required class="form-control" id="exampleFormControlInput1">
                                       
                            </div>
                            <div class="card-footer">
                                <input type="submit" value="Registrar" class="btn btn-info btn-block">
                                <a href="javascript: history.go(-3)"class="btn btn-info btn-block">Mostrar mas productos</a>
                            </div>    
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
         <br>
         <br>
         <br>
         <br>
        <%@include file="/footer.jsp"%>
    </body>
</html>
