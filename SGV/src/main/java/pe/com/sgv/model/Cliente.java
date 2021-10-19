package pe.com.sgv.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity //Para persistencia de datos
@Table(name = "cliente")
//Esto se usa porque en la bd dice "cliente", pero en la clase java dice "Cliente"
public class Cliente extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    //@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica cual es el campo de la llave primaria de nuestra tabla en la BD
    private Long idCliente;

    private String usuarioInsert;
    private String fechaInsert;
    private String usuarioUpdate;
    private String fechaUpdate;
    private String usuarioDelete;
    private String fechaDelete;
    private String hostName;
    private String ip;
}
