/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
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
public class EmpresaServicios {
    
     public ArrayList<LcEmpresa> getLcEmpresa(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpresa> arreglo = new ArrayList<LcEmpresa>();
        Query q = session.createQuery("from LcEmpresa  ");
        //q.setParameter("estado","A");
        List<LcEmpresa> lista=q.list();
        Iterator<LcEmpresa> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcEmpresa rol= (LcEmpresa) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
     
    public void addEmpresa(LcEmpresa empresa){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(empresa);
    tx.commit();
    session.close();
    }
    
    public void updateEmpresa(int idEmpresa, String idPais, String idCiudad, Integer idProvincia, String tipoIdentificacion, String identificacion, String razonSocial, String direccion, String telefonos, String email, String telfonos2,String celular){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcEmpresa agen = (LcEmpresa)session.get(LcEmpresa.class, idEmpresa);
    agen.setIdPais(idPais);
    agen.setIdCiudad(idCiudad);
    agen.setIdProvincia(idProvincia);
    agen.setTipoIdentificacion(tipoIdentificacion);
    agen.setIdentificacion(identificacion);
    agen.setRazonSocial(razonSocial);
    agen.setDireccion(direccion);
    agen.setTelefonos(telefonos);
    agen.setEmail(email);
    agen.setTelfonos2(telfonos2);
    agen.setCelular(celular);
    session.update(agen);
    tx.commit();
    session.close();
    }
   
    public void deleteEmpresa(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcEmpresa agen = (LcEmpresa)session.get(LcEmpresa.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
    public ArrayList<LcEmpresa> getDatosLCZonasID(int IDEmpresa){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpresa> arreglo = new ArrayList<LcEmpresa>();
        Query q = session.createQuery("from LcEmpresa E WHERE E.idEmpresa = :idEmpresa ");
        q.setParameter("idEmpresa",IDEmpresa);
        List<LcEmpresa> lista=q.list();
        Iterator<LcEmpresa> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcEmpresa rol= (LcEmpresa) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    } 
    
}
