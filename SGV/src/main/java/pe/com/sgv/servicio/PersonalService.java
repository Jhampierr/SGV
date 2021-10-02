package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Personal;

public interface PersonalService {
    public List<Personal> listarPersonal();
    
    public void guardar(Personal personal);
    
    public void eliminar(Personal personal);
    
    public Personal encontrarPersonal (Personal personal);
            
}
