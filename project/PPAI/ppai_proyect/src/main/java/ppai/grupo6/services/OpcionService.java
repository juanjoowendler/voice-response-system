package ppai.grupo6.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppai.grupo6.entitys.OpcionLlamada;
import ppai.grupo6.repositorys.OpcionLlamadaRepository;

@Service
public class OpcionService {
    @Autowired
    private OpcionLlamadaRepository opcionLlamadaRepository;

    public OpcionLlamada findById(Integer id){
        return this.opcionLlamadaRepository.findById(id).get();
    }
}
