<%-- 
    Document   : catalogo
    Created on : 04/10/2021, 05:45:04 PM
    Author     : edicz
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Entidad.Calificacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="Entidad.Producto"%>

 


<%
    List<Producto> da= (List<Producto>)request.getAttribute("data");
%>
<%
    List<Calificacion> da2= (List<Calificacion>)request.getAttribute("data2");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    
    <body>
        <%@include file="/header.jsp" %>
        
        
        <div class="container">
            <nav class="navbar navbar-light bg-light">
                <a class="btn btn-outline-info my-2 my-sm-0" href="ServletProducto?tipo=listarPedidoCliente&id=<jsp:getProperty name="usuarioBean" property ="idUsuario" />">Historial de Compras</a>
                <a class="btn btn-outline-info my-2 my-sm-0" href="ControladoProducto?accion=Carrito">Carrito <i class="fas fa-cart-plus">(<label style="color: orange">${contador}</label>)</i><img src="img/carrito.png"></a>             
            </nav>
            <div class="row">
                
                <div class="col-9  text-center">
                    <hr>
                    <%
                        if(da2!=null)
                            {
                                String nombreTienda="";
                                double con=0;
                                double sum=0;
                                for(Calificacion b:da2)
                                    {
                                        sum=sum+b.getCalificacion();
                                        con=con+1;
                                        nombreTienda=b.getNombreTienda();
                                    }
                                DecimalFormat formato1 = new DecimalFormat("#.0");
                    %>
                    <h1 class="text-info"><%=nombreTienda%> - <%=formato1.format(sum/con)%>★</h1>
                    <%
                            }
                    %>
                    <hr>
                    <div class="navbar text-right">
                        <a style="visibility: hidden">#</a>
                        <form action="ServletProducto" class="form-inline">
                            <input type="hidden" style="display: none" name="tipo" value="buscar">
                            <%
                                if(da!=null)
                                {
                                    for(Producto a:da)
                                    {
                            %>
                                        <input type="number" style="display: none" value="<%=a.getIdTienda()%>" name="id" required class="form-control">
                            <%          break;
                                    }
                                }
                            %>
                            <input type="search" name="txtBuscar" class="form-control">                            
                            <input type="submit" value="Buscar Producto" class="btn btn-info form-control" >
                        </form>
                    </div>
                    <hr>
                        <div class="row row-cols-2 row-cols-lg-5 g-2 g-lg-3">
                        <%
                            if(da!=null)
                                { 
                                    for(Producto a:da)
                                        {
                        %>
                                            <div class="col"><br>
                                                <div class="card" style="width: 11rem;">
                                                    <img class="card-img-top" src="<%=a.getImgProducto()%>"  alt="Card image cap">
                                                    <div class="card-body">
                                                        <h5 class="card-title">S/. <%=a.getPrecioProducto()%></h5>
                                                        <p class="card-text"><%=a.getNombreProducto()%>-<%=a.getUnidadDeMedida()%></p>
                                                        <p class="card-text"><%=a.getMarcaProducto()%></p>
                                                        <a href="ServletProducto?tipo=getProducto&id=<%=a.getIdProducto()%>" class="btn btn-outline-info my-2 my-sm-0">Ver Detalles</a>
                                                    </div>  
                                                </div>
                                            </div>
                        <%
                                        }
                                }
                        %>
                        </div><br>
                        <a href="javascript: history.go(-1)" class="btn btn-outline-info my-2 my-sm-0">Mas Productos</a>
                </div>
                <div class="col-3"><hr><br><br><br><br><hr>
                    <div class="form-group card text-center">
                        <h4 class="text-info">Califica la Tienda</h4>
                        <form action="ServletCalificacion">
                            <input type="hidden" name="tipo" value="registrarCalificacion" >
                            <div>
                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
                                <p class="clasificacion">
                                    <input id="radio1" type="radio" name="calificacion" value="1">
                                    <label for="radio1">★</label>
                                    <input id="radio2" type="radio" name="calificacion" value="2">
                                    <label for="radio2">★</label>
                                    <input id="radio3" type="radio" name="calificacion" value="3">
                                    <label for="radio3">★</label>
                                    <input id="radio4" type="radio" name="calificacion" value="4">
                                    <label for="radio4">★</label>
                                    <input id="radio5" type="radio" name="calificacion" value="5">
                                    <label for="radio5">★</label>
                                </p>
                                <textarea class="form-control" name="comentario" rows="2"></textarea>
                            </div><BR>
                            <div class="form-group" style="display:none">
                                <input type="text" name="fechaCalificacion" required class="form-control" id="fecha" readonly="">
                                <script>
                                    var f = new Date();
                                    document.getElementById("fecha").value =(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
                                </script>
                            </div>
                            <div style="display:none">
                                <input  type="number" value="<jsp:getProperty name="usuarioBean" property ="idUsuario" />" name="idUsuario" required class="form-control" id="exampleFormControlInput1">
                            </div>
                            <%
                                if(da!=null)
                                {
                                    for(Producto a:da)
                                    {
                            %>
                                        <div style="display:none">
                                            <input type="number" value="<%=a.getIdTienda()%>" name="idTienda" required class="form-control">
                                        </div>
                            <%          break;
                                    }
                                }
                            %>
                            <div>
                                <input type="submit" value="Calificar Tienda" class="btn btn-info form-control">
                            </div><br>                           
                        </form>
                    </div>
                    <div class="form-group card text-center">
                        <h4 class="text-info">Comentarios</h4>
                    <%
                        if(da2!=null)
                            {
                                for(Calificacion b:da2)
                                    {
                    %>
                    <div>
                        <div class="card border-info mb-3" style="max-width: 18rem;">
                            <div class="card-header bg-transparent border-info"><%=b.getNombreUsuario()%></div>
                            <div class="card-body text-info">
                              <h5 class="card-title"><%=b.getCalificacion()%>★</h5>
                              <p class="card-text"><%=b.getComentario()%></p>
                            </div>
                            <div class="card-footer bg-transparent border-info"><%=b.getFechaCalificacion()%></div>
                        </div>
                    </div>
                    <%
                                    }
                            }
                    %>
                        
                    </div>
                </div>
            </div>
        
        </div>                    
        <br> 
        <br>
        <br>
        <%@include file="/footer.jsp"%>
        <script>
            $(".clasificacion").find("input").change(function()
            {
            var valor = $(this).val();
            $(".clasificacion").find("input").removeClass("activo");
            $(".clasificacion").find("input").each(function(index){
               if(index+1<=valor){
                $(this).addClass("activo");
               }

            });
          });

          $(".clasificacion").find("label").mouseover(function(){
            var valor = $(this).prev("input").val();
            $(".clasificacion").find("input").removeClass("activo");
            $(".clasificacion").find("input").each(function(index){
               if(index+1<=valor){
                $(this).addClass("activo");
               }

            });
          });
        </script>
        <script src="js/funciones.js" type="text/javascript"></script>
    </body>
</html>
