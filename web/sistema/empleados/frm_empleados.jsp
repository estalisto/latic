<%-- 
    Document   : index
    Created on : 12-feb-2017, 22:28:05
    Author     : CIMA2015
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <!DOCTYPE html>
<html>
<head>
     
 </head>
    <body>
  <!-- Content Wrapper. Contains page content -->
  <div>

      <br >
      <ol class="breadcrumb">
            <li><a href="#" onclick="empleados(this)" >Lista Empleados</a></li>
            <li class="active"><a href="#" onclick="frm_empleados(this)">Registrar Empleados</a></li>
             
      </ol>
      
      <div class="col-md-8">

       

          <div class="box box-danger">
            <div class="box-header with-border bg-yellow"   >
              <h3 class="box-title" >Registra Empleados</h3>
            </div>
              <form name="form" action="empleados" method="get" class="well">
                <div class="box-body">
                        <!-- Color Picker -->
                        
                        <div class="form-group hidden">
                         <input type="text" class="form-control" placeholder="Ingrese Nombre Rol" value="registrar" required="required" name="accion" id="accion">

                        </div>
                        <div class="form-group">
                          <label>Empresa:</label>
                          <select class="form-control" name="empresa"  required="required" id="empresa">
                            <option value="">Seleccionar</option>
                             <c:forEach items="${empresas}" var="empresa">
                                 <option value="<c:out value="${empresa.getIdEmpresa()}" />" ><c:out value="${empresa.getRazonSocial()}" /></option>
                             </c:forEach>  
                            
                          </select>
                        </div>
                        
                        <div class="form-group ">
                          <label class="">Tipo de Identificación</label>
                                <div class="row">
                                  <div class="col-lg-6">
                                    <select class="form-control" name="t_identificacion" required="required" id="t_identificacion">
                                        <option value='' >Seleccionar tipo de identificación</option>
                                        <option value='CED' >CÉDULA</option>
                                        <option value='RUC' >R.U.C.</option>
                                        <option value='PAS' >PASSAPORTE</option>

                                   </select>
                                  </div>
                                  <div class="col-lg-6">
                                    <input type="text" class="form-control" placeholder="Ingrese Identificación" required="required" name="identificacion" id="identificacion" onkeypress="ValidaSoloNumeros()">
                                  </div>

                                </div>
                        </div> 
                        

                        
                        <div class="form-group">
                          <label>Nombres y Apellidos:</label>
                            <div class="row">
                                <div class="col-lg-6">
                                  <input type="text" class="form-control" placeholder="Ingrese Nombres" required="required" name="nombres" id="nombres" onkeypress="txNombres()">
                                </div>
                                <div class="col-lg-6">
                                  <input type="text" class="form-control" placeholder="Ingrese Apellidos" required="required" name="apellidos" id="apellidos" onkeypress="txNombres()">
                                </div>                                
                              </div>
                        </div>
                        

                        <div class="form-group">
                            <div class="row">
                                <div class="col-lg-3">
                                    <div class="form-group">
                                      <label>Lugar de Nacimiento</label>                          
                                      <input type="text" class="form-control" placeholder="Ingrese Lugar de Nacimiento" required="required" name="lugar_nac" id="lugar_nac" onkeypress="txNombres()">
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                  <div class="form-group">
                                    <label>Fecha de nacimiento:</label>
                                    <div class="input-group date">
                                      <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                      </div>
                                        <input type="text" class="form-control pull-right" id="fecha_nac" name="fecha_nac">
                                    </div>
                                    <!-- /.input group -->
                                  </div>
                                </div>
                                <div class="col-lg-6">
                                  <div class="form-group">
                                    <label>E-Mail</label>
                                    <div class="input-group">
                                      <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                      <input type="email" class="form-control" placeholder="Email" name="email" id="email">
                                    </div>
                                  </div>
                                </div>
                            </div>
                        </div>
                      
                      <!--
                      <div class="form-group">  
                        <div class="row">
                           <div class="col-lg-3">
                             <input type="text" class="form-control" placeholder=".col-xs-3">
                           </div>
                           <div class="col-lg-4">
                             <input type="text" class="form-control" placeholder=".col-xs-4">
                           </div>
                           <div class="col-lg-5">
                             <input type="text" class="form-control" placeholder=".col-xs-5">
                           </div>
                         </div>
                      </div> -->
                       <div class="form-group">  
                        <div class="row">
                           <div class="col-lg-3">
                                <div class="form-group">
                                  <label>Télefono:</label>

                                  <div class="input-group">
                                    <div class="input-group-addon">
                                      <i class="fa fa-phone"></i>
                                    </div>
                                    <input type="text" class="form-control" data-inputmask='"mask": "(99) 999-9999"' data-mask name="telefono" id="telefono" onkeypress="ValidaSoloNumeros()">
                                  </div>
                                  <!-- /.input group -->
                                </div>
                           </div>
                           <div class="col-lg-3">
                                <div class="form-group">
                                  <label>Celular: </label>

                                  <div class="input-group">
                                    <div class="input-group-addon">
                                      <i class="fa fa-phone"></i>
                                    </div>
                                      <input type="text" class="form-control" data-inputmask='"mask": "(99) 999-99999"' data-mask name="celular" id="celular" onkeypress="ValidaSoloNumeros()">
                                  </div>
                                  <!-- /.input group -->
                                </div>
                           </div>
                           <div class="col-lg-3">
                               <div class="form-group ">                                  
                                  <label class="">Estado Civil:</label>
                                  <select class="form-control" name="est_civil" required="required" id="est_civil"> 
                                       <option value='' >Seleccionar el Estado Civil</option>
                                       <option value='S' >SOLTERO</option>
                                       <option value='C' >CASADO</option>
                                       <option value='U'>UNIÓN LIBRE</option>
                                       <option value='D' >DIVORCIADO</option>
                                       <option value='V' >VIUDO</option>                            
                                  </select>
                                </div>

                           </div>
                           <div class="col-lg-3">
                                
                                <div class="form-group ">
                                  <label class="">Genero:</label>
                                  <select class="form-control" name="genero" required="required" id="genero">
                                       <option value='' >Seleccionar genero</option>
                                       <option value='M' >MASCULINO</option>
                                       <option value='F' >FEMENINO</option>                          
                                  </select>
                                </div>  

                           </div>
                         </div>
                      </div>
                        
                       <div class="form-group">  
                        <div class="row">

                           <div class="col-lg-6">
                                <div class="form-group">
                                  <label>Profesión:</label>
                                  <input type="text" class="form-control" placeholder="Ingrese Profesión" required="required" name="profesion" id="profesion" onkeypress="txNombres()">
                                </div>                           
                         </div>
                           <div class="col-lg-3">                        
                                <div class="form-group ">
                                  <label class="">Cargo</label>
                                  <select class="form-control" name="cargo" required="required" id="cargo">
                                       <option value='' >Seleccionar</option>
                                    <c:forEach items="${cargos}" var="cargo">
                                         <option value="<c:out value="${cargo.getIdCargo()}" />" ><c:out value="${cargo.getCargo()}" /></option>
                                     </c:forEach>  
                                  </select>
                                </div>
                           </div>
                           <div class="col-lg-3">                        
                                <div class="form-group ">
                                  <label class="">Jefe Directo:</label>
                                  <select class="form-control" name="jefe_directo" required="required" id="jefe_directo">
                                       <option value='0' >NINGUNO</option>
                                        <c:forEach items="${empleados}" var="empleado">
                                            <option value="<c:out value="${empleado.getIdEmpleado()}" />" ><c:out value="${empleado.getNombres()} ${empleado.getApellidos()}" /></option>
                                        </c:forEach>  
                                  </select>
                                </div> 
                           </div>

                         </div>
                      </div>  

                        
                        <div class="form-group">
                          <label>Dirección Domicilio:</label>
                          <textarea class="form-control" rows="1" id="dir_domicilio" placeholder="Ingrese Dirección Domicilio" name="dir_domicilio"></textarea>
                        </div>
                        
                        <div class="form-group">
                            <label for="comment">Observación:</label>
                            <textarea class="form-control" rows="1" id="observacion" placeholder="Ingrese Observación" name="observacion"></textarea>
                        </div>
                        
                        <div class=" form-group">
                           <input id="btncrearempleados" type="submit" value="Registrar" class="btn btn-primary"  title="Crear Empleados">
                        </div>

                       

                </div>
            </form> 
             
              <!-- /.box-body -->
          </div>

          <!-- /.box -->

        </div>
      
  </div>
  <!-- /.content-wrapper -->
  <script src="dist/js/empleados.js"></script>
</body>
</html>

