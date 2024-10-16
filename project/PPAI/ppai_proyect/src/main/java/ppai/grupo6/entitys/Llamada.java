package ppai.grupo6.entitys;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedNotification;
import ppai.grupo6.services.LlamadaService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llamadas")
public class Llamada {
    @Id
/*    @GeneratedValue(generator = "Llamadas")
    @TableGenerator(name = "Llamadas", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Llamadas",
            initialValue=1, allocationSize=1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLlamada;

    @Column(name = "descripcion_operador")
    private String descripcionOperador;

    @Column(name = "detalle_accion_requerida")
    private String detalleAccionRequerida;

    @Column(name = "duracion")
    private Double duracion;

    @Column(name = "encuesta_enviada")
    private Integer encuestaEnviada;

    @Column(name = "observacion_auditor")
    private String observacionAuditor;

    @Column(name = "id_operador")
    private Integer idOperador;

    @Column(name = "id_auditor")
    private Integer idAuditor;

    @ManyToOne
    @JoinColumn(name = "id_opcion_seleccionada")
    private OpcionLlamada opcionSeleccionada;

    @ManyToOne
    @JoinColumn(name = "id_sub_opcion_seleccionada")
    private SubOpcionLlamada subOpcionLlamada;

    @Column(name = "id_respuesta_de_encuesta")
    private Integer idRespuestaDeEncuesta;

    @ManyToOne
    @JoinColumn(name = "id_accion_requerida")
    private Accion accion;

    @OneToMany(mappedBy = "llamada", cascade = CascadeType.ALL)
    private List<CambioEstado> cambioEstados;

    @ManyToOne()
    @JoinColumn(name = "dni_cliente")
    private Cliente cliente;

    public void addCambioEstado(CambioEstado cambioEstado) {
        this.cambioEstados.add(cambioEstado);
    }

    public void ponerEnCurso(String fechaHoraActual){
        CambioEstado ultimo = this.buscarUltimoCambioEstado();
        if (ultimo.esIniciada()){
            ultimo.ponerEnCurso(fechaHoraActual, this);
        }
    }

    public CambioEstado buscarUltimoCambioEstado(){

        return this.cambioEstados.get(this.cambioEstados.size()-1);
    }

    public String getNombreClienteDeLlamada(){
        return this.cliente.getNombreCompleto();
    }

    public List<Validacion> buscarValidacionesCliente(){
        return this.cliente.buscarValidaciones();
    }

    public boolean validarRespuesta(Integer validacion, String opcionSeleccionada){
        return this.cliente.validarRespuesta(validacion, opcionSeleccionada);
    }

    public void calcularDuracion(String fhinicio, String fhfin){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime fechaHoraInicio = LocalDateTime.parse(fhinicio, dateTimeFormatter);
        LocalDateTime fechaHoraFin = LocalDateTime.parse(fhfin, dateTimeFormatter);
        Duration duration = Duration.between(fechaHoraInicio, fechaHoraFin);
        Double segundos = (double) duration.toSeconds();
        System.out.println(duration.toSeconds());
        //Double minutos = (double) duration.toMinutes();
        this.setDuracion(segundos);
    }

    public void cancelar(String fechaHoraActual, String fechaHoraAnterior){
        CambioEstado ultimo = this.buscarUltimoCambioEstado();
        if (ultimo.esEnCurso()){
            ultimo.cancelar(fechaHoraActual, fechaHoraAnterior, this);
        }
    }

    public void finalizar(String fechaHoraActual,String fechaHoraAnterior, String descripcionOperador, SubOpcionLlamada subOpcionLlamada){
        CambioEstado ultimo = this.buscarUltimoCambioEstado();
        if (ultimo.esEnCurso()){
            ultimo.finalizar(fechaHoraActual, fechaHoraAnterior, this, descripcionOperador, subOpcionLlamada);
        }
    }

}
