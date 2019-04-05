/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.entity.Estaciones;
import models.entity.EstacionesRutas;
import models.entity.Rutas;

/**
 *
 * @author BELLARTES
 */
public interface estacionesRutasDao {
      public List<EstacionesRutas> mostrarEstacionesRutas();
     public void nuevoEstacionesRutas(EstacionesRutas estacionesrutas);
      public void modificarEstacionRutas(EstacionesRutas estacionesrutas);
       public int eliminarEstacionRutas(EstacionesRutas estacionesrutas);
       public List<Estaciones> ListarEstaciones();
       public List<Rutas> ListarRutas();
       public List buscarEstacionesRutas(EstacionesRutas estacionesrutas);
}
