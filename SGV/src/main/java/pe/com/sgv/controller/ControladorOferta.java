
package pe.com.sgv.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.sgv.model.CheckIP;
import pe.com.sgv.model.Oferta;
import pe.com.sgv.servicio.OfertaService;

@Controller
@Slf4j
public class ControladorOferta {
   
    @Autowired
    private OfertaService ofertaService;
    
    @GetMapping("/oferta")
    public String oferta(Model model){
        var oferta = ofertaService.listarOferta();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("oferta", oferta);
        return "ofertaSEL";
    }
    
    @GetMapping("/agregaroferta")
    public String agregar(Oferta oferta){
        return "ofertaUPD";
    }
    
    @PostMapping("/guardaroferta")
    public String guardar(@Valid Oferta oferta, Errors errores, Model model, CheckIP check){
        if(errores.hasErrors()){
            return "ofertaUPD";
            
        }
        
        oferta.setHostName(check.host().getHostName());
        oferta.setIp(check.host().getHostAddress());
        
        ofertaService.guardar(oferta);
        this.oferta(model);
//        var oferta = ofertaService.listarOferta();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("oferta", oferta);
        return "ofertaSEL";
    }
    
    @GetMapping("/editaroferta/{idOferta}")
    public String editar(Oferta oferta, Model model){
       oferta = ofertaService.encontrarOferta(oferta);
       model.addAttribute("oferta", oferta);
       return "ofertaUPD";
    }
    @GetMapping("/eliminaroferta")
    public String eliminar(Oferta oferta, Model model){
        
        ofertaService.eliminar(oferta);
        this.oferta(model);
//        var oferta = ofertaService.listarOferta();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("oferta", oferta);
        return "ofertaSEL";
    }
    
}
