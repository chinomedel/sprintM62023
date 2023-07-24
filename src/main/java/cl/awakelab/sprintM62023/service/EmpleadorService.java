package cl.awakelab.sprintM62023.service;

import cl.awakelab.sprintM62023.entity.Empleador;
import cl.awakelab.sprintM62023.respository.IEmpleadorRepository;
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
public class EmpleadorService{
    @Autowired
    IEmpleadorRepository iEmpleadorRepository;

    public List<Empleador> listaEmpleadores(){ return iEmpleadorRepository.findAll();};

    public Optional<Empleador> buscarEmpleador(Integer id){return iEmpleadorRepository.findById(id);};

    public Empleador crearEmpleador(Empleador e){return iEmpleadorRepository.save(e);};

    public List<Empleador> obtenerEmpleadoresPorIds(List<Integer> empleadoresIds) {
        return iEmpleadorRepository.findAllById(empleadoresIds);
    }
    public List<Integer> empleadoresPorTrabajador(Integer trabajadorId){
        return iEmpleadorRepository.encontrarEmpleadorIdPorIdTrabajador(trabajadorId);
    }

    public Empleador actualizarEmpleador(Empleador e){
        e.setNombre(e.getNombre());
        e.setNombre(e.getApellido1());
        e.setApellido2(e.getApellido2());
        e.setEmail(e.getEmail());
        e.setDireccion(e.getDireccion());
        e.setTelefono(e.getTelefono());
        return iEmpleadorRepository.save(e);
    };
    public void eliminarEmpleador(Integer id){iEmpleadorRepository.deleteById(id);}
}
