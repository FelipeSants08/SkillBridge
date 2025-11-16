package santana.dev.skillbridge.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TrackStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id", nullable = false)
    private LearningTrack learningTrack;

    private String title;

    @Lob
    private String description;

    private String resourceLink;

    @Enumerated(EnumType.STRING)
    private StepType stepType;

    @Enumerated(EnumType.STRING)
    private StatusTrack status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private Skill targetSkill;
}