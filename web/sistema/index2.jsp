<%-- 
    Document   : roles
    Created on : 27-feb-2017, 11:50:46
    Author     : CIMA2015
--%>

<%
    String Sidentificacion = "", id_empresa = "", USER_SESION="";
    HttpSession sesion  = request.getSession();
     
     
    try {
     
        
        if (sesion.getAttribute("SstrUsuarioRol")== null && sesion.getAttribute("Sstrempresa")==null && sesion.getAttribute("SstrUSER")== null){
                  
                  sesion.invalidate();
                  response.sendRedirect("login.jsp");
              //out.print("<script>location.replace('login.jsp');<script>");
              return;

        }else {
        Sidentificacion = sesion.getAttribute("SstrUsuarioRol").toString();
        id_empresa = sesion.getAttribute("Sstrempresa").toString();
        USER_SESION= sesion.getAttribute("SstrUSER").toString();
        }
       
        
        
        
        
        
        
    } catch (Exception e) {
        Sidentificacion = "000";
      response.sendRedirect("/laticobsa/login");
    }
%>



<%@page import="com.laticobsa.modelo.LcUsuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.laticobsa.servicios.ValidaUsuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.laticobsa.servicios.ModulosRoles"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.laticobsa.modelo.LcModuloRol"%>
<%@page import="java.util.List"%>



    <!DOCTYPE html>
<html>
<head>
     <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <title>LatiCobsa S.A.</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
   <link rel="icon" type="image/png" href="../dist/img/favicon.png"/>

  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- jvectormap 
  <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">-->
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  </head>
  <style type="text/css">
    input {
        border-radius: 12px 12px 12px 12px;
-moz-border-radius: 12px 12px 12px 12px;
-webkit-border-radius: 12px 12px 12px 12px;
border: 0px groove #000000;

     }
</style>
<body class="hold-transition skin-yellow sidebar-mini">
<div class="wrapper">

  <header class="main-header">

    <!-- Logo -->
    <a href="home" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>RG</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b></b>ARGUS</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
         
          <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-success">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">Tienes 10 Notificaciones</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 1 notificación
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-warning text-green"></i>  2 notificación
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-red"></i>  3 notificación
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-shopping-cart text-green"></i> 4 notificación
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-user text-red"></i> Debes actuializar las credenciales de Usuario
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">Ver todas las Notificaciones</a></li>
            </ul>
          </li>

          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">User: <%=USER_SESION%></span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  <%=USER_SESION%> - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                <!-- /.row 
              </li> -->
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Perfil</a>
                </div>
                <div class="pull-right">
                    <a href="#" onclick="outlogin();" class="btn btn-default btn-flat">Salir</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button 
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>-->
        </ul>
      </div>

    </nav>
  </header>
 <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <!-- /.sidebar -->
  
<section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><%=USER_SESION%></p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->

      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">Menu de Navegación</li>
        
        <% Integer nivelPadre=0; 
           Integer contador=0;
           contador++;
           
           Integer RolID, EmpresaID;
           Integer rol=0, empresa=0;
           //empresa = sesion.getAttribute("strempresa"); 
           //rol = session.getAttribute("strUsuarioRol"); 
           // valida usuario -> rol-> modulos
           RolID =  Integer.parseInt(Sidentificacion);//Admin

           EmpresaID= Integer.parseInt(id_empresa);
           ModulosRoles mr = new ModulosRoles();
            List<LcModuloRol> modulos = mr.getLcModulosRoles(RolID,EmpresaID);
            List<LcModuloRol> modulos2 = mr.getLcModulosRolesROL(RolID,EmpresaID);
           
           for(int i=0; i< modulos.size(); i++) {
                if(modulos.get(i).getNivelModulo().equals(nivelPadre))
                {
                    %>
                        <li class="treeview">
                        <a href="#">
                            <i class="fa fa-cog"></i> <span><%=modulos.get(i).getLcModulos().getMenuOpciones() %></span>
                          <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                          </span>
                        </a>
                        <ul class="treeview-menu">
                            <%
                            for(int j=0; j< modulos2.size(); j++) {
                             if(modulos2.get(j).getNivelModulo().equals(contador))
                                {
                                %>
                                <li class=""><a href="#" onclick="<%=modulos2.get(j).getLcModulos().getFunciones() %>" ><i class="fa fa-circle-o text-yellow"></i> <%=modulos2.get(j).getLcModulos().getMenuOpciones() %></a></li>
                                <% 
                                }
                            }
                            %>
                        </ul>
                      </li>
           <%
                }
             contador++;  
           }
           %>
           
       
      </ul>
    </section>

  
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

      <div id="page-wrapper" >
          
          
          
      </div>
         
      
      
      
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.1.0
    </div>
        <strong> <a href="http://softwarefacturyec.com">SoftwareFactury</a>&copy; 2017. </strong>  Laticobsa - Todos los derechos reservados.

  </footer>

 
  <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>
<script src="dist/js/menu.js"></script>

<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $("#example2").DataTable();
    $('#example1').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>
</body>
</html>


</f:view>
