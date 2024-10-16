package ppai.grupo6.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ppai.grupo6.entitys.SubOpcionLlamada;

@Repository
public interface SubOpcionLlamadaRepository extends JpaRepository<SubOpcionLlamada, Integer> {
}
