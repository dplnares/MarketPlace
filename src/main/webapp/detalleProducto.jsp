<%-- 
    Document   : detalleProducto
    Created on : 06/10/2021, 01:36:12 PM
    Author     : edicz
--%>

<%@page import="Entidad.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%   Producto a = (Producto) request.getAttribute("data"); %>
        <%@include file="/header.jsp"%>
        <br> 
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-12 card">
                    <div class="row">
                        <hr>
                        <div class="col-sm card">
                            <h1 class="text-center"><%= a.getNombreProducto()%></h1>
                            <hr>
                            <div class="form-group" >
                                <form method="post" action="ControladoProducto">
                                    <input type="hidden" name="accion" value="AgregaCarrito">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-sm-5 col-md-6 card">
                                                <img src="<%= a.getImgProducto()%>">
                                            </div>
                                            <div class="col-sm-5 offset-sm-2 col-md-6 offset-md-0 card">
                                                <div class="form-group">
                                                    <h2>Precio Producto: </h2><h4> S/. <%= a.getPrecioProducto()%></h4>
                                                </div><hr>
                                                <div class="form-group">
                                                    <h2>Marca: </h2><h4><%= a.getMarcaProducto()%></h4>
                                                </div><hr>
                                                <div class="form-group">
                                                    <h2>Unidad de Medida: </h2><h4><%= a.getUnidadDeMedida()%></h4>
                                                </div><hr>
                                                <div class="form-group">
                                                    <h2>Descripcion: </h2><h4><%= a.getDescripcionProducto()%></h4>
                                                </div>
                                                <div class="form-group" style="display: none">
                                                    <input type="number" name="id" required class="form-control" value="<%= a.getIdProducto()%>">
                                                </div>
                                                <div class="form-group">
                                                    <h2>Cantidad: </h2>
                                                    <input type="number" id="cantidad" name="cantidad" required class="form-control">
                                                </div>

                                            </div>
                                        </div>
                                    </div><hr><br>
                                    <input type="submit" value="Añadir a carrito" class="btn btn-outline-info my-2 my-sm-0 form-control">
                                    <a href="javascript: history.go(-1)"  class="btn btn-outline-info my-2 my-sm-0 form-control">Ver mas Productos</a>
                                </form>
                            </div> 

                        </div>
                    </div>
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
