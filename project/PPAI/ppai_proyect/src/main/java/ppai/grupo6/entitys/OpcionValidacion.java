package ppai.grupo6.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opciones_validacion")
public class OpcionValidacion {
    @Id
/*    @GeneratedValue(generator = "opcionesvalidaciones")
    @TableGenerator(name = "opcionesvalidaciones", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="opcionesvalidaciones",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpcionesValidacion;

    @Column(name = "correcta")
    private boolean correcta;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_validacion")
    @JsonIgnore
    private Validacion validacion;

    public boolean esCorrecta(String respuesta){
        return Objects.equals(this.descripcion, respuesta);
    }

    @Override
    public String toString() {
        return "OpcionValidacion{" +
                "idOpcionesValidacion=" + idOpcionesValidacion +
                ", correcta=" + correcta +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
