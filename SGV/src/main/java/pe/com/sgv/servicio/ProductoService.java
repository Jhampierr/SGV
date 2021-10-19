package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Producto;

public interface ProductoService {
    public List<Producto> listarProducto();
    
    public void guardar(Producto producto);
    
    public void eliminar(Producto producto);
    
    public Producto encontrarProducto (Producto producto);
            
}
