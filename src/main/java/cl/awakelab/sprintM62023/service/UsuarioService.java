package cl.awakelab.sprintM62023.service;

import cl.awakelab.sprintM62023.entity.Usuario;
import cl.awakelab.sprintM62023.respository.IUsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Service
public class UsuarioService {

    @Autowired
    IUsuarioRespository iUsuarioRespository;

    public List<Usuario> listarUsuarios(){
        return iUsuarioRespository.findAll();
    };

    public Usuario nuevoUsuario(Usuario u){
      return iUsuarioRespository.save(u);
    };
    public Usuario guardarUsuario(Usuario u){
        Usuario usuarioExistente = iUsuarioRespository.findById(u.getIdUsuario()).orElse(null);
        usuarioExistente.setNombre(u.getNombre());
        usuarioExistente.setApellido1(u.getApellido1());
        usuarioExistente.setApellido2(u.getApellido2());
        usuarioExistente.setEmail(u.getEmail());
        usuarioExistente.setClave(u.getClave());
        usuarioExistente.setIdPerfil(u.getIdPerfil());
        return iUsuarioRespository.save(u);
    };
    public void eliminarUsuario(int id){iUsuarioRespository.deleteById(id);};

    public Optional<Usuario> encontrarUsuario(int id){return iUsuarioRespository.findById(id);};

}
