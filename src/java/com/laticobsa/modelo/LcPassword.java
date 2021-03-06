package com.laticobsa.modelo;
// Generated 31/03/2017 06:57:24 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * LcPassword generated by hbm2java
 */
public class LcPassword  implements java.io.Serializable {


     private int idPassword;
     private Integer idEmpresa;
     private Integer idPersona;
     private String password;
     private Date fechaRegistro;
     private Date fechaActualizacion;
     private String estado;

    public LcPassword() {
    }

	
    public LcPassword(int idPassword, String password) {
        this.idPassword = idPassword;
        this.password = password;
    }
    public LcPassword(int idPassword, Integer idEmpresa, Integer idPersona, String password, Date fechaRegistro, Date fechaActualizacion, String estado) {
       this.idPassword = idPassword;
       this.idEmpresa = idEmpresa;
       this.idPersona = idPersona;
       this.password = password;
       this.fechaRegistro = fechaRegistro;
       this.fechaActualizacion = fechaActualizacion;
       this.estado = estado;
    }
   
    public int getIdPassword() {
        return this.idPassword;
    }
    
    public void setIdPassword(int idPassword) {
        this.idPassword = idPassword;
    }
    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Integer getIdPersona() {
        return this.idPersona;
    }
    
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


