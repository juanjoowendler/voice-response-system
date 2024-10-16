package ppai.grupo6.entitys.estados;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ppai.grupo6.entitys.estados.Estado;

@Entity
@DiscriminatorValue("CANCELADA")
public class Cancelada extends Estado {
    public Cancelada(String name) {
        super(name);
    }

    public Cancelada(Integer idEstado, String nombre) {
        super(idEstado, nombre);
    }

    public Cancelada() {

    }
}
