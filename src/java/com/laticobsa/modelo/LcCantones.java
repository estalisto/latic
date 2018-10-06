package com.laticobsa.modelo;
// Generated 14-ene-2018 19:02:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * LcCantones generated by hbm2java
 */
public class LcCantones  implements java.io.Serializable {


     private int idCanton;
     private Integer idProvincia;
     private String canton;
     private String estado;
     private Set lcParroquiases = new HashSet(0);

    public LcCantones() {
    }

	
    public LcCantones(int idCanton) {
        this.idCanton = idCanton;
    }
    public LcCantones(int idCanton, Integer idProvincia, String canton, String estado, Set lcParroquiases) {
       this.idCanton = idCanton;
       this.idProvincia = idProvincia;
       this.canton = canton;
       this.estado = estado;
       this.lcParroquiases = lcParroquiases;
    }
   
    public int getIdCanton() {
        return this.idCanton;
    }
    
    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }
    public Integer getIdProvincia() {
        return this.idProvincia;
    }
    
    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }
    public String getCanton() {
        return this.canton;
    }
    
    public void setCanton(String canton) {
        this.canton = canton;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getLcParroquiases() {
        return this.lcParroquiases;
    }
    
    public void setLcParroquiases(Set lcParroquiases) {
        this.lcParroquiases = lcParroquiases;
    }




}

