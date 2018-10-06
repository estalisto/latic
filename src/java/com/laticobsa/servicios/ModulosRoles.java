/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcModuloRol;
import com.laticobsa.modelo.LcModulos;
import com.laticobsa.modelo.LcRoles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author CIMA2015
 */
public class ModulosRoles {
   
     public List<LcModuloRol> getLcModulosRoles(int rolID, int empresaID){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModuloRol> arreglo = new ArrayList<LcModuloRol>();
        Query q = session.createQuery("From LcModuloRol E WHERE E.nivelModulo = :nivel_Modulo and E.idEmpresa = :id_empresa and E.lcRoles.idRol = :idRol" );
        q.setParameter("nivel_Modulo",0);
        q.setParameter("idRol",rolID);
        q.setParameter("id_empresa",empresaID);
        
        
        List<LcModuloRol> lista=q.list();
         for(LcModuloRol mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcModulos().getMenuOpciones());
        }
        
      
         return lista;
    }
     
      public List<LcModuloRol> getCabecera(int empresaID ,int rolID, int nivel_cab){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModuloRol> arreglo = new ArrayList<LcModuloRol>();
        Query q = session.createQuery("From LcModuloRol E WHERE E.grupoMod = :grupoMod  and E.idEmpresa = :id_empresa and E.lcRoles.idRol = :idRol" );
        q.setParameter("grupoMod",nivel_cab);
        q.setParameter("idRol",rolID);
        q.setParameter("id_empresa",empresaID);
        
        
        List<LcModuloRol> lista=q.list();
         for(LcModuloRol mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcModulos().getMenuOpciones());
        }
        
      
         return lista;
    }
      
    public ArrayList<LcModulos> getLcModuloCabecera(int IDempresa, int nivel){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModulos> arreglo = new ArrayList<LcModulos>();
        Query q = session.createQuery("from LcModulos E WHERE E.grupo = :grupo and E.idEmpresa = :idEmpresa ");
        q.setParameter("grupo",nivel);
        q.setParameter("idEmpresa",IDempresa);
        List<LcModulos> lista=q.list();
        Iterator<LcModulos> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcModulos rol= (LcModulos) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }  
    public void addModulosCabecera(LcModuloRol modulo){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(modulo);
    tx.commit();
    session.close();
    }
    
      public List<LcModuloRol> getDatoEncontrado(int empresaID ,int rolID, int modulo){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModuloRol> arreglo = new ArrayList<LcModuloRol>();
        Query q = session.createQuery("From LcModuloRol E WHERE E.lcModulos.idModulo = :idModulo and E.idEmpresa = :id_empresa and E.lcRoles.idRol = :idRol" );
        q.setParameter("idModulo",modulo);
        q.setParameter("idRol",rolID);
        q.setParameter("id_empresa",empresaID);
        
        
        List<LcModuloRol> lista=q.list();
         for(LcModuloRol mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcModulos().getMenuOpciones());
        }
        
      
         return lista;
    }  
      
    public List<LcModuloRol> getLcModulosRolesROL(int rolID, int empresaID){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModuloRol> arreglo = new ArrayList<LcModuloRol>();
        Query q = session.createQuery("From LcModuloRol E WHERE E.nivelModulo != :nivel_Modulo and E.idEmpresa = :id_empresa and E.lcRoles.idRol = :idRol");
         q.setParameter("nivel_Modulo",0);
         q.setParameter("idRol",rolID);
         q.setParameter("id_empresa",empresaID);
        List<LcModuloRol> lista=q.list();
  
         for(LcModuloRol mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcModulos().getMenuOpciones());
        }
              tx.commit();
        session.close();
      
         return lista;
    }
      
    public List<LcModuloRol> getLcAgencia3(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModuloRol> arreglo = new ArrayList<LcModuloRol>();
        Query q = session.createQuery("from LcModuloRol E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcModuloRol> lista=q.list();
         for(LcModuloRol mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcModulos().getMenuOpciones());
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcRoles().getDescripcion());
        }
        
      
         return lista;
    } 
    
    public ArrayList<LcModuloRol> getLcmodulorol(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModuloRol> arreglo = new ArrayList<LcModuloRol>();
        Query q = session.createQuery("from LcModuloRol E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcModuloRol> lista=q.list();
        Iterator<LcModuloRol> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcModuloRol rol= (LcModuloRol) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
    
    public List<LcModuloRol> getDatosLCModuloRoll(int ID_rol, int IDEmpresa){
         List<LcModuloRol> lista = new  ArrayList();
try{
    SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        
        Query q = session.createQuery("from LcModuloRol E  WHERE E.lcRoles.idRol = :idRol AND E.idEmpresa = :id_empresa AND E.estado = :estado");
        q.setParameter("idRol",ID_rol);
        q.setParameter("id_empresa",IDEmpresa);
        q.setParameter("estado","A"); 
        lista=q.list();
         for(LcModuloRol mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcModulos().getMenuOpciones());
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcRoles().getDescripcion());
        }                
 } catch (Exception e) {
                System.out.println(e);
            }       
    return lista;     
    }

    public List<LcModuloRol> getDatosLCModuloID(int IDModulo_rol){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModuloRol> arreglo = new ArrayList<LcModuloRol>();
        Query q = session.createQuery("from LcModuloRol E WHERE E.idModuloRol = :idModuloRol ");
        q.setParameter("idModuloRol",IDModulo_rol);
        List<LcModuloRol> lista=q.list();
        for(LcModuloRol mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdModuloRol()+", "+mrol.getLcModulos().getMenuOpciones());
        }
           return lista;
        
    }
    
    public void addModulosrol(LcModuloRol modulo){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(modulo);
    tx.commit();
    session.close();
    }
    public void deleteModal(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcModuloRol agen = (LcModuloRol)session.get(LcModuloRol.class, id);    
    agen.setEstado("I");
   // agen.getGrupoMod();
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    
    public ArrayList<LcModuloRol> getLcModulo(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModuloRol> arreglo = new ArrayList<LcModuloRol>();
        Query q = session.createQuery("from LcModuloRol E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcModuloRol> lista=q.list();
        Iterator<LcModuloRol> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcModuloRol rol= (LcModuloRol) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
    public ArrayList<LcModulos> getLcModel(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcModulos> arreglo = new ArrayList<LcModulos>();
        Query q = session.createQuery("from LcModulos E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcModulos> lista=q.list();
        Iterator<LcModulos> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcModulos rol= (LcModulos) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
    public ArrayList<LcRoles> getDatosLCRolID(int IDModulo_rol){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcRoles> arreglo = new ArrayList<LcRoles>();
        Query q = session.createQuery("from LcRoles E WHERE E.idRol = :idRol ");
        q.setParameter("idRol",IDModulo_rol);
        List<LcRoles> lista=q.list();
        Iterator<LcRoles> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcRoles rol= (LcRoles) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
        
    }
    
    //***************************************************************************************
//        public List SelectModuloRol(int roles, int empresas){
//        
//        String cadena = "jdbc:postgresql://localhost:5432/bdjsp";
//        String user = "postgres";
//        String pass = "databasejim5";
//        
//        int rol ,empresa,modulo;
//        LcModuloRol lis =  new LcModuloRol();
//        List listamodulos = new ArrayList();
//        try{
//            Class.forName("org.postgresql.Driver");
//            Connection conex = DriverManager.getConnection(cadena, user, pass);
//            java.sql.Statement st = conex.createStatement();
//
//            String sql="select * from lc_modulo_rol A where A.id_rol ="+roles+"and A.id_empresa="+empresas+ "and A.estado ='A'";
//            ResultSet result = st.executeQuery(sql);
//            while(result.next()){
//                modulo = result.getInt(1);
//                empresa = result.getInt(2);
//                rol = result.getInt(3);
//                int name_modulo = result.getInt(4);
//                int nivel = result.getInt(5);
//                Date fecha = result.getDate(6);
//                String estado = result.getString(7);
//                lis = new LcModuloRol(modulo,rol,empresa);
//                listamodulos.add(lis);
//            }
//            result.close();
//            st.close();
//            conex.close();
//        }catch(Exception e){
//            System.out.println("Error:"+e.getMessage());
//        }
//       return listamodulos;
//    }
    
    
    
    
}
