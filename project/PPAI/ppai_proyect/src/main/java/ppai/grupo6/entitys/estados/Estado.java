package ppai.grupo6.entitys.estados;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import ppai.grupo6.entitys.CambioEstado;
import ppai.grupo6.entitys.Llamada;
import ppai.grupo6.entitys.SubOpcionLlamada;
import ppai.grupo6.repositorys.EstadoRepository;
import ppai.grupo6.services.EstadoService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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

    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<CambioEstado> cambiosEstado = new ArrayList<>();

    public boolean esIniciada(){
        return this.nombre.equals("iniciada");
    }

    public boolean esEnCurso(){
        return this.nombre.equals("en curso");
    }

    public void ponerEnCurso(String fechaHoraActual, Llamada llamada) {
    }

    public void finalizar(String fechaHoraActual,String fechaHoraAnterior, Llamada llamada,
                          String descripcionOperador, SubOpcionLlamada subOpcionLlamada){
    }

    public void cancelar(String fechaHoraActual, String fechaHoraAnterior,Llamada llamada){
    }

    public Estado(Integer idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public Estado(String name){
        this.nombre = name;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
