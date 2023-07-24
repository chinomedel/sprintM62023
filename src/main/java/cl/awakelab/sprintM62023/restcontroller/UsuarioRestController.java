package cl.awakelab.sprintM62023.restcontroller;

import cl.awakelab.sprintM62023.entity.Usuario;
import cl.awakelab.sprintM62023.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    };

    @GetMapping("/getOne/{id}")
    public Optional<Usuario> buscarPirId(@PathVariable("id") Integer id){
        return usuarioService.encontrarUsuario(id);
    };

    @PutMapping("/crearUsuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        usuario.setFechaCreacion(LocalDateTime.now());
        return usuarioService.nuevoUsuario(usuario);
    };


}
