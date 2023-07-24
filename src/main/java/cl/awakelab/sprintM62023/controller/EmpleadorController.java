package cl.awakelab.sprintM62023.controller;

import cl.awakelab.sprintM62023.entity.Empleador;
import cl.awakelab.sprintM62023.service.EmpleadorService;
import cl.awakelab.sprintM62023.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Controller
@RequestMapping("/empleadores")
public class EmpleadorController {
    @Autowired
    EmpleadorService empleadorService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public String listarEmpleadores(Model model){
        model.addAttribute("empleadores",empleadorService.listaEmpleadores());
        return "verEmpleadores";
    };
    @GetMapping("/nuevoEmpleador")
    public String nuevoEmpleador(Model model){
        model.addAttribute("usuarios",usuarioService.listarUsuarios());
        return "nuevoEmpleador";
    }
    @PostMapping("/nuevoEmpleador")
    public String guardarEmpleador(@ModelAttribute Empleador e){
         empleadorService.crearEmpleador(e);
         return ("redirect:/empleadores");
    }
    @GetMapping("/editarEmpleador/{id}")
    public String editarEmpleador(@PathVariable("id") Integer id, Model model){
        model.addAttribute("usuarios",usuarioService.listarUsuarios());
        model.addAttribute("empleadores", empleadorService.buscarEmpleador(id).get());
        return "editarEmpleador";
    }

}
