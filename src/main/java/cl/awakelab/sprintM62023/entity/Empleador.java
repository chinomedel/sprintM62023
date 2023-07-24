package cl.awakelab.sprintM62023.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Data
@Entity
@Table(name="empleador")
public class Empleador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empleador")
    private int idEmpleador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column(name="apellido_1")
    private String apellido1;
    @Column(name="apellido_2")
    private String apellido2;
    @Column
    private String direccion;
    @Column
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;
    @Column
    private long telefono;

    @ManyToMany(mappedBy = "empleadores")
    private List<Trabajador> trabajadores;
}
