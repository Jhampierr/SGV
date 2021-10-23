
package pe.com.sgv.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity //Para persistencia de datos
@Table(name ="empleado")
//Esto se usa porque en la bd dice "empleado", pero en la clase java dice "Empleado"
public class Empleado extends Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica cual es el campo de la llave primaria de nuestra tabla en la BD
    private Long idEmpleado;
    
    @NotEmpty
    private String fechaIngreso;
    
    @NotEmpty
    private TipoEmpleado tipoEmp;
    
    private String usuarioInsert;
    private String fechaInsert;
    private String usuarioUpdate;
    private String fechaUpdate;
    private String usuarioDelete;
    private String fechaDelete;
    private String hostName;
    private String ip;   
}
