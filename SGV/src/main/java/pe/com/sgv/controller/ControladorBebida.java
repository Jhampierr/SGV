
package pe.com.sgv.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import pe.com.sgv.model.Bebida;
//import pe.com.sgv.servicio.BebidaService;

@Controller
@Slf4j
public class ControladorBebida {
   
    /*@Autowired
    private BebidaService bebidaService;
    
    @GetMapping("/bebida")
    public String bebida(Model model){
        var bebidas = bebidaService.listarBebidas();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("bebidas", bebidas);
        return "bebidaSEL";
    }
    
    @GetMapping("/agregarbebida")
    public String agregarbebida(Bebida bebida){
        return "bebidaUPD";
    }
    
    @PostMapping("/guardarbebida")
    public String guardarbebida(@Valid Bebida bebida, Errors errores, Model model){
        if(errores.hasErrors()){
            return "bebidaUPD";
        }
        
        bebidaService.guardar(bebida);
        var bebidas = bebidaService.listarBebidas();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("bebidas", bebidas);
        return "bebidaSEL";
    }
    
    @GetMapping("/editarbebida/{idBebida}")
    public String guardarbebida(Bebida bebida, Model model){
       bebida = bebidaService.encontrarBebida(bebida);
       model.addAttribute("bebida", bebida);
       return "bebidaUPD";
    }
    @GetMapping("/eliminarbebida")
    public String eliminarbebida(Bebida bebida, Model model){
        
        bebidaService.eliminar(bebida);
        var bebidas = bebidaService.listarBebidas();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("bebidas", bebidas);
        return "bebidaSEL";
    }*/
    
}
