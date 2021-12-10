<%-- 
    Document   : atenderPedido
    Created on : 05/11/2021, 11:49:17 AM
    Author     : edicz
--%>
<%@page import="Entidad.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%   Pedido a = (Pedido) request.getAttribute("data"); %>
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
                                    <input type="hidden" name="tipo" value="actualizaPedido">
                                    <input type="hidden" name="id" value="<%= a.getIdPedido()%>" >	
                                    <table>
                                        <div class="form-group">
                                            <label>Fecha Pedido</label>
                                            <input type="text" readonly="" name="fechaPedido" required class="form-control"  value="<%= a.getFechaPedido()%>"> 
                                        </div>
                                        <div class="form-group">
                                            <label>Total Precio</label>
                                            <input type="text" name="totalPrecio" required class="form-control" value="<%= a.getTotalPrecio()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Estado Pedido</label>
                                            <select class="form-control" name="idEstadoPedido">
                                                <option value="1">Preparando Entrega</option>
                                                <option value="2">Cancelado</option>
                                                <option value="3">Enviado</option>
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Metodo de pago</label>
                                            <%
                                            if(a.getIdPago()==1)
                                            {
                                                %>
                                                <input type="text" readonly="" class="form-control"  value="Efectivo">
                                                <input type="number" style="display:none" name="idPago" required class="form-control"  value="<%= a.getIdPago()%>">
                                            <%
                                                }else{
%>
                                                <input type="text"  readonly="" class="form-control"  value="Tarjeta">
                                                <input type="number" style="display:none" name="idPago" required class="form-control"  value="<%= a.getIdPago()%>">
                                            <%
                                                }
                                            %>
                                        </div>
                                        <div style="visibility: hidden">
                                            <input type="text" name="idUsuario" required class="form-control"  value="<%= a.getIdUsuario()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Direccion Pedido</label>
                                            <input type="text" readonly="" name="direccionPedido" required class="form-control" value="<%= a.getDireccionPedido()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Hora Entrega</label>
                                            <input type="time" name="horaEntrega" required class="form-control" value="<%= a.getHoraEntrega()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Fecha Entrega</label>
                                            <input type="date" name="fechaEntrega" required class="form-control" value="<%= a.getFechaEntrega()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Seleccione al Repartidor</label>
                                            <select class="form-control">
                                                <option value="1" selected="">Seleccionar</option>
                                                <option value="2">Repartidor 1</option>
                                                <option value="3">Repartidor 2</option>
                                                <option value="4">Repartidor 3</option>
                                            </select>
                                        </div>
                                        <div style="display:none">
                                            <input type="number" value="<%= a.getIdTienda()%>" name="idTienda"class="form-control form-submit input_pass" >
                                        </div><hr>
                                        <input type="submit" value="enviar" class="btn btn-info form-control" >
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
