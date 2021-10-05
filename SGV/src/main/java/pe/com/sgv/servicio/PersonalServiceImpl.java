
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.dao.PersonalDao;
import pe.com.sgv.model.Personal;

@Service
public class PersonalServiceImpl implements PersonalService{

    @Autowired
    private PersonalDao personalDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Personal> listarPersonal() {
        return (List<Personal>) personalDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Personal personal) {
        personalDao.save(personal);
    }

    @Override
    @Transactional
    public void eliminar(Personal personal) {
        personalDao.delete(personal);
    }

    @Override
    @Transactional(readOnly = true)
    public Personal encontrarPersonal(Personal personal) {
        return personalDao.findById(personal.getIdPersonal()).orElse(null);
    }
    
}
