package ppai.grupo6.entitys.estados;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("FINALIZADA")
public class Finalizada extends Estado {
    public Finalizada( String name) {
        super(name);
    }

    public Finalizada(Integer idEstado, String nombre) {
        super(idEstado, nombre);
    }

    public Finalizada() {

    }
}
