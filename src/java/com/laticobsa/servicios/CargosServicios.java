/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcCargos;
import com.laticobsa.modelo.LcEmpresa;
import java.util.ArrayList;
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
public class CargosServicios {
    public ArrayList<LcCargos> getLcCargos(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcCargos> arreglo = new ArrayList<LcCargos>();
        Query q = session.createQuery("from LcCargos E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcCargos> lista=q.list();
        Iterator<LcCargos> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcCargos rol= (LcCargos) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
    
    public List<LcCargos> getLcCargoss(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcCargos> arreglo = new ArrayList<LcCargos>();
        Query q = session.createQuery("from LcCargos E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
         List<LcCargos> lista=q.list();
         for(LcCargos mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdCargo()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        
      
         return lista;
    }
    
    public void addCargos(LcCargos cargos){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(cargos);
    tx.commit();
    session.close();
    }
        
    public void updateCargo(int idCargo, int idEmpresa, String cargo, String observacion){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcCargos agen = (LcCargos)session.get(LcCargos.class, idCargo);
    agen.setLcEmpresa(new LcEmpresa(idEmpresa));
    agen.setCargo(cargo);
    agen.setObservacion(observacion);
    session.update(agen);
    tx.commit();
    session.close();
    }
   
    public void deleteCargos(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcCargos agen = (LcCargos)session.get(LcCargos.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
    public List<LcCargos> getDatosLCargosID(int IDCargo){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcCargos> arreglo = new ArrayList<LcCargos>();
        Query q = session.createQuery("from LcCargos E WHERE E.idCargo = :idCargo ");
        q.setParameter("idCargo",IDCargo);
        List<LcCargos> lista=q.list();
         for(LcCargos mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdCargo()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        
      
         return lista;
    }    
}
