/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.estacionesRutasDao;
import dao.estacionesRutasDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import models.entity.Estaciones;
import models.entity.EstacionesRutas;
import models.entity.Rutas;


/**
 *
 * @author BELLARTES
 */
@ManagedBean
@ViewScoped
public class estacionesRutasBean {
private List<EstacionesRutas> listarestacionesrutas;
private List<SelectItem> listarestaciones;
private List<SelectItem> listarrutas;
 private EstacionesRutas estacionesrutas;
    /**
     * Creates a new instance of estacionesRutasBean
     */
    public estacionesRutasBean() {
        estacionesrutas=new EstacionesRutas();
    }
        public List<EstacionesRutas> getListarestacionesrutas() {
        estacionesRutasDao etDao=new estacionesRutasDaoImpl();
        listarestacionesrutas=etDao.mostrarEstacionesRutas();
        return listarestacionesrutas;
    }

    public List<SelectItem> getListarestaciones() {
        this.listarestaciones=new ArrayList<SelectItem>();
        estacionesRutasDao etDao=new estacionesRutasDaoImpl();
        List<Estaciones> e=etDao.ListarEstaciones();
    
        for(Estaciones esta:e){
            SelectItem estacionitem=new SelectItem(esta.getIdEstacion(),esta.getNombreEstacion());
        this.listarestaciones.add(estacionitem);
        }
        return listarestaciones;
    }

    public List<SelectItem> getListarrutas() {
        this.listarrutas=new ArrayList<SelectItem>();
        estacionesRutasDao etDao=new estacionesRutasDaoImpl(); 
        List<Rutas> r=etDao.ListarRutas();
      
        for(Rutas rutas:r){
            SelectItem rutaitem=new SelectItem(rutas.getIdRuta());
        this.listarrutas.add(rutaitem);
        }
        return listarrutas;  
    }
        
     public void insertarEstacionesRutas(){
         estacionesRutasDao etDao=new estacionesRutasDaoImpl();
         
        if(etDao.buscarEstacionesRutas(estacionesrutas).size()==0){
            
         etDao.nuevoEstacionesRutas(estacionesrutas);
         
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se agrego correctamente"));
        }else{
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No fue posible eliminar porque ya se ha registrado"));   
        }
    }
    
    
      public void modificarEstacionesRutas(){
        estacionesRutasDao etDao=new estacionesRutasDaoImpl();
         etDao.modificarEstacionRutas(estacionesrutas);
         estacionesrutas=new EstacionesRutas();
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se modifico correctamente"));
     }
      
      public void removerEstacionesRutas(){
        estacionesRutasDao etDao=new estacionesRutasDaoImpl(); 
         if(etDao.eliminarEstacionRutas(estacionesrutas)==1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se elimino correctamente"));
         }else{
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo eliminar"));
         }
        estacionesrutas=new EstacionesRutas();
     }
      public void cancelarEstacionesRutas(){
      estacionesrutas=new EstacionesRutas();
     }



    public EstacionesRutas getEstacionesrutas() {
        return estacionesrutas;
    }

    public void setEstacionesrutas(EstacionesRutas estacionesrutas) {
        this.estacionesrutas = estacionesrutas;
    }

      
}
