/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcRoles;
import com.laticobsa.modelo.LcUsuarios;
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
public class UsuariosServicios {
    
     public ArrayList<LcUsuarios> getLcUsuarios(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcUsuarios> arreglo = new ArrayList<LcUsuarios>();
        Query q = session.createQuery("from LcUsuarios E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcUsuarios> lista=q.list();
        Iterator<LcUsuarios> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcUsuarios rol= (LcUsuarios) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
     
        public List<LcUsuarios> getLcUsuarioss(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcUsuarios> arreglo = new ArrayList<LcUsuarios>();
        Query q = session.createQuery("from LcUsuarios E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcUsuarios> lista=q.list();
         for(LcUsuarios mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdUsuario()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdUsuario()+", "+mrol.getLcRoles().getDescripcion());
        }

         return lista;
    }
     
      public ArrayList<LcUsuarios> getLcAutorizaUser(String user, String pass){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcUsuarios> arreglo = new ArrayList<LcUsuarios>();
        Query q = session.createQuery("from LcUsuarios E WHERE E.usuario= :id_user and  E.estado = :estado ");
        q.setParameter("id_user",user);
       // q.setParameter("estado",pass);
        q.setParameter("estado","A");
        List<LcUsuarios> lista=q.list();
        Iterator<LcUsuarios> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcUsuarios rol= (LcUsuarios) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
   public void addUsuario(LcUsuarios usuarios){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(usuarios);
    tx.commit();
    session.close();
    } 
    
    public void updateUsuario(int idUsuario, int idEmpresa, int idEmpleado, int idRol, String usuario, String contrasenia, String observacion){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcUsuarios agen = (LcUsuarios)session.get(LcUsuarios.class, idUsuario);
    //.setLcEmpresa(lcEmpresa.idEmpresa);//setIdEmpresa(idEmpresa);
    agen.setLcEmpresa(new LcEmpresa(idEmpresa));
    agen.setIdEmpleado(idEmpleado);
    agen.setLcRoles(new LcRoles (idRol));//setIdRol(idRol);
    agen.setUsuario(usuario);
    agen.setContrasenia(contrasenia);
    agen.setObservacion(observacion);
    session.update(agen);
    tx.commit();
    session.close();
    }
   
    public void deleteUsuario(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcUsuarios agen = (LcUsuarios)session.get(LcUsuarios.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
    public List<LcUsuarios> getDatosLCUsuariosID(int IDUsuario){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcUsuarios> arreglo = new ArrayList<LcUsuarios>();
        Query q = session.createQuery("from LcUsuarios E WHERE E.idUsuario = :idUsuario ");
        q.setParameter("idUsuario",IDUsuario);
        List<LcUsuarios> lista=q.list();
         for(LcUsuarios mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdUsuario()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdUsuario()+", "+mrol.getLcRoles().getDescripcion());
        }

         return lista;
    }
    
    public void Cambio_clave(int idUsuario, String contrasenia){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcUsuarios agen = (LcUsuarios)session.get(LcUsuarios.class, idUsuario);
    agen.setContrasenia(contrasenia);
    session.update(agen);
    tx.commit();
    session.close();
    }
}
