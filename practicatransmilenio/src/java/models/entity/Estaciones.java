package models.entity;
// Generated 02-abr-2019 12:32:39 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estaciones generated by hbm2java
 */
public class Estaciones  implements java.io.Serializable {


     private int idEstacion;
     private Troncales troncales;
     private String nombreEstacion;
     private String tipoEstacion;
     private String tipoCabecera;
     private Set<EstacionesRutas> estacionesRutases = new HashSet(0);

    public Estaciones() {
    }

	
    public Estaciones(int idEstacion, String nombreEstacion, String tipoEstacion) {
        this.idEstacion = idEstacion;
        this.nombreEstacion = nombreEstacion;
        this.tipoEstacion = tipoEstacion;
    }
    public Estaciones(int idEstacion, Troncales troncales, String nombreEstacion, String tipoEstacion, String tipoCabecera, Set estacionesRutases) {
       this.idEstacion = idEstacion;
       this.troncales = troncales;
       this.nombreEstacion = nombreEstacion;
       this.tipoEstacion = tipoEstacion;
       this.tipoCabecera = tipoCabecera;
       this.estacionesRutases = estacionesRutases;
    }
   
    public int getIdEstacion() {
        return this.idEstacion;
    }
    
    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
    }
    public Troncales getTroncales() {
        return this.troncales;
    }
    
    public void setTroncales(Troncales troncales) {
        this.troncales = troncales;
    }
    public String getNombreEstacion() {
        return this.nombreEstacion;
    }
    
    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }
    public String getTipoEstacion() {
        return this.tipoEstacion;
    }
    
    public void setTipoEstacion(String tipoEstacion) {
        this.tipoEstacion = tipoEstacion;
    }
    public String getTipoCabecera() {
        return this.tipoCabecera;
    }
    
    public void setTipoCabecera(String tipoCabecera) {
        this.tipoCabecera = tipoCabecera;
    }
    public Set<EstacionesRutas> getEstacionesRutases() {
        return this.estacionesRutases;
    }
    
    public void setEstacionesRutases(Set<EstacionesRutas> estacionesRutases) {
        this.estacionesRutases = estacionesRutases;
    }




}

