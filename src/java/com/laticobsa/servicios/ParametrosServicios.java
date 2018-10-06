/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcParametros;
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
public class ParametrosServicios {
    
    
    public ArrayList<LcParametros> getLcParametros(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcParametros> arreglo = new ArrayList<LcParametros>();
        Query q = session.createQuery("from LcParametros E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcParametros> lista=q.list();
        Iterator<LcParametros> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcParametros rol= (LcParametros) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    } 
   
   public boolean ValidaLCParametros(String parametro){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcParametros> arreglo = new ArrayList<LcParametros>();
        Query q = session.createQuery("from LcParametros E WHERE E.parametro = :parametro ");
        q.setParameter("parametro",parametro);
        
        boolean resp = false;
        List<LcParametros> lista=q.list();
        Iterator<LcParametros> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcParametros rol= (LcParametros) iter.next();
            arreglo.add(rol);
        }
        
        if(arreglo.size() > 0){
            resp = true;
        }
        
        return resp;
    }
   
    public void addLcParametros(LcParametros parametros){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(parametros);
    tx.commit();
    session.close();
    }
    public void updateParametros(int id, int codigo, String nombre, String valor){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcParametros agen = (LcParametros)session.get(LcParametros.class, id);
    agen.setIdParametro(codigo);
    agen.setParametro(nombre);
    agen.setValor(valor);
    session.update(agen);
    tx.commit();
    session.close();
    }
   
    public void deleteParametros(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcParametros agen = (LcParametros)session.get(LcParametros.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
   public ArrayList<LcParametros> getDatosLCParametrosID(int ID){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcParametros> arreglo = new ArrayList<LcParametros>();
        Query q = session.createQuery("from LcParametros E WHERE E.id = :id ");
        q.setParameter("id",ID);
        List<LcParametros> lista=q.list();
        Iterator<LcParametros> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcParametros rol= (LcParametros) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
}
