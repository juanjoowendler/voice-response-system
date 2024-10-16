package ppai.grupo6.entitys.estados;

import jakarta.persistence.*;
import ppai.grupo6.entitys.CambioEstado;
import ppai.grupo6.entitys.Llamada;
import ppai.grupo6.entitys.SubOpcionLlamada;
import ppai.grupo6.entitys.estados.Estado;

@Entity
@DiscriminatorValue("EN_CURSO")
public class EnCurso extends Estado {
    public EnCurso(String name) {
        super(name);
    }
    public EnCurso() {
    }

    public EnCurso(Integer idEstado, String nombre) {
        super(idEstado, nombre);
    }

    @Override
    public void cancelar(String fechaHoraActual,String fechaHoraAnterior, Llamada llamada) {
        super.cancelar(fechaHoraActual, fechaHoraAnterior, llamada);
        llamada.calcularDuracion(fechaHoraAnterior, fechaHoraActual);
        Cancelada cancelada = new Cancelada(4,"cancelada");
        CambioEstado nuevoCambioEstado = new CambioEstado(fechaHoraActual, cancelada, llamada);
        llamada.addCambioEstado(nuevoCambioEstado);
    }

    public void finalizar(String fechaHoraActual, String fechaHoraAnterior, Llamada llamada,
                          String descripcionOperador, SubOpcionLlamada subOpcionLlamada) {
        super.finalizar(fechaHoraActual,fechaHoraAnterior, llamada,descripcionOperador, subOpcionLlamada);
        llamada.setSubOpcionLlamada(subOpcionLlamada);
        llamada.setDescripcionOperador(descripcionOperador);
        llamada.calcularDuracion(fechaHoraAnterior, fechaHoraActual);
        Finalizada finalizada = new Finalizada(3, "finalizada");
        CambioEstado nuevoCambioEstado = new CambioEstado(fechaHoraActual, finalizada, llamada);
        llamada.addCambioEstado(nuevoCambioEstado);
    }
}
