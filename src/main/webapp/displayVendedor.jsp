<%-- 
    Document   : displayVendedor
    Created on : 03/10/2021, 03:55:59 PM
    Author     : edicz
--%>

<%@page import="Entidad.Tienda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Tienda emp = (Tienda) request.getAttribute("tienda");
%>

<jsp:useBean id="tiendaBean" class="JavaBeans.TiendaBean" scope="session"></jsp:useBean>   
<jsp:setProperty name="tiendaBean" property ="idTienda" value="<%=emp.getIdTienda()%>"/>    
<jsp:setProperty name="tiendaBean" property ="nombreTienda" value="<%=emp.getNombreTienda()%>" />
<jsp:setProperty name="tiendaBean" property ="idUsuario" value="<%=emp.getIdUsuario()%>"/> 



<%@include file="/header.jsp"%>
<br>
<div class="container">
    <div class="row">
        <div class="col-3"><%@include file="/menuVendedor.jsp"%></div>
        <div class="col-9"></div>
    </div>
</div>
<%@include file="/footer.jsp"%>
