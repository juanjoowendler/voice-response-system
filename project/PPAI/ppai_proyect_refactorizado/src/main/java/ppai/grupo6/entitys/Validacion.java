package ppai.grupo6.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "validaciones")
public class Validacion {
    @Id
/*    @GeneratedValue(generator = "Validaciones")
    @TableGenerator(name = "Validaciones", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Validaciones",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValidacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nro_orden")
    private Integer nroOrden;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoInformacion tipoInformacion;

    @OneToMany(mappedBy = "validacion", fetch = FetchType.EAGER)
    private List<OpcionValidacion> opciones = new ArrayList<>();

    @ManyToMany(mappedBy = "validacionesopciones")
    @JsonIgnore
    private List<OpcionLlamada> opcionesLlamadaValidacion = new ArrayList<>();

    @ManyToMany(mappedBy = "validacionessubopciones")
    @JsonIgnore
    private List<SubOpcionLlamada> subOpcionesLlamadaValidacion = new ArrayList<>();

    public boolean esValidacionCliente(List<Validacion> validaciones){
        AtomicBoolean esValidacion = new AtomicBoolean(false);
        validaciones.forEach(validacion -> {
            if (Objects.equals(this, validacion)){
                esValidacion.set(true);
            }
        });
        return esValidacion.get();
    }

    public boolean esValidacionInformacion(Integer validacion){
        return Objects.equals(this.nroOrden, validacion);
    }

    public List<String> buscarOpcionesValidacion(){
        return this.opciones
                .stream().map(OpcionValidacion::getDescripcion).toList();
    }

    @Override
    public String toString() {
        return "Validacion{" +
                "idValidacion=" + idValidacion +
                ", nombre='" + nombre + '\'' +
                ", nroOrden=" + nroOrden +
                ", tipoInformacion=" + tipoInformacion +
                ", opciones=" + opciones +
                '}';
    }
}
