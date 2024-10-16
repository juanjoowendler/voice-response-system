package ppai.grupo6.entitys.estados;

import jakarta.persistence.*;
import ppai.grupo6.entitys.CambioEstado;
import ppai.grupo6.entitys.Llamada;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@DiscriminatorValue("INICIADA")
public class Iniciada extends Estado {

    private final Integer idEstado = 1;
    private final String nombre = "iniciada";

    @Override
    public void ponerEnCurso(LocalDateTime fechaHoraActual, Llamada llamada, List<CambioEstado> cambiosEstado) {
        super.ponerEnCurso(fechaHoraActual, llamada, cambiosEstado);
        CambioEstado cambioEstado = this.buscarUltimoCambioEstado(cambiosEstado);
        cambioEstado.setFechaHoraFin(fechaHoraActual);
        EnCurso enCurso = (EnCurso) this.crearProximoEstado("en curso");
        CambioEstado nuevoCambioEstado = this.crearNuevoCambioEstado(fechaHoraActual, enCurso, llamada);
        llamada.addCambioEstado(nuevoCambioEstado);
        llamada.setEstadoActual(enCurso);
    }

    @Override
    public Estado crearProximoEstado(String nombre){
        return new EnCurso();
    }

    public Iniciada() {
        super(1, "iniciada");
    }

    @Override
    public boolean esIniciada() {
        return true;
    }
}
