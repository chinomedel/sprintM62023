package cl.awakelab.sprintM62023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="institucion_prevision")
public class InstitucionPrevision {
    @Id
    @Column(name="id_inst_prevision")
    private int idInstPrevision;
    @Column
    private String descripcion;
    @Column(name="porc_dcto")
    private float porcentaje;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idInstPrevision")
    private List<Trabajador> trabajadores;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idInstPrevisional")
    private List<Liquidacion> liquidaciones;
}
