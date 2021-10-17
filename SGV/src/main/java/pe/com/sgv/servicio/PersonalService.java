package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Empleado;

public interface PersonalService {
    public List<Empleado> listarPersonal();
    
    public void guardar(Empleado personal);
    
    public void eliminar(Empleado personal);
    
    public Empleado encontrarPersonal (Empleado personal);
            
}
