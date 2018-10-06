/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcClientes;
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
 * @author ViewSoft
 */
public class ClientesServicios {
    public ArrayList<LcClientes> getLcClientes(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcClientes> arreglo = new ArrayList<LcClientes>();
        Query q = session.createQuery("from LcClientes E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcClientes> lista=q.list();
        Iterator<LcClientes> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcClientes rol= (LcClientes) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
         public List<LcClientes> getLcClientess(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcClientes> arreglo = new ArrayList<LcClientes>();
        Query q = session.createQuery("from LcClientes E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcClientes> lista=q.list();
         for(LcClientes mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdCliente()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        
      
         return lista;
    }
    public void addclientes(LcClientes clientes){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(clientes);
    tx.commit();
    session.close();
    }
    
    public void updateClientes(int idCliente, int idEmpresa, String tipoIdentificacion, String identificacion, String razonSocial, String direccion, String pais, int provincia, String ciudad, String contacto, String email, String telefono, String extensioon, String celular){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcClientes agen = (LcClientes)session.get(LcClientes.class, idCliente);
    
    
    agen.setTipoIdentificacion(tipoIdentificacion);
    agen.setIdentificacion(identificacion);
    agen.setRazonSocial(razonSocial);
    agen.setDireccion(direccion);
    agen.setPais(pais);
    agen.setProvincia(provincia);
    agen.setCiudad(ciudad);
    agen.setContacto(contacto);
    agen.setEmail(email);
    agen.setTelefono(telefono);
    agen.setExtensioon(extensioon);
    agen.setCelular(celular);
    
    session.update(agen);
    tx.commit();
    session.close();
    }
   
    public void deleteClientes(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcClientes agen = (LcClientes)session.get(LcClientes.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
    public List<LcClientes> getDatosLClienteID(int IDCliente){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcClientes> arreglo = new ArrayList<LcClientes>();
        Query q = session.createQuery("from LcClientes E WHERE E.idCliente = :idCliente ");
        q.setParameter("idCliente",IDCliente);
        List<LcClientes> lista=q.list();
         for(LcClientes mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdCliente()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        
      
         return lista;
    }
}
