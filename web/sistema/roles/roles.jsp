<%-- 
    Document   : roles
    Created on : 27-feb-2017, 11:50:46
    Author     : CIMA2015
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


    <!DOCTYPE html>
<html>
<head>
</head>
<body>
  <div>
      <section class="content">
          <a href="#" onclick="frm_roles(this)"  class="btn btn-success"  >Agregar +</a>
      <div class="row">
        <div class="col-xs-6">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Roles de la Empresa</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th class="hidden">ID</th>
                  <th>Nombre Rol</th>
                  <th>Empresa</th>
                  <th>Acción </th>
                  
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${datos}" var="dato">
                        <tr>
                            <td class="hidden"><c:out value="${dato.getIdRol()}" /> </td>
                          <td><c:out value="${dato.getDescripcion()}" /> </td>
                          <td><c:out value="${dato.getLcEmpresa().getRazonSocial()}" /> </td>
                          <td><a onclick="ConnsultaDatosID(${dato.getIdRol()})" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                              <a onclick="deleterol(${dato.getIdRol()})"> <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span></a> </td>     
                        </tr>     
                    </c:forEach>  

           
                </tbody>

              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
   
      
      
      
  </div>
  <!-- /.content-wrapper -->

 

 

<script src="dist/js/roles.js"></script>    
<script>
  $(function () {
    $("#example2").DataTable();
    $('#example1').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>
</body>
</html>



