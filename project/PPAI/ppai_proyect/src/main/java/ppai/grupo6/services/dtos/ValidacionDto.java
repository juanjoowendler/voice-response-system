package ppai.grupo6.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ppai.grupo6.entitys.Validacion;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidacionDto {
    private List<String> descripcionesOpciones;
    private String descripcionValidacion;
    private Integer nroOrden;
    private Validacion validacion;
}
