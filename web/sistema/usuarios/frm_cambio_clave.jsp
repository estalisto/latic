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
    
  <!-- Content Wrapper. Contains page content -->
  <div>

<ol class="breadcrumb">
    <li><a href="#" onclick="usuarios();">Usuarios</a></li>
          <li><a href="#" onclick="cambio_clave();" >Cambio Clave</a></li>
      </ol>
      
      <div class="col-md-6">

       

          <div class="box box-danger">
            <div class="box-header with-border bg-yellow"   >
              <h3 class="box-title" >Cambio Clave</h3>
            </div>
               <form name="form" action="usuarios" method="get" class="well">
                    
                <div class="form-group">
                  <label>Usuarios:</label>
                 
                    <select id="usuario" class="form-control" name="usuario" required="required" >
                    <option value=''>Seleccionar Usuario</option>
                     <c:forEach items="${usuarios}" var="user">
                             <option value="<c:out value="${user.getIdUsuario()}" />"><c:out value="${user.getUsuario()}" /> </option>                         
                     </c:forEach>  
                    </select>
                </div>
                
                  <div class="form-group hidden">
                    <label for="exampleInputClave1">Clave: </label>
                    <input type="password" class="form-control" id="exampleInputClave1" placeholder="Ingrese clave actual " required="required" name="clave">
                  </div>
                
               
                  
                  <div class="form-group">
                    <label for="exampleInputClave2">Nueva Clave: </label>
                    <input type="password" class="form-control" id="newclave" placeholder="Ingrese nueva clave " required="required" name="newclave">
                  </div>
                
              
                  
                  <div class="form-group">
                    <label for="exampleInputClave3">Confirmar Clave: </label>
                    <input type="password" class="form-control" id="confirmaclave" placeholder="Confirme nueva clave " required="required" name="confirmaclave">
                  </div>
                
                
                <div class="form-group">
                  <input id="btn-cambio_clave" type="submit" value="Cambiar Contraseña" class="btn btn-primary"  title="Cambio contraseña" >                       
                </div>
            </form>
              <!-- /.box-body -->
          </div>
                 
          <!-- /.box -->

        </div>
      
  </div>
  <!-- /.content-wrapper -->

 <script src="dist/js/usuario.js"></script>

</body>
</html>


