/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcEmpleados;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcRoles;
import com.laticobsa.modelo.LcUsuarios;
import com.laticobsa.servicios.CargosServicios;
import com.laticobsa.servicios.EmpleadosServicios;
import com.laticobsa.servicios.EmpresaServicios;
import com.laticobsa.servicios.RolesOperaciones;
import com.laticobsa.servicios.UsuariosServicios;
import com.laticobsa.utils.EnviarEmail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author CIMA2015
 */
public class UsuariosControllers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UsuariosServicios us = new UsuariosServicios();
        EmpleadosServicios emp = new EmpleadosServicios();
        RolesOperaciones ro= new RolesOperaciones();
        EmpresaServicios es =new EmpresaServicios();
        CargosServicios cs = new CargosServicios();
        PrintWriter out = response.getWriter();
        String accion;
        accion= request.getParameter("accion");


      
        
        if(accion.equals("listar"))
        {
            
        
        List<LcUsuarios> usuarios = us.getLcUsuarioss();
        request.setAttribute("usuarios", usuarios);
            
            request.getRequestDispatcher("sistema/usuarios/lista_usuarios.jsp").forward(request, response);
        //request.getContextPath()+
        }
                
        if(accion.equals("agregar"))
        {
        
       ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
       request.setAttribute("empresas", empresas);
       
       ArrayList<LcRoles> roles = ro.getLCRoles();
        request.setAttribute("roles", roles);    
        
        ArrayList<LcUsuarios> usuarios = us.getLcUsuarios();
        request.setAttribute("usuarios", usuarios);
            
            request.getRequestDispatcher("sistema/usuarios/frm_usuarios.jsp").forward(request, response);
        //request.getContextPath()+
        }
        if(accion.equals("cambio_clave"))
        {  
            ArrayList<LcUsuarios> usuarios = us.getLcUsuarios();
            request.setAttribute("usuarios", usuarios);
            
            request.getRequestDispatcher("sistema/usuarios/frm_cambio_clave.jsp").forward(request, response);
        //request.getContextPath()+
        }  
        if(accion.equals("recupera_clave"))
        {  
          ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
		  request.setAttribute("empresas", empresas); 
		  request.getRequestDispatcher("sistema/usuarios/frm_recuperar_clave.jsp").forward(request, response);
		  //request.getContextPath()
		  }
        
	if(accion.equals("validar")){
            int empresa_nom=0;
        String ide = request.getParameter("identificacion");
    List<LcEmpleados> empleado = emp.ValidaLCEmpleado(ide);
        if(!empleado.isEmpty())
        {
        
        LcEmpleados dato = empleado.get(0);
        empresa_nom = dato.getLcEmpresa().getIdEmpresa();
        //request.setAttribute("empresa_nom", empresa_nom);
        }
        out.println(empresa_nom);
        }
        
        if(accion.equals("cambio")){
            
         int usuario =  Integer.parseInt(request.getParameter("usuario")); 
         String newclave=request.getParameter("newclave");
         String encriptar=DigestUtils.sha1Hex(newclave);
         us.Cambio_clave(usuario, encriptar);
         response.getWriter().println("Contraseña Actualizada");
        }
        
        if(accion.equals("registrar"))
        { int id_usuario;
          int id_empleados;  
          //mpresaOperaciones op =new EmpresaOperaciones();
        ArrayList<LcUsuarios> usuarios = us.getLcUsuarios();
        

                
         if(usuarios.isEmpty()){
             id_usuario = 1;
         }else {
                LcUsuarios iduser =usuarios.get(usuarios.size() -1);
                id_usuario=iduser.getIdUsuario()+1;
                }
         
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                int idEmpleado=Integer.parseInt(request.getParameter("sel_cedula"));
                //String nombre=request.getParameter("nombre");
                int idRol=Integer.parseInt(request.getParameter("rol"));
                String usuario=request.getParameter("nusuario");
                String observacion=request.getParameter("observaciones");
                String ncontrasenia=request.getParameter("ncontrasenia");
                Date fecha_regis=new Date();
                String mensagemUsuario=null;
                String encript=DigestUtils.sha1Hex(ncontrasenia);
                us.addUsuario(new LcUsuarios(id_usuario,(new LcEmpresa(empresa)),(new LcRoles(idRol)),idEmpleado,usuario,encript,observacion,fecha_regis,"A"));
                
//                EnviarEmail enviar = new EnviarEmail();
//                boolean enviou = enviar.enviarHotmail2(DigestUtils.sha1Hex(usuario+"laticobsa"));
//                if (enviou) {
//                mensagemUsuario = "Dados enviados com sucesso";
//                System.out.println("EMAIL"+mensagemUsuario);
//                } else {
//                mensagemUsuario = "N�o foi enviar as informa��es";
//                System.out.println("EMAIL"+mensagemUsuario);            
//                }
                    response.getWriter().println("Nuevo Usuario Registrado");
       
                    //response.sendRedirect("/laticobsa/usuarios?accion=listar");
            
        }

        
        if(accion.equals("buscaID")){

            int id= Integer.parseInt(request.getParameter("id"));
            
            if(id!=0){
               
                List<LcUsuarios> user = us.getDatosLCUsuariosID(id);
                request.setAttribute("user", user);
                ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
                request.setAttribute("empresas", empresas);

                ArrayList<LcRoles> roles = ro.getLCRoles();
                 request.setAttribute("roles", roles);    

                 ArrayList<LcUsuarios> usuarios = us.getLcUsuarios();
                 request.setAttribute("usuarios", usuarios);
                //se envia los datos al formulario para actualizar
                request.getRequestDispatcher("sistema/usuarios/frm_usuarios_up.jsp").forward(request, response);
                
                
            }else{
                 response.getWriter().println("No existen datos a consultar");
                 
            }
                    
         }
        if(accion.equals("editar")){
            
            
                int idusuario = Integer.parseInt(request.getParameter("idusuario"));
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                int idEmpleado=Integer.parseInt(request.getParameter("sel_cedula"));
                int idRol=Integer.parseInt(request.getParameter("rol"));
                String usuario=request.getParameter("nusuario");
                String observacion=request.getParameter("observaciones");
                String ncontrasenia=request.getParameter("ncontrasenia"); 
                
                us.updateUsuario(idusuario, empresa, idEmpleado, idRol, usuario, ncontrasenia, observacion);
                response.getWriter().println("Registro de Usuarios Actualizado");
               
    }
        if(accion.equals("eliminar")){

                int id= Integer.parseInt(request.getParameter("id"));
                us.deleteUsuario(id);
             //response.getWriter().println("Zona Eliminada");
         }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
