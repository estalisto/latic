<%-- 
    Document   : login
    Created on : 05-feb-2017, 22:36:36
    Author     : CIMA2015
--%>
<%
    String Sidentificacion = "", id_empresa = "", USER_SESION="";
    HttpSession sesion = request.getSession(true);
    
    try {
     if (sesion.getAttribute("SstrUsuarioRol")!= null && sesion.getAttribute("Sstrempresa")!=null && sesion.getAttribute("SstrUSER")!= null){
                  
                  //sesion.invalidate();
                  response.sendRedirect("/laticobsa/home");
              //out.print("<script>location.replace('login.jsp');<script>");
              return;

        }
        
    } catch (Exception e) {
        Sidentificacion = "000";
       response.sendRedirect("/laticobsa/login"); 
    }
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>LatiCobsa S.A.</title>
        <link rel="icon" type="image/png" href="dist/img/favicon.png"/>

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
    <body class="m-404" data-scrolling-animations="true"  style="background-color: rgba(0, 198, 243, 0.05);">

        <!-- Loader -->

        <!-- Loader end -->
        <nav class="b-nav">
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
        <section class="b-error b-login" >
            <div class="container">
                <div class="row">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4">
                        <div class="b-contacts__form">
                            <header class="b-contacts__form-header s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s">
                                <h2 style="padding: 0 30px 0px 30px;" class="s-titleDet">ARGUS</h2> 
                            </header>
                            <!--div id="success"></div
                            <form action="autoriza" method="get">-->
                                    <div>
                                        <!--input   type="text" placeholder="EMPRESA" value="" name="empresa"/>
                                        <button type="submit"><span class="fa fa-home"></span></button-->
                                        <select class="form-control" name="empresa" required="required" id="empresa">
                                        <option value='0'> -- Seleccionar Empresa -- </option>
                                          <c:forEach items="${empresas}" var="empresa">
                                           <option value='<c:out value="${empresa.getIdEmpresa()}"/>'><c:out value="${empresa.getRazonSocial()}" /> </option>                         
                                        </c:forEach>                 

                                        </select>
                                    </div>
                                        <br>
                                    <!--div class="form-group hidden">
                                    <input type="text" class="form-control" placeholder="Ingrese Nombre Rol" value="autorizar" required="required" name="accion" id="accion">

                                   </div-->
                                   <div id="form" class="b-blog__aside-search">
                                    <div>
                                        <input id ="usuario"type="text"  placeholder="USUARIO" value="" name="usuario" />
                                        <button type="submit"><span class="fa fa-user"></span></button>
                                    </div>
                                    <div>
                                        <input id="password"  type="password" placeholder="PASSWORD" value="" name="password"/>
                                        <button type="submit"><span class="fa fa-key"></span></button>
                                    </div>
                
                               </div>
                                <input id="btn_logeo" type="submit" value="Ingresar" class="btn btn-primary btn-block btn-lg"  title="Ingresar Usuarios" >
                               
                                <div id="DivMensajeError" class="alert alert-warning alert-dismissible" style="display:none;">
                                    <button type="button" class="close" data-dismiss="alert" onclick=" location.reload(true);" aria-hidden="true">&times;</button>
                                <h4><i class="icon fa fa-warning"></i> Alert!
                                <div id="idMensajeError"></div></h4>
                              </div>
                        </div>
                    </div>
                    
                </div>
                <p class="wow zoomInUp" data-wow-delay="0.7s"></p>
            </div>
        </section>
  <div  id="mensajeSalida"></div>

        <script src="resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="resources/plugins/iCheck/icheck.min.js"></script>
        <script src="dist/js/usuario.js"></script>
        

        <script>
            $(function () {
                
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
               
                var URLactual = window.location;
                var url =URLactual.toString();
                if(/login.jsp/.test(URLactual)){                 
                   url=url.replace("login.jsp","login");                 
                  location.href=url;
                }
                
                
            });
            
        </script>
    </body>
</html>
