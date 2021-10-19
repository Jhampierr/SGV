package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Cliente;

public interface ClienteService {
    public List<Cliente> listarCliente();
    
    public void guardar(Cliente cliente);
    
    public void eliminar(Cliente cliente);
    
    public Cliente encontrarCliente (Cliente cliente);
            
}
