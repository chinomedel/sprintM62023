package cl.awakelab.sprintM62023.controller;

import cl.awakelab.sprintM62023.entity.Empleador;
import cl.awakelab.sprintM62023.entity.Trabajador;
import cl.awakelab.sprintM62023.service.EmpleadorService;
import cl.awakelab.sprintM62023.service.PrevisionService;
import cl.awakelab.sprintM62023.service.SaludService;
import cl.awakelab.sprintM62023.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    @Autowired
    TrabajadorService trabajadorService;
    @Autowired
    EmpleadorService empleadorService;
    @Autowired
    SaludService saludService;
    @Autowired
    PrevisionService previsionService;

    @GetMapping
    public String listarTrabajadores(Model model){
        model.addAttribute("trabajador", trabajadorService.listarTrabajadores());
        return "verTrabajadores";
    };
    @GetMapping("/nuevoTrabajador")
    public String nuevoTrabajador(Model model){
        model.addAttribute("empleadores",empleadorService.listaEmpleadores());
        model.addAttribute("instSalud", saludService.listaInstSalud());
        model.addAttribute("instPrevision", previsionService.listaInstPrevision());
        return "nuevoTrabajador";
    }
    @PostMapping("/nuevoTrabajador")
    public String guardarTrabajador(@ModelAttribute Trabajador t, @RequestParam List<Integer> empleadoresIds){
        List<Empleador> empleadores = empleadorService.obtenerEmpleadoresPorIds(empleadoresIds);
        t.setEmpleadores(empleadores);
        trabajadorService.crearTrabajador(t);
        return ("redirect:/trabajadores");
    }

    @GetMapping("editar/{id}")
    public String editarTrabajador(@PathVariable("id") Integer id, Model model){
        model.addAttribute("trabajador",trabajadorService.buscarTrabajador(id));
        model.addAttribute("empleadores",empleadorService.listaEmpleadores());
        model.addAttribute("instSalud", saludService.listaInstSalud());
        model.addAttribute("instPrevision", previsionService.listaInstPrevision());
        model.addAttribute("empleadoresEncontrados",empleadorService.empleadoresPorTrabajador(id));
        return ("editarTrabajador");
    };
}
