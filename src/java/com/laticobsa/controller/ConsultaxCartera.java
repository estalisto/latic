/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcDatosDeudores;

import com.laticobsa.servicios.ConsultaxCarteraServicios;
import com.laticobsa.servicios.EmpresaServicios;
import com.laticobsa.servicios.ParametrosServicios;
import com.laticobsa.servicios.SucursalServicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ViewSoft
 */
public class ConsultaxCartera extends HttpServlet {

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
       ConsultaxCarteraServicios cd = new ConsultaxCarteraServicios();
       ParametrosServicios param = new ParametrosServicios();
       String accion;
       accion= request.getParameter("accion");
       String id_empresas,id_empleados,id_sucursal,id_rol_empleado,nombreRolEmpleado="";    
       HttpSession sesion = request.getSession(true);
       id_empresas = sesion.getAttribute("Sstrempresa").toString();
       int EmpresaID= Integer.parseInt(id_empresas);
       id_empleados = sesion.getAttribute("Sstrempleado").toString();
       int EmpleadoID= Integer.parseInt(id_empleados);
       id_sucursal = sesion.getAttribute("Sstrsucursal").toString();
       int SucursalID= Integer.parseInt(id_sucursal);
       id_rol_empleado = sesion.getAttribute("SstrUsuarioRol").toString();
       int RolEmpleado= Integer.parseInt(id_rol_empleado);
         String SSqlDatosDeudor="";
           nombreRolEmpleado = sesion.getAttribute("SstrRolEmpleado").toString();

       
       if(accion.equals("listar"))
        {            
           int idclienteok;
           idclienteok = cd.getIdCliente(EmpresaID, SucursalID, EmpleadoID);
           String Tabla="";
          
           int opcion=0;
           
            
           List<LcClientes> carteras = cd.getLcDatoscliente(EmpresaID, idclienteok);  
           request.setAttribute("carteras", carteras);
          // List<LcDatosDeudores> datas = cd.getLcDatos2(EmpresaID,SucursalID, EmpleadoID);
          // request.setAttribute("datas", datas);
            try {
                    String filtro1 = request.getParameter("orden_dia");
                    String filtro2 = request.getParameter("orden_valor");
                    String filtro3 = request.getParameter("orden_fecha");
                 if((filtro1==null)&&(filtro2==null)&&(filtro3==null)){
                     //Tabla=cd.getDatosCarteras(idclienteok, EmpleadoID, opcion);
                     request.setAttribute("Tablacartera", Tabla);
                    // SSqlDatosDeudor=cd.getRetornaQuery(idclienteok, EmpleadoID, opcion);
                     sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                    
                 }
                   if(filtro1!=null){
                       int valorFiltro1 = Integer.parseInt(filtro1);
                      // Tabla=cd.getDatosCarteras(idclienteok, EmpleadoID, valorFiltro1);
                      // request.setAttribute("Tablacartera", Tabla);
                       SSqlDatosDeudor=cd.getRetornaQuery(idclienteok, EmpleadoID, valorFiltro1);
                       sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                       response.getWriter().println(Tabla);
                   }
                    if(filtro2!=null){
                       int valorfiltro2 = Integer.parseInt(filtro2);
                       Tabla=cd.getDatosCarteras(idclienteok, EmpleadoID, valorfiltro2);
                        request.setAttribute("Tablacartera", Tabla);
                        SSqlDatosDeudor=cd.getRetornaQuery(idclienteok, EmpleadoID, valorfiltro2);
                        sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor);
                        response.getWriter().println(Tabla);
                    }
                    if(filtro3!=null){
                       int valorfiltro3 = Integer.parseInt(filtro3); 
                        Tabla=cd.getDatosCarteras(idclienteok, EmpleadoID, valorfiltro3);
                        request.setAttribute("Tablacartera", Tabla);
                        SSqlDatosDeudor=cd.getRetornaQuery(idclienteok, EmpleadoID, valorfiltro3);
                        sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                        response.getWriter().println(Tabla);
                    }
                    // request.getRequestDispatcher("sistema/gestion/frm_consulta_por_cartera_1.jsp").forward(request, response);
                       request.getRequestDispatcher("sistema/gestion/frm_consulta_por_cartera_new.jsp").forward(request, response);

                     
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }


