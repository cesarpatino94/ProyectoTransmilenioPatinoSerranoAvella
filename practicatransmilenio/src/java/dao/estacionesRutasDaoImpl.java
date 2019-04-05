/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.print.Book;
import java.util.List;
import models.entity.Estaciones;
import models.entity.EstacionesRutas;
import models.entity.EstacionesRutasId;
import models.entity.Rutas;
import models.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author BELLARTES
 */
public class estacionesRutasDaoImpl implements estacionesRutasDao{

    @Override
    public List<EstacionesRutas> mostrarEstacionesRutas() {
        List<EstacionesRutas> listaroestacionesrutas=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        String hql="from EstacionesRutas et left  join fetch et.estaciones e left join fetch et.rutas r";
        try{
            listaroestacionesrutas=session.createQuery(hql).list();
            
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
            return listaroestacionesrutas;
    }

    @Override
    public void nuevoEstacionesRutas(EstacionesRutas estacionesrutas) {
       Session session=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Rutas r=(Rutas) session.get(Rutas.class, estacionesrutas.getRutas().getIdRuta());
        Estaciones e=(Estaciones) session.get(Estaciones.class, estacionesrutas.getEstaciones().getNombreEstacion());
        EstacionesRutasId eid=new EstacionesRutasId(r.getIdRuta(), e.getNombreEstacion());
        EstacionesRutas er=new EstacionesRutas(eid, e, r, estacionesrutas.getOrdenRuta());
        session.save(er);
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
    public void modificarEstacionRutas(EstacionesRutas estacionesrutas) {
     Session session=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Rutas r=(Rutas) session.get(Rutas.class, estacionesrutas.getRutas().getIdRuta());
        Estaciones e=(Estaciones) session.get(Estaciones.class, estacionesrutas.getEstaciones().getNombreEstacion());
        EstacionesRutasId eid=new EstacionesRutasId(r.getIdRuta(), e.getNombreEstacion());
        EstacionesRutas er=new EstacionesRutas(eid, e, r, estacionesrutas.getOrdenRuta());
        session.update(er);
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
    public int eliminarEstacionRutas(EstacionesRutas estacionesrutas) {
        Session session=null;
       int result=0;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("delete from EstacionesRutas et where et.id.nombreEstacion=:nombreestacion and et.id.idRuta=:idruta");
        
        session.beginTransaction();
        //session.delete(operadores);
        
       
       query.setString("idruta",estacionesrutas.getRutas().getIdRuta());
       query.setString("nombreestacion",estacionesrutas.getEstaciones().getNombreEstacion());
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
    public List<Estaciones> ListarEstaciones() {
         List<Estaciones> listarestaciones=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        String hql="from Estaciones e";
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
    public List<Rutas> ListarRutas() {
        List<Rutas> listarrutas=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        String hql="from Rutas";
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
    public List buscarEstacionesRutas(EstacionesRutas estacionesrutas) {
        Session session=null;
     List result=null; 
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        String hql=("select er.id from EstacionesRutas er where er.id.nombreEstacion=:nombreestacion and er.id.idRuta=:idruta");
        
        session.beginTransaction();
        //session.delete(operadores);
     result=(List) session.createQuery(hql)
       .setParameter("idruta",estacionesrutas.getRutas().getIdRuta())
       .setParameter("nombreestacion", estacionesrutas.getEstaciones().getNombreEstacion())
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
