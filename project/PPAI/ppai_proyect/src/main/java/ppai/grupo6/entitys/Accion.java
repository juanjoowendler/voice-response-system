package ppai.grupo6.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "acciones")
public class Accion {
    @Id
/*    @GeneratedValue(generator = "Acciones")
    @TableGenerator(name = "Acciones", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Acciones",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accion")
    private Integer idAccion;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "accion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Llamada> llamadasOpcion = new ArrayList<>();

    public boolean esAccionSeleccionada(Integer idRequerida){
        if (this.idAccion == idRequerida){
            return true;
        } else {
            return false;
        }
    }

    public void addLlamada(Llamada llamada) {
        this.llamadasOpcion.add(llamada);
    }

    @Override
    public String toString() {
        return "Accion{" +
                "idAccion=" + idAccion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
