<%-- 
    Document   : combo_rol
    Created on : 03/04/2017, 10:27:27 PM
    Author     : ViewSoft
--%>

<%@page import="com.laticobsa.servicios.EmpresaServicios"%>
<%@page import="com.laticobsa.modelo.LcProvincia"%>
<%@page import="java.util.List"%>
<%@page import="com.laticobsa.servicios.RolesOperaciones"%>
<%@page import="com.laticobsa.modelo.LcRoles"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
   <select id="rol" class="form-control" name="rol" disabled="true">
   <option value=''>Seleccionar Rol</option>
<%
  RolesOperaciones ro = new RolesOperaciones();  
  int empresa = Integer.parseInt(request.getParameter("empresa"));  
  ArrayList<LcRoles> roless = ro.getRolesEmpresa(empresa);
  if(!roless.isEmpty()){
   for(int i=0; i< roless.size(); i++) {
   %>
 
   <option value="<%=roless.get(i).getIdRol() %>"><%=roless.get(i).getDescripcion() %></option>                         
      

<%   }
   }else{ response.getWriter().println("Empresa no tiene Usuarios con Roles asignados");}
%>

</select>

