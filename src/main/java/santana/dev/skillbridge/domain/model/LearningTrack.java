package santana.dev.skillbridge.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Entity
@Data
public class LearningTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Qual usuário pertence a esta trilha
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // O objetivo de carreira que gerou esta trilha
    private String targetJobGoal;

    private Instant generatedDate;

    // Relacionamento com os passos da trilha
    @OneToMany(mappedBy = "learningTrack", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrackStep> trackSteps;
}
