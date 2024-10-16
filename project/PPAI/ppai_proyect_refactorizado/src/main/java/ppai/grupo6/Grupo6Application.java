package ppai.grupo6;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ppai.grupo6.repositorys.AccionRepository;
import ppai.grupo6.services.AccionService;
import ppai.grupo6.services.GestorLlamadas;

@SpringBootApplication
public class Grupo6Application {
	public static void main(String[] args) {
		SpringApplication.run(Grupo6Application.class, args);
	}

/*	@PostConstruct
	public void comunicarseConOperador(){
		GestorLlamadas gestor = new GestorLlamadas();
		gestor.comunicarseConOperador();
	}*/

}
