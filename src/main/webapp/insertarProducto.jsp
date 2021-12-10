<%-- 
    Document   : insertarProducto
    Created on : 04/10/2021, 12:38:44 PM
    Author     : edicz
--%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Producto</title>
    </head>
    <body> 
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
                                    <input type="hidden" name="tipo" value="registrarProducto">	
                                    <table>
                                        <div class="form-group">
                                            <label>Nombre Producto</label>
                                            <input type="text" name="nombreProducto" required class="form-control" id="exampleFormControlInput1">
                                        </div>
                                        <div class="form-group">
                                            <label>Precio Producto</label>
                                            <input type="text" name="precioProducto" required class="form-control" id="exampleFormControlInput1">
                                        </div>
                                        <div class="form-group">
                                            <label>Link de imagen del producto</label>
                                            <input type="text" name="imgProducto" required class="form-control" id="exampleFormControlInput1">
                                        </div>
                                        <div class="form-group">
                                            <label>Descripcion del Producto</label>
                                            <input type="text" name="descripcionProducto" required class="form-control" id="exampleFormControlInput1">
                                        </div>
                                        <div style="visibility: hidden">
                                            <input type="number" value="1" name="estadoProducto" required class="form-control" id="exampleFormControlInput1">
                                        </div>
                                        <div class="form-group">
                                            <label>Marca Producto</label>
                                            <input type="text" name="marcaProducto" required class="form-control" id="exampleFormControlInput1">
                                        </div>
                                        <div class="form-group">
                                            <label>Unidad de Medida del Producto</label>
                                            <input type="text" name="unidadDeMedida" required class="form-control" id="exampleFormControlInput1">
                                        </div>
                                        <div class="form-group">
                                            <label>Categorias de Productos</label>
                                            <select name="idCategoria" class="custom-select mr-sm-2" required>
                                                <%
                                                    List<Categoria> da= (List<Categoria>)request.getAttribute("data");
                                                    if(da!=null)
                                                    {
                                                        for(Categoria a:da)
                                                        {
                                                %>
                                                    <option value="<%=a.getIdCategoria()%>"><%=a.getNombreCategoria()%></option>
                                                <%
                                                        }
                                                    }
                                                %>
                                                </select>
                                        </div>
                                        <div style="visibility: hidden">
                                            <input type="number" value="<jsp:getProperty name="tiendaBean" property ="idTienda"/>" name="idTienda" class="form-control form-submit input_pass" >
                                        </div>
                                        <input type="submit" value="Registrar Vendedor" class="btn btn-info form-control" >
                                    </table><br>
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
