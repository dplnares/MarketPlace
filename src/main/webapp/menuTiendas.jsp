<%-- 
    Document   : menuTiendas
    Created on : 04/10/2021, 09:11:22 PM
    Author     : edicz
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Tienda"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Entidad.Usuario"%>
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
        <title>Menu Tiendas</title>
        <script src="http://code.jquery.com/jquery-3.2.1.js"></script>
    </head>
    <body>
        <%
            List<Tienda> da= (List<Tienda>)request.getAttribute("data");
            ArrayList<Tienda> ubicacion= (ArrayList<Tienda>)request.getAttribute("data");
        %>
        <%@include file="/header.jsp"%>
        <br><br>
        <div class="container">
            <div class="row">
                <div class="col-2">                   
                </div>
                <div class="col-8 card ">
                    <h1 class="text-center">Seleccion de Tienda</h1>
                    <hr>
                    <div class="form-group" >
                        <form action="ServletProducto">  
                            <input type="hidden" name="tipo" value="listarCatalogo">	
                            <div>
                                <label>Bienvenido: <jsp:getProperty name="usuarioBean" property ="nombresUsuario" /></label>
                            </div>
                            <hr>
                                <div class="form-group">
                                    <label>Tiendas Disponibles</label>
                                    <select name="id" class="custom-select mr-sm-2" required>
                                        <%
                                            
                                            if(da!=null)
                                            {
                                                for(Tienda a:da)
                                                {
                                        %>
                                            <option value="<%=a.getIdTienda()%>"><%=a.getNombreTienda()%> - <%=a.getDireccionTienda()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>
                                
                                <script>
                                    
                                    function initMap()
                                    {
                                        var mapa = new google.maps.Map(document.getElementById('mapa'),
                                        {
                                            zoom: 13,
                                            center: { lat: -16.40804986276924, lng: -71.54277044914045}
                                        });
                                        <%
                                            if(da!=null)
                                            {
                                                for(Tienda o:ubicacion)
                                                {
                                        %>
                                                    var marker<%=o.getIdTienda()%> = new google.maps.Marker({
                                                        map: mapa,
                                                        draggable: false,
                                                        icon: "img/marcador.png",
                                                        animation: google.maps.Animation.DROP,
                                                        position: {lat: <%=o.getLatitud()%>, lng: <%=o.getLongitud()%>},
                                                        title: '<%=o.getNombreTienda()%>'
                                                    });
                                                    var mostrar=
                                                            '<form action="ServletProducto">' +
                                                                '<input type="hidden" name="tipo" value="listarCatalogoMapa">' +
                                                                '<h4> <%=o.getNombreTienda()%> </h4>'+
                                                                '<div>'+
                                                                    '<input type="hidden" name="idMapa" value="<%=o.getIdTienda()%>">'+
                                                                "</div>"+
                                                                '<input type="submit" value="Ver Catalogo" class="btn btn-info form-control" >'
                                                            "</form>";
                                                    var infowindow<%=o.getIdTienda()%>  = new google.maps.InfoWindow({
                                                        content: mostrar
                                                    })
                                                    marker<%=o.getIdTienda()%>.addListener("click", () => {
                                                        infowindow<%=o.getIdTienda()%>.open({
                                                          anchor: marker<%=o.getIdTienda()%>,
                                                          mapa,
                                                          shouldFocus: false
                                                        });
                                                    });
                                        <%
                                                }
                                            }
                                        %>    
                                                                              
                                    }
                                </script>
                                <div>
                                    <div id="mapa" style="width: 100%; height: 500px;"></div>
                                </div>
                                <br>
                                <input type="submit" value="Ver Catalogo" class="btn btn-info form-control" >
                        </form>
                    </div>        
                </div> 
                <div class="col-2"></div>
                </div>
            </div>
        <br><br>
        <%@include file="/footer.jsp"%>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&callback=initMap&v=weekly&channel=2"></script>
    </body>
</html>
