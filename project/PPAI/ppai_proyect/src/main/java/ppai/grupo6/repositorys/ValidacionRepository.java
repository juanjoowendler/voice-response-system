package ppai.grupo6.repositorys;

import org.hibernate.boot.model.internal.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ppai.grupo6.entitys.Validacion;
@Repository
public interface ValidacionRepository extends JpaRepository<Validacion, Integer> {
}
