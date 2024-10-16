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
@Table(name = "opciones_llamada")
public class OpcionLlamada {
    @Id
/*    @GeneratedValue(generator = "opcionesllamadas")
    @TableGenerator(name = "opcionesllamadas", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="opcionesllamadas",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpcionLlamada;

    @Column(name = "audio_mensaje_sub_opcion_llamada")
    private String audioMensajeSubOpcion;

    @Column(name = "mesaje_subopciones")
    private String messageSubOpciones;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nro_orden")
    private Integer nroOrden;

    @OneToMany(mappedBy = "opcionLlamada")
    private List<SubOpcionLlamada> subOpciones;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaLlamada categoria;

    @ManyToMany()
    @JoinTable(
            name = "Validaciones_opciones",
            joinColumns = @JoinColumn(name = "id_opcion_llamada"),
            inverseJoinColumns = @JoinColumn(name = "id_validacion")
    )
    private List<Validacion> validacionesopciones = new ArrayList<>();

    @Override
    public String toString() {
        return "OpcionLlamada{" +
                "idOpcionLlamada=" + idOpcionLlamada +
                ", audioMensajeSubOpcion='" + audioMensajeSubOpcion + '\'' +
                ", messageSubOpciones='" + messageSubOpciones + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nroOrden=" + nroOrden +
                ", subOpciones=" + subOpciones +
                ", categoria=" + categoria +
                ", validacionesopciones=" + validacionesopciones +
                '}';
    }
}
