package cl.awakelab.sprintM62023.service;

import cl.awakelab.sprintM62023.entity.Liquidacion;
import cl.awakelab.sprintM62023.respository.ILiquidacionRepository;
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
public class ServiceLiquidacion {

    @Autowired
    ILiquidacionRepository iLiquidacionRepository;

    public List<Liquidacion> listarLiquidaciones(){return iLiquidacionRepository.findAll();};
    public Liquidacion crearLiquidacion(Liquidacion l){return iLiquidacionRepository.save(l);};
    public Optional<Liquidacion> buscarLiquidacion(Integer id){return iLiquidacionRepository.findById(id);};

}
