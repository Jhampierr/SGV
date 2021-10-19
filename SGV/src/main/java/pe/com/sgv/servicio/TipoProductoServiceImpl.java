
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.model.TipoProducto;
import pe.com.sgv.dao.TipoProductoDao;

@Service
public class TipoProductoServiceImpl implements TipoProductoService{

    @Autowired
    private TipoProductoDao tipoProductoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoProducto> listarTipoProducto() {
        return (List<TipoProducto>) tipoProductoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(TipoProducto tipoProducto) {
        tipoProductoDao.save(tipoProducto);
    }

    @Override
    @Transactional
    public void eliminar(TipoProducto tipoProducto) {
        tipoProductoDao.delete(tipoProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoProducto encontrarTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoDao.findById(tipoProducto.getIdTipoProducto()).orElse(null);
    }
    
}
