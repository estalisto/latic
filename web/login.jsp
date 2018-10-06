<%-- 
    Document   : login
    Created on : 05-feb-2017, 22:36:36
    Author     : CIMA2015
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" type="image/png" href="dist/img/favicon.png"/>
        <title>LatiCobsa S.A.</title>

        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">

        <link href="resources/css/master.css" rel="stylesheet">
        

    </head>
    <body class="m-404" data-scrolling-animations="true">

        <!-- Loader -->

        <!-- Loader end -->
        <nav class="b-nav" style="background-color: rgba(0, 198, 243, 0.05);">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3 col-xs-4">
                        <div class="b-nav__logo wow slideInLeft" data-wow-delay="0.3s">
                            <h3><a href="#">LATICOBSA</a></h3>
                            <h2><a href="#">ADMINISTRACIÓN WEB</a></h2>
                        </div>
                    </div>
                </div>
            </div>
        </nav><!--b-nav-->
        <section class="b-error b-login" style="background-color: rgba(0, 198, 243, 0.05);">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4">
                        <div class="b-contacts__form">
                            <header class="b-contacts__form-header s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s">
                                <h2 style="padding: 0 30px 0px 30px;" class="s-titleDet">ARGUS</h2> 
                            </header>
                            <!--div id="success"></div-->
                            <form action="autoriza" method="get">
                                    <div class="form-group hidden">
                                    <input type="text" class="form-control" placeholder="Ingrese Nombre Rol" value="autorizar" required="required" name="accion" id="accion">

                                   </div>
                                <div id="form" class="b-blog__aside-search">
                                    <div>
                                        <input id ="usuario"type="text"  placeholder="USUARIO" value="" name="usuario" />
                                        <button type="submit"><span class="fa fa-user"></span></button>
                                    </div>
                                    <div>
                                        <input id="password"  type="password" placeholder="PASSWORD" value="" name="password"/>
                                        <button type="submit"><span class="fa fa-key"></span></button>
                                    </div> 
                                    <div id="contactForm" novalidate class="s-form wow zoomInUp" data-wow-delay="0.5s">
                                        <div class="col-xs-8">
                                            <div class="checkbox icheck">
                                                <label>
                                                    <input type="checkbox"> Recordar Contraseña
                                                </label>
                                            </div>
                                        </div>
                                        <!--button  type="submit" class="btn btn-primary btn-block btn-lg">LOGIN<span class="fa fa-angle-right"></span></button-->
                                    </div>
                               </div>
                                <!--button id="btn-login" type="submit" class="btn btn-primary btn-block btn-lg" style="right: -40px">Ingresar</button-->
                                <input id="btn-login" type="submit" value="Ingresar" class="btn btn-primary btn-block btn-lg"  title="Ingresar Usuarios">
                            </form>
                        </div>
                    </div>
                    <!--div class="col-lg-4"> </div-->
                </div>
                <p class="wow zoomInUp" data-wow-delay="0.7s"></p>
            </div>
        </section><!--b-error-->

        <footer class="b-footer" >
            <a id="to-top" href="#this-is-top"><i class="fa fa-chevron-up"></i></a>
            <div class="container">
                <div class="row">
                    <div class="col-xs-4">
                        <div class="b-footer__company wow fadeInLeft" data-wow-delay="0.3s">
                            <div class="b-nav__logo">
                                <h3><a href="#" style="color: #FFF" >LATICOBSA</a></h3>
                            </div>
                            <p>&copy; 2016 Designed by Templines &amp; Powered by <a>LATICOBSA</a>.</p>
                        </div>
                    </div>
                    <div class="col-xs-8">
                        <div class="b-footer__content wow fadeInRight" data-wow-delay="0.3s">
                            <div class="b-footer__content-social">
                                <a href="#"><span class="fa fa-facebook-square"></span></a>
                                <a href="#"><span class="fa fa-twitter-square"></span></a>
                                <a href="#"><span class="fa fa-google-plus-square"></span></a>
                                <a href="#"><span class="fa fa-instagram"></span></a>
                                <a href="#"><span class="fa fa-youtube-square"></span></a>
                                <a href="#"><span class="fa fa-skype"></span></a>
                            </div>
                            <nav class="b-footer__content-nav">
                                <!--ul>
                                    <li><a href="#">Home</a></li>
                                    <li><a href="#">Pages</a></li>
                                    <li><a href="#">Inventory</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="#">Services</a></li>
                                    <li><a href="#">Blog</a></li>
                                    <li><a href="#">Shop</a></li>
                                    <li><a href="#">Contact</a></li>
                                </ul-->
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </footer><!--b-footer-->
        <!--Main-->   



        <script src="resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="resources/plugins/iCheck/icheck.min.js"></script>

        <!--script src="resources/js/administracion.js"></script-->

        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
    </body>
</html>
