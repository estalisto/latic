/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcRoles;
import com.laticobsa.servicios.RolesOperaciones;
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
public class CrearRol extends HttpServlet {

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
        RolesOperaciones op =new RolesOperaciones();
        ArrayList<LcRoles> datos = op.getLCRoles();
        
       
       Date fecha_reg=new Date();
   
       int id_rol;
       
       if(datos.isEmpty()){
             id_rol = 1;
         }else {
                LcRoles idRol =datos.get(datos.size() -1);
                id_rol=idRol.getIdRol()+1;
                }
       int empresa=Integer.parseInt(request.getParameter("empresa"));
       //int cargo=Integer.parseInt(request.getParameter("cargo"));
       String rol= request.getParameter("rol");
       op.addRol(new LcRoles(id_rol,(new LcEmpresa(empresa)),rol, rol,fecha_reg,"A",null,null));
      
       response.getWriter().println("Rol Creado Exitosamente");
       //out.println("Nivel de acceso ingresado correctamente");
      // response.sendRedirect("/laticobsa/lista_roles");
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
