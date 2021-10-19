
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.model.CatProducto;
import pe.com.sgv.dao.CatProductoDao;

@Service
public class CatProductoServiceImpl implements CatProductoService{

    @Autowired
    private CatProductoDao catProductoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<CatProducto> listarCatProducto() {
        return (List<CatProducto>) catProductoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(CatProducto catProducto) {
        catProductoDao.save(catProducto);
    }

    @Override
    @Transactional
    public void eliminar(CatProducto catProducto) {
        catProductoDao.delete(catProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public CatProducto encontrarCatProducto(CatProducto catProducto) {
        return catProductoDao.findById(catProducto.getIdCatProducto()).orElse(null);
    }
    
}
