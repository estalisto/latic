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
          <a href="#" class="btn btn-success" onclick="frm_empleados();" >Agregar +</a>
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Empleados de la Empresa</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="overflow-x:scroll;">
              <table id="example1" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>ID</th>
                  <th>Identificación</th>
                  <th>Nombre</th>
                  <th>Cargo </th>
                  <th>Profesión </th>
                  <th>Jefe Inmediato </th>
                  <th>E-Mail </th>
                  <th>Estado/Civil </th>
                  <th>Lugar/Nacimiento </th>
                  <th>Fecha </th>
                  <th>Télefonos </th>
                  <th>Fecha Ingreso </th>
                  <th>Observación </th>
                  <th>Acción </th>
                </tr>
                </thead>
                <tbody>
                    
                    <c:forEach items="${empleados}" var="empleado">
                        <tr>
                          <td><c:out value="${empleado.getIdEmpleado()}" /> </td>
                          <td><c:out value="${empleado.getIdentificacion()}" /> </td>
                          <td><c:out value="${empleado.getNombres()}  ${empleado.getApellidos()}" /> </td>
                          <td><c:out value="${empleado.getLcCargos().getCargo()}" /> </td>
                          <td><c:out value="${empleado.getProfesion()}" /> </td>
                          <td><c:out value="${empleado.getIdJefeInmediato()}" /> </td>
                          <td><c:out value="${empleado.getEmail()}" /> </td>
                          <td><c:out value="${empleado.getEstadoCivil()}" /> </td>
                          <td><c:out value="${empleado.getLugarNacimiento()}" /> </td>
                          <td><c:out value="${empleado.getFechaNacimiento()}" /> </td>
                          <td><c:out value="${empleado.getTelefonos()} - ${empleado.getCelular()}" /> </td> 
                          <td><c:out value="${empleado.getFechaCreacion()}" /> </td>
                          <td><c:out value="${empleado.getObservacion()}" /> </td>                         
                          <td><a  onclick="ConnsultaDatosID(${empleado.getIdEmpleado()})" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                              <a onclick="deletempleado(${empleado.getIdEmpleado()})"> <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>     
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

  <script src="dist/js/empleados.js"></script>    
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
