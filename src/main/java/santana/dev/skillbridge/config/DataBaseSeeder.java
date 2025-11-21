package santana.dev.skillbridge.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.domain.model.UserRole;
import santana.dev.skillbridge.repository.UserRepository;

import java.util.List;

@Component
public class DataBaseSeeder {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        if (userRepository.findUserByEmail("felipesantana@email.com").isPresent()) return;
        var felipe = User.builder()
                .name("Felipe")
                .email("felipesantana@email.com")
                .password(passwordEncoder.encode("123456"))
                .role(UserRole.ADMIN)
                .jobGoal("Desenvolvedor backend Java")
                .experienceSummary("Assistente administrativo em multinacional")
                .skills(List.of("Java", "Spring boot", "Docker"))
                .build();
        var yasmin = User.builder()
                .name("Yasmin")
                .email("yasminleme@email.com")
                .password(passwordEncoder.encode("123456"))
                .role(UserRole.USER)
                .build();
        userRepository.saveAll(List.of(yasmin,felipe));


    }
}
