package santana.dev.skillbridge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import santana.dev.skillbridge.domain.dto.request.UserExperienceRequest;
import santana.dev.skillbridge.domain.dto.request.UserSkillDetails;
import santana.dev.skillbridge.domain.model.Skill;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.domain.model.UserSkill;
import santana.dev.skillbridge.repository.SkillRepository;
import santana.dev.skillbridge.repository.UserRepository;
import santana.dev.skillbridge.repository.UserSkillRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SkillRepository skillRepository;
    private final UserRepository userRepository;
    private final UserSkillRepository userSkillRepository;

    public void updateUserExperience(Long id, UserExperienceRequest user){
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
        userToUpdate.setJobGoal(user.jobGoal());
        userToUpdate.setExperienceSummary(user.experienceSummary());
        userRepository.save(userToUpdate);
    }

    public void addUserSkill(Long id, UserSkillDetails skillRequest){
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
        Skill skill = skillRepository.findBySkillName(skillRequest.skill().name()).orElseThrow(()->new RuntimeException("Skill not found"));

        userSkillRepository.findByUserAndSkill(userToUpdate, skill)
                .ifPresentOrElse(existing -> {

                    if (!existing.getSkillLevel().equals(skillRequest.skillLevel())) {
                        existing.setSkillLevel(skillRequest.skillLevel());
                        userSkillRepository.save(existing);
                    }
                }, () -> {
                    UserSkill userSkill = UserSkill.builder()
                            .user(userToUpdate)
                            .skill(skill)
                            .skillLevel(skillRequest.skillLevel())
                            .build();

                    userSkillRepository.save(userSkill);
                });
    }

    public List<User> findAllUser() {
        return userRepository.findAll();

    }




}
