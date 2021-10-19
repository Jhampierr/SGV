package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Persona;

public interface PersonaService {
    public List<Persona> listarPersona();
    
    public void guardar(Persona pedido);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona (Persona pedido);
            
}
