package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Platillo;

public interface PlatilloService {
    public List<Platillo> listarPlatillos();
    
    public void guardar(Platillo platillo);
    
    public void eliminar(Platillo platillo);
    
    public Platillo encontrarPlatillo (Platillo platillo);
            
}
