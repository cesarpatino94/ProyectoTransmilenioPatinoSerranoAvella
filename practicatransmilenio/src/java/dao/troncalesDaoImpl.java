/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.entity.EstacionesRutas;
import models.entity.Troncales;
import models.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cesar
 */
public class troncalesDaoImpl implements troncalesDao{

    @Override
    public List<Troncales> mostrarTroncales() {
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

    @Override
    public void nuevoTroncales(Troncales troncales) {
        Session session=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(troncales);
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
    public void modificarTroncales(Troncales troncales) {
         Session session=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(troncales);
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
    public int eliminarTroncales(Troncales troncales) {
          Session session=null;
       int result=0;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("delete from Troncales where idTroncal=:id");
        
        session.beginTransaction();
        //session.delete(operadores);
        query.setString("id",troncales.getIdTroncal());
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
    public List buscarTroncales(Troncales troncales) {
        Session session=null;
     List result=null; 
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        String hql=("from Troncales t where t.idTroncal=:idtroncal");
        
        session.beginTransaction();
        //session.delete(operadores);
     result=(List) session.createQuery(hql)
       .setParameter("idtroncal", troncales.getIdTroncal())
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
    
}
