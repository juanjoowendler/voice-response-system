package ppai.grupo6.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppai.grupo6.entitys.CambioEstado;
import ppai.grupo6.repositorys.CambioEstadoRepository;

@Service
public class CambioEstadoService {
    @Autowired
    private CambioEstadoRepository cambioEstadoRepository;

    public CambioEstado save(CambioEstado cambioEstado){
        return this.cambioEstadoRepository.saveAndFlush(cambioEstado);
    }
}
