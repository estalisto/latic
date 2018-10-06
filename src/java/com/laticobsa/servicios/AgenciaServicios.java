/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcAgencia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ViewSoft
 */
public class AgenciaServicios {
    public ArrayList<LcAgencia> getLcAgencia(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcAgencia> arreglo = new ArrayList<LcAgencia>();
        Query q = session.createQuery("from LcAgencia E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcAgencia> lista=q.list();
        Iterator<LcAgencia> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcAgencia rol= (LcAgencia) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    } 
    
        public List<LcAgencia> getLcAgencias(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcAgencia> arreglo = new ArrayList<LcAgencia>();
        Query q = session.createQuery("from LcAgencia E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcAgencia> lista=q.list();
         for(LcAgencia mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdAgencia()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        
      
         return lista;
    }
    
    public void addAgencia(LcAgencia agencia){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(agencia);
    tx.commit();
    session.close();
    }
    
   public void updateAgencia(int idAgencia, int idEmpresa, String nombre, String opcion, String direccion, String telefono, String telefono2, String celular, String email){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcAgencia agen = (LcAgencia)session.get(LcAgencia.class, idAgencia);
    //agen.setIdEmpresa(idEmpresa);
    agen.setNombre(nombre);
    agen.setOpcion(opcion);
    agen.setDireccion(direccion);
    agen.setTelefono(telefono);
    agen.setTelefono2(telefono2);
    agen.setCelular(celular);
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    public void deleteAgencia(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcAgencia agen = (LcAgencia)session.get(LcAgencia.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    public List<LcAgencia> getDatosLCAgenciaID(int IDAgencia){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcAgencia> arreglo = new ArrayList<LcAgencia>();
        Query q = session.createQuery("from LcAgencia E WHERE E.idAgencia = :idAgencia ");
        q.setParameter("idAgencia",IDAgencia);
        List<LcAgencia> lista=q.list();
         for(LcAgencia mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdAgencia()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        
      
         return lista;
    }
    
}
