/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.rutasDao;
import dao.rutasDaoImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import models.entity.Rutas;

/**
 *
 * @author cesar
 */
@ManagedBean
@ViewScoped
public class rutasBean {
private Rutas rutas;
private int cantidaddatos;
private List<Rutas> listarrutas;
private String listaletratroncaltransmi[]={"A","B","C","D","E","F","G","H","I","J","K","L","M",""};
private String listarutaalimen="-";
private String listarutaurb[]={"RUTA","A","B"};
private String listtipobus[]={"T","A","U"};
private String nombrerutaurban[]={"Fontibon San Pablo - Porciuncula", "Brasilia - Germania", "Portal 20 de Julio - Altamira", "Betania - Chapinero Central", "Boitá - Bachué", "Jaqueline - Chapinero", "Colina - Pq. Central Bavaria", "Bachué - Ciudad Kenndedy ", "Metrovivienda - San Rafael Sur Or", "Galerías - Porvernir", "Bachué - Centro Internacional", "Villa Alexandra - Paloquemao", "Altos de Zuque - Paloquemao", "San Bernardino - Potreritos - Libertadores ", "Bosa San José - Egipto ", "El Recreo - San Diego ", "Centro - Villa Gladys", "San Bernardino / Potreritos - Chapinero Central", "Jacqueline - Bosque Popular","Germania-Bosa San Jose", "Metrovivienda Potreritos-Teusaquillo", "Mochuelo Bajo-Teusaquillo", "Terminal Norte-Engativa", "Sabana del Dorado-Usme Centro", "Sabana del Dorado-Providencia", "La Rivera-Usme Pueblo", "Terminal Norte-La Rivera", "Teusaquillo - Usme Centro", "Bachué - Ricaurte", "Compartir - Puente Grande", "Bosa San José - Bachue", "El Tuno - Terminal", "Tierra Buena-Fiscala Alta", "Roma - Germania", "Providencia - El Palmar"};
private int rangoaliment[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350};
private ArrayList<Rutas> listacargamasivarutas;
/**
     * Creates a new instance of rutasBean
     */
    public rutasBean() {
        rutas=new Rutas();
        listacargamasivarutas=new ArrayList<Rutas>();
    }

    public List<Rutas> getListarrutas() {
        rutasDao rDao=new rutasDaoImpl();
         listarrutas=rDao.mostrarRutas();
        return listarrutas;
    }
 public void insertarRutas(){
         rutasDao rDao=new rutasDaoImpl();
           if(rDao.buscarRutas(rutas).size()==0){
         rDao.nuevoRutas(rutas);
        
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se agrego correctamente"));
           }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No fue posible insertar troncal porque ya se ha registrado"));  
           }
          rutas=new Rutas();
     }
    
      public void modificarRutas(){
       rutasDao rDao=new rutasDaoImpl();
         rDao.modificarRutas(rutas);
        rutas=new Rutas();
     }
      public void removerRutas(){
       rutasDao rDao=new rutasDaoImpl();
         if(rDao.eliminarRutas(rutas)==1){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","se elimino correctamente"));
         
         }else{
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No fue posible eliminar troncal"));     
         }
      rutas=new Rutas();
        
     }
      public void cargamasivadatosRutas(){
        Random rand = new Random();
         rutasDao rmDao=new rutasDaoImpl();
      int contador=1;
               while(contador<cantidaddatos) {
      int numero = (int) (Math.random() * cantidaddatos) + 1;
           int posicionexttipobus = rand.nextInt(listtipobus.length);
       String tipobus=listtipobus[posicionexttipobus];
       
       if(tipobus.equals("T")){
            int posicionexrutatransmi = rand.nextInt(listaletratroncaltransmi.length);
             String idruta = listaletratroncaltransmi[posicionexrutatransmi]+""+cantidaddatos;
             if(rmDao.buscarRutasmas(idruta).size()==0){
             listacargamasivarutas.add(new Rutas(idruta,null, tipobus));
             contador++;
             }
             }else if(tipobus.equals("A")){
           int posicionexrangoalim = rand.nextInt(rangoaliment.length);
           int primervalorrango=rangoaliment[posicionexrangoalim]+numero;
           int segundovalorrango=rangoaliment[posicionexrangoalim]+numero;
                String numeroruta=primervalorrango+""+listarutaalimen+""+segundovalorrango;
                if(rmDao.buscarRutasmas(numeroruta).size()==0){
                            listacargamasivarutas.add(new Rutas(numeroruta,null, tipobus));
                 contador++;   
                }
                
       }else if(tipobus.equals("U")){
                int posicionexrutaurban = rand.nextInt(listarutaurb.length);
                String numrutaurb=listarutaurb[posicionexrutaurban];
                if(numrutaurb.equals("RUTA")){
           int posicionexnomrutar = rand.nextInt(nombrerutaurban.length);
           String nombrerutar=nombrerutaurban[posicionexnomrutar]+""+numero;
           String numerorutaurr=numrutaurb+""+numero;
            if(rmDao.buscarRutasmas(numerorutaurr).size()==0){
                listacargamasivarutas.add(new Rutas(numerorutaurr,nombrerutar, tipobus));
               contador++;
           }
       }else if(numrutaurb.equals("A")){
           int posicionexnomrutaa = rand.nextInt(nombrerutaurban.length);
           String numerorutaura=numero+""+numrutaurb;
            String nombrerutaa=nombrerutaurban[posicionexnomrutaa]+""+numero;
            if(rmDao.buscarRutasmas(numerorutaura).size()==0){
                listacargamasivarutas.add(new Rutas(numerorutaura,nombrerutaa, tipobus));
               contador++;
           }
       }else if(numrutaurb.equals("B")){
           int posicionexnomrutb = rand.nextInt(nombrerutaurban.length);
           String numerorutaurb=numero+""+numrutaurb;
            String nombrerutab=nombrerutaurban[posicionexnomrutb]+""+numero;
           if(rmDao.buscarRutasmas(numerorutaurb).size()==0){
               listacargamasivarutas.add(new Rutas(numerorutaurb,nombrerutab, tipobus));
               contador++;
           }
       }
                
       }
      
       
                 
      }
               if(contador==cantidaddatos){
                   insertarcargamasiva(listacargamasivarutas);
               }
      }
       public void insertarcargamasiva(ArrayList<Rutas> listarrutasmas){
           rutasDao rmDao=new rutasDaoImpl();
          
           for(Rutas r:listarrutasmas){
               rmDao.nuevoRutas(r);
           }
           listacargamasivarutas.clear();
           listacargamasivarutas=new ArrayList<>();
           cantidaddatos=0;
       }       
      public void cancelarRutas(){
         rutas=new Rutas();
     }
      public void cancelarGenerarDatosRutas(){
         cantidaddatos=0;
     }
    public Rutas getRutas() {
        return rutas;
    }

    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }

    public int getCantidaddatos() {
        return cantidaddatos;
    }

    public void setCantidaddatos(int cantidaddatos) {
        this.cantidaddatos = cantidaddatos;
    }
    
}
