<%-- 
    Document   : registrarVendedor
    Created on : 02/10/2021, 12:45:15 PM
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
                    <h1 class="text-center">Registrar Vendedor</h1>
                    <hr><br>
                    <div class="form-group" >
                        <form action="ServletUsuario">
                            <input type="hidden" name="tipo" value="registrarVendedor">	
                            <table>
                                <div class="form-group">
                                    <label>Nombres</label>
                                    <input type="text" name="nombresUsuario" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div class="form-group">
                                    <label>Apellidos</label>
                                    <input type="text" name="apellidosUsuario" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div class="form-group">
                                    <label>Telefono</label>
                                    <input type="number" name="telefonoUsuario" required class="form-control" oninput="maxLengthCheck(this)" maxlength="9" min="0" max="999999999">
                                </div>
                                <div class="form-group">
                                    <label>Correo</label>
                                    <input type="email" name="correoUsuario" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div class="form-group">
                                    <label>Usuario</label>
                                    <input type="text" name="usuario" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div class="form-group">
                                    <label>Contraseña</label>
                                    <input type="password" name="clave" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div class="form-group">
                                    <label>DNI</label>
                                    <input type="number" name="dniUsuario" required class="form-control" oninput="maxLengthCheck(this)" maxlength="8" min="0" max="99999999">
                                </div>
                                <div class="form-group">
                                    <label>Direccion</label>
                                    <input type="text" name="direccionUsuario" required class="form-control" id="exampleFormControlInput1">
                                </div>
                                <div class="form-group">
                                    <label>Distrito</label>
                                    <select name="idDistrito" class="custom-select mr-sm-2" required>
                                        <%
                                            List<Distrito> da= (List<Distrito>)request.getAttribute("data");
                                            if(da!=null)
                                            {
                                                for(Distrito a:da)
                                                {
                                        %>
                                            <option value="<%=a.getIdDistrito()%>"><%=a.getNombreDireccion()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                        </select>
                                </div>
                                <div style="visibility: hidden">
                                    <input type="number" value="2" name="idRol"class="form-control form-submit input_pass" >
                                </div>
                                <input type="submit" value="Registrar Vendedor" class="btn btn-info form-control" >
                                <script>
                                      // This is an old version, for a more recent version look at
                                      // https://jsfiddle.net/DRSDavidSoft/zb4ft1qq/2/
                                      function maxLengthCheck(object)
                                      {
                                        if (object.value.length > object.maxLength)
                                          object.value = object.value.slice(0, object.maxLength)
                                      }
                                    </script>
                            </table><br>
                        </form>
                    </div>        
                </div> 
                <div class="col-3"></div>
                </div>
            </div>
        <br><br>
        <%@include file="/footer.jsp"%>
    </body>
</html>
