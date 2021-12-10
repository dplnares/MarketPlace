<%-- 
    Document   : Reporte
    Created on : 07/12/2021, 07:26:21 PM
    Author     : edicz
--%>
<%@page import="java.util.Collections"%>
<%@page import="Entidad.Pedido"%>
<%@page import="java.util.List"%>
<%
    List<Pedido> da= (List<Pedido>)request.getAttribute("data");
    %>
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
                <div class="col-3">
                    <%@include file="/menuVendedor.jsp"%>
                </div>
                <div class="col-9 card text-center">
                    
                    <div class="col-sm card">
                        <h1>Reporte de Venta</h1>
                        <hr>
                        <%
                        if(da!=null)
                        {
                            double total=0.0;
                            for(Pedido a:da)
                            {
                                total=total+a.getTotalPrecio();
                            }
                            for(Pedido a:da)
                            {
                        %>
                            <form name="form1" action="pdfReporte.jsp" target="_black">
                                <input type="text" name ="idTienda" style="display:none" value="<jsp:getProperty name="tiendaBean" property ="idTienda"/>"/>
                                <input type="text" name ="bodega" style="display:none" value="<jsp:getProperty name="tiendaBean" property ="nombreTienda"/>"/>
                                <input type="text" name ="totalVentas" style="display:none" value="<%=total%>"/>
                                <input type="submit" value="Reporte de Ventas" class="btn btn-outline-info my-2 my-sm-0 form-control"/>
                            </form>
                        <%break;
                            }
                        }
                        %>
                        
                        <table border="1" class="table table-hover">
                            <thead>
                                <tr>
                                    <th>CODIGO</th>
                                    <th>FECHA DE PEDIDO</th>
                                    <th>FECHA DE ENTREGA</th>
                                    <th>ESTADO DE PEDIDO</th>
                                    <th>METODO DE PAGO</th>
                                    <th>DIRECCION DE ENVIO</th>
                                    <th>PRECIO</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                            if(da!=null)
                            {   Collections.reverse(da);
                                for(Pedido a:da)
                                {
                                    if(a.getIdEstadoPedido()==3)
                                    {
                                    %>
                                        <tr>
                                            <td><%=a.getIdPedido()%></td>
                                            <td><%=a.getFechaPedido()%></td>
                                            <td><%=a.getFechaEntrega()%></td>
                                            
                                            <td><%if(a.getIdEstadoPedido()==3){%>
                                                    Enviado
                                            <%}%></td>
                                            <td><%if(a.getIdPago()==1){%>
                                                Efectivo
                                            <%}else{%>
                                                Tarjeta
                                            <%}%></td>
                                            <td><%=a.getDireccionPedido()%></td>
                                            <td><%=a.getTotalPrecio()%></td>
                                        </tr>
                                    <%
                                    }
                                }
                            }
                            %>
                            </tbody>
                        </table>
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
