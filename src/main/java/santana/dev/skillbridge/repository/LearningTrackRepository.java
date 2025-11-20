package santana.dev.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santana.dev.skillbridge.domain.model.LearningTrack;

public interface LearningTrackRepository extends JpaRepository<LearningTrack, Long> {
}
