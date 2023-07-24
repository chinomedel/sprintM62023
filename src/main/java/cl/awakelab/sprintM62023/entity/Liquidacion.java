package cl.awakelab.sprintM62023.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Data
@Entity
public class Liquidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_liquidacion")
    private int idLiquidacion;
    @ManyToOne
    @JoinColumn(name="id_trabajador")
    private Trabajador idTrabajador;
    @Column
    private LocalDate periodo;
    @Column(name="sueldo_imponible")
    private int sueldoImponible;
    @Column(name="sueldo_liquido")
    private int sueldoLiquido;
    @ManyToOne
    @JoinColumn(name="id_inst_salud")
    private InstitucionSalud idInstSalud;
    @Column(name="monto_inst_salud")
    private int montoInstSalud;
    @ManyToOne
    @JoinColumn(name="id_inst_previsional")
    private InstitucionPrevision idInstPrevisional;
    @Column(name="monto_inst_previsional")
    private int montoInstPrevisional;
    @Column(name="total_descuento")
    private int totalDescuentos;
    @Column(name="total_haberes")
    private int totalHaberes;
    @Column
    private int anticipo;

}
