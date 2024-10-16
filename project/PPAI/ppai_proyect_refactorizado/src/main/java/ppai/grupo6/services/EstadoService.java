package ppai.grupo6.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppai.grupo6.repositorys.EstadoRepository;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
}
