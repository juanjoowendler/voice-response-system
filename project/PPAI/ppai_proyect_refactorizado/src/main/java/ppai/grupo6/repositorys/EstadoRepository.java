package ppai.grupo6.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ppai.grupo6.entitys.estados.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    Estado findByNombre(String nombre);
}
