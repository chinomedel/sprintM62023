package cl.awakelab.sprintM62023.service;

import cl.awakelab.sprintM62023.entity.Empleador;
import cl.awakelab.sprintM62023.entity.Trabajador;
import cl.awakelab.sprintM62023.respository.ITrabajadorRespository;
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
public class TrabajadorService {
    @Autowired
    ITrabajadorRespository iTrabajadorRespository;

    public List<Trabajador> listarTrabajadores(){
        return iTrabajadorRespository.findAll();
    };
    public Trabajador crearTrabajador(Trabajador t){return iTrabajadorRespository.save(t);};
    public Optional<Trabajador> buscarTrabajador(Integer id){return iTrabajadorRespository.findById(id);};
}
