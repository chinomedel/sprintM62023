package cl.awakelab.sprintM62023.controller;

import cl.awakelab.sprintM62023.service.PrevisionService;
import cl.awakelab.sprintM62023.service.SaludService;
import cl.awakelab.sprintM62023.service.ServiceLiquidacion;
import cl.awakelab.sprintM62023.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Controller
@RequestMapping("liquidaciones")
public class LiquidacionController {
    @Autowired
    ServiceLiquidacion serviceLiquidacion;
    @Autowired
    TrabajadorService trabajadorService;
    @Autowired
    SaludService saludService;
    @Autowired
    PrevisionService previsionService;

    @GetMapping
    public String listarLiquidaciones(Model model){
        model.addAttribute("liquidacion", serviceLiquidacion.listarLiquidaciones());
        return "verLiquidaciones";
    };
}
