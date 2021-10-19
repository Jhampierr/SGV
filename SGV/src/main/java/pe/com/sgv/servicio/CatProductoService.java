package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.CatProducto;

public interface CatProductoService {
    public List<CatProducto> listarCatProducto();
    
    public void guardar(CatProducto catProducto);
    
    public void eliminar(CatProducto catProducto);
    
    public CatProducto encontrarCatProducto (CatProducto catProducto);
            
}
