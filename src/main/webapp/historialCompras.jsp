<%-- 
    Document   : historialCompras
    Created on : 07/10/2021, 11:51:40 PM
    Author     : edicz
--%>

<%@page import="java.util.Collections"%>
<%@page import="Entidad.Pedido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Pedido> da= (List<Pedido>)request.getAttribute("data");
%>

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
                        <h1>Historial de Compras</h1>
                    </div>
                    <div class="row">
                        <div class="col-sm card-body">
                            <table border="1" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>CODIGO DE PEDIDO</th>
                                        <th>FECHA DE PEDIDO</th>
                                        <th>TOTAL</th>
                                        <th>ESTADO DE PEDIDO</th>
                                        <th>DIRECCION DE ENVIO</th>
                                        <th>METODO DE PAGO</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                if(da!=null)
                                {
                                    Collections.reverse(da);
                                    for(Pedido a:da)
                                    {
                                %>
                                    <tr>
                                        <td><%=a.getIdPedido()%></td>
                                        <td><%=a.getFechaPedido()%></td>
                                        <td><%=a.getTotalPrecio()%></td>
                                        <td><%if(a.getIdEstadoPedido()==1){%>
                                            Preparando Entrega  
                                        <%  }else if (a.getIdEstadoPedido()==2){%>
                                            Cancelado
                                        <%  }else{%>
                                            Enviado
                                        <%  }%></td>
                                        <td><%=a.getDireccionPedido()%></td>
                                        <td><%if(a.getIdPago()==1){%>
                                            Efectivo
                                        <%}else{%>
                                            Tarjeta
                                        <%}%></td>
                                        <td><a href="ServletProducto?tipo=listarDetallePedido&id=<%=a.getIdPedido()%>"  class="btn btn-outline-info my-2 my-sm-0 form-control">Detalles</a></td>
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
