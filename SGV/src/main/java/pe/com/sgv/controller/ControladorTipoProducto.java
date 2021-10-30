
package pe.com.sgv.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.jp.util.CheckIP;
import pe.com.sgv.model.TipoProducto;
import pe.com.sgv.servicio.TipoProductoService;

@Controller
@Slf4j
public class ControladorTipoProducto {
   
    @Autowired
    private TipoProductoService tipoProductoService;
    
    @GetMapping("/tipoProducto")
    public String tipoProducto(Model model){
        var tipoProducto = tipoProductoService.listarTipoProducto();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("tipoProducto", tipoProducto);
        return "tipoProductoSEL";
    }
    
    @GetMapping("/agregartipoProducto")
    public String agregartipoProducto(TipoProducto tipoProducto){
        return "tipoProductoUPD";
    }
    
    @PostMapping("/guardartipoProducto")
    public String guardartipoProducto(@Valid TipoProducto tipoProducto, Errors errores, Model model, CheckIP check) {
        if(errores.hasErrors()){
            return "tipoProductoUPD";
        }
        
        String fechString = LocalDate.now().toString();
        String horaString = LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        tipoProducto.setFechaUpdate(fechString + " " + horaString);
        //tipoEmpleado.setUsuarioUpdate(tipoEmpleado.getDescripcion());
        
        tipoProducto.setHostName(check.host().getHostName());
        tipoProducto.setIp(check.host().getHostAddress());
        
        tipoProductoService.guardar(tipoProducto);
        this.tipoProducto(model);
        //var tipoProducto = tipoProductoService.listarTipoProducto();
        
        //log.info("Ejecutando el controlador Spring MVC");
        //model.addAttribute("tipoProducto", tipoProducto);
        return "tipoProductoSEL";
    }
    
    @GetMapping("/editartipoProducto/{idTipoProducto}")
    public String guardartipoProducto(TipoProducto tipoProducto, Model model){
       tipoProducto = tipoProductoService.encontrarTipoProducto(tipoProducto);
       model.addAttribute("tipoProducto", tipoProducto);
       return "tipoProductoUPD";
    }
    @GetMapping("/eliminartipoProducto")
    public String eliminartipoProducto(TipoProducto tipoProducto, Model model){
                
        tipoProductoService.eliminar(tipoProducto);
        this.tipoProducto(model);
//        var tipoProducto = tipoProductoService.listarTipoProducto();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("tipoProducto", tipoProducto);
        return "tipoProductoSEL";
    }
    
}
