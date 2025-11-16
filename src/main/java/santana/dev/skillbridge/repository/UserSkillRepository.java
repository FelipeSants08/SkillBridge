package santana.dev.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santana.dev.skillbridge.domain.model.Skill;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.domain.model.UserSkill;

import java.util.List;
import java.util.Optional;

public interface UserSkillRepository extends JpaRepository<UserSkill,Long> {

    List<UserSkill> findByUserId(Long id);

    Optional<UserSkill> findByUserAndSkill(User user, Skill skill);
}
