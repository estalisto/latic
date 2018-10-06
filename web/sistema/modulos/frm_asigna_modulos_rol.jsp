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
            <!-- Content Wrapper. Contains page content -->
                <br >
                <div>
                <ol class="breadcrumb">
                    <li><a href="home">Home</a></li>
                    <li class="active"><a href="">Módulos Rol</a></li>
                </ol>

                    <div class="col-md-6">
                        <!-- general form elements -->
                        <div class="box box-danger">
                            <div class="box-header with-border bg-yellow">
                                <h3 class="box-title">Asignar Módulos del Sistema por Nivel de Acceso</h3>
                            </div>
                           <!-- <form name="form" action="modulos" method="get" class="well">-->

                                <div class="box-body"> 
                                    <!--div class="form-group hidden">
                                        <input type="text" class="form-control" placeholder="Ingrese Nombre Rol" value="listar" required="required" name="accion" id="accion">
                                    </div-->
                                    <div class="form-group">
                                        <label>Empresa:</label>
                                        <select id="empresa" class="form-control" name="empresa" >
                                            <option value=''>Seleccionar Empresa</option>
                                            <c:forEach items="${empresas}" var="empresa">
                                                <option value="<c:out value="${empresa.getIdEmpresa()}" />"><c:out value="${empresa.getRazonSocial()}" /> </option>                         
                                            </c:forEach>                 
                                        </select>
                                    </div> 

                                    <div class="form-group">
                                        <label>Rol:</label>
                                        <select id="rol" class="form-control" name="rol" required="required">
                                            <option value=''>Seleccionar Rol</option>
                                            <c:forEach items="${roles}" var="rol">
                                                <option value="<c:out value="${rol.getIdRol()}" />"><c:out value="${rol.getDescripcion()}"/> </option>                         
                                            </c:forEach> 
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input id="btncrearmodulo" type="submit"  value="Ver Módulos" onclick=""  class="btn btn-primary"  title="Ver modulos">
                                    </div>
                                </div>
                           <!-- </form>-->
                        </div>    
                    </div>
                    
                    <div id="list_modulo" class="col-md-6" style="display: none" >
                        <form name="form2" action="modulos" method="get" class="well">
                        <div class="box">
                          <div class="box-header">
                            <h3 class="box-title">Lista de Modulos</h3>
                          </div>
                          <!-- /.box-header -->
                          <div class="box-body" style="overflow-y:scroll;">

                            <table id="example1" class="table table-bordered table-hover">
                              <thead>
                              <tr>
                                <th>ID</th>
                                <th>Modulo</th>
                                <th>Nivel</th>
                                <th><center>Acción</center></th>
                              </tr>
                              </thead>
                              <tbody>

                                  <c:forEach items="${modu}" var="modulo">
                                      <tr>
                                        <td><c:out value="${modulo.getIdModulo()}" /> </td>
                                        <td><c:out value="${modulo.getMenuOpciones()}"/> </td>
                                        <td><c:out value="${modulo.getNivel()}"/> </td>
                                        <td><center><label>Activar &nbsp;</label><input id="check_active" onclick="ActivaModulo(${modulo.getIdModulo()},${modulo.getNivel()},${modulo.getGrupo()})" name="check_active"  type="checkbox">&nbsp;</center></td> 
                                      </tr>     
                                  </c:forEach>  
                              </tbody>

                            </table>
                          </div>
                          <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                        </form>
                    </div>
                    <!-- Main content -->
                    
                    <section class="content ">
                        <div id="pagetable">  
                        </div> 
                    </section>
                    
                </div>
                <script src="dist/js/modulo_rol.js"></script>  
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

