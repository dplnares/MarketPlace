<%-- 
    Document   : detallePedido
    Created on : 20/10/2021, 07:43:53 PM
    Author     : edicz
--%>

<%@page import="Entidad.DetallePedido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<DetallePedido> da= (List<DetallePedido>)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/header.jsp"%>
        <div class="container">
            <br>
            <div class="row">
                <div class="col-3">
                    <div class="card">
                        <div class="card-header">
                            <h3>Datos de Cuenta</h3>
                        </div>
                        <div class="card-body">
                            <label>Nombres: </label>
                            <input type="text" readonly="" class="form-control" value="<jsp:getProperty name="usuarioBean" property ="nombresUsuario" />">
                            <label>Apellidos: </label>
                            <input type="text" readonly="" class="form-control" value="<jsp:getProperty name="usuarioBean" property ="apellidosUsuario" />">
                            <label>Codigo Usuario: </label>
                            <input type="text" value="<jsp:getProperty name="usuarioBean" property ="idUsuario" />" readonly="" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="col-9 card">
                    <div class="text-center card-header">
                        <h1>Carrito de Compras</h1>
                    </div>
                    <div class="row">
                        <div class="col-sm card-body">
                            <table border="1" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>CODIGO DE DETALLE PEDIDO</th>
                                        <th>CANTIDAD</th>
                                        <th>PRECIO</th>
                                        <th>ID PRODUCTO</th>
                                        <th>ID PEDIDO</th>
                                        <th>NOMBRE PRODUCTO</th>
                                        <th>IMAGEN</th>
                                </thead>
                                <tbody>
                                    <%
                                if(da!=null)
                                {
                                    for(DetallePedido a:da)
                                    {
                                %>
                                    <tr>
                                        <td><%=a.getIdDetallePedido()%></td>
                                        <td><%=a.getCantida()%></td>
                                        <td><%=a.getPrecio()%></td>
                                        <td><%=a.getIdProducto()%></td>
                                        <td><%=a.getIdPedido()%></td>
                                        <td><%=a.getNombreProducto()%></td>
                                        <td><img src="<%=a.getImgProducto()%>" width="50" height="50"></td>
                                    </tr>
                                <%
                                        }
                                    }
                                %>
                                </tbody>
                            </table>
                            <a href="javascript: history.go(-1)"  class="btn btn-outline-info my-2 my-sm-0 form-control">Seguir Comprando</a>
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
    </body>
</html>
