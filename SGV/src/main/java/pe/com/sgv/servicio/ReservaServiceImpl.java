
package pe.com.sgv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sgv.model.Reserva;
import pe.com.sgv.dao.ReservaDao;

@Service
public class ReservaServiceImpl implements ReservaService{

    @Autowired
    private ReservaDao reservaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> listarReserva() {
        return (List<Reserva>) reservaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    @Transactional
    public void eliminar(Reserva reserva) {
        reservaDao.delete(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva encontrarReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }
    
}
