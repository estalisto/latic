/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcEmpleados;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcRoles;
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
public class EmpleadosServicios {
    
    public ArrayList<LcEmpleados> getLCEmpleados(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpleados> arreglo = new ArrayList<LcEmpleados>();
        Query q = session.createQuery("from LcEmpleados E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
        Iterator<LcEmpleados> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcEmpleados rol= (LcEmpleados) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
    
    public List<LcEmpleados> getLcEmpleadoss(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpleados> arreglo = new ArrayList<LcEmpleados>();
        Query q = session.createQuery("from LcEmpleados E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo());
             
        }

         return lista;
    }
    
    public void addEmpleado(LcEmpleados empleado){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(empleado);
    tx.commit();
    session.close();
    } 
    public List<LcEmpleados> ValidaLCEmpleado(String ident){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpleados> arreglo = new ArrayList<LcEmpleados>();
        Query q = session.createQuery("from LcEmpleados E WHERE E.identificacion = :identificacion ");
        q.setParameter("identificacion",ident);
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
        }

         return lista;
    }
    
    public void updateEmpleados(int idEmpleado, int idEmpresa, String tipoIdentificacion, String identificacion, String nombres, String apellidos, String lugarNacimiento, Date fechaNacimiento, String email, String telefonos, String celular, String direccionDomicilio, String estadoCivil, String genero, String profesion, Integer idCargo, Integer idJefeInmediato, String observacion){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcEmpleados agen = (LcEmpleados)session.get(LcEmpleados.class, idEmpleado);
    agen.setLcEmpresa(new LcEmpresa(idEmpresa));
    agen.setTipoIdentificacion(tipoIdentificacion);
    agen.setIdentificacion(identificacion);
    agen.setNombres(nombres);
    agen.setApellidos(apellidos);
    agen.setLugarNacimiento(lugarNacimiento);
    agen.setFechaNacimiento(fechaNacimiento);
    agen.setEmail(email);
    agen.setTelefonos(telefonos);
    agen.setCelular(celular);
    agen.setDireccionDomicilio(direccionDomicilio);
    agen.setEstadoCivil(estadoCivil);
    agen.setGenero(genero);
    agen.setProfesion(profesion);
    //agen.setIdCargo(idCargo);
    agen.setIdJefeInmediato(idJefeInmediato);
    agen.setObservacion(observacion);
    session.update(agen);
    tx.commit();
    session.close();
    }
   
    public void deleteEmpleado(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcEmpleados agen = (LcEmpleados)session.get(LcEmpleados.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
    public List<LcEmpleados> getDatosLCEmpleadosID(int IDEmpleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpleados> arreglo = new ArrayList<LcEmpleados>();
        Query q = session.createQuery("from LcEmpleados E WHERE E.idEmpleado = :idEmpleado ");
        q.setParameter("idEmpleado",IDEmpleado);
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
        }

         return lista;
    }
    
}
