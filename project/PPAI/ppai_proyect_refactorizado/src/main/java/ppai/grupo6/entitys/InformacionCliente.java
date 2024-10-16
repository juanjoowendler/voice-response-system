package ppai.grupo6.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "informaciones_cliente")
public class InformacionCliente {
    @Id
/*    @GeneratedValue(generator = "informacionescliente")
    @TableGenerator(name = "informacionescliente", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="informacionescliente",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInformacionCliente;

    @Column(name = "dato_a_validar")
    private String datoAValidar;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_informacion")
    private TipoInformacion tipoInformacion;

    @OneToOne
    @JoinColumn(name = "id_opcion_correcta")
    private OpcionValidacion opcionCorrecta;

    @OneToOne
    @JoinColumn(name = "id_validacion")
    private Validacion validacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private Cliente cliente;

    public boolean esInformacionCorrecta(Integer validacion, String respuesta){
        return this.validacion.esValidacionInformacion(validacion)
                && this.opcionCorrecta.esCorrecta(respuesta);
    }

    @Override
    public String toString() {
        return "InformacionCliente{" +
                "idInformacionCliente=" + idInformacionCliente +
                ", datoAValidar='" + datoAValidar + '\'' +
                ", tipoInformacion=" + tipoInformacion +
                ", opcionCorrecta=" + opcionCorrecta +
                ", validacion=" + validacion +
                '}';
    }
}
