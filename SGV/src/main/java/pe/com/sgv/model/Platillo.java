
package pe.com.sgv.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name ="platillo")
//Esto se usa porque en la bd dice "platillo", pero en la clase java dice "Platillo"
public class Platillo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indica cual es el campo de la llave primaria de nuestra tabla en la BD
    private Long idPlatillo;
    
    @NotEmpty
    private String nombre;
    
    @NotNull
    private Double precio;
    
    @NotEmpty
    private String categoria;
        
    
}
