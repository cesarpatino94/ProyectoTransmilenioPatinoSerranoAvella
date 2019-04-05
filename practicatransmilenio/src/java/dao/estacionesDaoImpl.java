/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.entity.Estaciones;
import models.entity.Troncales;
import models.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cesar
 */
public class estacionesDaoImpl implements estacionesDao{

    @Override
    public List<Estaciones> mostrarEstaciones() {
       List<Estaciones> listarestaciones=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        String hql="from Estaciones e left join fetch e.troncales t";
        try{
            listarestaciones=session.createQuery(hql).list();
            
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
            return listarestaciones;
    }

    @Override
    public void nuevoEstaciones(Estaciones estaciones) {
 Session session=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(estaciones);
        session.getTransaction().commit();
    }catch(Exception e){
                 System.out.println(e.getMessage());
            session.getTransaction().rollback();
    }finally{
        if(session!=null){
            session.close();
        }
    }
    }

    @Override
    public void modificarEstaciones(Estaciones estaciones) {
          Session session=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(estaciones);
        session.getTransaction().commit();
    }catch(Exception e){
                 System.out.println(e.getMessage());
            session.getTransaction().rollback();
    }finally{
        if(session!=null){
            session.close();
        }
    }
    }

    @Override
    public int eliminarEstaciones(Estaciones estaciones) {
Session session=null;
       int result=0;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("delete from Estaciones where nombreEstacion=:id");
        
        session.beginTransaction();
        //session.delete(operadores);
        query.setString("id",estaciones.getNombreEstacion());
       result = query.executeUpdate();
        session.getTransaction().commit();
        
    }catch(Exception e){
                 System.out.println(e.getMessage());
            session.getTransaction().rollback();
    }finally{
        if(session!=null){
            session.close();
        }
    }
    return result;
    }

    @Override
    public List buscarEstaciones(Estaciones estaciones) {
       Session session=null;
     List<String> result=null; 
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        String hql=("from Estaciones e where e.nombreEstacion=:nombreestacion");
        
        session.beginTransaction();
        //session.delete(operadores);
     result=(List) session.createQuery(hql)
       .setParameter("nombreestacion", estaciones.getNombreEstacion())
        .list();
        
        session.getTransaction().commit();
        
    }catch(Exception e){
                 System.out.println(e.getMessage());
            session.getTransaction().rollback();
    }finally{
        if(session!=null){
            session.close();
        }
    }
    return result;
    }

    @Override
    public List<Troncales> ListarTroncales() {
         List<Troncales> listartroncales=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        String hql="from Troncales t";
        try{
            listartroncales=session.createQuery(hql).list();
            
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
            return listartroncales;
    }
    
    
}
