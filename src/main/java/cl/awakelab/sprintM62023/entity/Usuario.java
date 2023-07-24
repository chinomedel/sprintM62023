package cl.awakelab.sprintM62023.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private int idUsuario;
    @Column(unique = true)
    private int run;
    @Column
    private String clave;
    @Column
    private String nombre;
    @Column(name="apellido_1")
    private String apellido1;
    @Column(name="apellido_2")
    private String apellido2;
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil idPerfil;
    @Column
    private String email;
    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column
    private long telefono;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUsuario")
    List<Empleador> empleadores;

}
