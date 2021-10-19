package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Reserva;

public interface ReservaService {
    public List<Reserva> listarReserva();
    
    public void guardar(Reserva reserva);
    
    public void eliminar(Reserva reserva);
    
    public Reserva encontrarReserva (Reserva reserva);
            
}
