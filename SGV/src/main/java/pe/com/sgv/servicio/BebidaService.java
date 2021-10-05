package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Bebida;

public interface BebidaService {
    public List<Bebida> listarBebidas();
    
    public void guardar(Bebida bebida);
    
    public void eliminar(Bebida bebida);
    
    public Bebida encontrarBebida (Bebida bebida);
            
}
