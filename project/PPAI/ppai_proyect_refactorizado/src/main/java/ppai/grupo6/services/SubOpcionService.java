package ppai.grupo6.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppai.grupo6.entitys.SubOpcionLlamada;
import ppai.grupo6.repositorys.SubOpcionLlamadaRepository;

@Service
public class SubOpcionService {
    @Autowired
    private  SubOpcionLlamadaRepository subOpcionLlamadaRepository;

    public SubOpcionLlamada findById(Integer id){
        return this.subOpcionLlamadaRepository.findById(id).get();
    }
}
