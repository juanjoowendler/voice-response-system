package ppai.grupo6.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ppai.grupo6.entitys.Llamada;
import ppai.grupo6.entitys.estados.Estado;

import java.util.List;

@Repository
public interface LlamadaRepository extends JpaRepository<Llamada, Integer> {

    List<Llamada> findLlamadasByEstadoActual(Estado estado);

}
