package santana.dev.skillbridge.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import santana.dev.skillbridge.domain.dto.response.TrackStepResponse;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    // Relacionamento com os passos da trilha
    @OneToMany(mappedBy = "learningTrack", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrackStep> trackSteps;
}
