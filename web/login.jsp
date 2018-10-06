<%-- 
    Document   : login2
    Created on : 12-ago-2018, 11:58:15
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



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
       
        <title>LatiCobsa S.A.</title>
        <link rel="icon" type="image/png" href="dist/img/favicon.png"/>
        

        <!-- CSS okok-->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons 
        <link rel="shortcut icon" href="assets/ico/favicon.png">-->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-14x4-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">        	
            <div class="inner-bg">
                <div class="container">
				


                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>LATICOBSA S.A.</strong></h1>
                            <div class="description">                            	
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>INICIAR SESI&Oacute;N</h3>
                            		<p>Bienvenidos al Sistema Gesti&oacute;n de Cobranzas ARGUS</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">EMPRESA: </label>
			                        	<!--select type="text" class="form-select form-control" id="id_empresa">
								<option value=1>LATICOBSA </option>
							</select-->
                                                        <select class="form-control" name="empresa" required="required" id="empresa">
                                                            <!--option value='0'> -- Seleccionar Empresa -- </option-->
                                                              <c:forEach items="${empresas}" var="empresa">
                                                               <option value='<c:out value="${empresa.getIdEmpresa()}"/>'><c:out value="${empresa.getRazonSocial()}" /> </option>                         
                                                            </c:forEach>      
                                                        </select>
			                        </div>
									<div class="form-group">
			                    		<label class="sr-only" for="form-username">USUARIO: </label>
			                        	<input type="text" name="form-username" placeholder="Ingrese su ID USUARIO" class="form-username form-control" id="usuario">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">CONTRASEÑA</label>
			                        	<input type="password" name="form-password" placeholder="Ingrese su CONTRASE&Ntilde;A" class="form-password form-control" id="password">
			                        </div>
			                        <button  id="btn_logeo" type="submit" class="btn">INGRESAR</button>
			                    </form>
                                            <div id="DivMensajeError" class="alert alert-warning alert-dismissible" style="display:none;">
                                                    <button type="button" class="close" data-dismiss="alert" onclick=" location.reload(true);" aria-hidden="true">&times;</button>
                                                <h4><i class="icon fa fa-warning"></i> Alert!
                                                <div id="idMensajeError"></div></h4>
                                              </div>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3></h3>
                        	<!--div class="social-login-buttons">
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-facebook"></i> Facebook
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-twitter"></i> Twitter
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-google-plus"></i> Google Plus
	                        	</a>
                        	</div-->
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        <script src="dist/js/usuario.js"></script>
        <script>
            $(function () {
                              
                var URLactual = window.location;
                var url =URLactual.toString();
                if(/login.jsp/.test(URLactual)){                 
                   url=url.replace("login.jsp","login");                 
                  location.href=url;
                }
                
                
            });
            
        </script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>
