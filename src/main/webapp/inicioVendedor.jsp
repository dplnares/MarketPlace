<%-- 
    Document   : inicioVendedor
    Created on : 05/10/2021, 07:35:14 PM
    Author     : edicz
--%>

<%@page import="Entidad.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Usuario emp = (Usuario) request.getAttribute("usuario");
%>

<jsp:useBean id="usuarioBean" class="JavaBeans.UsuarioBean" scope="session"></jsp:useBean>   
<jsp:setProperty name="usuarioBean" property ="idUsuario" value="<%=emp.getIdUsuario()%>"/>  
<jsp:setProperty name="usuarioBean" property ="nombresUsuario" value="<%=emp.getNombresUsuario()%>"/>
<jsp:setProperty name="usuarioBean" property ="apellidosUsuario" value="<%=emp.getApellidosUsuario()%>" />  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/header.jsp"%>
        <br><br>
        <div class="container">
            <div class="row">
                <div class="col card ">
                    <%
                        String x=(String) request.getAttribute("mensaje");
                        String a="";
                        if(x!=null)
                            a=x;
                    %> 
                    <h1>Bienvenido: <jsp:getProperty name="usuarioBean" property ="nombresUsuario" /> <jsp:getProperty name="usuarioBean" property ="apellidosUsuario" /></h1>
                    <hr>
                    <img src="https://atrevete.pe/blog/wp-content/uploads/2021/04/Banner1.png">
                    <div class="form-group" >
                        <form action="ServletTienda" method="post">
                            <input type="hidden" name="tipo" value="vendedorTienda">
                            <table>
                                <div class="form-group text-center">
                                    
                                </div>
                                <div style="visibility: hidden">
                                    <input type="number" value="<jsp:getProperty name="usuarioBean" property ="idUsuario"/>" name="txtid"class="form-control form-submit input_pass" >
                                </div>
                                <hr>
                                <input type="submit" value="Empezar a vender" class="btn btn-info form-control" >
                            </table><br>
                        </form>
                    </div>        
                </div>
            </div>
            <br><br>
        </div>
        <%@include file="/footer.jsp"%>
    </body>
    
</html>
