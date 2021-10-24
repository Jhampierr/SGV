
package pe.com.sgv.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity //Para persistencia de datos
@Table(name ="oferta")
//Esto se usa porque en la bd dice "oferta", pero en la clase java dice "Oferta"
public class Oferta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica cual es el campo de la llave primaria de nuestra tabla en la BD
    private Long idOferta;
    
    @NotEmpty
    private String detalle; 
    
    private Double precioOferta;
    
    @NotEmpty
    private String fechaInicio;
    
    @NotEmpty
    private String fechaFinal;
    
    @NotEmpty
    private String estado;
    
    //@NotEmpty
    @Column(name="producto_id_producto")
    //private Producto producto;
    private Integer producto;
    
    private String usuarioInsert;
    private String fechaInsert;
    private String usuarioUpdate;
    private String fechaUpdate;
    private String usuarioDelete;
    private String fechaDelete;
    private String hostName;
    private String ip;
}
