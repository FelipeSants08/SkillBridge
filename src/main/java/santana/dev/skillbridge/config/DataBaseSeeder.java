package santana.dev.skillbridge.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import santana.dev.skillbridge.domain.model.Skill;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.domain.model.UserRole;
import santana.dev.skillbridge.repository.SkillRepository;
import santana.dev.skillbridge.repository.UserRepository;

import java.util.List;

@Component
public class DataBaseSeeder {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SkillRepository skillRepository;

    @PostConstruct
    public void init(){
        if (userRepository.findUserByEmail("felipesantana@email.com").isPresent()) return;
        var felipe = User.builder()
                .name("Felipe")
                .email("felipesantana@email.com")
                .password(passwordEncoder.encode("123456"))
                .role(UserRole.ADMIN)
                .build();
        var yasmin = User.builder()
                .name("Yasmin")
                .email("yasminleme@email.com")
                .password(passwordEncoder.encode("123456"))
                .role(UserRole.USER)
                .build();
        userRepository.saveAll(List.of(yasmin,felipe));
//        List<Skill> skills = List.of(
//                Skill.builder().skillName("Java").category("Backend").build(),
//                Skill.builder().skillName("Spring Boot").category("Backend").build(),
//                Skill.builder().skillName("Python").category("Backend").build(),
//                Skill.builder().skillName("Django").category("Backend").build(),
//                Skill.builder().skillName("Node.js").category("Backend").build(),
//                Skill.builder().skillName("Express.js").category("Backend").build(),
//
//                Skill.builder().skillName("JavaScript").category("Frontend").build(),
//                Skill.builder().skillName("TypeScript").category("Frontend").build(),
//                Skill.builder().skillName("React").category("Frontend").build(),
//                Skill.builder().skillName("Angular").category("Frontend").build(),
//                Skill.builder().skillName("Vue.js").category("Frontend").build(),
//                Skill.builder().skillName("HTML").category("Frontend").build(),
//                Skill.builder().skillName("CSS").category("Frontend").build(),
//
//                Skill.builder().skillName("SQL").category("Database").build(),
//                Skill.builder().skillName("PostgreSQL").category("Database").build(),
//                Skill.builder().skillName("MySQL").category("Database").build(),
//                Skill.builder().skillName("Oracle").category("Database").build(),
//                Skill.builder().skillName("MongoDB").category("Database").build(),
//
//                Skill.builder().skillName("Docker").category("DevOps").build(),
//                Skill.builder().skillName("Kubernetes").category("DevOps").build(),
//                Skill.builder().skillName("Git").category("DevOps").build(),
//                Skill.builder().skillName("Linux").category("DevOps").build(),
//                Skill.builder().skillName("CI/CD").category("DevOps").build(),
//
//                Skill.builder().skillName("Scrum").category("Methodology").build(),
//                Skill.builder().skillName("Kanban").category("Methodology").build(),
//                Skill.builder().skillName("Agile").category("Methodology").build(),
//                Skill.builder().skillName("Comunicação").category("Soft Skill").build(),
//                Skill.builder().skillName("Trabalho em equipe").category("Soft Skill").build()
//        );
//        skillRepository.saveAll(skills);

    }
}
