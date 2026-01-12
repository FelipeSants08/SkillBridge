package santana.dev.skillbridge.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import santana.dev.skillbridge.domain.dto.response.TrackStepResponse;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrackStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id", nullable = false)
    private LearningTrack learningTrack;

    private String title;

    private String estimatedTime;

    @Lob
    private String description;

    @ElementCollection
    private List<String> links;

    @ElementCollection
    private List<String> resources;


    @Enumerated(EnumType.STRING)
    private StatusTrack status;

    public TrackStep(TrackStepResponse response, LearningTrack track){
        this.learningTrack = track;
        this.title = response.title();
        this.estimatedTime = response.estimatedTime();
        this.description = response.description();
        this.links = response.links();
        this.resources = response.resources();
        this.status = response.status();
    }


}