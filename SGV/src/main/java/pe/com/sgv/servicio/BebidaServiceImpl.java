
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.dao.BebidaDao;
import pe.com.sgv.model.Bebida;

@Service
public class BebidaServiceImpl implements BebidaService{
    
    @Autowired
    private BebidaDao bebidaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Bebida> listarBebidas() {
        return (List<Bebida>) bebidaDao.findAll();
    }
    
    @Override
    @Transactional
    public void guardar(Bebida bebida) {
        bebidaDao.save(bebida);
    }
    
    @Override
    @Transactional
    public void eliminar(Bebida bebida) {
        bebidaDao.delete(bebida);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Bebida encontrarBebida(Bebida bebida) {
        return bebidaDao.findById(bebida.getIdBebida()).orElse(null);
    }
    
}
