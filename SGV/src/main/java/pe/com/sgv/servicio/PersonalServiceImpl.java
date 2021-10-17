
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.dao.PersonalDao;
import pe.com.sgv.model.Empleado;

@Service
public class PersonalServiceImpl implements PersonalService{

    @Autowired
    private PersonalDao personalDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarPersonal() {
        return (List<Empleado>) personalDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Empleado personal) {
        personalDao.save(personal);
    }

    @Override
    @Transactional
    public void eliminar(Empleado personal) {
        personalDao.delete(personal);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarPersonal(Empleado personal) {
        return personalDao.findById(personal.getIdPersonal()).orElse(null);
    }
    
}
