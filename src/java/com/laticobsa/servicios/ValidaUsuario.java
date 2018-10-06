/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcPassword;
import com.laticobsa.modelo.LcRoles;
import com.laticobsa.modelo.LcUsuarios;
import com.laticobsa.utils.EnviarEmail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author CIMA2015
 */
public class ValidaUsuario {
    
    ArrayList<LcUsuarios> usuarioOK;
    ArrayList<LcPassword> passwordOk;
    ArrayList<LcRoles> rolesOk;
    ArrayList<LcEmpresa>empresaOk;
    public ArrayList<LcUsuarios> getLcValidaUser(String user ,String pass){
         
        
         //String encript2=DigestUtils.sha1Hex(pass);
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcUsuarios> arreglo = new ArrayList<LcUsuarios>();
        Query q = session.createQuery("from LcUsuarios E WHERE E.usuario= :usuario and E.contrasenia= :contrasenia and E.estado = :estado ");
        q.setParameter("usuario",user);
        q.setParameter("contrasenia",pass);
        //q.setParameter("idEmpresa",strempresa);
        //q.setParameter("idRol",strUsuarioRol);
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
    
    public ArrayList<LcPassword> getLcValidaPass(String pass, int persona){
         
        //String sql;
      //  sql="from LcPassword E WHERE E.password= "+pass+" AND e.idPersona= "+persona+" and  E.estado = :estado ";
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcPassword> arreglo = new ArrayList<LcPassword>();
        Query q = session.createQuery("from LcPassword E WHERE E.password= :id_pass AND E.idPersona= :persona and  E.estado = :estado ");
        q.setParameter("id_pass",pass);
        q.setParameter("persona",persona);
        q.setParameter("estado","A");
        List<LcPassword> lista=q.list();
        Iterator<LcPassword> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcPassword rol= (LcPassword) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }
    
    public ArrayList<LcRoles> getValidaRol(int strUsuarioRol){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcRoles> arreglo = new ArrayList<LcRoles>();
        Query q = session.createQuery("from LcRoles E WHERE E.idRol= :idRol ");
        q.setParameter("idRol",strUsuarioRol);
        //q.setParameter("descripcion",user);
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
        
    public ArrayList<LcEmpresa> getValidaEmpresa(int strempresa){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpresa> arreglo = new ArrayList<LcEmpresa>();
        Query q = session.createQuery("from LcEmpresa E WHERE E.idEmpresa= :idEmpresa ");
        q.setParameter("idEmpresa",strempresa);
        //q.setParameter("descripcion",user);
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
      
    public boolean getValidaUsuario(String user, String pass){
        String mensagemUsuario=null;
         String encript=DigestUtils.sha1Hex(pass);
         
         usuarioOK=getLcValidaUser(user,encript);
           //  String encript=DigestUtils.sha1Hex(user);
        System.out.println("shaHex:"+DigestUtils.sha1Hex(pass));
       // System.out.println("shaHex:"+DigestUtils.sha1Hex(pass));
          /*EnviarEmail enviar = new EnviarEmail();
          System.out.println("shaHex:"+DigestUtils.sha1Hex(pass));
              boolean enviou = enviar.enviarHotmail();
            if (enviou) {
            
            mensagemUsuario = "Dados enviados com sucesso";
            System.out.println("EMAIL"+mensagemUsuario);
           
            } else {
            mensagemUsuario = "Não foi enviar as informações";
            System.out.println("EMAIL"+mensagemUsuario);
            
         }*/
         if (!usuarioOK.isEmpty() && usuarioOK.size()<= 1 ){// && !passwordOk.isEmpty()){
//            LcUsuarios person;
//            person=usuarioOK.get(0);
//            LcUsuarios roll = null, empresa = null;
//            roll= usuarioOK.get(0);
//            strUsuarioRol = roll.getIdRol();
//            empresa = usuarioOK.get(0);
//            strempresa = empresa.getIdEmpresa();
//            //consultamos el rol del usuario
//            empresaOk = getValidaEmpresa(strempresa);
//            rolesOk = getValidaRol(strUsuarioRol);
            //consultamos la empresa del usuario
            
             // consultamos el password encriptado del usuario
             //passwordOk=getLcValidaPass(DigestUtils.sha1Hex(pass),person.getIdUsuario()); 
             return !usuarioOK.isEmpty();         
             
         }else{
         return false;    
         }
       
        }
    
    public ArrayList<LcUsuarios> getLcValidacion(String user ,String pass,int strempresa, int strUsuarioRol){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcUsuarios> arreglo = new ArrayList<LcUsuarios>();
        Query q = session.createQuery("from LcUsuarios E WHERE E.usuario= :usuario and E.contrasenia= :contrasenia "
                + "and E.idEmpresa= :idEmpresa and E.idRol= :idRol and E.estado = :estado ");
        q.setParameter("usuario",user);
        q.setParameter("contrasenia",pass);
        q.setParameter("idEmpresa",strempresa);
        q.setParameter("idRol",strUsuarioRol);
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
}
