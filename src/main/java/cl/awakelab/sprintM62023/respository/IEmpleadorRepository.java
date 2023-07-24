package cl.awakelab.sprintM62023.respository;

import cl.awakelab.sprintM62023.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador, Integer> {

    @Query("SELECT e.idEmpleador FROM Empleador e " +
            "JOIN e.trabajadores t " +
            "WHERE t.idTrabajador = :trabajadorId")
    List<Integer> encontrarEmpleadorIdPorIdTrabajador(@Param("trabajadorId") Integer trabajadorId);
}
