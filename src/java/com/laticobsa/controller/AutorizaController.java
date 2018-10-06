/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcUsuarios;
import com.laticobsa.servicios.UsuariosServicios;
import com.laticobsa.servicios.ValidaUsuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author CIMA2015
 */
public class AutorizaController extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        UsuariosServicios us = new UsuariosServicios();
        ValidaUsuario vs=new ValidaUsuario();
        String accion, user, pass ;
        int rol=0;
        int empresa=0;
        
        boolean autorizaOK;
               
        accion= request.getParameter("accion");
        
        if(accion.equals("autorizar"))
        {
        user= request.getParameter("usuario");
        pass= request.getParameter("password");
        
            
        autorizaOK=vs.getValidaUsuario(user, pass); 
        
         if (!autorizaOK){  
             
              response.sendRedirect("/laticobsa/login");
              
         }else{
                String encript=DigestUtils.sha1Hex(pass);
                //Validar el uuario
                ArrayList<LcUsuarios> autoriza = vs.getLcValidaUser(user, encript);//.getLcAutorizaUser(user,pass);
                LcUsuarios dato = autoriza.get(rol);
                LcUsuarios dato2 = autoriza.get(empresa);
                //rol = dato.getIdRol();  //trae el rol de usuario
                session.setAttribute("SstrUsuarioRol",dato.getLcRoles().getIdRol());
                session.setAttribute("Sstrempresa",dato2.getLcEmpresa().getIdEmpresa());
                session.setAttribute("SstrUSER",user);
                response.sendRedirect("/laticobsa/home");
            }
        }
        if (accion.equals("outlogin")){
              session.invalidate();
             response.sendRedirect("/laticobsa/login");
 
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
