package pe.com.sgv.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.com.jp.util.CheckIP;
import pe.com.sgv.model.Oferta;
import pe.com.sgv.model.Producto;
import pe.com.sgv.servicio.OfertaService;
import pe.com.sgv.servicio.ProductoService;

@Controller
@Slf4j
public class ControladorOferta {

    @Autowired
    private OfertaService ofertaService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/oferta")
    public String oferta(Model model) {
        var oferta = ofertaService.listarOferta();

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("oferta", oferta);
        return "ofertaSEL";
    }

    @GetMapping("/agregaroferta")
    public String agregar(Model model) {
        Oferta oferta = new Oferta();
        List<Producto> idProducto = productoService.listarProducto();

        model.addAttribute("oferta", oferta);
        model.addAttribute("idProducto", idProducto);
        return "ofertaUPD";
    }

    @PostMapping("/guardaroferta")
    public String guardar(@Valid @ModelAttribute Oferta oferta, BindingResult result,
            Model model, CheckIP check, RedirectAttributes attribute) {

        List<Producto> idProducto = productoService.listarProducto();

        if (result.hasErrors()) {
            model.addAttribute("oferta", oferta);
            model.addAttribute("idProducto", idProducto);
            System.out.println("Existen errores en el formulario");
            return "ofertaUPD";

        }

        String fechString = LocalDate.now().toString();
        String horaString = LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        oferta.setFechaUpdate(fechString + " " + horaString);

        oferta.setHostName(check.host().getHostName());
        oferta.setIp(check.host().getHostAddress());

        ofertaService.guardar(oferta);
        System.out.println("Oferta guardado con exito");
        attribute.addFlashAttribute("success", "Oferta guardado con exito!");

        return "redirect:/oferta/";
    }

    @GetMapping("/editaroferta/{idOferta}")
    public String editar(@PathVariable("idOferta") Long idOferta,
            Model model, RedirectAttributes attribute) {

        Oferta oferta = null;

        if (idOferta > 0) {
            oferta = ofertaService.encontrarOferta(idOferta);
            if (oferta == null) {
                System.out.println("Error: El ID de la oferta no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID de la oferta no existe!");
                return "empleadoUPD";
            }
        } else {
            System.out.println("Error: Error con el ID del Empleado");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del empleado");
            return "empleadoUPD";
        }

        List<Producto> idProducto = productoService.listarProducto();

        model.addAttribute("oferta", oferta);
        model.addAttribute("idProducto", idProducto);
        return "ofertaUPD";
    }

    @GetMapping("/eliminaroferta/{idOferta}")
    public String eliminar(@PathVariable("idOferta") Long idOferta,
            RedirectAttributes attribute){
        
        Oferta oferta = null;

        if (idOferta > 0) {
            oferta = ofertaService.encontrarOferta(idOferta);
            if (oferta == null) {
                System.out.println("Error: El ID de la oferta no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID de la oferta no existe!");
                return "empleadoUPD";
            }
        } else {
            System.out.println("Error: Error con el ID del Empleado");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del empleado");
            return "empleadoUPD";
        }
        
        ofertaService.eliminar(idOferta);
        System.out.println("Oferta eliminado con exito");
        attribute.addFlashAttribute("warning", "Oferta eliminado con Exito!");
        return "redirect:/oferta/";
    }

}
