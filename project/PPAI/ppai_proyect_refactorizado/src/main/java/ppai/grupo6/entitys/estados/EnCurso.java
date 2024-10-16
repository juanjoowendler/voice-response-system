package ppai.grupo6.entitys.estados;

import jakarta.persistence.*;
import ppai.grupo6.entitys.CambioEstado;
import ppai.grupo6.entitys.Llamada;
import ppai.grupo6.entitys.SubOpcionLlamada;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("EN_CURSO")
public class EnCurso extends Estado {
    private final Integer idEstado = 2;
    private final String nombre = "en curso";

    public EnCurso() {
        super(2, "en curso");
    }

    @Override
    public void cancelar(LocalDateTime fechaHoraActual, Llamada llamada, List<CambioEstado> cambiosEstado) {
        super.cancelar(fechaHoraActual, llamada, cambiosEstado);

        CambioEstado cambioEstado = this.buscarUltimoCambioEstado(cambiosEstado);
        cambioEstado.setFechaHoraFin(fechaHoraActual);

        LocalDateTime fechaHoraInicio = cambioEstado.getFechaHoraInicio();
        Integer duracion = this.calcularDuracion(fechaHoraInicio, fechaHoraActual);
        llamada.setDuracion(duracion);

        Cancelada cancelada = (Cancelada) this.crearProximoEstado("cancelada");
        CambioEstado nuevoCambioEstado = this.crearNuevoCambioEstado(fechaHoraActual, cancelada, llamada);
        llamada.addCambioEstado(nuevoCambioEstado);
        llamada.setEstadoActual(cancelada);
    }

    @Override
    public void finalizar(LocalDateTime fechaHoraActual,
                          Llamada llamada,
                          String descripcionOperador,
                          SubOpcionLlamada subOpcionLlamada,
                          List<CambioEstado> cambiosEstado) {
        super.finalizar(fechaHoraActual, llamada,descripcionOperador, subOpcionLlamada, cambiosEstado);

        CambioEstado cambioEstado = this.buscarUltimoCambioEstado(cambiosEstado);
        cambioEstado.setFechaHoraFin(fechaHoraActual);

        llamada.setDescripcionOperador(descripcionOperador);
        llamada.setSubOpcionSeleccionada(subOpcionLlamada);

        LocalDateTime fechaHoraInicio = cambioEstado.getFechaHoraInicio();
        Integer duracion = this.calcularDuracion(fechaHoraInicio, fechaHoraActual);
        llamada.setDuracion(duracion);

        Finalizada finalizada = (Finalizada) this.crearProximoEstado("finalizada");
        CambioEstado nuevoCambioEstado = this.crearNuevoCambioEstado(fechaHoraActual, finalizada, llamada);
        llamada.addCambioEstado(nuevoCambioEstado);
        llamada.setEstadoActual(finalizada);
    }

    @Override
    public Estado crearProximoEstado(String nombre){
        super.crearProximoEstado(nombre);
        if (Objects.equals(nombre, "finalizada")){
            return new Finalizada();
        }
        if (Objects.equals(nombre, "cancelada")){
            return new Cancelada();
        }
        return null;
    }

    public Integer calcularDuracion(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin){
        Duration duration = Duration.between(fechaHoraInicio, fechaHoraFin);
        Integer segundos = Math.toIntExact(duration.toSeconds());
        System.out.println(duration.toSeconds());
        return segundos;
    }

    @Override
    public boolean esEnCurso() {
        return true;
    }
}
