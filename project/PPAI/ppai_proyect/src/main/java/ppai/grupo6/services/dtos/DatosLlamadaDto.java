package ppai.grupo6.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatosLlamadaDto {
    private String nombreCliente;
    private String nombreCategoria;
    private String nombreOpcion;
    private String nombreSubOpcion;
}
