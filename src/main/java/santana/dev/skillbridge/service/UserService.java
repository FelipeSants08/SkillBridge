package santana.dev.skillbridge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import santana.dev.skillbridge.domain.dto.request.UserExperienceRequest;
import santana.dev.skillbridge.domain.dto.request.UserSkillRequest;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public void updateUserExperience(Long id, UserExperienceRequest user){
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
        userToUpdate.setJobGoal(user.jobGoal());
        userToUpdate.setExperienceSummary(user.experienceSummary());
        userRepository.save(userToUpdate);
    }

    public void addUserSkill(Long id, UserSkillRequest skillRequest){
        User user = findUserById(id);
        user.getSkills().add(skillRequest.skill());
        userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();

    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
    }




}
