package ppai.grupo6.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import ppai.grupo6.entitys.*;
import ppai.grupo6.services.dtos.DatosLlamadaDto;
import ppai.grupo6.services.dtos.SeleccionRtasValidacionesDto;
import ppai.grupo6.services.dtos.ValidacionDto;
import ppai.grupo6.services.dtos.ValidacionResponseDto;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class GestorLlamadas {
    @Autowired
    private  LlamadaService llamadaService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private OpcionService opcionService;
    @Autowired
    private SubOpcionService subOpcionService;
    @Autowired
    private AccionService accionService;

    private SubOpcionLlamada subOpcionLlamada;
    private OpcionLlamada opcionLlamada;
    private CategoriaLlamada categoriaLlamada;
    private Llamada llamada;

    private List<Accion> acciones;

    private LocalDateTime fechaHoraActual;
    private String nombreSubOpcion;
    private String nombreOpcion;
    private String nombreCategoria;
    private String nombreCliente;

    private List<Validacion> validacionesCliente;
    private List<ValidacionDto> validacionesClienteSubOpcion;
    private List<SeleccionRtasValidacionesDto> selecionesRtaCliente;
    private List<Accion> accionesDisponibles;
    private Integer accionRequerida;

    private Accion accionRequeridaEntity;
    private String descripcionRespuesta;
    private boolean validacionesCorrectas = true;

    public void inicio(){
        this.llamada = this.llamadaService.findIniciada();
        System.out.println(this.llamada);
        this.categoriaLlamada = this.categoriaService.findById(1);
        this.opcionLlamada =this.opcionService.findById(1);
        this.subOpcionLlamada = this.subOpcionService.findById(6);
        this.acciones = this.accionService.getAll();
    }

    public DatosLlamadaDto comunicarseConOperador() {
        this.inicio();
        this.ponerEnCurso();
        this.buscarDatosLlamada();
        return new DatosLlamadaDto(this.nombreCliente,
                this.nombreCategoria,
                this.nombreOpcion,
                this.nombreSubOpcion);
    }

    public void ponerEnCurso() {
        this.buscarFechaHoraActual();
        this.llamada.ponerEnCurso(this.fechaHoraActual);
        //this.llamadaService.save(this.llamada);
    }

    public void buscarDatosLlamada() {
        this.nombreCliente = this.llamada.getNombreClienteDeLlamada();
        this.nombreCategoria = this.categoriaLlamada.getNombre();
        this.nombreOpcion = this.opcionLlamada.getNombre();
        if (this.subOpcionLlamada != null) {
            this.nombreSubOpcion = this.subOpcionLlamada.getNombre();
        }
    }

    public List<ValidacionResponseDto> mostrarValidaciones(){
        this.buscarValidacionesCliente();
        this.buscarValidacionesSubOpcion();
        this.ordernarValidaciones();
        return this.validacionesClienteSubOpcion.stream().map(
                validacion -> {
                    return new ValidacionResponseDto(
                            validacion.getDescripcionesOpciones(),
                            validacion.getDescripcionValidacion(),
                            validacion.getNroOrden()
                    );
                }
        ).toList();
    }

    public void buscarValidacionesCliente(){
        this.validacionesCliente = this.llamada.buscarValidacionesCliente();
    }

    public void buscarValidacionesSubOpcion(){
        this.validacionesClienteSubOpcion = this.subOpcionLlamada
                .buscarValidacionesSubOpcionCliente(this.validacionesCliente);
    }

    public void ordernarValidaciones(){
        this.validacionesClienteSubOpcion = this.validacionesClienteSubOpcion.stream().sorted(
                Comparator.comparing(ValidacionDto::getNroOrden)
        ).toList();
    }

    public void buscarFechaHoraActual() {
        this.fechaHoraActual = LocalDateTime.now().withNano(0);
    }

    public List<Accion> tomarRespuestaValidacion(List<SeleccionRtasValidacionesDto> respuestasSeleccionadas){
        this.selecionesRtaCliente = respuestasSeleccionadas;
        this.validarRespuestas();
        if (this.validacionesCorrectas){
            this.buscarAccionesARealizar();
            return this.accionesDisponibles;
        } else {
            System.out.println("Por alguna razon entra aca");
            this.registrarCancelacionDeLlamada();
            throw new ServiceException("Error, se inserto una respuesta incorrecta");
        }
    }

    public void validarRespuestas() {
        this.validacionesCorrectas = true;
        System.out.println("Pre validacion");
        System.out.println(validacionesCorrectas);
        System.out.println(selecionesRtaCliente);
        this.selecionesRtaCliente.forEach(
                respuesta -> {
                    if(this.llamada.validarRespuesta(
                            respuesta.getNroOrdenValidacion(), respuesta.getOpcionSeleccionada()

                    )) {
                        return;
                    } else {
                        this.validacionesCorrectas = false;
                    }
                }
        );
        System.out.println("Post validacion");
        System.out.println(validacionesCorrectas);
    }

    public void buscarAccionesARealizar(){
        this.accionesDisponibles = this.acciones;
    }

    public void tomarAccionRequerida(Integer accionRequerida){
        this.accionRequerida = accionRequerida;
    }

    public void tomarDescripcionRespuesta(String descripcionRespuesta){
        this.descripcionRespuesta = descripcionRespuesta;
    }

    public boolean tomarConfirmacion(){
        return this.registarAccionRequerida();
    }

    public boolean registarAccionRequerida(){
        Random random = new Random();
        int indiceAleatorio = random.nextInt(1,20);

        if (indiceAleatorio == 1){
            this.registrarCancelacionDeLlamada();
            throw new ServiceException("Fallo refistro accion");
        }
        this.buscarAccionSeleccionada();
        this.llamada.setAccion(this.accionRequeridaEntity);
        this.accionRequeridaEntity.addLlamada(this.llamada);
        return true;
    }

    public void buscarAccionSeleccionada(){
        this.acciones.forEach(
                accion -> {
                    if (accion.esAccionSeleccionada(accionRequerida)){
                        this.accionRequeridaEntity = accion;
                    }
                });
    }

    public void registrarFinalizacionLlamada(){
        this.buscarFechaHoraActual();
        this.llamada.finalizar(this.fechaHoraActual, descripcionRespuesta, subOpcionLlamada);
        this.finCu();
    }

    public void registrarCancelacionDeLlamada(){
        this.buscarFechaHoraActual();
        this.llamada.cancelar(this.fechaHoraActual);
        this.finCu();
    }

    public void salir(){
        System.out.println("llega a salir");
        this.llamada = null;
        System.gc();
    }

    public void finCu(){
        this.llamadaService.save(this.llamada);
        System.gc();
    }
}
