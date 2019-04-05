/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.estacionesDao;
import dao.estacionesDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import models.entity.Estaciones;
import models.entity.Troncales;

/**
 *
 * @author cesar
 */
@ManagedBean
@ViewScoped
public class estacionesBean {
private Estaciones estaciones;
private List<Estaciones> listarestaciones;
private List<SelectItem> listartroncales;
private List<String> resultnombrestacion;
    /**
     * Creates a new instance of estacionesBean
     */
    public estacionesBean() {
        estaciones=new Estaciones();
    }

    public List<Estaciones> getListarestaciones() {
         estacionesDao eDao=new estacionesDaoImpl();
         listarestaciones=eDao.mostrarEstaciones();
       
        return listarestaciones;
    }
      public List<SelectItem> getListarTroncales() {
        this.listartroncales=new ArrayList<SelectItem>();
        estacionesDao eDao=new estacionesDaoImpl();
        List<Troncales> tr=eDao.ListarTroncales();
    
        for(Troncales tronc:tr){
            SelectItem troncalesitem=new SelectItem(tronc.getIdTroncal(),tronc.getNombreTroncal());
        this.listartroncales.add(troncalesitem);
        }
        return listartroncales;
    }
    public void insertarEstaciones(){
  this.resultnombrestacion=new ArrayList<String>();
        estacionesDao eDao=new estacionesDaoImpl();
    resultnombrestacion= eDao.buscarEstaciones(estaciones); 
       if(resultnombrestacion.size()==0){
           
           eDao.nuevoEstaciones(estaciones);
            
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se agrego correctamente"));
       }else{
         
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No fue posible insertar estacion porque ya se ha registrado"));  
       }   
       
          estaciones=new Estaciones();
     }
    
      public void modificarEstaciones(){
        estacionesDao eDao=new estacionesDaoImpl();
         eDao.modificarEstaciones(estaciones);
       estaciones=new Estaciones();
     }
      public void removerEstaciones(){
     estacionesDao eDao=new estacionesDaoImpl();
         if(eDao.eliminarEstaciones(estaciones)==1){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se elimino correctamente"));
         
         }else{
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No fue posible eliminar estacion"));     
         }
           estaciones=new Estaciones();
        
     }
      
      public void cancelarEstaciones(){
         estaciones=new Estaciones();
     }

    public Estaciones getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(Estaciones estaciones) {
        this.estaciones = estaciones;
    }

    
    
}
