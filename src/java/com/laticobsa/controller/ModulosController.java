/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;


import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcModuloRol;
import com.laticobsa.modelo.LcModulos;
import com.laticobsa.modelo.LcRoles;
import com.laticobsa.servicios.EmpresaServicios;
import com.laticobsa.servicios.ModulosRoles;
import com.laticobsa.servicios.RolesOperaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CIMA2015
 */
public class ModulosController extends HttpServlet {

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
      String accion;
        accion= request.getParameter("accion");
        ModulosRoles mr = new ModulosRoles();
        RolesOperaciones ro = new RolesOperaciones();
        EmpresaServicios es =new EmpresaServicios();
        PrintWriter out = response.getWriter();
        if(accion.equals("listar"))
        {

            ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
            request.setAttribute("empresas", empresas);
            ArrayList<LcRoles> roles = ro.getLCRoles();
            request.setAttribute("roles", roles);
            ArrayList<LcModulos> modu = mr.getLcModel();
            request.setAttribute("modu", modu);
            
            
            request.getRequestDispatcher("sistema/modulos/frm_asigna_modulos_rol.jsp").forward(request, response);
        }
        if(accion.equals("desactivar")){

                int id= Integer.parseInt(request.getParameter("id"));
                mr.deleteModal(id);
             //response.getWriter().println("Zona Eliminada");
         }
        if(accion.equals("registrar")){

            int id= Integer.parseInt(request.getParameter("id"));
            Date fecha_reg = new Date();
            int id_empresa=Integer.parseInt(request.getParameter("empresa"));
            int id_rol = Integer.parseInt(request.getParameter("rol"));
            int grupo = Integer.parseInt(request.getParameter("grupo"));
            int nivel = Integer.parseInt(request.getParameter("nivel"));
            int id_modulorol;

                      ArrayList<LcModuloRol> datos = mr.getLcModulo();
                      // en esta linea solo sirve cuando existen datos en la tabla
                       if(datos.isEmpty()){
                           id_modulorol = 1;
                       }else {
                              LcModuloRol idModulo =datos.get(datos.size() -1);
                              id_modulorol=idModulo.getIdModuloRol()+1;
                              }
            if(grupo == 0){
                
                List<LcModuloRol> contenedor = mr.getCabecera(id_empresa, id_rol,nivel);
                
                if(contenedor.isEmpty()){
                
                ArrayList<LcModulos> cabecera = mr.getLcModuloCabecera(id_empresa,nivel);
                LcModulos content = cabecera.get(0);
                int id_cabecera = id;
                int empresa_cab = id_empresa;
                int rol_cab = id_rol;
                int modulo_cab = content.getIdModulo();
                int nivel_cab = content.getNivel();
                int grupo_cab = content.getGrupo();
                
                mr.addModulosCabecera(new LcModuloRol(
                            id_cabecera,
                            (new LcModulos (modulo_cab)),
                            (new LcRoles (rol_cab)),
                            empresa_cab,
                            nivel_cab,
                            grupo_cab,
                            fecha_reg,
                            "A"
                ));
                }
                
                List<LcModuloRol> encuentra = mr.getDatoEncontrado(id_empresa,id_rol,id);
                //int cab_grupo=0;
                if(encuentra.isEmpty()){
                                
                    mr.addModulosrol(new LcModuloRol
                                     (id_modulorol,
                                      (new LcModulos (id)),
                                      (new LcRoles (id_rol)),
                                      id_empresa,
                                      nivel,
                                      grupo,       
                                      fecha_reg,"A"
                                      ));
                    response.getWriter().println("true");
                }
            }           
            else{
                 response.getWriter().println("false");
                 
            }
                    
         }
        if(accion.equals("listar_modulos")){
        int id_modulorol = Integer.parseInt(request.getParameter("rol"));    
        int id_empresa=Integer.parseInt(request.getParameter("empresa"));
            
        List<LcModuloRol> moduloss = mr.getDatosLCModuloRoll(id_modulorol, id_empresa);
                //.SelectModuloRol(id_modulorol, id_empresa);
                //.getDatosLCModuloRoll(id_modulorol, id_empresa);
        request.setAttribute("moduloss", moduloss);
                
                // llamar a la pagina
                request.getRequestDispatcher("sistema/modulos/modulos_asignados.jsp").forward(request, response);
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
