<%-- 
    Document   : actualizaProductoe
    Created on : 06/10/2021, 12:23:11 AM
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
                <div class="col-3">
                    <%@include file="/menuVendedor.jsp"%>
                </div>
                <div class="col-9 card text-center">
                    <div class="row">
                        <hr>
                        <div class="col-sm card">
                            <h1>Agregar Producto</h1>
                            <hr>
                            <div class="form-group" >
                                <form action="ServletProducto">
                                    <input type="hidden" name="tipo" value="actualizarProducto">
                                    <input type="hidden" name="id" value="<%= a.getIdProducto()%>" >	
                                    <table>
                                        <div class="form-group">
                                            <label>Nombre Producto</label>
                                            <input type="text" name="nombreProducto" required class="form-control"  value="<%= a.getNombreProducto()%>"> 
                                        </div>
                                        <div class="form-group">
                                            <label>Precio Producto</label>
                                            <input type="text" name="precioProducto" required class="form-control" value="<%= a.getPrecioProducto()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Link de imagen del producto</label>
                                            <input type="text" name="imgProducto" required class="form-control" value="<%= a.getImgProducto()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Descripcion del Producto</label>
                                            <input type="text" name="descripcionProducto" required class="form-control"  value="<%= a.getDescripcionProducto()%>">
                                        </div>
                                        <div style="visibility: hidden">
                                            <input type="text" name="estadoProducto" required class="form-control"  value="<%= a.getEstadoProducto()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Marca Producto</label>
                                            <input type="text" name="marcaProducto" required class="form-control" value="<%= a.getMarcaProducto()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Unidad de Medida del Producto</label>
                                            <input type="text" name="unidadDeMedida" required class="form-control" value="<%= a.getUnidadDeMedida()%>">
                                        </div>
                                        <div style="visibility: hidden">
                                            <input type="text" value="<%= a.getIdCategoria()%>" name="idCategoria" class="form-control form-submit input_pass" >
                                        </div>
                                        <div style="visibility: hidden">
                                            <input type="number" value="<%= a.getIdTienda()%>" name="idTienda"class="form-control form-submit input_pass" >
                                        </div><hr>
                                        <input type="submit" value="enviar" class="btn btn-info form-control" ><hr>
                                        <input type="reset" value="borrar" class="btn btn-info form-control" >
                                    </table>
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
