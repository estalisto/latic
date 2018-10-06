<%-- 
    Document   : index
    Created on : 12-feb-2017, 22:28:05
    Author     : Stalyn Granda
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

  <!DOCTYPE html>
<html>
  <head>      
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--link rel="stylesheet" href="dist/css/jquery.datetimepicker.css"-->   
       
  </head>
    <body>
  

  <div> <!-- div inicio  -->
      
    <div class="col-lg-10"> 
        <br>
        <div class="box box-danger">
            <div class="box-header with-border bg-yellow">
                <h3 class="box-title">Compromiso de Pago</h3>
            </div>
      <div class="panel panel-default well-lg margin"> 
           <form class="form-inline">            
            <div class="form-group has-feedback">
                <label class="control-label"> Fecha Desde:</label>
                <input type="text" class="form-control" placeholder="DD-MM-YYYY" data-date-format="dd-mm-yyyy" id="datepicker"/>
                <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
            </div> 
               <div class="form-group has-feedback"></div> 
            <div class="form-group has-feedback">
                <label class="control-label">Fecha Hasta: </label>
                <input type="text" class="form-control" placeholder="DD-MM-YYYY" data-date-format="dd-mm-yyyy" id="datepicker2"/>
                <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
            </div> 
               <div class="form-group has-feedback"></div> 
               <button type="button" class="btn btn-success " id="buscarCompromisos">
                 <span class="glyphicon glyphicon-search"></span> <strong> Buscar </strong>
              </button>
                <div id="example_wrapper" class="form-group has-feedback"></div> 
          </form>
          <br>
          
            <div class="row">
                <div  class="box">
                     <div  class="box-body table-responsive" style="overflow-x: auto" >
                        <div id="busca_compromisos"> 
                          <table  id="compro_pago" class="table table-striped table-bordered table-hover " cellspacing="0" width="100%">                            
                            <thead>  
                            <tr bgcolor="#FBF5EF">
                              <th class="col-sm-1 text-center" >N°</th>
                              <th class="col-sm-1  text-center">Fecha llamada</th>
                              <th class="col-sm-3">Deudor</th>
                              <th class="col-sm-1 text-center">Fech. Compromiso</th>
                              <th class="col-sm-1">Monto Compromiso</th>
                              <th class="col-sm-3">Observación</th>
                            </tr>
                             </thead>         
                            
                                        <%= request.getAttribute("Tablacompromiso") %>

                            
                          </table>
                        </div>
                     </div>
                </div>                
            </div>
      </div>
    </div>
      
    </div>   
  </div>  <!-- fin de div de inicio  --> 
       
  
  
  <!-- /.content-wrapper 
<script src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script src="dist/js/jquery.datetimepicker.full.js"></script>-->
<script src="dist/js/compromiso_pagos.js"></script> 
<script src="dist/js/cobranzas.js"></script>


<!-- DataTables
<script src="plugins/datatables/jquery.dataTables.min.js"></script> 
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
--> 
<script>    
$(function() {
 $("#compro_pago").DataTable({
    "paging": true,
    "lengthChange": false,
    "lengthMenu": [10],
    "ordering": false,
    "info": false,
    "autoWidth": false
  });
   
 


    
});

</script> 

<!-- ./wrapper -->
</body>
</html>


