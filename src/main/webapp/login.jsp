<%-- 
    Document   : login
    Created on : 03/09/2021, 09:30:13 AM
    Author     : edicz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/header.jsp"%>
        
        <div class="container"><br><br><br>

            <div class="row align-items-center sidebar" >
                <%
                    String x=(String) request.getAttribute("mensaje");
                    String a="";
                    if(x!=null)
                        a=x;
                %> 
                <div class="col-sm text-center"></div>
                <div class="col-sm text-center">
                    <div class="card">

                        <div class="card-header">
                            <h4>Iniciar Sesion</h4>
                        </div>
                        <div >
                            <ul class="nav nav-tabs">
                                <li class="nav-item">
                                  <a class="nav-link active" href="login.jsp">Comprar</a>
                                </li>
                                <li class="nav-item">
                                  <a class="nav-link" href="loginVender.jsp">Vender</a>
                                </li>
                            </ul>
                        </div>
                        <div class="card-doby">
                            <br>
                            <br>
                            <div class="d-flex justify-content-center form_container">
                                <form method="post" action="ServletSesion">
                                    <input type="hidden" name="tipo" value="sesionCliente">	
                                    <div class="input-group mb-3" id="busqueda-cerrar">
                                        <div class="input-group-append">
                                            <span class="input-group-text busqueda-etiqueta"><i class="fas fa-user"></i></span>
                                        </div>
                                        <input type="text" name="txtlogin" class="form-control input_user form-submit" value="" placeholder="usuario">
                                    </div>
                                    <div class="input-group mb-2" id="busqueda-cerrar">
                                        <div class="input-group-append">
                                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                                        </div>
                                        <input type= "password" name="txtpass" class="form-control form-submit input_pass" value="" placeholder="contraseña">
                                    </div>
                                    <div style="visibility: hidden">
                                        <input name="txtrol" value="1" class="form-control form-submit input_pass" >
                                    </div>
                                    <div class="container-login100-form-btn">
                                        <div class="wrap-login100-form-btn">
                                            <input type="submit" id="busqueda-submit"  class="btn btn-info action-button btn-block" value="Iniciar" />
                                            <h5 align="center"><%=a %></h5> 
                                        </div>
                                        <div class="wrap-login100-form-btn">
                                            <p align="center" ><a href="ServletUsuario?tipo=listarDistritoCliente" class="btn btn-info action-button btn-block">Registrar</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="card-footer"><br></div>
                    </div>
                </div>
                <div class="col-sm text-center"></div>
            </div>
        </div><br><br><br><br>
        <%@include file="/footer.jsp"%>
    </body>
</html>