        if(accion.equals("listar_datos")){
        int cartera = Integer.parseInt(request.getParameter("cartera"));
            List<LcDatosDeudores> datas = cd.getLcDatos(EmpresaID, SucursalID, cartera,EmpleadoID);
            request.setAttribute("datas", datas);
            request.getRequestDispatcher("sistema/gestion/consulta_cartera.jsp").forward(request, response);
        }
        
        if(accion.equals("orden")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_dia"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                Tabla2=cd.getDatosCarteras(cartera, EmpleadoID, opcion);
                 SSqlDatosDeudor=cd.getRetornaQuery(cartera, EmpleadoID, opcion);
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(accion.equals("ordenDesc")){
            String Tabla3="";
            int opcion=Integer.parseInt(request.getParameter("opcion"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                Tabla3=cd.getDatosCarteras(cartera, EmpleadoID, opcion);
                 //request.setAttribute("Tablacartera3", Tabla3);
                 SSqlDatosDeudor=cd.getRetornaQuery(cartera, EmpleadoID, opcion);
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 response.getWriter().println(Tabla3);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(accion.equals("filtrosDiasMora")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_dia"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery2(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(accion.equals("filtrosTotalVenc")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_total"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery5(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }         
        if(accion.equals("filtrosDiasFecha")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_Fecha"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery10(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(accion.equals("filtrosIDE")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_IDE"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery3(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(accion.equals("filtrosNombre")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_Nombre"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery4(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(accion.equals("filtrosPagos")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_Pago"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery6(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        if(accion.equals("filtrosSaldo")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_Saldo"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery7(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        if(accion.equals("filtrosValorComp")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_ValorComp"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery8(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
         if(accion.equals("filtrosFechaComp")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_FechaComp"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery9(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
         if(accion.equals("filtrosUltima")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_Ultima"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery11(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }         
         if(accion.equals("filtrosResultado")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_Resultado"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery12(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(accion.equals("filtrosFechaUltPagos")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_FechaUltPagos"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery13(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(accion.equals("TiposGestiones")){
          int idclienteok;
            idclienteok = cd.getIdCliente(EmpresaID, SucursalID, EmpleadoID);
            
            String DatosTiposGestion="{\"tipo_gestion\": "+ cd.getTiposGestion(idclienteok)+"}";//  getTiposGestion
            System.out.println("json: "+DatosTiposGestion);
             response.getWriter().println(DatosTiposGestion);
        }
        if(accion.equals("MisClientes")){
         String Clientes = "{\"listaClientes\": "+cd.getIdCliente2(EmpresaID, SucursalID, EmpleadoID)+"}";
         response.getWriter().println(Clientes);
        }
        if(accion.equals("AllClientes")){
         String Clientes = "{\"listaClientes\": "+cd.getIdClienteAll(EmpresaID, SucursalID)+"}";
         response.getWriter().println(Clientes);
        }
        if(accion.equals("AllTiposGestiones")){
          int idclienteok;
          int cliente = Integer.parseInt(request.getParameter("cliente"));
           // idclienteok = cd.getIdCliente(EmpresaID, SucursalID, EmpleadoID);
            
            String DatosTiposGestion="{\"tipo_gestion\": "+ cd.getTiposGestion(cliente)+"}";//  getTiposGestion
            System.out.println("json: "+DatosTiposGestion);
             response.getWriter().println(DatosTiposGestion);
        }
        
        if(accion.equals("GestionesDiarias")){
            
            String DatosTiposGestion=cd.fnc_ConsultaGestionesDiarias();//  getTiposGestion
          
               System.out.println("json: "+DatosTiposGestion);
             response.getWriter().println(DatosTiposGestion);
        }
        
        
        
        if(accion.equals("Clientes")){
         String Clientes = "{\"listaClientes\": "+cd.getClientes(EmpresaID)+"}";
         response.getWriter().println(Clientes);
        }
        
        if(accion.equals("ClientesPorRol")){
              System.out.println("RolEmpleado: "+RolEmpleado);
              String Clientes = "";
              
             //int cliente=0;
              if(param.permisos_admin(id_rol_empleado)){
                Clientes = "{\"listaClientes\": "+cd.getClientes(EmpresaID)+"}";
                     
              }else{
                    Clientes = "{\"listaClientes\": "+cd.getIdCliente2(EmpresaID, SucursalID, EmpleadoID)+"}";
              }
            
              
              
              
        
         response.getWriter().println(Clientes);
        }
        
        if(accion.equals("GuardaClienteSession")){
            int SSCliente = Integer.parseInt(request.getParameter("IdCliente"));
            try{
            sesion.setAttribute("SSCliente",SSCliente); 
            response.getWriter().println(1);
            }catch (Exception ex){
                response.getWriter().println(0);
            }
        
        }
        if(accion.equals("OPCION_BUSCAR_CLIENTE")){
            String rol = request.getParameter("valida_rol");
            try{
             String cadena=param.getValorParametro("LB_VALIDA_BUSQUEDA_CLIENTE");
                int intIndex = cadena.indexOf(rol);
                if(intIndex != - 1){
                    response.getWriter().println("true");
                }else{
                   response.getWriter().println("false");
                }
            
            }catch (Exception ex){
                response.getWriter().println("flase");
            }
        
        }
        //
        if(accion.equals("TiposResulatdos")){
         int idcliente;
        String DatosTiposResultados="";
         if(!request.getParameter("idcliente").isEmpty()){
             idcliente=Integer.parseInt(request.getParameter("idcliente"));
            
         }else{
             idcliente = cd.getIdCliente(EmpresaID, SucursalID, EmpleadoID);
         }
         //nombreRolEmpleado   
         try{
             String cadena=param.getValorParametro("PERFIL_TIPO_RESULTADO");
                int intIndex = cadena.indexOf(nombreRolEmpleado.toUpperCase());
                if(intIndex != - 1){
                     DatosTiposResultados=cd.getTiposResultados2(idcliente,nombreRolEmpleado.toUpperCase());
                }else{
                    DatosTiposResultados=cd.getTiposResultados(idcliente);
                }
            
            }catch (Exception ex){
               DatosTiposResultados="[]";
            }
         
        
        
         if(DatosTiposResultados.equals("[]")){
             DatosTiposResultados="{\"tipos_resultado\": []}";
         }else{
             DatosTiposResultados="{\"tipos_resultado\": "+ DatosTiposResultados+"}";//  getTiposGestion
  
         }
           // System.out.println("json: "+DatosTiposResultados);
             response.getWriter().println(DatosTiposResultados);
        }
        if(accion.equals("ALLTiposResulatdos")){
         int idcliente=0;
       
         if(!request.getParameter("idcliente").isEmpty()){
             idcliente=Integer.parseInt(request.getParameter("idcliente"));
            
         }
            
         String DatosTiposResultados="";
         DatosTiposResultados=cd.getTiposResultados(idcliente);
         if(DatosTiposResultados.equals("[]")){
             DatosTiposResultados="{\"tipos_resultado\": []}";
         }else{
             DatosTiposResultados="{\"tipos_resultado\": "+ DatosTiposResultados+"}";//  getTiposGestion
  
         }
            System.out.println("json: "+DatosTiposResultados);
             response.getWriter().println(DatosTiposResultados);
        }
        if(accion.equals("MisTiposResulatdos")){
         
            
         String DatosTiposResultados="";
         DatosTiposResultados=cd.getMisTiposResultados();
         if(DatosTiposResultados.equals("[]")){
             DatosTiposResultados="{\"tipos_resultado\": []}";
         }else{
             DatosTiposResultados="{\"tipos_resultado\": "+ DatosTiposResultados+"}";//  getTiposGestion
  
         }
            System.out.println("json: "+DatosTiposResultados);
             response.getWriter().println(DatosTiposResultados);
        }
         if(accion.equals("nuevaConsulta")){
               
                 int cartera = Integer.parseInt(request.getParameter("cartera")); 
                 String QueryConsulta =request.getParameter("sqlQuery");
                 String NuevosDatos="", datos="";
             try{
                   int secuancia;
                 if(param.Consulta_Parametro("LB_HABILITA_CAMPANIA").equals("S")){
                 //consulta si esite campaña
                    datos=cd.getConsultaCampania(EmpleadoID);
                    if(!datos.equals("N")){
                    datos="{\"data\": "+datos+"}";
                         response.getWriter().println(datos);
                         return;
                    }else{
                        QueryConsulta = QueryConsulta.replaceAll("IDClienteConsulta", Integer.toString(cartera));
                        QueryConsulta = QueryConsulta.replaceAll("IDEmpleadoConsulta", Integer.toString(EmpleadoID));
                        QueryConsulta = QueryConsulta.replaceAll("'", "''");

                        sesion.setAttribute("SSqlDatosDeudor",QueryConsulta);
                        String orderby = "ORDER BY";
                            if(!QueryConsulta.toUpperCase().contains(orderby)){
                                QueryConsulta=QueryConsulta+" ORDER BY s.nombres_completo";

                            }
                        NuevosDatos=cd.getNuevaConsulta(QueryConsulta);
                        if(NuevosDatos==null){
                            NuevosDatos="{\"data\":[]}";
                        }else{
                            NuevosDatos="{\"data\": "+NuevosDatos+"}";
                        }
                        
                        response.getWriter().println(NuevosDatos);
                    }
                 }else{
                    QueryConsulta = QueryConsulta.replaceAll("IDClienteConsulta", Integer.toString(cartera));
                    QueryConsulta = QueryConsulta.replaceAll("IDEmpleadoConsulta", Integer.toString(EmpleadoID));
                    QueryConsulta = QueryConsulta.replaceAll("'", "''");
                    
                    sesion.setAttribute("SSqlDatosDeudor",QueryConsulta);
                    NuevosDatos="{\"data\": "+cd.getNuevaConsulta(QueryConsulta)+"}";
                    response.getWriter().println(NuevosDatos);
                 
                 }
                 
                 
                }catch (Exception ex){
                       System.out.println("Error Nueva Consulta: "+QueryConsulta);
                }
                 
                 
         }
         if(accion.equals("consulta_secuencia")){
             int cartera = Integer.parseInt(request.getParameter("cartera")); 
             String QueryConsulta;
            QueryConsulta = request.getParameter("sqlQuery");
                 String datos="", orden=request.getParameter("ordenQuery");
                 //String NuevosDatos="";
                 int secuancia;
                 if(param.Consulta_Parametro("LB_HABILITA_CAMPANIA").equals("S")){
                     
                   datos=cd.getConsultaCampania(EmpleadoID);
                    if(!datos.equals("N")){
                        QueryConsulta="select \n" +
                                        "s.* from lc_empleado_campania  e, lc_det_campanias s \n" +
                                        "where e.id_empleado=s.id_empleado\n" +
                                        "and e.id_campanias=s.id_campanias \n" +
                                        "and e.id_campanias in (select id_campania from lc_campanias \n" +
                                        "			where now() between fecha_inicio and fecha_fin\n" +
                                        "			and estado='A')\n" +
                                        "and e.id_empleado=IDEmpleadoConsulta\n" +
                                        "and e.estado='A'\n" +
                                        "and s.estado='A'\n" +
                                        "and s.asignacion='A'";
                        QueryConsulta=QueryConsulta+" "+orden;
                    }
                     
                 }
                    QueryConsulta = QueryConsulta.replaceAll("IDClienteConsulta", Integer.toString(cartera));
                    QueryConsulta = QueryConsulta.replaceAll("IDEmpleadoConsulta", Integer.toString(EmpleadoID));
                    QueryConsulta = QueryConsulta.replaceAll("'", "''");

                    secuancia=cd.seq_query(QueryConsulta);
                    System.out.println(secuancia+"Query: "+QueryConsulta);
                    response.getWriter().println(secuancia); 

                 
                 
                
         
         }
         //suman_totales
         if(accion.equals("suman_totales")){
             int cartera = Integer.parseInt(request.getParameter("cartera")); 
                 String QueryConsulta =request.getParameter("sqlQuery");
                 //String NuevosDatos="";
                 if(cartera!=0){
                    QueryConsulta = QueryConsulta.replaceAll("IDClienteConsulta", Integer.toString(cartera));
                 }
                 QueryConsulta = QueryConsulta.replaceAll("IDClienteConsulta", Integer.toString(cartera));
                 QueryConsulta = QueryConsulta.replaceAll("IDEmpleadoConsulta", Integer.toString(EmpleadoID));
                 QueryConsulta = QueryConsulta.replaceAll("'", "''");
                 String NuevosDatos="";
                 sesion.setAttribute("SSqlDatosDeudor",QueryConsulta);
                 NuevosDatos="{\"data\": "+cd.getNuevaConsulta(QueryConsulta)+"}";
                 response.getWriter().println(NuevosDatos);
                
                //secuancia=cd.seq_query(QueryConsulta);
                System.out.println("Query: "+QueryConsulta);
               // response.getWriter().println(secuancia);
         
         }
         if(accion.equals("digitador")){
         int idclienteok;
           idclienteok = cd.getIdCliente(EmpresaID, SucursalID, EmpleadoID);
           String Tabla="";
          request.getRequestDispatcher("sistema/gestion/frm_gestion_digitador.jsp").forward(request, response);

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
