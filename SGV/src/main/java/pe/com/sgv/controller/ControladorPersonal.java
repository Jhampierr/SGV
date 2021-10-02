
package pe.com.sgv.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.sgv.model.Personal;
import pe.com.sgv.servicio.PersonalService;

@Controller
@Slf4j
public class ControladorPersonal {
   
    @Autowired
    private PersonalService personalService;
    
    @GetMapping("/personal")
    public String personal(Model model){
        var personal = personalService.listarPersonal();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personal", personal);
        return "personalSEL";
    }
    
    @GetMapping("/agregarpersonal")
    public String agregar(Personal personal){
        return "personalUPD";
    }
    
    @PostMapping("/guardarpersonal")
    public String guardar(@Valid Personal personal, Errors errores, Model model){
        if(errores.hasErrors()){
            return "personalUPD";
        }
        
        personalService.guardar(personal);
        this.personal(model);
//        var personal = personalService.listarPersonal();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("personal", personal);
        return "personalSEL";
    }
    
    @GetMapping("/editarpersonal/{idPersonal}")
    public String editar(Personal personal, Model model){
       personal = personalService.encontrarPersonal(personal);
       model.addAttribute("personal", personal);
       return "personalUPD";
    }
    @GetMapping("/eliminarpersonal")
    public String eliminar(Personal personal, Model model){
        
        personalService.eliminar(personal);
        this.personal(model);
//        var personal = personalService.listarPersonal();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("personal", personal);
        return "personalSEL";
    }
    
}
