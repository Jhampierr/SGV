
package pe.com.sgv.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.sgv.model.Pedido;

@Repository
public interface PedidoDao extends CrudRepository<Pedido, Long>{

    
}
