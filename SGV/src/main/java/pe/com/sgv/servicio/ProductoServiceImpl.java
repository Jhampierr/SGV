
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.model.Producto;
import pe.com.sgv.dao.ProductoDao;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProducto() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto encontrarProducto(Long producto) {
        return productoDao.findById(producto).orElse(null);
    }
    
    @Override
    @Transactional
    public void eliminar(Long producto) {
        productoDao.deleteById(producto);
    }
}
