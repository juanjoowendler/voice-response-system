package ppai.grupo6.entitys.estados;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("FINALIZADA")
public class Finalizada extends Estado {
    private final Integer idEstado = 3;
    private final String nombre = "finalizada";
    public Finalizada() {
        super(3, "finalizada");
    }

    @Override
    public boolean esFinalizada() {
        return true;
    }
}
