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
  <!-- Content Wrapper. Contains page content -->
  <div>
      <section class="content">
          <a href="#" class="btn btn-success" onclick="frm_parametros();" >Agregar +</a>
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Parámetros de Configuración</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="overflow-x:scroll;">
              <table id="example1" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>ID</th>
                  <th>Código</th>
                  <th>Parametro</th>
                  <th>Valor </th>
                  <th>Fecha Registro </th>
                  <th>Estado </th>
                  <th>Acción </th>
                </tr>
                </thead>
                <tbody>
                     <c:forEach items="${parametros}" var="parametro">
                        <tr>
                          <td><c:out value="${parametro.getId()}" /> </td>
                          <td><c:out value="${parametro.getIdParametro()}" /> </td>
                          <td><c:out value="${parametro.getParametro()}" /> </td>
                          <td><c:out value="${parametro.getValor()}" /> </td>
                          <td><c:out value="${parametro.getFechaRegistro()}" /> </td>
                          <td><c:out value="${parametro.getEstado()}" /> </td>               
                          <td><a  onclick="ConnsultaDatosID(${parametro.getId()})" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                              <a onclick="deleteparametro(${parametro.getId()})"> <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span></a> </td>   
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

  <script src="dist/js/parametros.js"></script>     
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



