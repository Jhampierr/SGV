
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
import pe.com.sgv.model.Empleado;
import pe.com.sgv.model.TipoEmpleado;
import pe.com.sgv.servicio.EmpleadoService;

@Controller
@Slf4j
public class ControladorEmpleado {
   
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping("/empleado")
    public String empleado(Model model){
        var empleado = empleadoService.listarEmpleado();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("empleado", empleado);
        return "empleadoSEL";
    }
    
    @GetMapping("/agregarempleado")
    public String agregar(Empleado empleado){
        return "empleadoUPD";
    }
    
    @PostMapping("/guardarempleado")
    public String guardar(@Valid Empleado empleado, Errors errores, Model model, CheckIP check, TipoEmpleado tipoEmpleado){
        if(errores.hasErrors()){
            return "empleadoUPD";
        }
        
        String fechString = LocalDate.now().toString();
        String horaString = LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        empleado.setFechaUpdate(fechString + " " + horaString);
        //empleado.setUsuarioUpdate(tipoEmpleado.getDescripcion());
        
        
        empleado.setHostName(check.host().getHostName());
        empleado.setIp(check.host().getHostAddress());
        
        empleadoService.guardar(empleado);
        this.empleado(model);
//        var empleado = empleadoService.listarEmpleado();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("empleado", empleado);
        return "empleadoSEL";
    }
    
    @GetMapping("/editarempleado/{idEmpleado}")
    public String editar(Empleado empleado, Model model){
       empleado = empleadoService.encontrarEmpleado(empleado);
       model.addAttribute("empleado", empleado);
       return "empleadoUPD";
    }
    @GetMapping("/eliminarempleado")
    public String eliminar(Empleado empleado, Model model){
        
        empleadoService.eliminar(empleado);
        this.empleado(model);
//        var empleado = empleadoService.listarEmpleado();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("empleado", empleado);
        return "empleadoSEL";
    }
    
}
