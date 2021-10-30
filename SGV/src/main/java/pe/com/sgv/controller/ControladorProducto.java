
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
import pe.com.sgv.model.Producto;
import pe.com.sgv.servicio.ProductoService;

@Controller
@Slf4j
public class ControladorProducto {
   
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/producto")
    public String producto(Model model){
        var producto = productoService.listarProducto();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("producto", producto);
        return "productoSEL";
    }
    
    @GetMapping("/agregarproducto")
    public String agregar(Producto producto){
        return "productoUPD";
    }
    
    @PostMapping("/guardarproducto")
    public String guardar(@Valid Producto producto, Errors errores, Model model, CheckIP check){
        if(errores.hasErrors()){
            return "productoUPD";
            
        }
        
        String fechString = LocalDate.now().toString();
        String horaString = LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        producto.setFechaUpdate(fechString + " " + horaString);
        //tipoEmpleado.setUsuarioUpdate(tipoEmpleado.getDescripcion());
        
        producto.setHostName(check.host().getHostName());
        producto.setIp(check.host().getHostAddress());
        
        productoService.guardar(producto);
        this.producto(model);
//        var producto = productoService.listarProducto();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("producto", producto);
        return "productoSEL";
    }
    
    @GetMapping("/editarproducto/{idProducto}")
    public String editar(Producto producto, Model model){
       producto = productoService.encontrarProducto(producto);
       model.addAttribute("producto", producto);
       return "productoUPD";
    }
    @GetMapping("/eliminarproducto")
    public String eliminar(Producto producto, Model model){
        
        productoService.eliminar(producto);
        this.producto(model);
//        var producto = productoService.listarProducto();
//        
//        log.info("Ejecutando el controlador Spring MVC");
//        model.addAttribute("producto", producto);
        return "productoSEL";
    }
    
}
