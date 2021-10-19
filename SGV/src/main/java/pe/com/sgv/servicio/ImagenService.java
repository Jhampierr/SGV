package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Imagen;

public interface ImagenService {
    public List<Imagen> listarImagen();
    
    public void guardar(Imagen imagen);
    
    public void eliminar(Imagen imagen);
    
    public Imagen encontrarImagen (Imagen imagen);
            
}
