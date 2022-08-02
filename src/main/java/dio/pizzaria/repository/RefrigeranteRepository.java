package dio.pizzaria.repository;

import dio.pizzaria.model.Refrigerante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefrigeranteRepository extends JpaRepository<Refrigerante, Long> {
}
