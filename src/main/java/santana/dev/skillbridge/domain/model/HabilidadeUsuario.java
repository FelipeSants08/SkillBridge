package santana.dev.skillbridge.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

//@Entity
@Data
public class HabilidadeUsuario {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "habilidade_id")
    private Habilidade habilidades;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

}
