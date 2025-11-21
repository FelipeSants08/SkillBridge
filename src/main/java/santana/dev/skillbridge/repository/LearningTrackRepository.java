package santana.dev.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santana.dev.skillbridge.domain.model.LearningTrack;
import santana.dev.skillbridge.domain.model.User;

public interface LearningTrackRepository extends JpaRepository<LearningTrack, Long> {
    void deleteByUser(User user);
}
