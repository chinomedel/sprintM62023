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
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perfil")
    private int IdPerfil;
    @Column
    private String descripcion;
    @Column
    private Boolean estado;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPerfil")
    List<Usuario> usuarios;
}
