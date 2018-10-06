/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcCargos;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcRoles;
import com.laticobsa.modelo.LcZonas;
import com.laticobsa.servicios.CargosServicios;
import com.laticobsa.servicios.EmpresaServicios;
import com.laticobsa.servicios.RolesOperaciones;
import com.laticobsa.servicios.ZonasServicios;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ViewSoft
 */
@WebServlet(name = "SectoresController", urlPatterns = {"/sectores"})
public class SectoresController extends HttpServlet {

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
          EmpresaServicios es =new EmpresaServicios();
        CargosServicios cs = new CargosServicios();
        RolesOperaciones ro = new  RolesOperaciones();
        ZonasServicios lz = new ZonasServicios();
         PrintWriter out = response.getWriter();
        String accion;
        accion= request.getParameter("accion");


      
        
        if(accion.equals("listar"))
        {
            
        
       List<LcZonas> zonas = lz.getLcZonass();
       request.setAttribute("zonas", zonas);
         request.getRequestDispatcher("sistema/sectores/lista_sectores.jsp").forward(request, response);   
          
        //request.getContextPath()+
        }
        
        if(accion.equals("validar")){
        String ide = request.getParameter("nombre");
        boolean sector = lz.ValidaLCZonas(ide);
        
        out.println(sector);
        
        }
        
        if(accion.equals("agregar"))
        {
            
                    
               
       ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
       request.setAttribute("empresas", empresas);
       ArrayList<LcRoles> roles = ro.getLCRoles();
       request.setAttribute("roles", roles);
       
       request.getRequestDispatcher("sistema/sectores/frm_sectores.jsp").forward(request, response);
        //request.getContextPath()+
        }
        
        if(accion.equals("registrar"))
        { int id_zona;
            
          //mpresaOperaciones op =new EmpresaOperaciones();
        ArrayList<LcZonas> zona = lz.getLCZonas();
        

                
         if(zona.isEmpty()){
             id_zona = 1;
         }else {
                LcZonas iduser =zona.get(zona.size() -1);
                id_zona=iduser.getIdZona()+1;
                }
         
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                String nombre=request.getParameter("nombre");
                String pais=request.getParameter("pais");
                int  provincia=Integer.parseInt(request.getParameter("provincia"));
                String ciudad=request.getParameter("ciudad");
                String descripcion=request.getParameter("descripcion");
                
                lz.addZonas(new LcZonas
                                (id_zona,
                                 (new LcEmpresa(empresa)),
                                 pais,
                                 provincia,
                                 ciudad,
                                 nombre,       
                                 descripcion, 
                                 null,"A"));
       
             //response.sendRedirect("/laticobsa/sectores?accion=listar");
            response.getWriter().println("Zona Creada Exitosamente");  
            
    }
        if(accion.equals("buscaID")){

            int id= Integer.parseInt(request.getParameter("id"));
            
            if(id!=0){
               
                List<LcZonas> zonas = lz.getDatosLCZonasID(id);
                request.setAttribute("zonas", zonas);
                ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
                request.setAttribute("empresas", empresas);
                
                //se envia los datos al formulario para actualizar
                request.getRequestDispatcher("sistema/sectores/frm_sectores_up.jsp").forward(request, response);
                
                
            }else{
                 response.getWriter().println("No existen datos a consultar");
                 
            }
            
             
             
                
         }
        
        
        
        if(accion.equals("editar")){
                      
                //request.getRequestDispatcher("sistema/sectores/frm_sectores.jsp").forward(request, response);
                int id= Integer.parseInt(request.getParameter("idzona"));
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                String nombre=request.getParameter("nombre");
                String pais=request.getParameter("pais");
                int  provincia=Integer.parseInt(request.getParameter("provincia"));
                String ciudad=request.getParameter("ciudad");
                String descripcion=request.getParameter("descripcion");
                lz.updateZona(id,empresa,pais,provincia,ciudad,nombre,descripcion);
                response.getWriter().println("Registro de zona actualizado");
               
    }
        
        
        if(accion.equals("eliminar")){

                int id= Integer.parseInt(request.getParameter("id"));
                lz.deleteZona(id);
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
