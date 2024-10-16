package ppai.grupo6.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppai.grupo6.entitys.Llamada;
import ppai.grupo6.repositorys.LlamadaRepository;

@Service

public class LlamadaService {
    @Autowired
    private  LlamadaRepository llamadaRepository;

    @Transactional
    public Llamada save(Llamada llamada) {
        return this.llamadaRepository.saveAndFlush(llamada);
    }

    public Llamada findById(Integer id) {
        return this.llamadaRepository.findById(id).get();
    }


}
