/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.laticobsa.servicios.ClientesServicios;
import com.laticobsa.servicios.EmpresaServicios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author ViewSoft
 */
public class ClientesController extends HttpServlet {

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
         ClientesServicios es =new ClientesServicios();
         EmpresaServicios em =new EmpresaServicios();
       String accion;
       accion= request.getParameter("accion");
       
       if(accion.equals("listar"))
        {
            
        
        List<LcClientes> clientes = es.getLcClientess();
        request.setAttribute("clientes", clientes);
            
          request.getRequestDispatcher("sistema/cliente/lista_clientes.jsp").forward(request, response);
        //request.getContextPath()+
        }
        if(accion.equals("agregar"))
        {
        ArrayList<LcEmpresa> empresas = em.getLcEmpresa();
        request.setAttribute("empresas", empresas);
          request.getRequestDispatcher("sistema/cliente/frm_clientes.jsp").forward(request, response);
        //request.getContextPath()+
        }
        
        if(accion.equals("registrar"))
        { int id_cliente;
            
          //mpresaOperaciones op =new EmpresaOperaciones();
        ArrayList<LcClientes> datos = es.getLcClientes();
        // en esta linea solo sirve cuando existen datos en la tabla
         if(datos.isEmpty()){
             id_cliente = 1;
         }else {
                LcClientes idCliente =datos.get(datos.size() -1);
                id_cliente=idCliente.getIdCliente()+1;
                }
                
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                String tipo_identificacion = request.getParameter("Tipo_Identificacion");
                String identificacion=request.getParameter("identificacion");
                String razon_social=request.getParameter("razon");
                String direccion=request.getParameter("direccion");
                String pais=request.getParameter("pais");
                int provincia=Integer.parseInt(request.getParameter("Provincia"));
                String ciudad=request.getParameter("Ciudad");
                String contacto=request.getParameter("contacto");
                String email=request.getParameter("email");
                String telefono=request.getParameter("fono1");
                String extensioon=request.getParameter("ext");
                String celular=request.getParameter("celular");
                Date fecha_reg = new Date();
                es.addclientes(new LcClientes
                                     (id_cliente,
                                      (new LcEmpresa (empresa)),
                                      tipo_identificacion,
                                      identificacion,
                                      razon_social,
                                      direccion,
                                      pais, 
                                      provincia,
                                      ciudad,
                                      contacto,
                                      email,
                                      telefono,
                                      extensioon,
                                      celular,
                                      fecha_reg,"A"));
       
             //response.sendRedirect("/laticobsa/clientes?accion=listar");
             response.getWriter().println("Cliente Ingresado correctamente");
            
    }
     if(accion.equals("buscaID")){

            int id= Integer.parseInt(request.getParameter("id"));
            
            if(id!=0){
               
                List<LcClientes> client = es.getDatosLClienteID(id);
                request.setAttribute("client", client);
                ArrayList<LcEmpresa> empresas = em.getLcEmpresa();
                request.setAttribute("empresas", empresas);
                
//                ArrayList<LcCargos> cargos = cs.getLcCargos();
//                request.setAttribute("cargos", cargos);   
//
//                ArrayList<LcEmpleados> empleados = emp.getLCEmpleados();
//                request.setAttribute("empleados", empleados);
                //se envia los datos al formulario para actualizar
                request.getRequestDispatcher("sistema/cliente/frm_clientes_up.jsp").forward(request, response);
                
                
            }else{
                 response.getWriter().println("No existen datos a consultar");
                 
            }
                    
         }
        if(accion.equals("editar")){
            
                int idcliente = Integer.parseInt(request.getParameter("idcliente"));
                int  empresa=Integer.parseInt(request.getParameter("empresa"));
                String tipo_identificacion = request.getParameter("Tipo_Identificacion");
                String identificacion=request.getParameter("identificacion");
                String razon_social=request.getParameter("razon");
                String direccion=request.getParameter("direccion");
                String pais=request.getParameter("pais");
                int provincia=Integer.parseInt(request.getParameter("Provincia"));
                String ciudad=request.getParameter("Ciudad");
                String contacto=request.getParameter("contacto");
                String email=request.getParameter("email");
                String telefono=request.getParameter("fono1");
                String extensioon=request.getParameter("ext");
                String celular=request.getParameter("celular");
                
                es.updateClientes(idcliente, empresa, tipo_identificacion, identificacion, razon_social, direccion, pais, provincia, ciudad, contacto, email, telefono, extensioon, celular);
                response.getWriter().println("Registro de Clientes Actualizado");
               
    }
        if(accion.equals("eliminar")){

                int id= Integer.parseInt(request.getParameter("id"));
                es.deleteClientes(id);
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
