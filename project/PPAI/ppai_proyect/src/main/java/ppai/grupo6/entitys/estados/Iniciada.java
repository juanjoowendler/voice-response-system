package ppai.grupo6.entitys.estados;

import jakarta.persistence.*;
import ppai.grupo6.entitys.CambioEstado;
import ppai.grupo6.entitys.Llamada;
import ppai.grupo6.entitys.estados.Estado;
import ppai.grupo6.services.CambioEstadoService;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("INICIADA")
public class Iniciada extends Estado {
    @Override
    public void ponerEnCurso(String fechaHoraActual, Llamada llamada) {
        super.ponerEnCurso(fechaHoraActual, llamada);
        EnCurso enCurso = new EnCurso(2,"en curso");
        CambioEstado nuevoCambioEstado = new CambioEstado(fechaHoraActual, enCurso, llamada);;
        llamada.addCambioEstado(nuevoCambioEstado);
    }
}
