package ppai.grupo6.entitys.estados;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ppai.grupo6.entitys.estados.Estado;

@Entity
@DiscriminatorValue("CANCELADA")
public class Cancelada extends Estado {

    private final Integer idEstado = 4;
    private final String nombre = "cancelada";

    public Cancelada() {
        super(4, "cancelada");
    }

    @Override
    public boolean esCancelada(){
        return true;
    }

}
