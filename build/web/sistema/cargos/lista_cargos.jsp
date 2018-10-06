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
   
  <!-- Content Wrapper. Contains page content -->
  <div>

     
      
      <section class="content">
          <a href="#" onclick="frm_cargos();" class="btn btn-success"  >Agregar +</a>
      <div class="row">
        <div class="col-xs-6">
           <div class="box">
            <div class="box-header">
              <h3 class="box-title">Cargos Empresa</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>Id</th>
                  <th>Cargos</th>
                  <th>Empresa</th>
                  <th>Acción</th>
                  
                </tr>
                </thead>
                <tbody>
                      <c:forEach items="${cargos}" var="cargo">
                        <tr>
                          <td><c:out value="${cargo.getIdCargo()}" /> </td>
                          <td><c:out value="${cargo.getCargo()}" /> </td>                
                          <td><c:out value="${cargo.getLcEmpresa().getRazonSocial()}" /> </td>  
                          <td>
                              <a  onclick="ConnsultaDatosID(${cargo.getIdCargo()})" > <span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span></a>
                              
                              <a onclick="deletecargo(${cargo.getIdCargo()})"> <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>  
                          
                        </tr>     
                    </c:forEach>  
             
                </tbody>
               
              </table>
            </div>
            <!-- /.box-body -->
          </div>

          
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
   
      
      
      
  </div>
  <!-- /.content-wrapper -->
<script src="dist/js/cargos.js"></script>   
<!-- page script -->
<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
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


</f:view>
