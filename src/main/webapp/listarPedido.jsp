

<%@page import="java.util.Collections"%>
<%@page import="Entidad.Pedido"%>
<%-- 
    Document   : listarPe
    Created on : 20/10/2021, 08:21:58 PM
    Author     : edicz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="Entidad.Producto"%>

<%
    List<Pedido> da= (List<Pedido>)request.getAttribute("data");
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
                    <h1>Listar Pedido</h1>
                    <hr>
                    <table border="1" class="table table-hover">
                        <thead>
                            <tr>
                                <th>FECHA DE PEDIDO</th>
                                <th>TOTAL</th>
                                <th>ESTADO DE PEDIDO</th>
                                <th>METODO DE PAGO</th>
                                <th>DIRECCION DE ENVIO</th>
                                <th>HORA ENTREGA</th>
                                <th>FECHA ENTREGA</th>
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
                                if(a.getIdEstadoPedido()==1)
                                {
                            %>
                            <tr>
                                <td><%=a.getFechaPedido()%></td>
                                <td><%=a.getTotalPrecio()%></td>
                                <td><%if(a.getIdEstadoPedido()==1)
                                    {%>
                                    Preparando Entrega  
                                <%  }%></td>
                                <td><%if(a.getIdPago()==1){%>
                                    Efectivo
                                <%  }else{%>
                                    Tarjeta
                                <%  }%></td>
                                <td><%=a.getDireccionPedido()%></td>
                                <td><%=a.getHoraEntrega()%></td>
                                <td><%=a.getFechaEntrega()%></td>
                                <td><a href="ServletProducto?tipo=listarDetallePedidoTienda&id=<%=a.getIdPedido()%>"  class="btn btn-outline-info">Detalles</a>
                                    <a href="ServletProducto?tipo=buscarPedido&id=<%=a.getIdPedido()%>" class="btn btn-outline-info">Atender</a></td>
                            </tr>
                            <%
                                }   
                            }
                        }
                        %>
                        </tbody>
                    </table>
                </div><br><br>    
            </div>
        </div>
        <br> 
        <br>
        <br>
        <%@include file="/footer.jsp"%>
    </body>
</html>
