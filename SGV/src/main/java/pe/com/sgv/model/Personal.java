
package pe.com.sgv.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name ="personal")
//Esto se usa porque en la bd dice "personal", pero en la clase java dice "Personal"
public class Personal implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indica cual es el campo de la llave primaria de nuestra tabla en la BD
    private Long idPersonal;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    private String dni;
    
    @NotEmpty
    private String cargo;
    
    @NotEmpty
    private String fecha_ingreso;
    
    
        
    
}
