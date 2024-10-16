package ppai.grupo6.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;
import ppai.grupo6.entitys.estados.Estado;
import ppai.grupo6.services.CambioEstadoService;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cambios_estado")
public class CambioEstado {
    @Id
/*    @GeneratedValue(generator = "CambioEstados")
    @TableGenerator(name = "CambioEstados", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="CambioEstados",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCambioEstado;

    @Column(name = "fecha_hora_inicio")
    private String fechaHoraInicio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_llamada")
    @JsonIgnore
    private Llamada llamada;

    public CambioEstado(String fechaHoraInicio, Estado estado, Llamada llamada) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
        this.llamada = llamada;
    }

    public CambioEstado(String fechaHoraInicio, Estado estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    public boolean esIniciada(){
        return this.estado.esIniciada();
    }

    public boolean esEnCurso(){
        return this.estado.esEnCurso();
    }

    public void ponerEnCurso(String fechaHoraActual, Llamada llamada){
        this.estado.ponerEnCurso(fechaHoraActual, llamada);
    }

    public void cancelar(String fechaHoraActual,String fechaHoraAnterior, Llamada llamada){
        this.estado.cancelar(fechaHoraActual, fechaHoraAnterior, llamada);
    }

    public void finalizar(String fechaHoraActual,String fechaHoraAnterior, Llamada llamada, String descripcionOperador,
                          SubOpcionLlamada subOpcionLlamada){
        this.estado.finalizar(fechaHoraActual,fechaHoraAnterior, llamada, descripcionOperador, subOpcionLlamada);
    }



    @Override
    public String toString() {
        return "CambioEstado{" +
                "idCambioEstado=" + idCambioEstado +
                ", fechaHoraInicio='" + fechaHoraInicio + '\'' +
                ", estado=" + estado +
                '}';
    }
}
