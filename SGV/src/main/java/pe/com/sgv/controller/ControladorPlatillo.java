
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
    public String inicio(Model model){
        var platillos = platilloService.listarPlatillos();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("platillos", platillos);
        
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Platillo platillo){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Platillo platillo, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        
        platilloService.guardar(platillo);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPlatillo}")
    public String editar(Platillo platillo, Model model){
       platillo = platilloService.encontrarPlatillo(platillo);
       model.addAttribute("platillo", platillo);
       return "modificar";
    }
    @GetMapping("/eliminar")
    public String eliminar(Platillo platillo){
        platilloService.eliminar(platillo);
        return "redirect:/";
    }
    
}
