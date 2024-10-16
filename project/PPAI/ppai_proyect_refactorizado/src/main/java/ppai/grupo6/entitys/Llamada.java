package ppai.grupo6.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ppai.grupo6.entitys.estados.Estado;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llamadas")
public class Llamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLlamada;

    @Column(name = "descripcion_operador")
    private String descripcionOperador;

    @Column(name = "detalle_accion_requerida")
    private String detalleAccionRequerida;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "encuesta_enviada")
    private boolean encuestaEnviada;

    @Column(name = "observacion_auditor")
    private String observacionAuditor;

    @ManyToOne
    @JoinColumn(name = "id_accion_requerida")
    private Accion accion;

    @ManyToOne
    @JoinColumn(name = "id_opcion_seleccionada")
    private OpcionLlamada opcionSeleccionada;

    @ManyToOne
    @JoinColumn(name = "id_sub_opcion_seleccionada")
    private SubOpcionLlamada subOpcionSeleccionada;

    @OneToMany(mappedBy = "llamada", cascade = CascadeType.ALL)
    private List<CambioEstado> cambioEstados;

    @ManyToOne()
    @JoinColumn(name = "dni_cliente")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "id_Estado")
    private Estado estadoActual;

    @Column(name = "id_operador")
    private Integer idOperador;

    @Column(name = "id_auditor")
    private Integer idAuditor;

    @Column(name = "id_respuesta_de_encuesta")
    private Integer idRespuestaDeEncuesta;


    public void setDuracion(Integer duracion){
        this.duracion = duracion;
    }

    public void setSubOpcionSeleccionada(SubOpcionLlamada subOpcionSeleccionada){
        this.subOpcionSeleccionada = subOpcionSeleccionada;
    }

    public void setDescripcionOperador(String descripcion){
        this.descripcionOperador = descripcion;
    }
    public void setEstadoActual(Estado estadoActual){
        this.estadoActual = estadoActual;
    }

    public void addCambioEstado(CambioEstado cambioEstado) {
        this.cambioEstados.add(cambioEstado);
    }

    public void ponerEnCurso(LocalDateTime fechaHoraActual){
        this.estadoActual.ponerEnCurso(fechaHoraActual, this, this.cambioEstados);
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

    public void cancelar(LocalDateTime fechaHoraActual){
        this.estadoActual.cancelar(fechaHoraActual, this, this.cambioEstados);
    }

    public void finalizar(LocalDateTime fechaHoraActual, String descripcionOperador, SubOpcionLlamada subOpcionLlamada){
        this.estadoActual.finalizar(fechaHoraActual, this,descripcionOperador, subOpcionLlamada, this.cambioEstados);
    }

}
