/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.entity.Troncales;

/**
 *
 * @author cesar
 */
public interface troncalesDao {
     public List<Troncales> mostrarTroncales();
     public void nuevoTroncales(Troncales troncales);
      public void modificarTroncales(Troncales troncales);
       public int eliminarTroncales(Troncales troncales);
       public List buscarTroncales(Troncales troncales);
}
