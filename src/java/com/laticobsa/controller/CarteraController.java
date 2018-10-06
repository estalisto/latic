/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcDeudor;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.servicios.ClientesServicios;
import com.laticobsa.servicios.DeudorServicios;
import com.laticobsa.servicios.EmpresaServicios;
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
 * @author ViewSoft
 */
public class CarteraController extends HttpServlet {

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
        ClientesServicios cl = new ClientesServicios();
        DeudorServicios du = new DeudorServicios();
        PrintWriter out = response.getWriter();
        String accion;
        accion= request.getParameter("accion");


      
        
        if(accion.equals("listar"))
        {
            
        
       ArrayList<LcDeudor> deudor = du.getLcDeudor();
       request.setAttribute("deudor", deudor);
         request.getRequestDispatcher("sistema/cartera/lista_cartera.jsp").forward(request, response);   
          
        //request.getContextPath()+
        }
     
        
        if(accion.equals("agregar"))
        {
         
               
       ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
       request.setAttribute("empresas", empresas);
       ArrayList<LcClientes> clientes = cl.getLcClientes();
       request.setAttribute("clientes", clientes);
       
       request.getRequestDispatcher("sistema/cartera/frm_cartera.jsp").forward(request, response);
        //request.getContextPath()+
        }
        
                
        if(accion.equals("registrar"))
        { int id_deudor;
            
          //mpresaOperaciones op =new EmpresaOperaciones();
        ArrayList<LcDeudor> zona = du.getLcDeudor();
        

                
         if(zona.isEmpty()){
             id_deudor = 1;
         }else {
                LcDeudor iduser =zona.get(zona.size() -1);
                id_deudor=iduser.getIdDeudor()+1;
                }
                Date fecha_reg = new Date();
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                int  cliente=Integer.parseInt(request.getParameter("cliente"));
                String nombre=request.getParameter("nombre");
                String observacion=request.getParameter("observacion");
                String adicional=request.getParameter("adicional");
               
                du.addDeudor(new LcDeudor
                                (id_deudor,
                                 empresa,
                                 cliente,
                                 nombre,
                                 observacion,
                                 adicional,       
                                 fecha_reg, 
                                 fecha_reg,"A"));
       
             //response.sendRedirect("/laticobsa/sectores?accion=listar");
            response.getWriter().println("Cartera Deudor Creado Exitosamente");  
            
    }
        if(accion.equals("buscaID")){

            int id= Integer.parseInt(request.getParameter("id"));
            
            if(id!=0){
               
                ArrayList<LcDeudor> deuda = du.getDatosLCDeudorID(id);
                request.setAttribute("deuda", deuda);
                ArrayList<LcEmpresa> empresas = es.getLcEmpresa();
                request.setAttribute("empresas", empresas);
                ArrayList<LcClientes> clientes = cl.getLcClientes();
                request.setAttribute("clientes", clientes);
                //se envia los datos al formulario para actualizar
                request.getRequestDispatcher("sistema/cartera/frm_cartera_up.jsp").forward(request, response);
                
                
            }else{
                 response.getWriter().println("No existen datos a consultar");
                 
            }
               
         }
       
        if(accion.equals("editar")){
                      
                //request.getRequestDispatcher("sistema/sectores/frm_sectores.jsp").forward(request, response);
                int id= Integer.parseInt(request.getParameter("iddeuda"));
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                int  cliente=Integer.parseInt(request.getParameter("cliente"));
                String nombre=request.getParameter("nombre");
                String observacion=request.getParameter("observacion");
                String adicional=request.getParameter("adicional");
                du.updateDeudor(id, empresa, cliente, nombre, observacion, adicional);
                response.getWriter().println("Registro de Deudor Actualizado");
    }
        
        if(accion.equals("eliminar")){

                int id= Integer.parseInt(request.getParameter("id"));
                du.deleteDeudor(id);
             
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
