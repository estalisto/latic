/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcAgencia;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.servicios.AgenciaServicios;
import com.laticobsa.servicios.EmpresaServicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "AgenciaController", urlPatterns = {"/agencia"})
public class AgenciaController extends HttpServlet {

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
        AgenciaServicios ag = new AgenciaServicios();
        EmpresaServicios es =new EmpresaServicios();
        PrintWriter out = response.getWriter();
        if(accion.equals("listar"))
        {
            
        
       List<LcAgencia> agencias = ag.getLcAgencias();
       request.setAttribute("agencias", agencias);
            
              request.getRequestDispatcher("sistema/agencia/lista_agencia.jsp").forward(request, response);
        //request.getContextPath()+
        }
         if(accion.equals("agregar"))
        {
        
       ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
       request.setAttribute("empresas", empresas);
       request.getRequestDispatcher("sistema/agencia/frm_agencia.jsp").forward(request, response);
        //request.getContextPath()+
        }
        
        if(accion.equals("registrar"))
        { int id_agencia;
            
          //mpresaOperaciones op =new EmpresaOperaciones();
        ArrayList<LcAgencia> datos = ag.getLcAgencia();
        // en esta linea solo sirve cuando existen datos en la tabla
         if(datos.isEmpty()){
             id_agencia = 1;
         }else {
                LcAgencia idAgencia =datos.get(datos.size() -1);
                id_agencia=idAgencia.getIdAgencia()+1;
                }
       
                Date fecha_reg = new Date();
                int empresa=Integer.parseInt(request.getParameter("empresa"));
                String nombre=request.getParameter("nombre");
                String opcion = request.getParameter("opcion");
                String direccion=request.getParameter("direccion");
                String telefono=request.getParameter("telefono");
                String telefono2=request.getParameter("telefono2");
                String celular=request.getParameter("celular");
                String mail=request.getParameter("mail");
                                                
                ag.addAgencia(new LcAgencia
                                     (id_agencia,
                                      (new LcEmpresa(empresa)),
                                      nombre,
                                      opcion,
                                      direccion,
                                      telefono,
                                      telefono2, 
                                      celular,
                                      mail,      
                                      fecha_reg,"A"
                                       ));
       
             //response.sendRedirect("/laticobsa/empresa?accion=listar");
           response.getWriter().println("Agencia Creado Exitosamente");           
         // request.getRequestDispatcher("sistema/empresa/frm_empresa.jsp").forward(request, response);
        //request.getContextPath()+
        }
         if(accion.equals("eliminar")){

                int id= Integer.parseInt(request.getParameter("id"));
                ag.deleteAgencia(id);
             //response.getWriter().println("Agencia Eliminada");
         }
         
          if(accion.equals("buscaID")){

            int id= Integer.parseInt(request.getParameter("id"));
            
            if(id!=0){
               
                List<LcAgencia> agent = ag.getDatosLCAgenciaID(id);
                request.setAttribute("agent", agent);
                ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
                 request.setAttribute("empresas", empresas);
                request.getRequestDispatcher("sistema/agencia/frm_agencia_up.jsp").forward(request, response);
                
                
            }else{
                 response.getWriter().println("No existen datos a consultar");
                 
            }
                    
         }
        if(accion.equals("editar")){
            
                int idagencia = Integer.parseInt(request.getParameter("idagencia"));
                int empresa=Integer.parseInt(request.getParameter("empresa"));
                String nombre=request.getParameter("nombre");
                String opcion = request.getParameter("opcion");
                String direccion=request.getParameter("direccion");
                String telefono=request.getParameter("telefono");
                String telefono2=request.getParameter("telefono2");
                String celular=request.getParameter("celular");
                String mail=request.getParameter("mail");
                
                ag.updateAgencia(idagencia, empresa, nombre, opcion, direccion, telefono, telefono2, celular, mail);
                response.getWriter().println("Registro de Clientes Actualizado");
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
