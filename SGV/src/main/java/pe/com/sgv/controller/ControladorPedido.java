package pe.com.sgv.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.com.jp.util.CheckIP;
import pe.com.sgv.model.Cliente;
import pe.com.sgv.model.Empleado;
import pe.com.sgv.model.Oferta;
import pe.com.sgv.model.Pedido;
import pe.com.sgv.model.Producto;
import pe.com.sgv.servicio.ClienteService;
import pe.com.sgv.servicio.EmpleadoService;
import pe.com.sgv.servicio.OfertaService;
import pe.com.sgv.servicio.PedidoService;
import pe.com.sgv.servicio.ProductoService;

@Controller
@Slf4j
public class ControladorPedido {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private OfertaService ofertaService;

    @GetMapping("/pedido")
    public String pedido(Model model) {
        var pedido = pedidoService.listarPedido();

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("pedido", pedido);
        return "pedidoSEL";
    }

    @GetMapping("/agregarpedido")
    public String agregar(Model model) {
        Pedido pedido = new Pedido();
        List<Cliente> cliente = clienteService.listarCliente();
        List<Empleado> empleado = empleadoService.listarEmpleado();
        List<Producto> producto = productoService.listarProducto();
        List<Oferta> oferta = ofertaService.listarOferta();

        model.addAttribute("pedido", pedido);
        model.addAttribute("cliente", cliente);
        model.addAttribute("empleado", empleado);
        model.addAttribute("producto", producto);
        model.addAttribute("oferta", oferta);

        return "pedidoUPD";
    }

    @PostMapping("/guardarpedido")
    public String guardar(@Valid @ModelAttribute Pedido pedido, BindingResult result,
            Model model, CheckIP check, RedirectAttributes attribute) {

        List<Cliente> cliente = clienteService.listarCliente();
        List<Empleado> empleado = empleadoService.listarEmpleado();
        List<Producto> producto = productoService.listarProducto();
        List<Oferta> oferta = ofertaService.listarOferta();

        if (result.hasErrors()) {
            model.addAttribute("pedido", pedido);
            model.addAttribute("cliente", cliente);
            model.addAttribute("empleado", empleado);
            model.addAttribute("producto", producto);
            model.addAttribute("oferta", oferta);
            System.out.println("Existen errores en el formulario");

            return "pedidoUPD";

        }
        
        String fechString = LocalDate.now().toString();
        String horaString = LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        pedido.setFechaUpdate(fechString + " " + horaString);
        
        pedido.setHostName(check.host().getHostName());
        pedido.setIp(check.host().getHostAddress());
        
        Double a = pedido.getProducto().getPrecio();
        Double b = pedido.getOferta().getPrecioOferta();
        
        if(a == null && b == null){
            pedido.setTotal(0D);
        } else if(a == null){
            a=0D;
            pedido.setTotal(a+b);
        } else if(b == null){
            b=0D;
            pedido.setTotal(a+b);
        }
        else{
            pedido.setTotal(a+b);
        }
        
        pedidoService.guardar(pedido);
        System.out.println("Pedido guardado con exito");
        attribute.addFlashAttribute("success", "Pedido guardado con exito!");

        return "redirect:/pedido/";
    }
    /*
    @GetMapping("/detallepedido/{idPedido}")
    public String detalle(@PathVariable("idPedido") Long idPedido,
            Model model, RedirectAttributes attribute) {

        Pedido pedido = null;

        if (idPedido > 0) {
            pedido = pedidoService.encontrarPedido(idPedido);
            if (pedido == null) {
                attribute.addFlashAttribute("error", "ATENCION: El ID del pedido no existe!");
                return "redirect:/pedido/";
            }
        } else {
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del pedido");
            return "redirect:/pedido/";
        }

        model.addAttribute("pedido", pedido);

        return "pedidoDetalle";
    }*/

    @GetMapping("/editarpedido/{idPedido}")
    public String editar(@PathVariable("idPedido") Long idPedido,
            Model model, RedirectAttributes attribute) {

        Pedido pedido = null;

        if (idPedido > 0) {
            pedido = pedidoService.encontrarPedido(idPedido);
            if (pedido == null) {
                System.out.println("Error: El ID del pedido no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del pedido no existe!");
                return "pedidoUPD";
            }
        } else {
            System.out.println("Error: Error con el ID del Pedido");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del pedido");
            return "pedidoUPD";
        }

        List<Cliente> cliente = clienteService.listarCliente();
        List<Empleado> empleado = empleadoService.listarEmpleado();
        List<Producto> producto = productoService.listarProducto();
        List<Oferta> oferta = ofertaService.listarOferta();

        model.addAttribute("pedido", pedido);
        model.addAttribute("cliente", cliente);
        model.addAttribute("empleado", empleado);
        model.addAttribute("producto", producto);
        model.addAttribute("oferta", oferta);

        return "pedidoUPD";
    }

    @GetMapping("/eliminarpedido/{idPedido}")
    public String eliminar(@PathVariable("idPedido") Long idPedido,
            RedirectAttributes attribute) {

        Pedido pedido = null;

        if (idPedido > 0) {
            pedido = pedidoService.encontrarPedido(idPedido);
            if (pedido == null) {
                System.out.println("Error: El ID del pedido no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del pedido no existe!");
                return "pedidoUPD";
            }
        } else {
            System.out.println("Error: Error con el ID del Pedido");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del pedido");
            return "pedidoUPD";
        }

        pedidoService.eliminar(idPedido);
        System.out.println("Pedido eliminado con exito");
        attribute.addFlashAttribute("warning", "pedido eliminado con Exito!");
        return "redirect:/pedido/";
    }

}
