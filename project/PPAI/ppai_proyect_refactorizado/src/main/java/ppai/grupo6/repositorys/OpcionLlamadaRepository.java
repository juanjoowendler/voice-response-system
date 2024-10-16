package ppai.grupo6.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ppai.grupo6.entitys.OpcionLlamada;

@Repository
public interface OpcionLlamadaRepository extends JpaRepository<OpcionLlamada, Integer> {
}
