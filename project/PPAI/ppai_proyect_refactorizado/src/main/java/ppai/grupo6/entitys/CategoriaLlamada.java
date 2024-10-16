package ppai.grupo6.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias_llamada")
public class CategoriaLlamada {
    @Id
/*    @GeneratedValue(generator = "categoriasllamadas")
    @TableGenerator(name = "categoriasllamadas", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="categoriasllamadas",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoriaLlamada;

    @Column(name = "audio_mensaje_opciones")
    private String audioMensajeOpciones;

    @Column(name = "mensaje_opciones")
    private String mensajeOpciones;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nro_orden")
    private Integer nroOrden;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<OpcionLlamada> opcionesCategoria = new ArrayList<>();

    @Override
    public String toString() {
        return "CategoriaLlamada{" +
                "idCategoriaLlamada=" + idCategoriaLlamada +
                ", audioMensajeOpciones='" + audioMensajeOpciones + '\'' +
                ", mensajeOpciones='" + mensajeOpciones + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nroOrden=" + nroOrden +
                '}';
    }
}
