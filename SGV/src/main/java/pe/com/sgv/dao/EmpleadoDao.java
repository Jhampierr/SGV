
package pe.com.sgv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.sgv.model.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado, Long>{
         //Empleado findByUsername(String username);
    
}
