package santana.dev.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santana.dev.skillbridge.domain.model.TrackStep;

import java.util.Optional;

public interface TrackStepRepository extends JpaRepository<TrackStep,Long> {
}
