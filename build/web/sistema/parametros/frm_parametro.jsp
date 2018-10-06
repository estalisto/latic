<%-- 
    Document   : index
    Created on : 12-feb-2017, 22:28:05
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

      <br >
      <ol class="breadcrumb">
          <li><a href="#" onclick="parametros();">Parámetros</a></li>
          <li class="active"><a href="#" onclick="frm_parametros();">Registra Parámetros</a></li>
             
      </ol>
      
      <div class="col-md-6">

       

          <div class="box box-danger">
            <div class="box-header with-border bg-yellow"   >
              <h3 class="box-title" >Registra Parámetros</h3>
            </div>
              <form name="form" action="parametros" method="get" class="well">
            
                    <div class="form-group hidden">
                         <input type="text" class="form-control" placeholder="Ingrese Nombre Rol" value="registrar" required="required" name="accion" id="accion">
                    </div>
                                  
                 <div class="form-group">
                  <label>Código:</label>
                  <input type="text" class="form-control"  placeholder="Ingrese el Cargo " required="required" name="codigo" id="codigo"> 
                </div> 
                  
                <div class="form-group">
                  <label>Parámetro:</label>
                  <input type="text" class="form-control"  placeholder="Ingrese el Cargo " required="required" name="nombre" id="nombre"> 
                </div> 
                
                <div class="form-group">
                  <label>Valor:</label>
                  <textarea class="form-control" rows="5"  placeholder="Ingrese los valores del Parámetro" name="valor" id="valor"></textarea>
                 
                </div> 
              <div class="form-group">
                <input id="btncrearparametro" type="submit" value="Registrar" class="btn btn-primary"  title="Crear Parametros">
              </div>
            </form>
              <!-- /.box-body -->
          </div>

          <!-- /.box -->

        </div>
      
  </div>
  <!-- /.content-wrapper -->

  
<!-- ./wrapper -->
<script src="dist/js/parametros.js"></script>     
</body>
</html>


