package cl.awakelab.sprintM62023.service;

import cl.awakelab.sprintM62023.entity.InstitucionPrevision;
import cl.awakelab.sprintM62023.respository.IPrevisionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Service
public class PrevisionService {
    @Autowired
    IPrevisionRespository iPrevisionRespository;

    public List<InstitucionPrevision> listaInstPrevision(){return iPrevisionRespository.findAll();};
}
