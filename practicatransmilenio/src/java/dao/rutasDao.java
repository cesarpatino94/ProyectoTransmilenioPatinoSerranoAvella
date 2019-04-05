/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.entity.Rutas;

/**
 *
 * @author cesar
 */
public interface rutasDao {
     public List<Rutas> mostrarRutas();
     public void nuevoRutas(Rutas rutas);
      public void modificarRutas(Rutas rutas);
       public int eliminarRutas(Rutas rutas);
       public List buscarRutas(Rutas rutas);
     public List buscarRutasmas(String rutas);
}
