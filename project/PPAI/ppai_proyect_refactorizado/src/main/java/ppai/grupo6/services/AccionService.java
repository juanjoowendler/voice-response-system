package ppai.grupo6.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppai.grupo6.entitys.Accion;
import ppai.grupo6.repositorys.AccionRepository;

import java.util.List;

@Service
public class AccionService {
    @Autowired
    private  AccionRepository accionRepository;

    public List<Accion> getAll(){
        return this.accionRepository.findAll();
    }
}
