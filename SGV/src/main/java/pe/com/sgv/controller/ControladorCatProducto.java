
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
import pe.com.sgv.model.CatProducto;
import pe.com.sgv.servicio.CatProductoService;

@Controller
@Slf4j
public class ControladorCatProducto {
   
    @Autowired
    private CatProductoService catProductoService;
    
    @GetMapping("/catProducto")
    public String catProducto(Model model){
        var catProducto = catProductoService.listarCatProducto();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("catProducto", catProducto);
        return "catProductoSEL";
    }
    
    @GetMapping("/agregarcatProducto")
    public String agregarcatProducto(CatProducto catProducto){
        return "catProductoUPD";
    }
    
    @PostMapping("/guardarcatProducto")
    public String guardarcatProducto(@Valid CatProducto catProducto, Errors errores, Model model, CheckIP check) {
        if(errores.hasErrors()){
            return "catProductoUPD";
        }
        
        catProducto.setHostName(check.host().getHostName());
        catProducto.setIp(check.host().getHostAddress());
        
        catProductoService.guardar(catProducto);
        this.catProducto(model);
        //var catProducto = catProductoService.listarCatProducto();
        
        //log.info("Ejecutando el controlador Spring MVC");
        //model.addAttribute("catProducto", catProducto);
        return "catProductoSEL";
    }
    
    @GetMapping("/editarcatProducto/{idCatProducto}")
    public String guardarcatProducto(CatProducto catProducto, Model model){
       catProducto = catProductoService.encontrarCatProducto(catProducto);
       model.addAttribute("catProducto", catProducto);
       return "catProductoUPD";
    }
    @GetMapping("/eliminarcatProducto")
    public String eliminarcatProducto(CatProducto catProducto, Model model){
                
        catProductoService.eliminar(catProducto);
        this.catProducto(model);
//        var catProducto = catProductoService.listarCatProducto();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("catProducto", catProducto);
        return "catProductoSEL";
    }
    
}
