
package pe.com.sgv.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name ="bebida")
//Esto se usa porque en la bd dice "bebida", pero en la clase java dice "Bebida"
public class Bebida implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indica cual es el campo de la llave primaria de nuestra tabla en la BD
    private Long idBebida;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private double precio;
    
    @NotEmpty
    private String categoria;
        
    
}
