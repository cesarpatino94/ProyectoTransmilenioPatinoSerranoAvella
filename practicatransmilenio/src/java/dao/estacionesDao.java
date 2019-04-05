/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.entity.Estaciones;
import models.entity.Troncales;

/**
 *
 * @author cesar
 */
public interface estacionesDao {
         public List<Estaciones> mostrarEstaciones();
     public void nuevoEstaciones(Estaciones estaciones);
      public void modificarEstaciones(Estaciones estaciones);
       public int eliminarEstaciones(Estaciones estaciones);
       public List buscarEstaciones(Estaciones estaciones);
        public List<Troncales> ListarTroncales();
}
