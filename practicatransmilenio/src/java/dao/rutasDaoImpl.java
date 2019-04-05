/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.entity.Rutas;
import models.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cesar
 */
public class rutasDaoImpl implements rutasDao{

    @Override
    public List<Rutas> mostrarRutas() {
        List<Rutas> listarrutas=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        String hql="from Rutas r";
        try{
            listarrutas=session.createQuery(hql).list();
            
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
            return listarrutas;
    }

    @Override
    public void nuevoRutas(Rutas rutas) {
        Session session=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rutas);
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
    public void modificarRutas(Rutas rutas) {
     Session session=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(rutas);
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
    public int eliminarRutas(Rutas rutas) {
Session session=null;
       int result=0;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("delete from Rutas where idRuta=:id");
        
        session.beginTransaction();
        //session.delete(operadores);
        query.setString("id",rutas.getIdRuta());
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
    public List buscarRutas(Rutas rutas) {
Session session=null;
     List result=null; 
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        String hql=("from Rutas r where r.idRuta=:idruta");
        
        session.beginTransaction();
        //session.delete(operadores);
     result=(List) session.createQuery(hql)
       .setParameter("idruta", rutas.getIdRuta())
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
    public List buscarRutasmas(String rutas) {
        Session session=null;
     List result=null; 
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        String hql=("from Rutas r where r.idRuta=:idruta");
        
        session.beginTransaction();
        //session.delete(operadores);
     result=(List) session.createQuery(hql)
       .setParameter("idruta", rutas)
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
