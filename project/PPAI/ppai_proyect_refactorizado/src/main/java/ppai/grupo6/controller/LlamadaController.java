package ppai.grupo6.controller;

import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ppai.grupo6.entitys.Accion;
import ppai.grupo6.services.dtos.DatosLlamadaDto;
import ppai.grupo6.services.GestorLlamadas;
import ppai.grupo6.services.dtos.SeleccionRtasValidacionesDto;
import ppai.grupo6.services.dtos.ValidacionResponseDto;

import java.util.List;

@RestController
@RequestMapping("/llamada")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LlamadaController {
    private GestorLlamadas gestorLlamadas;

    @GetMapping("/com-operador")
    public ResponseEntity<DatosLlamadaDto> getDatosLlamada(){
        return ResponseEntity.status(HttpStatus.OK).body(this.gestorLlamadas.comunicarseConOperador());
    }

    @GetMapping("/validaciones")
    public ResponseEntity<List<ValidacionResponseDto>> getValdaciones(){
        return ResponseEntity.status(HttpStatus.OK).body(this.gestorLlamadas.mostrarValidaciones());
    }

    @PostMapping("/respuestas-validaciones")
    public ResponseEntity<List<Accion>> tomarSeleccionValidaciones(
            @RequestBody List<SeleccionRtasValidacionesDto> respuestasValidaciones){
        try {
            System.out.println(respuestasValidaciones);
            return ResponseEntity.status(HttpStatus.OK).body(
                    this.gestorLlamadas.tomarRespuestaValidacion(respuestasValidaciones));
        } catch (ServiceException e1) {
            return ResponseEntity.status(HttpStatus.CONFLICT).header(
                    "error-message", e1.getMessage()
            ).build();
        }
    }

    @PostMapping("/accion-selec")
    public ResponseEntity<Boolean> tomarAccion(@RequestBody Integer accion){
        System.out.println(accion);
            this.gestorLlamadas.tomarAccionRequerida(accion);
            return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping("/descripcion-operador")
    public ResponseEntity<Boolean> tomarDescripcion(@RequestBody String descripcion){
        System.out.println(descripcion);
        this.gestorLlamadas.tomarDescripcionRespuesta(descripcion);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping("/confirmar")
    public ResponseEntity<Boolean> tomarConfirmacion(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.gestorLlamadas.tomarConfirmacion());
        } catch (ServiceException e1){
            return ResponseEntity.status(HttpStatus.CONFLICT).header(
                    "error-message", e1.getMessage()
            ).body(false);
        }
    }

    @PostMapping("/finalizarLlamada")
    public ResponseEntity<Boolean> finalizarLlamada(){
        this.gestorLlamadas.registrarFinalizacionLlamada();
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping("/salir")
    public ResponseEntity<Boolean> salir(){
        this.gestorLlamadas.salir();
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
