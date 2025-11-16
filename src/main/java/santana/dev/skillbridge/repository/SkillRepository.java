package santana.dev.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santana.dev.skillbridge.domain.model.Skill;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    Optional<Skill> findBySkillName(String name);
}
