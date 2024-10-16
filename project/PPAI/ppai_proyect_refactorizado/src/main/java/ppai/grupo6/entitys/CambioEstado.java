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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCambioEstado;

    @Column(name = "fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    public CambioEstado(LocalDateTime fechaHoraInicio, Estado estado, Llamada llamada) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
        this.llamada = llamada;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin){
        this.fechaHoraFin = fechaHoraFin;
    }

    public boolean esUltimoEstado(){
        return this.fechaHoraFin == null;
    }

    @Override
    public String toString() {
        return "CambioEstado{" +
                "idCambioEstado=" + idCambioEstado +
                ", fechaHoraInicio='" + fechaHoraInicio + '\'' +
                ", estado=" + estado +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "id_llamada")
    @JsonIgnore
    private Llamada llamada;
}
