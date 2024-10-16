package ppai.grupo6.entitys.estados;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ppai.grupo6.entitys.CambioEstado;
import ppai.grupo6.entitys.Llamada;
import ppai.grupo6.entitys.SubOpcionLlamada;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "estados")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ENTITY_TYPE", discriminatorType = DiscriminatorType.STRING)
@Entity
public abstract class Estado {
    @Id
    private Integer idEstado;

    @Column(name = "nombre")
    private String nombre;

    public boolean esIniciada(){
        return false;
    }

    public boolean esEnCurso(){
        return false;
    }

    public boolean esCancelada(){return false;}

    public boolean esFinalizada(){return false;}

    public void ponerEnCurso(LocalDateTime fechaHoraActual, Llamada llamada, List<CambioEstado> cambiosEstado) {
    }

    public void finalizar(LocalDateTime fechaHoraActual,
                          Llamada llamada,
                          String descripcionOperador,
                          SubOpcionLlamada subOpcionLlamada,
                          List<CambioEstado> cambiosEstado){
    }

    public void cancelar(LocalDateTime fechaHoraActual,Llamada llamada, List<CambioEstado> cambiosEstado){
    }

    public CambioEstado buscarUltimoCambioEstado(List<CambioEstado> cambiosEstado){
        Optional<CambioEstado> ultimo = cambiosEstado.stream().filter(CambioEstado::esUltimoEstado).findFirst();
        return ultimo.get();
    }


    public Estado crearProximoEstado(String nombre){
        return null;
    }

    public CambioEstado crearNuevoCambioEstado(LocalDateTime fechaHoraInicio, Estado estado, Llamada llamada){
        return new CambioEstado(fechaHoraInicio, estado, llamada);
    }

    public Estado(Integer idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }






    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
