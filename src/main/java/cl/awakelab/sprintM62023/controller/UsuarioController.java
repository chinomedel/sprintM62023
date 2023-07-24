package cl.awakelab.sprintM62023.controller;

import cl.awakelab.sprintM62023.entity.Usuario;
import cl.awakelab.sprintM62023.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    Log logger = LogFactory.getLog(UsuarioService.class);
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> usuariosLista = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuariosLista);
        return "verUsuarios";
    };

    @GetMapping("/nuevoUsuario")
    public String nuevoUsuario(Model model){
        model.addAttribute("u", new Usuario());
        return "registrarUsuario";
    }
    @PostMapping("/nuevoUsuario")
    public String nuevoUsuario(@ModelAttribute Usuario u, @RequestParam("fechaCreacion") LocalDateTime fechaCreacion){
        u.setFechaCreacion(fechaCreacion);
        usuarioService.nuevoUsuario(u);
        return ("redirect:/usuario");
    };

    @GetMapping("eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id){
        usuarioService.eliminarUsuario(id);
        return ("redirect:/usuario");
    };
    @GetMapping("editar/{id}")
    public String editarUsuario(@PathVariable("id") Integer id, Model model){
        model.addAttribute("usuario", usuarioService.encontrarUsuario(id).get());
        return ("editarUsuario");
    };
    @PostMapping("/guardarUsuario")
    public String save(@ModelAttribute Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuario";
    }
}
