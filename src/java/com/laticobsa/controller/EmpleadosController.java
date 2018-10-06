/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcCargos;
import com.laticobsa.modelo.LcEmpleados;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.servicios.CargosServicios;
import com.laticobsa.servicios.EmpleadosServicios;
import com.laticobsa.servicios.EmpresaServicios;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CIMA2015
 */
public class EmpleadosController extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        EmpleadosServicios emp = new EmpleadosServicios();
        EmpresaServicios es =new EmpresaServicios();
        CargosServicios cs = new CargosServicios();
        String accion;
        accion= request.getParameter("accion");


      
        
        if(accion.equals("listar"))
        {
            
        
        List<LcEmpleados> empleados = emp.getLcEmpleadoss();
        request.setAttribute("empleados", empleados);
            
            request.getRequestDispatcher("sistema/empleados/lista_empleados.jsp").forward(request, response);
        //request.getContextPath()+
        }
        if(accion.equals("agregar"))
        {
            
        //
        ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
        request.setAttribute("empresas", empresas); 
        
        
        ArrayList<LcCargos> cargos = cs.getLcCargos();
        request.setAttribute("cargos", cargos);   
       
        ArrayList<LcEmpleados> empleados = emp.getLCEmpleados();
        request.setAttribute("empleados", empleados);
            
          /*  
        EmpleadosServicios es = new EmpleadosServicios();
        ArrayList<LcEmpleados> empleados = es.getLCEmpleados();
        request.setAttribute("empleados", empleados);*/
            
            request.getRequestDispatcher("sistema/empleados/frm_empleados.jsp").forward(request, response);
        //request.getContextPath()+
        }
        if(accion.equals("registrar"))
        {
            
        String strDate=request.getParameter("fecha_nac");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nac = formatter.parse(strDate);
        Date fecha_reg = new Date();
        
        
         int  empresa=Integer.parseInt(request.getParameter("empresa"));
         String  t_identificacion=request.getParameter("t_identificacion");
         String identificacion=request.getParameter("identificacion");
         String nombres=request.getParameter("nombres");
         String apellidos=request.getParameter("apellidos");
         String lugar_nac=request.getParameter("lugar_nac");
        // Date fecha_nac=  request.getParameter("fecha_nac");
         String email=request.getParameter("email");
         String telefono=request.getParameter("telefono");
         String celular=request.getParameter("celular");        
         String est_civil=request.getParameter("est_civil");
         String genero=request.getParameter("genero");
         String profesion=request.getParameter("profesion");
         int cargo=Integer.parseInt(request.getParameter("cargo"));
         int jefe_directo=Integer.parseInt(request.getParameter("jefe_directo"));
         String dir_domicilio=request.getParameter("dir_domicilio");
         String observacion=request.getParameter("observacion");
         
         ArrayList<LcEmpleados> empleados = emp.getLCEmpleados();
         LcEmpleados idEmpelado =empleados.get(empleados.size() -1);
         int id_empleado=idEmpelado.getIdEmpleado()+1;
         /**
          , , , ,, id_cargo, id_jefe_inmediato, observacion, fecha_creacion, 
            fecha_actualizacion, estado)*/
          emp.addEmpleado(new LcEmpleados
                            (id_empleado,
                            (new LcCargos(cargo)),
                            (new LcEmpresa(empresa)),
                            t_identificacion,    
                            identificacion,
                            nombres.toUpperCase(),apellidos.toUpperCase(),lugar_nac.toUpperCase(),fecha_nac,email,telefono,celular,dir_domicilio,est_civil,genero,profesion.toUpperCase(),jefe_directo,observacion.toUpperCase(),fecha_reg,null,"A"));
       
           
            
          response.getWriter().println("Nuevo Empleado Registrado");
         //response.sendRedirect("/laticobsa/empleados?accion=listar");
            
           // request.getRequestDispatcher("sistema/empleados/lista_empleados.jsp").forward(request, response);
        //request.getContextPath()+
        }
        
        if(accion.equals("inactivar"))
        {
            
        //EmpleadosServicios emp = new EmpleadosServicios();
        ArrayList<LcEmpleados> empleados = emp.getLCEmpleados();
        request.setAttribute("empleados", empleados);
            
            request.getRequestDispatcher("sistema/empleados/lista_empleados.jsp").forward(request, response);
        //request.getContextPath()+
        }
        
        if(accion.equals("buscaID")){

            int id= Integer.parseInt(request.getParameter("id"));
            
            if(id!=0){
               
                List<LcEmpleados> emplea = emp.getDatosLCEmpleadosID(id);
                request.setAttribute("emplea", emplea);
                ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
                request.setAttribute("empresas", empresas);
                
                ArrayList<LcCargos> cargos = cs.getLcCargos();
                request.setAttribute("cargos", cargos);   

                ArrayList<LcEmpleados> empleados = emp.getLCEmpleados();
                request.setAttribute("empleados", empleados);
                //se envia los datos al formulario para actualizar
                request.getRequestDispatcher("sistema/empleados/frm_empleados_up.jsp").forward(request, response);
                
                
            }else{
                 response.getWriter().println("No existen datos a consultar");
                 
            }
                    
         }
        if(accion.equals("editar")){
            String strDate=request.getParameter("fecha_nac");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_nac = formatter.parse(strDate);
            
                int idempleado = Integer.parseInt(request.getParameter("idempleado"));
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                String  t_identificacion=request.getParameter("t_identificacion");
                String identificacion=request.getParameter("identificacion");
                String nombres=request.getParameter("nombres");
                String apellidos=request.getParameter("apellidos");
                String lugar_nac=request.getParameter("lugar_nac");
                
                String email=request.getParameter("email");
                String telefono=request.getParameter("telefono");
                String celular=request.getParameter("celular");        
                String est_civil=request.getParameter("est_civil");
                String genero=request.getParameter("genero");
                String profesion=request.getParameter("profesion");
                int cargo=Integer.parseInt(request.getParameter("cargo"));
                int jefe_directo=Integer.parseInt(request.getParameter("jefe_directo"));
                String dir_domicilio=request.getParameter("dir_domicilio");
                String observacion=request.getParameter("observacion"); 
                
                emp.updateEmpleados(idempleado, empresa, t_identificacion, identificacion, nombres, apellidos, lugar_nac, fecha_nac, email, telefono, celular, dir_domicilio, est_civil, genero, profesion, cargo, jefe_directo, observacion);
                response.getWriter().println("Registro de Empleados Actualizado");
               
    }
        if(accion.equals("eliminar")){

                int id= Integer.parseInt(request.getParameter("id"));
                emp.deleteEmpleado(id);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
