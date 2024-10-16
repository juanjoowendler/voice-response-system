package ppai.grupo6.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ppai.grupo6.entitys.CategoriaLlamada;

@Repository
public interface CategoriaLlamadaRepository extends JpaRepository<CategoriaLlamada, Integer> {
}
