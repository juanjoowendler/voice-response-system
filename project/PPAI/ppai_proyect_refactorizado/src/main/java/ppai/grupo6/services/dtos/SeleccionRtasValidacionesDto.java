package ppai.grupo6.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeleccionRtasValidacionesDto {
    private Integer nroOrdenValidacion;
    private String opcionSeleccionada;

}
