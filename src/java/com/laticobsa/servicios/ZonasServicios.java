/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcEmpleados;
import com.laticobsa.modelo.LcZonas;
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
public class ZonasServicios {
    
   public ArrayList<LcZonas> getLCZonas(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcZonas> arreglo = new ArrayList<LcZonas>();
        Query q = session.createQuery("from LcZonas E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcZonas> lista=q.list();
        Iterator<LcZonas> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcZonas rol= (LcZonas) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    } 
    public List<LcZonas> getLcZonass(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcZonas> arreglo = new ArrayList<LcZonas>();
        Query q = session.createQuery("from LcZonas E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcZonas> lista=q.list();
         for(LcZonas mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdZona()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        
      
         return lista;
    }
   public boolean ValidaLCZonas(String nombre){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcZonas> arreglo = new ArrayList<LcZonas>();
        Query q = session.createQuery("from LcZonas E WHERE E.nombre = :nombre ");
        q.setParameter("nombre",nombre);
        
        boolean resp = false;
        List<LcZonas> lista=q.list();
        Iterator<LcZonas> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcZonas rol= (LcZonas) iter.next();
            arreglo.add(rol);
        }
        
        if(arreglo.size() > 0){
            resp = true;
        }
        
        return resp;
    }
   
   public void addZonas(LcZonas zona){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(zona);
    tx.commit();
    session.close();
    }
   
   public void updateZona(int id, int empresa,String pais, int provincia, String ciudad, String nombre,String sector){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcZonas agen = (LcZonas)session.get(LcZonas.class, id);
    //agen.setIdEmpresa(empresa);
    agen.setIdPais(pais);
    agen.setIdProvincia(provincia);
    agen.setIdCiudad(ciudad);
    agen.setNombreZona(nombre);
    agen.setSectorDescripcion(sector);
    session.update(agen);
    tx.commit();
    session.close();
    }
   
    public void deleteZona(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcZonas agen = (LcZonas)session.get(LcZonas.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
    public List<LcZonas> getDatosLCZonasID(int IDZona){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcZonas> arreglo = new ArrayList<LcZonas>();
        Query q = session.createQuery("from LcZonas E WHERE E.idZona = :idZona ");
        q.setParameter("idZona",IDZona);
        List<LcZonas> lista=q.list();
         for(LcZonas mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdZona()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        
      
         return lista;
    } 
}
