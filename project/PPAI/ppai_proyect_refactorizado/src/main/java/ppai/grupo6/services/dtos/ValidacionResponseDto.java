package ppai.grupo6.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidacionResponseDto {
    private List<String> descripcionesOpciones;
    private String descripcionValidacion;
    private Integer nroOrden;
}
