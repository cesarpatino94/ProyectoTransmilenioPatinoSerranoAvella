/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.troncalesDao;
import dao.troncalesDaoImpl;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import models.entity.Troncales;

/**
 *
 * @author cesar
 */
@ManagedBean
@ViewScoped
public class troncalesBean {
private Troncales troncales;
private List<Troncales> listartroncales;
    /**
     * Creates a new instance of troncalesBean
     */
    public troncalesBean() {
        troncales=new Troncales();
    }
    public List<Troncales> getListartroncales() {
         troncalesDao tDao=new troncalesDaoImpl();
         listartroncales=tDao.mostrarTroncales();
       
        return listartroncales;
    }
         public void insertarTroncales(){
         troncalesDao tDao=new troncalesDaoImpl();
           if(tDao.buscarTroncales(troncales).size()==0){
         tDao.nuevoTroncales(troncales);
        
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se agrego correctamente"));
           }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No fue posible insertar troncal porque ya se ha registrado"));  
           }
          troncales=new Troncales();
     }
    
      public void modificarTroncales(){
         troncalesDao tDao=new troncalesDaoImpl();
         tDao.modificarTroncales(troncales);
        troncales=new Troncales();
     }
      public void removerTroncales(){
         troncalesDao tDao=new troncalesDaoImpl(); 
         if(tDao.eliminarTroncales(troncales)==1){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se elimino correctamente"));
         
         }else{
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No fue posible eliminar troncal"));     
         }
          troncales=new Troncales();
        
     }
      
      public void cancelarTroncales(){
         troncales=new Troncales();
     }

    public Troncales getTroncales() {
        return troncales;
    }

    public void setTroncales(Troncales troncales) {
        this.troncales = troncales;
    }
      
}
