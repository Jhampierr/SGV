
package pe.com.sgv.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity //Para persistencia de datos
@Table(name ="pedido")
//Esto se usa porque en la bd dice "pedido", pero en la clase java dice "Pedido"
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica cual es el campo de la llave primaria de nuestra tabla en la BD
    private Long idPedido;
    
    @NotEmpty
    private String fecha;
    
    @NotEmpty
    private String hora;
    
    @NotEmpty
    private String direccionPedido;
    
    @NotEmpty
    private Integer cantidad;
    
    @NotEmpty
    private Double total;
    
    @NotEmpty
    private String estado;
    
    @NotEmpty
    private String detalle;
    
    @NotEmpty
    private Cliente cliente;
        
    @NotEmpty
    private Empleado empleado;
    
    private Producto producto;
    
    private Oferta oferta;
    
    private String usuarioInsert;
    private String fechaInsert;
    private String usuarioUpdate;
    private String fechaUpdate;
    private String hostName;
    private String ip;
}
