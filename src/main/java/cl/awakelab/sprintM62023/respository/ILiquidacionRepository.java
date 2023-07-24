package cl.awakelab.sprintM62023.respository;

import cl.awakelab.sprintM62023.entity.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Repository
public interface ILiquidacionRepository extends JpaRepository<Liquidacion, Integer> {
}
