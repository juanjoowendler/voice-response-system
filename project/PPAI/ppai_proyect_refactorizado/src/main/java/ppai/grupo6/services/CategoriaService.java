package ppai.grupo6.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppai.grupo6.entitys.CategoriaLlamada;
import ppai.grupo6.repositorys.CategoriaLlamadaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaLlamadaRepository categoriaLlamadaRepository;

    public CategoriaLlamada findById(Integer id){
        return this.categoriaLlamadaRepository.findById(id).get();
    }
}
