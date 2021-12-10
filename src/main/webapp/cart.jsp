<%-- 
    Document   : cart
    Created on : 06/10/2021, 02:26:19 PM
    Author     : edicz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidad.Producto"%>
<%@page import="Entidad.Carrito"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="scripts/main.js"></script>
    </head>
    <body>
        <%@include file="/header.jsp"%>
        <div class="container">
            <br>
            <div class="row">
                <div class="col-9 card">
                    <div class="text-center card-header">
                        <h1>Carrito de Compras</h1>
                    </div>
                    <div class="row">
                        <div class="col-sm card-body">
                            <table border="1" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ITEM</th>
                                        <th>IMAGEN</th>
                                        <th>NOMBRES</th>
                                        <th>PRECIO</th>
                                        <th>CANTIDAD</th>
                                        <th>SUBTOTAL</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="car" items="${carrito}"> 
                                        <tr>
                                            <td>${car.getItem()}</td>
                                            <td><img src="${car.getImg()}" width="50" height="50"></td>
                                            <td>${car.getNombres()}</td>
                                            <td>${car.getPrecioCompra()}</td>
                                            <td>
                                                <input type="hidden" id="idProducto" value="${car.getIdProducto()}">
                                                <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1" readonly="">
                                            </td>
                                            <td>${car.getSubTotal()}</td>
                                            <td>
                                                <input type="hidden" id="idProducto" value="${car.getIdProducto()}">
                                                <a href="" id="btnDelete">Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                            <a href="javascript: history.go(-2)"  class="btn btn-outline-info my-2 my-sm-0 form-control">Seguir Comprando</a>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <div class="card">
                        <div class="card-header">
                            <h3>Generar Compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Sub Total: </label>
                            <input type="text" value="S/. ${totalPagar}" readonly="" class="form-control">
                            <label>Descuento: </label>
                            <input type="text" value="S/. 0.00" readonly="" class="form-control">
                            <label>Envio: </label>
                            <input type="text" value="S/. 0.00" readonly="" class="form-control">
                            <label>Total a Pagar: </label>
                            <input type="text" value="S/. ${totalPagar}" readonly="" class="form-control">
                        </div>
                        <div class="card-footer">
                            <a href="ControladoProducto?accion=listarCarrito" class="btn btn-outline-info btn-block">Generar Compra</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%@include file="/footer.jsp"%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
        
    </body>
</html>
