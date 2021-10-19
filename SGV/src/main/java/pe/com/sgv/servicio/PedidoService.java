package pe.com.sgv.servicio;

import java.util.List;
import pe.com.sgv.model.Pedido;

public interface PedidoService {
    public List<Pedido> listarPedido();
    
    public void guardar(Pedido pedido);
    
    public void eliminar(Pedido pedido);
    
    public Pedido encontrarPedido (Pedido pedido);
            
}
