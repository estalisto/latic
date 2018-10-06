/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author ViewSoft
 */
public class Conexion {
    
    public static void main(String[] args){
        
        String cadena = "jdbc:postgresql://localhost:5432/bdjsp";
        String user = "postgres";
        String pass = "databasejim5";
        try{
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, user, pass);
            java.sql.Statement st = conex.createStatement();
             
            String sql="select * from lc_modulo_rol A, lc_roles B, lc_empresa C where A.id_rol = B.id_rol and A.id_empresa=C.id_empresa and A.estado ='A'";
            ResultSet result = st.executeQuery(sql);
//            while(result.next()){
//                String rol = result.getString("rol");
//                String empresa = result.getString("empresa");
//                
//            }
//            result.close();
            st.close();
            conex.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
}
