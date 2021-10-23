
package pe.com.sgv.dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.sgv.model.Empleado;

public interface EmpleadoDao extends CrudRepository<Empleado, Long>{
         //Empleado findByUsername(String username);
    
}
