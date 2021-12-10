<%-- 
    Document   : validarVendedor
    Created on : 04/10/2021, 08:47:04 PM
    Author     : edicz
--%>

<%@page import="Entidad.Distrito"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <div class="col-3">                   
                </div>
                <div class="col-6 card ">
                    <%
                        String x=(String) request.getAttribute("mensaje");
                        String a="";
                        if(x!=null)
                            a=x;
                    %> 
                    <h1 class="text-center">Registrar De Tienda</h1>
                    <hr><br>
                    <div class="form-group" >
                        <form action="ServletUsuario" method="post">
                            <input type="hidden" name="tipo" value="siguiente">
                            <table>
                                <div class="form-group text-center">
                                    <h3>Validar Credenciales</h3>
                                    <br><br>
                                </div>
                                <div class="form-group">
                                    <label>Usuario</label>
                                    <input type="text" name="txtlogin" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div class="form-group">
                                    <label>Contraseña</label>
                                    <input type="password" name="txtpass" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div style="visibility: hidden">
                                    <input type="number" value="2" name="txtrol"class="form-control form-submit input_pass" >
                                </div>
                                <input type="submit" value="Siguente" class="btn btn-info form-control" >
                            </table><br>
                        </form>
                    </div>        
                </div> 
                <div class="col-3"></div>
                </div>
            </div>
        <br><br><br><br><br><br><br>
        <%@include file="/footer.jsp"%>
    </body>
</html>