
package pe.com.sgv.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.sgv.model.Platillo;
import pe.com.sgv.servicio.PlatilloService;

@Controller
@Slf4j
public class ControladorPlatillo {
   
    @Autowired
    private PlatilloService platilloService;
    
    @GetMapping("/")
    public String inicio(){
        /*var platillos = platilloService.listarPlatillos();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("platillos", platillos);*/
        
        return "index";
    }

    @GetMapping("/platillo")
    public String platillo(Model model){
        var platillos = platilloService.listarPlatillos();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("platillos", platillos);
        return "platilloSEL";
    }
    
    @GetMapping("/agregar")
    public String agregar(Platillo platillo){
        return "platilloUPD";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Platillo platillo, Errors errores, Model model){
        if(errores.hasErrors()){
            return "platilloUPD";
        }
        
        platilloService.guardar(platillo);
        var platillos = platilloService.listarPlatillos();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("platillos", platillos);
        return "platilloSEL";
    }
    
    @GetMapping("/editar/{idPlatillo}")
    public String editar(Platillo platillo, Model model){
       platillo = platilloService.encontrarPlatillo(platillo);
       model.addAttribute("platillo", platillo);
       return "platilloUPD";
    }
    @GetMapping("/eliminar")
    public String eliminar(Platillo platillo, Model model){
        
        platilloService.eliminar(platillo);
        var platillos = platilloService.listarPlatillos();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("platillos", platillos);
        return "platilloSEL";
    }
    
}
