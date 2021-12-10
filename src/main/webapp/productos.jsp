<%-- 
    Document   : productos
    Created on : 03/09/2021, 10:41:17 AM
    Author     : edicz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="Entidad.Producto"%>

<%
    List<Producto> da= (List<Producto>)request.getAttribute("data");
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <%@include file="/header.jsp" %>
        <br> 
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    <%@include file="/menuVendedor.jsp"%>
                </div>
                <div class="col-9 card text-center">
                    <h1>Listar Producto</h1>
                    <hr>
                    <form action="ServletProducto">
                        <input type="hidden" name="id" value="<jsp:getProperty name="tiendaBean" property ="idTienda"/>" >	
                        <ul class="nav nav-tabs">
                            <li class="nav-item">
                                <a class="nav-link active" href="ServletProducto?tipo=listarProducto&id=<jsp:getProperty name="tiendaBean" property ="idTienda"/>">Catalogo</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="ServletProducto?tipo=listarCategoria">Agregar Productos</a>
                            </li>
                        </ul>
                        <div class="row row-cols-2 row-cols-lg-5 g-2 g-lg-3">
                        <%
                            if(da!=null)
                                {
                                    for(Producto a:da)
                                        {
                        %>
                                            <div class="col"><br>
                                                <div class="card" style="width: 11rem;">
                                                    <img class="card-img-top" src="<%=a.getImgProducto()%>"  alt="Card image cap">
                                                    <div class="card-body">
                                                        <h5 class="card-title">S/. <%=a.getPrecioProducto()%></h5>
                                                        <p class="card-text"><%=a.getNombreProducto()%>-<%=a.getUnidadDeMedida()%></p>
                                                        <p class="card-text"><%=a.getMarcaProducto()%></p>
                                                        <a href="ServletProducto?tipo=buscarProducto&id=<%=a.getIdProducto()%>" class="btn btn-outline-info my-2 my-sm-0">Actualizar</a>
                                                        <hr>
                                                        <a href="ServletProducto?tipo=eliminarProducto&id=<%=a.getIdProducto()%>" class="btn btn-outline-info my-2 my-sm-0">Eliminar</a>
                                                    </div>
                                                </div>
                                            </div>
                        <%
                                        }
                                }
                        %>
                        </div>
                    </form> 
                </div><br><br>    
            </div>
        </div>
        <br> 
        <br>
        <br>
        <%@include file="/footer.jsp"%>
    </body>
</html>
