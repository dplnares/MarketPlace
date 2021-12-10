<%-- 
    Document   : index
    Created on : 03/09/2021, 07:20:23 AM
    Author     : edicz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MARKETPLACE UTP</title>
    </head>
    <body>
        <div>
            <nav class="navbar navbar navbar-expand-lg navbar-light bg-info">
                <div class="container-fluid"><a class="navbar-brand" href="#" ><img src="img/logo.png"  alt=""></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navcol-1">
                        <ul class="nav navbar-nav">
                            <li class="nav-item" role="presentation"><a class="nav-link" href="#"><h5>Menu</h5></a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" href="#"><h5>Nosotros</h5></a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" href="#"><h5>Contacto</h5></a></li>
                        </ul>
                        <form class="form-inline mr-auto" target="_self">
                        </form><span class="navbar-text"> <a class="btn btn-outline-light my-2 my-sm-0" href="login.jsp">Ingresar</a></span>
                    </div>
                </div>
            </nav>
        </div><br>
        <div id="carouselExampleIndicators" class="container carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block w-100" src="https://img.freepik.com/vector-gratis/banner-compras-linea-viernes-negro-compras-linea-telefonos-moviles-sitios-web-bandera_42705-121.jpg?size=626&ext=jpg" height="400" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="https://static.vecteezy.com/system/resources/thumbnails/002/240/254/small_2x/online-on-sale-banner-vector.jpg" height="400"  alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="https://img.freepik.com/vector-gratis/banner-pago-linea-tarjeta-credito-telefono-inteligente_107791-2059.jpg?size=626&ext=jpg" height="400"  alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
        </div>
        <br>
        <hr>
        <img src="..." class="img-fluid" alt="...">
        
        <div class="container text-center">
            <img src="img/electronico.PNG" class="img-fluid" alt="...">
            <hr>
            <img src="img/literatura.PNG" class="img-fluid" alt="...">
            <hr>
            <img src="img/vestuario.PNG" class="img-fluid" alt="...">
            <hr>
            <img src="img/mercado.PNG" class="img-fluid" alt="...">
        </div><br>
                <!-- Footer -->
        <footer class="page-footer font-small elegant-color bg-info">

          <!-- Footer Links -->
          <div class="container text-center text-md-left pt-4 pt-md-5">

            <!-- Grid row -->
            <div class="row mt-1 mt-md-0 mb-4 mb-md-0">

              <!-- Grid column -->
              <div class="col-md-3 mx-auto mt-3 mt-md-0 mb-0 mb-md-4">

                <!-- Links -->
                <h5>Nosotros</h5>
                <hr class="color-primary mb-4 mt-0 d-inline-block mx-auto w-60">

                <p class="foot-desc mb-0">Tienda online</p>

              </div>
              <!-- Grid column -->

              <hr class="clearfix w-100 d-md-none">

              <!-- Grid column -->
              <div class="col-md-3 mx-auto mt-3 mt-md-0 mb-0 mb-md-4">

                <!-- Links -->
                <h5>Productos</h5>
                <hr class="color-primary mb-4 mt-0 d-inline-block mx-auto w-60">

                <ul class="list-unstyled foot-desc">
                  <li class="mb-2">
                    <a href="#!">Supermercado</a>
                  </li>
                </ul>

              </div>


              <hr class="clearfix w-100 d-md-none">

              <div class="col-md-3 mx-auto mt-3 mt-md-0 mb-0 mb-md-4">
                <h5>Contactos</h5>
                <hr class="color-primary mb-3 mt-0 d-inline-block mx-auto w-60">

                <ul class="fa-ul foot-desc ml-4">
                  <li class="mb-2"><span class="fa-li"><i class="far fa-map"></i></span>Arequipa
                  </li>
                  <li class="mb-2"><span class="fa-li"><i class="fas fa-phone-alt"></i></span>042 876 836 908</li>
                  <li class="mb-2"><span class="fa-li"><i class="far fa-envelope"></i></span>marketplace@utp.com</li>
                </ul>

              </div>
            </div>
          </div>
          <!-- Footer Links -->
          <hr>
          <!-- Copyright -->
          <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="#"> Marketplace UTP</a>
          </div>
          <!-- Copyright -->

        </footer>
        <!-- Footer -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
