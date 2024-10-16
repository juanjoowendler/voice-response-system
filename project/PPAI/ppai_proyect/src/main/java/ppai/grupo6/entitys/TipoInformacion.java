package ppai.grupo6.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipos_informacion")
public class TipoInformacion {
    @Id
/*    @GeneratedValue(generator = "TiposInformacion")
    @TableGenerator(name = "TiposInformacion", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="TiposInformacion",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoInformacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Override
    public String toString() {
        return "TipoInformacion{" +
                "idTipoInformacion=" + idTipoInformacion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
