package ppai.grupo6.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ppai.grupo6.entitys.InformacionCliente;

@Repository
public interface InformacionClienteRepository extends JpaRepository<InformacionCliente, Integer> {
}
