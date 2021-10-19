
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.model.Imagen;
import pe.com.sgv.dao.ImagenDao;

@Service
public class ImagenServiceImpl implements ImagenService{

    @Autowired
    private ImagenDao imagenDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Imagen> listarImagen() {
        return (List<Imagen>) imagenDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Imagen imagen) {
        imagenDao.save(imagen);
    }

    @Override
    @Transactional
    public void eliminar(Imagen imagen) {
        imagenDao.delete(imagen);
    }

    @Override
    @Transactional(readOnly = true)
    public Imagen encontrarImagen(Imagen imagen) {
        return imagenDao.findById(imagen.getIdImagen()).orElse(null);
    }
    
}
