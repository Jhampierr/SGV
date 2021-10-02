
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.dao.PlatilloDao;
import pe.com.sgv.model.Platillo;

@Service
public class PlatilloServiceImpl implements PlatilloService{

    @Autowired
    private PlatilloDao platilloDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Platillo> listarPlatillos() {
        return (List<Platillo>) platilloDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Platillo platillo) {
        platilloDao.save(platillo);
    }

    @Override
    @Transactional
    public void eliminar(Platillo platillo) {
        platilloDao.delete(platillo);
    }

    @Override
    @Transactional(readOnly = true)
    public Platillo encontrarPlatillo(Platillo platillo) {
        return platilloDao.findById(platillo.getIdPlatillo()).orElse(null);
    }
    
}
