package cl.awakelab.sprintM62023.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Data
@Entity
@Table(name="trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_trabajador")
    private int idTrabajador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column(name="apellido_1")
    private String apellido1;
    @Column(name="apellido_2")
    private String apellido2;
    @Column
    private String email;
    @ManyToOne
    @JoinColumn(name="id_inst_salud")
    private InstitucionSalud idInstSalud;
    @ManyToOne
    @JoinColumn(name="id_inst_prevision")
    private InstitucionPrevision idInstPrevision;
    @Column
    private long telefono;
    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_trabajador"),
            inverseJoinColumns = @JoinColumn(name = "id_empleador"))
    private List<Empleador> empleadores;

    @OneToMany(mappedBy = "idTrabajador")
    private List<Liquidacion> liquidaciones;
}
