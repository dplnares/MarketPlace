<%-- 
    Document   : registrarTienda
    Created on : 02/10/2021, 04:03:48 PM
    Author     : edicz
--%>

<%@page import="Entidad.Distrito"%>
<%@page import="Entidad.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    Usuario emp = (Usuario) request.getAttribute("usuario");
%>

<jsp:useBean id="usuarioBean" class="JavaBeans.UsuarioBean" scope="session"></jsp:useBean>   
    
<jsp:setProperty name="usuarioBean" property ="nombresUsuario" value="<%=emp.getNombresUsuario()%>" />
<jsp:setProperty name="usuarioBean" property ="apellidosUsuario" value="<%=emp.getApellidosUsuario()%>" />
<jsp:setProperty name="usuarioBean" property ="idUsuario" value="<%=emp.getIdUsuario()%>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Tienda</title>
    </head>
    <body>
        <%@include file="/header.jsp"%>
        <br><br>
        <div class="container">
            <div class="row">
                <div class="col-3">                   
                </div>
                <div class="col-6 card ">
                    <h1 class="text-center">Registrar Tienda</h1>
                    <hr><br>
                    <div class="form-group" >
                        <form action="ServletTienda">
                            <input type="hidden" name="tipo" value="registrarTienda">	
                            <table>
                                <div class="form-group">
                                    <label>Nombre de Tienda</label>
                                    <input type="text" name="nombreTienda" required class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label for="longitud">Longitud</label>
                                    <input type="text" id="longitud" name="longitud" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label for="latitud">Latitud</label>
                                    <input type="text" id="latitud" name="latitud" class="form-control" >
                                </div>
                                <div>
                                    <div id="mapa" style="width: 100%; height: 500px;"></div>
                                </div>
                                <script>
                                    function initMap()
                                    {
                                        var longitud = -71.53652249220312;
                                        var latitud = -16.40981511995887;
                                        
                                        coordenas ={
                                            lng: longitud,
                                            lat: latitud
                                        }
                                        generarMapa(coordenas);
                                    }
                                    
                                    function generarMapa(coordenadas)
                                    {
                                        var mapa = new google.maps.Map(document.getElementById('mapa'),
                                        {
                                            zoom: 12,
                                            center: new google.maps.LatLng(coordenadas.lat, coordenadas.lng)
                                        });
                                        marcador = new google.maps.Marker({
                                            map: mapa,
                                            draggable: true,
                                            position: new google.maps.LatLng(coordenadas.lat, coordenadas.lng)
                                        });
                                         marcador.addListener('dragend',function(event){
                                            document.getElementById("latitud").value = this.getPosition().lat();
                                            document.getElementById("longitud").value = this.getPosition().lng();
                                         })
                                        
                                    }
                                </script>
                                <div style="visibility: hidden">
                                    <input type="number" value="1" name="estadoTienda"class="form-control form-submit input_pass" >
                                </div>
                                <div class="form-group">
                                    <label>Telefono de Tienda</label>
                                    <input type="number" name="telefonoTienda" required class="form-control" oninput="maxLengthCheck(this)" maxlength="9" min="0" max="999999999">
                                    <script>
                                      // This is an old version, for a more recent version look at
                                      // https://jsfiddle.net/DRSDavidSoft/zb4ft1qq/2/
                                      function maxLengthCheck(object)
                                      {
                                        if (object.value.length > object.maxLength)
                                          object.value = object.value.slice(0, object.maxLength)
                                      }
                                    </script>
                                </div>
                                <div style="visibility: hidden">
                                    <input type="number" value="1" name="idCalificacion"class="form-control form-submit input_pass" >
                                </div>
                                <div class="form-group">
                                    <label>Direccion de Tienda</label>
                                    <input type="text" name="direccionTienda" required class="form-control">
                                </div>
                                <div style="visibility: hidden">
                                    <input type="number" value="<jsp:getProperty name="usuarioBean" property ="idUsuario" />" name="idUsuario"class="form-control form-submit input_pass" >
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
                                <input type="submit" value="Registrar Tienda" class="btn btn-info form-control" >
                            </table><br>
                        </form>
                    </div>        
                </div> 
                <div class="col-3"></div>
                </div>
            </div>
        <br><br>
        <%@include file="/footer.jsp"%>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&callback=initMap&v=weekly&channel=2"></script>
    </body>
</html>