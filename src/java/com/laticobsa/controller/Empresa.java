/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcSucursal;
import com.laticobsa.servicios.EmpresaServicios;
import com.laticobsa.servicios.SucursalServicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CIMA2015
 */
public class Empresa extends HttpServlet {

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
       PrintWriter out = response.getWriter(); 
       EmpresaServicios es =new EmpresaServicios();
       SucursalServicios su = new SucursalServicios();
       String accion;
       accion= request.getParameter("accion");
       
       if(accion.equals("listar"))
        {
            
        
        ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
        request.setAttribute("empresas", empresas);
        
//        LcEmpresa dato = empresas.get(0);
//        String estate = dato.getEstado();
//        out.println(estate);    
          request.getRequestDispatcher("sistema/empresa/lista_empresa.jsp").forward(request, response);
        //request.getContextPath()+
        }
        if(accion.equals("agregar"))
        {
            ArrayList<LcSucursal> sucursal = su.getLcSucursal();
            request.setAttribute("sucursale", sucursal);
          request.getRequestDispatcher("sistema/empresa/frm_empresa.jsp").forward(request, response);
        //request.getContextPath()+
        }
        
        if(accion.equals("registrar"))
        { int id_empresa;
            
          //mpresaOperaciones op =new EmpresaOperaciones();
        ArrayList<LcEmpresa> datos = es.getLcEmpresa();
        // en esta linea solo sirve cuando existen datos en la tabla
         if(datos.isEmpty()){
             id_empresa = 1;
         }else {
                LcEmpresa idEmpresa =datos.get(datos.size() -1);
                id_empresa=idEmpresa.getIdEmpresa()+1;
                }
       
                Date fecha_reg = new Date();
                
                String tipo_identificacion = request.getParameter("t_identificacion");
                String identificacion=request.getParameter("identificacion");
                String nom_emp=request.getParameter("nombre");
                String direccion=request.getParameter("direccion");
                String telefono=request.getParameter("telefono");
                String mail=request.getParameter("mail");
                String pais=request.getParameter("pais");
                int provincia=Integer.parseInt(request.getParameter("provincia"));
                String ciudad=request.getParameter("ciudad");
                //int sucursal=Integer.parseInt(request.getParameter("sucursal"));
                String telefono2=request.getParameter("telefono2");
                String celular=request.getParameter("celular"); 
                es.addEmpresa(new LcEmpresa
                                     (id_empresa,
                                      pais,
                                      ciudad,
                                      provincia,
                                      tipo_identificacion,
                                      identificacion,
                                      nom_emp, 
                                      direccion,
                                      telefono,      
                                      mail,
                                      fecha_reg,fecha_reg,"A",
                                      telefono2,celular,null,null,null,null,null,null,null,null
                                      ));
       
             //response.sendRedirect("/laticobsa/empresa?accion=listar");
           response.getWriter().println("Empresa Creado Exitosamente");           
         // request.getRequestDispatcher("sistema/empresa/frm_empresa.jsp").forward(request, response);
        //request.getContextPath()+
        }
        if(accion.equals("buscaID")){

            int id= Integer.parseInt(request.getParameter("id"));
            
            if(id!=0){
               
                ArrayList<LcEmpresa> enterprise = es.getDatosLCZonasID(id);
                request.setAttribute("enterprise", enterprise);
                ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
                request.setAttribute("empresas", empresas);
                
                //se envia los datos al formulario para actualizar
                request.getRequestDispatcher("sistema/empresa/frm_empresa_up.jsp").forward(request, response);
                
                
            }else{
                 response.getWriter().println("No existen datos a consultar");
                 
            }
                    
         }
        if(accion.equals("editar")){
                
                int id =Integer.parseInt(request.getParameter("idempresa"));
                String tipo_identificacion = request.getParameter("t_identificacion");
                String identificacion=request.getParameter("identificacion");
                String nom_emp=request.getParameter("nombre");
                String direccion=request.getParameter("direccion");
                String telefono=request.getParameter("telefono");
                String mail=request.getParameter("mail");
                String pais=request.getParameter("pais");
                int provincia=Integer.parseInt(request.getParameter("provincia"));
                String ciudad=request.getParameter("ciudad");
                //int sucursal=Integer.parseInt(request.getParameter("sucursal"));
                String telefono2=request.getParameter("telefono2");
                String celular=request.getParameter("celular"); 
                es.updateEmpresa(id, pais, ciudad, provincia, tipo_identificacion, identificacion, nom_emp, direccion, telefono, mail, telefono2, celular);
                response.getWriter().println("Registro de Empresa Actualizado");
               
    }
        if(accion.equals("eliminar")){

                int id= Integer.parseInt(request.getParameter("id"));
                es.deleteEmpresa(id);
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
