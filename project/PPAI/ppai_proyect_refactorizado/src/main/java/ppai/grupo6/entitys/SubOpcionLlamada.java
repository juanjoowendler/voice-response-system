package ppai.grupo6.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.jmx.export.annotation.ManagedNotification;
import ppai.grupo6.services.dtos.ValidacionDto;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subopciones_llamada")
public class SubOpcionLlamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubOpcionLlamada;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nroOrden")
    private Integer nroOrden;

    @ManyToOne()
    @JoinColumn(name = "id_opcion_llamada")
    @JsonIgnore
    private OpcionLlamada opcionLlamada;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "validaciones_subopciones",
            joinColumns = @JoinColumn(name = "id_sub_opcion_llamada"),
            inverseJoinColumns = @JoinColumn(name = "id_validacion")
    )
    private List<Validacion> validacionessubopciones = new ArrayList<>();

    public List<ValidacionDto> buscarValidacionesSubOpcionCliente(List<Validacion> validacionesCliente){

        return this.validacionessubopciones.stream().map(
                validacionSubOpcion -> {
                    if(validacionSubOpcion.esValidacionCliente(validacionesCliente)){
                        List<String> descripcionesOpciones = validacionSubOpcion.buscarOpcionesValidacion();
                        String descripcionValidacion = validacionSubOpcion.getNombre();
                        Integer nroOrdenValidacion = validacionSubOpcion.getNroOrden();
                        return new ValidacionDto(descripcionesOpciones,
                                descripcionValidacion,
                                nroOrdenValidacion,
                                validacionSubOpcion);
                    }
                    return null;
                }
        ).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "SubOpcionLlamada{" +
                "idSubOpcionLlamada=" + idSubOpcionLlamada +
                ", nombre='" + nombre + '\'' +
                ", nroOrden=" + nroOrden +
                ", validacionessubopciones=" + validacionessubopciones +
                '}';
    }
}
