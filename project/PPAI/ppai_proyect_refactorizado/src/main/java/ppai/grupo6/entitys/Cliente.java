package ppai.grupo6.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "dni")
    private Integer dni;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "nro_celular")
    private String nroCelular;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<InformacionCliente> informaciones = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Llamada>  llamadas = new ArrayList<>();

    public List<Validacion> buscarValidaciones(){
        return this.informaciones.stream().map(
                InformacionCliente::getValidacion
        ).toList();
    }

    public boolean validarRespuesta(Integer validacion, String respuesta){
        AtomicBoolean rta = new AtomicBoolean(false);
        this.informaciones.forEach(
                informacionCliente -> {
                    if (informacionCliente.esInformacionCorrecta(validacion, respuesta)){
                        rta.set(true);
                    }
                }
        );
        System.out.println(rta.get());
        return rta.get();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", nroCelular='" + nroCelular + '\'' +
                ", informaciones=" + informaciones +
                '}';
    }
}
