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
import pe.com.sgv.model.TipoEmpleado;
import pe.com.sgv.servicio.TipoEmpleadoService;

@Controller
@Slf4j
public class ControladorTipoEmpleado {

    @Autowired
    private TipoEmpleadoService tipoEmpleadoService;
    
    @GetMapping("/tipoEmpleado")
    public String tipoEmpleado(Model model) {
        var tipoEmpleado = tipoEmpleadoService.listarTipoEmpleado();

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("tipoEmpleado", tipoEmpleado);
        return "tipoEmpleadoSEL";
    }

    @GetMapping("/agregartipoEmpleado")
    public String agregartipoEmpleado(TipoEmpleado tipoEmpleado) {
                
        return "tipoEmpleadoUPD";
    }

    @PostMapping("/guardartipoEmpleado")
    public String guardartipoEmpleado(@Valid TipoEmpleado tipoEmpleado, Errors errores, Model model, CheckIP check) {
        if (errores.hasErrors()) {
            return "tipoEmpleadoUPD";
        }

        String fechString = LocalDate.now().toString();
        String horaString = LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        tipoEmpleado.setFechaUpdate(fechString + " " + horaString);
        //tipoEmpleado.setUsuarioUpdate(tipoEmpleado.getDescripcion());

        tipoEmpleado.setHostName(check.host().getHostName());
        tipoEmpleado.setIp(check.host().getHostAddress());

        tipoEmpleadoService.guardar(tipoEmpleado);
        this.tipoEmpleado(model);
        //var tipoEmpleado = tipoEmpleadoService.listarTipoEmpleado();

        //log.info("Ejecutando el controlador Spring MVC");
        //model.addAttribute("tipoEmpleado", tipoEmpleado);
        return "tipoEmpleadoSEL";
    }

    @GetMapping("/editartipoEmpleado/{idTipoEmpleado}")
    public String guardartipoEmpleado(TipoEmpleado tipoEmpleado, Model model) {
                
        tipoEmpleado = tipoEmpleadoService.encontrarTipoEmpleado(tipoEmpleado);
        model.addAttribute("tipoEmpleado", tipoEmpleado);
        return "tipoEmpleadoUPD";
    }

    @GetMapping("/eliminartipoEmpleado")
    public String eliminartipoEmpleado(TipoEmpleado tipoEmpleado, Model model) {

        tipoEmpleadoService.eliminar(tipoEmpleado);
        this.tipoEmpleado(model);
//        var tipoEmpleado = tipoEmpleadoService.listarTipoEmpleado();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("tipoEmpleado", tipoEmpleado);
        return "tipoEmpleadoSEL";
    }

}
