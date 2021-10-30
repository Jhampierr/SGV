package pe.com.sgv.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name ="imagen")
//Esto se usa porque en la bd dice "imagen", pero en la clase java dice "Imagen"
public class Imagen implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica cual es el campo de la llave primaria de nuestra tabla en la BD
    private Long idImagen;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String descripcion;  
        
    private String usuarioInsert;
    private String fechaInsert;
    private String usuarioUpdate;
    private String fechaUpdate;
    private String hostName;
    private String ip;
}
